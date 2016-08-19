package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKillDao {
	
	/**
	 * ���빺����ϸ,�ɹ����ظ�
	 * 
	 * @param seckilledId
	 * @param userPhone
	 * @return ���������
	 */
	int insertSuccessKilled(long seckilledId, long userPhone);

	/**
	 * ����id��ѯSuccessKilled��Я����ɱ��Ʒ����
	 * @param seckilled
	 * @param userphone
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long seckilled);
}
