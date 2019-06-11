/**
 * 
 */
package com.leiyide.data.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.leiyide.data.domain.mapper.VkUserMapper;
import com.leiyide.data.domain.model.VkUser;
import com.leiyide.data.domain.service.VkUserService;

/**
 * @Title:VkUserServiceImpl
 * @Description: 
 * @Company: 智能科技 
 * @version v0.1
 * @author leiyide
 * @date 2019年6月10日 上午11:39:17
 */
@Service
@Transactional
public class VkUserServiceImpl extends ServiceImpl<VkUserMapper, VkUser> implements VkUserService {
	
	@Autowired
	private VkUserMapper vkUserMapper;
	
	/**
	 * @Description: 使用xml形式测试---根据用户id获得用户信息
	 * @param userId
	 * @return
	 */
	public VkUser selectByPrimaryKey(Integer userId) {
		return userId != null ? vkUserMapper.selectByPrimaryKey(userId) : null;
	}
	
}
