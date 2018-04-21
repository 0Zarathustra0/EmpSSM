package nsu.edu.cn.zsq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nsu.edu.cn.zsq.dao.EmpMapper;

/** 
* @author zhangshuqiang <br>
* @version 2018年4月21日 下午8:08:30 <br>
* spring的测试组件，使用spring测试
* @ContextConfiguration指定spring配置文件的位置
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class EmpMapperTest {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void EmpTest() {
		empMapper.delete(7839);
		System.out.println("=================成功");
		
	}
}
