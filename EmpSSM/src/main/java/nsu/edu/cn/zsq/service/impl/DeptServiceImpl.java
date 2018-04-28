package nsu.edu.cn.zsq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nsu.edu.cn.zsq.bean.Dept;
import nsu.edu.cn.zsq.dao.DeptMapper;
import nsu.edu.cn.zsq.dao.EmpMapper;
import nsu.edu.cn.zsq.service.DeptService;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月28日 上午9:28:02 <br>
*/
@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public List<Dept> getDepts() {
		// TODO Auto-generated method stub
		List<Dept> depts = deptMapper.list();
		return depts;
	}


}
