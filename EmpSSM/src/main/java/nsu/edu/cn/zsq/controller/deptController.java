package nsu.edu.cn.zsq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nsu.edu.cn.zsq.bean.Dept;
import nsu.edu.cn.zsq.bean.Emp;
import nsu.edu.cn.zsq.bean.Msg;
import nsu.edu.cn.zsq.service.DeptService;
import nsu.edu.cn.zsq.service.EmpService;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月28日 上午9:26:13 <br>
* 处理和部门有关的请求
*/
@Controller
public class deptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("depts")
	@ResponseBody
	public Msg getDepts() {
		List<Dept> depts = deptService.getDepts();
		return Msg.success().add("depts",depts);
	}
}
