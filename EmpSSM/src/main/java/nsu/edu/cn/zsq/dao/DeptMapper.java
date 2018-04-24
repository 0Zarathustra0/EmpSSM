package nsu.edu.cn.zsq.dao;

import java.util.List;

import nsu.edu.cn.zsq.bean.Dept;


/**
 * project_name:EmpSSM <br>
 * user:师哥<br>
 * date:2018年1月23日 <br>
 * 定义部门增删改查接口
 */
public interface DeptMapper {
	/**查询部门列表
	 * @return
	 */
	List<Dept> list();
	
	/**根据部门编号查询
	 * @param deptNo
	 * @return
	 */
	Dept get(Integer deptno);
	
	/**新增部门
	 * @param dept
	 */
	void save(Dept dept);
	
	/**更新部门
	 * @param dept
	 */
	void update(Dept dept);
	
	/**删除部门
	 * @param deptNo
	 */
	void delete(Integer deptno);
}
