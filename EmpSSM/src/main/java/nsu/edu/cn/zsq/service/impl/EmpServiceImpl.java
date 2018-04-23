package nsu.edu.cn.zsq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nsu.edu.cn.zsq.bean.Emp;
import nsu.edu.cn.zsq.dao.EmpMapper;
import nsu.edu.cn.zsq.service.EmpService;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月23日 上午10:20:09 <br>
*/
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> getEmps() {
		// TODO Auto-generated method stub
		List<Emp> emps = empMapper.list();
		return emps;
	}

}
