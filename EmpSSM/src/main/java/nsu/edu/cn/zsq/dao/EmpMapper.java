package nsu.edu.cn.zsq.dao;

import java.util.List;

import nsu.edu.cn.zsq.bean.Emp;

/**
 * project_name:StudyMybatis
 * user:师哥
 * date:2018年1月23日
 * 定义员工增删改查接口
 */
public interface EmpMapper {
	
	
 
	//查询员工列表
	List<Emp> list();
	//根据员工编号查询
	Emp get(Integer empno);
	//新增员工信息
	void save(Emp emp);
	//修改员工信息
	void update(Emp emp);
	//删除员工信息
	void delete(Integer empno);
}
