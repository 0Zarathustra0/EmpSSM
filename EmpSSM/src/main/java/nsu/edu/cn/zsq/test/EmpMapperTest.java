package nsu.edu.cn.zsq.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nsu.edu.cn.zsq.bean.Emp;
import nsu.edu.cn.zsq.dao.EmpMapper;
import nsu.edu.cn.zsq.service.EmpService;

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
	
	@Autowired
	SqlSession sqlSession;
	
	//这个不能直接Autowired实现
	@Autowired
	EmpService empService;
	
	@Test
	public void listTest() {
		System.out.println(empService.getEmps());
	}
	
	@Test
	public void EmpTest() {
		empMapper.delete(7499);
		System.out.println("=================成功");
		
	}
	
	@Test
	public void batchTest() {
		/*
		 * 这是一个批量操作的插入
		 * 只有使用这个SqlSession获取的mapper才是一个可以批量操作的mapper
		 * */
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		for(int i=0;i<2;i++) {
			empMapper.save(new Emp( null, "测试", null, i, null, null, null, 20));
		}
	}
}
