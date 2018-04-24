package nsu.edu.cn.zsq.bean;
import java.io.Serializable;
/**
 * project_name:EmpSSM
 * user:师哥
 * date:2018年1月23日
 * 实体类：部门
 */
public class Dept implements Serializable{
	private Integer deptno;	// 部门编号
	private String dname;	// 部门名称
	private String loc;		// 部门所在地区
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "deptno:"+deptno+"\ndname:"+dname+"\nloc:"+loc;
	}
}
