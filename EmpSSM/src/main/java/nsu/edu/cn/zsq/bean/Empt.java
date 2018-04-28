package nsu.edu.cn.zsq.bean;

import java.util.Date;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月28日 上午11:10:47 <br>
*/
public class Empt {
	private String         empno;   // 员工编号
    private String         ename;   // 员工姓名
    private String         job;     // 员工职位
    private Integer        mgr;     // 领导编号
    private Date         hiredate; // 入职日期
    private Double         sal;     // 员工工资
    private Double         comm;    // 员工奖金
    private String        deptno;  // 部门编号
	

	public String getEmpno() {
		return empno;
	}


	public void setEmpno(String empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public Integer getMgr() {
		return mgr;
	}


	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public Double getSal() {
		return sal;
	}


	public void setSal(Double sal) {
		this.sal = sal;
	}


	public Double getComm() {
		return comm;
	}


	public void setComm(Double comm) {
		this.comm = comm;
	}


	public String getDeptno() {
		return deptno;
	}


	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{empno:"+empno+"\n ename:"+ename+"\n job:"+job+"\n mgr:"+mgr+
    			"\n hiredate:"+hiredate+"\n sal:"+sal+"\n comn:"+comm+"\n deptno:"+deptno+"}";
	}
    
    
}
