/**
 * 
 */
package com.leiyide.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

/**
 * @Title:MybatisPlusConfig
 * @Description: MybatisPlus配置类
 * @Company: 智能科技 
 * @version v0.1
 * @author leiyide
 * @date 2019年6月10日 上午9:48:30
 */
@Configuration
public class MybatisPlusConfig {
	
	/**
	 * @Description:mybatis-plus SQL执行效率插件【生成环境可以关闭】
	 * 此处主要是针对sql执行性能的分析，在开发环境使用，线上不推荐。
	 * @return
	 */
	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		//设置sql最大执行时长
		//performanceInterceptor.setMaxTime(5000);
		//sql是否格式化，默认是false
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}
	
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
