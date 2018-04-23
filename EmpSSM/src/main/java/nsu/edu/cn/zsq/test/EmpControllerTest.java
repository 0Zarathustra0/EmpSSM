package nsu.edu.cn.zsq.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

import nsu.edu.cn.zsq.bean.Emp;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月23日 下午5:39:37 <br>
* 使用spring测试模块，测试controller请求
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class EmpControllerTest {
	//传入springmvc的ioc
	@Autowired
	WebApplicationContext context;
	
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void pageTest() throws Exception {
		//模拟请求，拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/list").param("pn", "1"))
				.andReturn();
		//请求成功之后，请求域中会有pageInfo，可以取出pageInfo进行验证。
		MockHttpServletRequest request = result.getRequest();
		PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
		System.out.println("当前页码：" +pageInfo.getPageNum());
		System.out.println("总页码："+pageInfo.getPages());
		System.out.println("总记录数："+pageInfo.getTotal());
		System.out.println("在页面中需要连续显示的页码");
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i : nums) {
			System.out.println(" "+i);
		}
		List<Emp> emps = pageInfo.getList();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
}
