package org.seckill.service.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetSeckillList() throws Exception{
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}",list);
	}
	
	@Test
	public void testGetById() throws Exception {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}",seckill);
	}
	
	@Test
	public void testExportSeckillUrl() throws Exception{
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("exposer={}",exposer);
		//exposer=Exposer [exposed=true, md5=ee2e23a6957c2201f39427379dd1c62a, seckillId=1000, now=0, start=0, end=0]
	}
	
	@Test
	public void testExecutionSeckill() throws Exception{
		long id = 1000;
		long phone = 15825453696L;
		String md5 = "ee2e23a6957c2201f39427379dd1c62a";
		try {
			SeckillExecution seckillExecution  = seckillService.excuteSeckill(id, phone, md5);
			logger.info("seckillExecution={}",seckillExecution);
		} catch (RepeatKillException e) {
			logger.error(e.getMessage(),e);
		} catch (SeckillCloseException e2) {
			logger.error(e2.getMessage(),e2);
		}
	}
	@Test
	public void excuteSeckillProcedure(){
		long seckillId = 1001;
		long phone = 15801202092L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			String md5 = exposer.getMd5();
			SeckillExecution execution = seckillService.excuteSeckillProcedure(seckillId, phone, md5);
			logger.info(execution.getStateInfo());
		}
		String md5 = null;
		
	}
	
	
}
