package com.hungslab.urban.service.impl;

import cn.hutool.core.convert.Convert;
import com.hungslab.urban.mapper.OperationLogMapper;
import com.hungslab.urban.pojo.OperationLog;
import com.hungslab.urban.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hungs
 * @date 2024-04-08
 * @Description
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    @Override
    public void insertOperationLog(OperationLog operLog)
    {
        operationLogMapper.insertOperationLog(operLog);
    }

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    @Override
    public List<OperationLog> selectOperationLogList(OperationLog operLog)
    {
        return operationLogMapper.selectOperationLogList(operLog);
    }

    /**
     * 批量删除系统操作日志
     *
     * @param ids 需要删除的数据
     * @return
     */
    @Override
    public int deleteOperationLogByIds(String ids)
    {
        return operationLogMapper.deleteOperationLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    @Override
    public OperationLog selectOperationLogById(Long operId)
    {
        return operationLogMapper.selectOperationLogById(operId);
    }

    /**
     * 清空操作日志
     */
    @Override
    public void cleanOperationLog()
    {
        operationLogMapper.cleanOperationLog();
    }

}
