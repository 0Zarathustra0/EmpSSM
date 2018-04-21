package nsu.edu.cn.zsq.dao;

import java.util.List;
import nsu.edu.cn.zsq.bean.dept;
import nsu.edu.cn.zsq.bean.deptExample;
import org.apache.ibatis.annotations.Param;

public interface deptMapper {
    long countByExample(deptExample example);

    int deleteByExample(deptExample example);

    int deleteByPrimaryKey(Integer deptno);

    int insert(dept record);

    int insertSelective(dept record);

    List<dept> selectByExample(deptExample example);

    dept selectByPrimaryKey(Integer deptno);

    int updateByExampleSelective(@Param("record") dept record, @Param("example") deptExample example);

    int updateByExample(@Param("record") dept record, @Param("example") deptExample example);

    int updateByPrimaryKeySelective(dept record);

    int updateByPrimaryKey(dept record);
}