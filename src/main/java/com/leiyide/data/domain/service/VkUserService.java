/**
 * 
 */
package com.leiyide.data.domain.service;

import com.baomidou.mybatisplus.service.IService;
import com.leiyide.data.domain.model.VkUser;

/**
 * @Title:VkUserService
 * @Description: 
 * @Company: 智能科技 
 * @version v0.1
 * @author leiyide
 * @date 2019年6月10日 上午11:38:42
 */
public interface VkUserService extends IService<VkUser>{

	/**
	 * @Description: 使用xml形式测试---根据用户id获得用户信息
	 * @param userId
	 * @return
	 */
	VkUser selectByPrimaryKey(Integer userId);
	
	VkUser selectByName(String userName);
}
