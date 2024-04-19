package com.hungslab.urban.core.utils;

import com.github.pagehelper.PageHelper;
import com.hungslab.urban.core.page.PageDomain;
import com.hungslab.urban.core.page.TableSupport;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 分页工具类
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = pageDomain.getOrderBy();
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
