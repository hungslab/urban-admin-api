package com.hungslab.urban.mapper;

import com.hungslab.urban.pojo.OperationLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Hong
* @description
* @createDate 2024-04-08 11:43:36
*/
@Mapper
public interface OperationLogMapper {

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
    public int deleteOperationLogByIds(String[] ids);

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
