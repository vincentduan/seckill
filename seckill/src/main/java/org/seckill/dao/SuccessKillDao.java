package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKillDao {
	
	/**
	 * 插入购买明细,可过滤重复
	 * 
	 * @param seckilledId
	 * @param userPhone
	 * @return 插入的行数
	 */
	int insertSuccessKilled(long seckilledId, long userPhone);

	/**
	 * 根据id查询SuccessKilled并携带秒杀产品对象
	 * @param seckilled
	 * @param userphone
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long seckilled);
}
