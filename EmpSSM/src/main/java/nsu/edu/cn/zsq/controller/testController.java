package nsu.edu.cn.zsq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月21日 下午3:59:57 <br>
*/
@Controller
public class testController {
	
	@RequestMapping("/list")
	public String hello() {
		return "hello";
	}
}
