package com.hungslab.urban.service;

import com.hungslab.urban.pojo.OperationLog;

import java.util.List;

/**
 * @author hungs
 * @date 2024-04-08
 * @Description 操作日志Api管理
 */
public interface OperationLogService {
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperationLog(OperationLog operLog);

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<OperationLog> selectOperationLogList(OperationLog operLog);

    /**
     * 批量删除系统操作日志
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteOperationLogByIds(String ids);

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public OperationLog selectOperationLogById(Long operId);

    /**
     * 清空操作日志
     */
    public void cleanOperationLog();

}
