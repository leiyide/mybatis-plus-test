package com.leiyide.data.domain.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.leiyide.data.domain.model.VkUser;

public interface VkUserMapper extends BaseMapper<VkUser>{
    int deleteByPrimaryKey(Integer userId);

    Integer insert(VkUser record);

    int insertSelective(VkUser record);

    VkUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(VkUser record);

    int updateByPrimaryKey(VkUser record);
    
    
    VkUser selectByName(String userName);
}