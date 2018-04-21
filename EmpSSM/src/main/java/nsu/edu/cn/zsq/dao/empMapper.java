package nsu.edu.cn.zsq.dao;

import java.util.List;
import nsu.edu.cn.zsq.bean.emp;
import nsu.edu.cn.zsq.bean.empExample;
import org.apache.ibatis.annotations.Param;

public interface empMapper {
    long countByExample(empExample example);

    int deleteByExample(empExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(emp record);

    int insertSelective(emp record);

    List<emp> selectByExample(empExample example);

    emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") emp record, @Param("example") empExample example);

    int updateByExample(@Param("record") emp record, @Param("example") empExample example);

    int updateByPrimaryKeySelective(emp record);

    int updateByPrimaryKey(emp record);
}