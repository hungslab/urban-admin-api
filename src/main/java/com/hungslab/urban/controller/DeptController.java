package com.hungslab.urban.controller;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.core.utils.SecurityUtils;
import com.hungslab.urban.pojo.Dept;
import com.hungslab.urban.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hungs
 * @date 2024-04-03
 * @Description 部门管理相关接口
 */
@Controller
@CrossOrigin
@Tag(name = "部门管理相关接口")
@RequestMapping("/system/dept")
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @Operation(summary = "部门信息列出接口")
    @PostMapping("/list")
    public List<Dept> list(Dept dept)
    {
        return deptService.selectDeptList(dept);
    }

    /**
     * 修改部门
     */
    @Operation(summary = "修改部门接口")
    @PostMapping("/edit")
    public AjaxResult editSave(@Validated Dept dept)
    {
        // 传入deptName即可，deptId对外不可知
        if (!deptService.checkDeptNameUnique(dept))
        {
            return error("修改部门'" + dept.getDeptName() + "'失败，部门名称已存在");
        }
        dept.setUpdateBy(SecurityUtils.getLoginName());
        return toAjax(deptService.updateDept(dept));
    }

    /**
     * 删除
     */
    @Operation(summary = "删除部门接口")
    @GetMapping("/remove")
    public AjaxResult remove(Long deptId)
    {
        if (deptService.checkDeptExistUser(deptId))
        {
            return AjaxResult.warn("部门存在用户,不允许删除");
        }
        return toAjax(deptService.deleteDeptById(deptId));
    }

    /**
     * 新增部门
     */
    @Operation(summary = "新增部门接口")
    @PostMapping("/add")
    public AjaxResult addSave(@Validated Dept dept)
    {
        if (!deptService.checkDeptNameUnique(dept))
        {
            return error("新增部门'" + dept.getDeptName() + "'失败，部门名称已存在");
        }
        dept.setCreateBy(SecurityUtils.getLoginName());
        return toAjax(deptService.insertDept(dept));
    }

}
