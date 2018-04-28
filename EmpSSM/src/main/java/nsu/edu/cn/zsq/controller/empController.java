package nsu.edu.cn.zsq.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import nsu.edu.cn.zsq.bean.Emp;
import nsu.edu.cn.zsq.bean.Empt;
import nsu.edu.cn.zsq.bean.Msg;
import nsu.edu.cn.zsq.service.EmpService;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月23日 上午10:17:41 <br>
*/
@Controller
public class empController {

	@Autowired
	private EmpService empService;
	
	/*rest风格url
	 * 规定url
	 * url：/emp/{id}--------->如果ajax发的是GET请求，则是查询员工
	 * url：/emp--------->如果ajax发的是POST请求，则是保存员工
	 * url：/emp/{id}--------->如果ajax发的是PUT请求，则是修改员工
	 * url：/emp/{id}--------->如果ajax发的是DELETE请求，则是删除员工
	 * */
	//员工保存
	@RequestMapping(value="emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(Emp emp) {
		System.out.println("===================\n"+emp);
		empService.saveEmp(emp);
		return Msg.success();
	}
	
	@RequestMapping("emps")
	@ResponseBody
	public Msg list(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn,6);
		List<Emp> emps = empService.getEmps();
		//使用PageInfo包装查询后的结果，只需将pageInfo返回给页面即可
		//5：连续显示的页码数
		PageInfo pageInfo = new PageInfo(emps,5);
		Msg msg = Msg.success().add("pageInfo",pageInfo);
//		System.out.println("========="+msg.getExtend().get("pageInfo"));
		return msg;
	}
	
//	@RequestMapping("emp")
	public String list(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		/*
		 * 分页查询
		 * 需要引入pageHelper插件
		 * */
		//传入的页码，每页显示的数据条数
		PageHelper.startPage(pn,6);
		List<Emp> emps = empService.getEmps();
		//使用PageInfo包装查询后的结果，只需将pageInfo返回给页面即可
		//5：连续显示的页码数
		PageInfo pageInfo = new PageInfo(emps,5);
		model.addAttribute("pageInfo",pageInfo);
		return "list";
	}
}
