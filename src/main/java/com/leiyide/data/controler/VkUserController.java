/**
 * 
 */
package com.leiyide.data.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiyide.data.domain.model.VkUser;
import com.leiyide.data.domain.service.VkUserService;
import com.leiyide.utils.ResponseData;

/**
 * @Title:VkUserController
 * @Description: 
 * @Company: 智能科技 
 * @version v0.1
 * @author leiyide
 * @date 2019年6月10日 上午11:45:11
 */
@RestController
@RequestMapping("/vkUserController")
public class VkUserController {
	
	/**
	 * required = false:表示忽略当前注入的bean，如果有，直接注入，如果没有直接跳过，不会报错
	 * required = true: 默认是存在注入的bean，
	 * 参考：https://blog.csdn.net/static_coder/article/details/79580981
	 */
	@Autowired(required = false)
	private VkUserService vkUserService;
	
	@GetMapping("/getVkUserInfo")
	public ResponseData getVkUserInfo(Integer userId) {
		if (userId != null) {
			VkUser vkUser = vkUserService.selectById(userId);
			return ResponseData.ok().putDataValue("vkUser", vkUser);
		}
		return ResponseData.notFount();
	}
	
	/**
	 * @Description: 测试使用xml注解形式，获取用户信息
	 * @param userId
	 * @return
	 */
	@GetMapping("/getVkUserById")
	public ResponseData getVkUserById(Integer userId) {
		if (userId != null) {
			VkUser vkUser = vkUserService.selectByPrimaryKey(userId);
			return ResponseData.ok().putDataValue("user", vkUser);
		}
		return ResponseData.notFount();
	}

}
