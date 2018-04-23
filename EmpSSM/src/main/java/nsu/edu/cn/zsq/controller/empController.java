package nsu.edu.cn.zsq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nsu.edu.cn.zsq.bean.Emp;
import nsu.edu.cn.zsq.service.EmpService;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月23日 上午10:17:41 <br>
*/
@Controller
public class empController {

	@Autowired
	private EmpService empService;

	@RequestMapping("list")
	public String list(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		/*
		 * 分页查询
		 * 需要引入pageHelper插件
		 * */
		List<Emp> emps = empService.getEmps();
		model.addAttribute("emps",emps);
		return "list";
	}
}
