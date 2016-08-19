package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 配置Spring和Junit整合,junit启动时加载springIOC容器
 * spring-test,junit
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReduceNumber() {
		Date killTime = new Date();
		int updateCount =  seckillDao.reduceNumber(1000L, killTime);
		System.out.println(updateCount);
	}

	@Test
	public void testQueryById() {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
//		1000元秒杀iPhone6
//		Seckill [seckillId=1000, name=1000元秒杀iPhone6, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Thu Aug 18 12:50:38 CST 2016]

	}

	@Test
	public void testQueryAll() {
		//org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.binding.BindingException: Parameter 'offset' not found. Available parameters are [1, 0, param1, param2]
		//java没有保存形参的记录
		//添加上@Param("offset")
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for(Seckill seckill : seckills){
			System.out.println(seckill);
		}
//				Seckill [seckillId=1000, name=1000元秒杀iPhone6, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Thu Aug 18 12:50:38 CST 2016]
//				Seckill [seckillId=1001, name=500元秒杀iPad2, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Thu Aug 18 12:50:38 CST 2016]
//				Seckill [seckillId=1002, name=300元秒杀小米4, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Thu Aug 18 12:50:38 CST 2016]
//				Seckill [seckillId=1003, name=200元秒杀红米, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Thu Aug 18 12:50:38 CST 2016]
	}

}
