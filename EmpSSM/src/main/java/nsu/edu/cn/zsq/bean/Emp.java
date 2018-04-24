package nsu.edu.cn.zsq.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * project_name:EmpSSM
 * user:师哥
 * date:2018年1月23日
 * 
 */
public class Emp implements Serializable{
	 // 定义属性
    private Integer empno;   // 员工编号
    private String         ename;   // 员工姓名
    private String         job;     // 员工职位
    private Integer        mgr;     // 领导编号
    private Date           hiredate; // 入职日期
    private Double         sal;     // 员工工资
    private Double         comm;    // 员工奖金
    private Integer        deptno;  // 部门编号

    public Emp() {
		// TODO Auto-generated constructor stub
	}
    
    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal, Double comm,
			Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	// 设置上述属性getters/setters系列方法
    public Integer getEmpno()
    {
        return empno;
    }

    public void setEmpno(Integer empno)
    {
        this.empno = empno;
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public Integer getMgr()
    {
        return mgr;
    }

    public void setMgr(Integer mgr)
    {
        this.mgr = mgr;
    }

    public Date getHiredate()
    {
        return hiredate;
    }

    public void setHiredate(Date hiredate)
    {
        this.hiredate = hiredate;
    }

    public Double getSal()
    {
        return sal;
    }

    public void setSal(Double sal)
    {
        this.sal = sal;
    }

    public Double getComm()
    {
        return comm;
    }

    public void setComm(Double comm)
    {
        this.comm = comm;
    }

    public Integer getDeptno()
    {
        return deptno;
    }

    public void setDeptno(Integer deptno)
    {
        this.deptno = deptno;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "{empno:"+empno+"\n ename:"+ename+"\n job:"+job+"\n mgr:"+mgr+
    			"\n hiredate:"+hiredate+"\n sal:"+sal+"\n comn:"+comm+"\n deptno}";
    }
}
