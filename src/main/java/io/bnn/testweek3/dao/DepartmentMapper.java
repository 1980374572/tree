package io.bnn.testweek3.dao;

import io.bnn.testweek3.dto.out.DepartmentNode;
import io.bnn.testweek3.po.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    //    custom
    List<DepartmentNode> selectChildren(@Param("departmentId") Integer departmentId);
}