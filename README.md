# mybatis-plus-test
持久层集成mybatis-plus

整体的框架为：springboot+mybatis+mybatis-plus+mysql，
使用逆向生成插件与代码构造器，在生成实体时将匹配对应的注解与注释。
问题总结：
1、demo中可以正常使用，整合到项目中竟然报错，信息如下：
"Invalid bound statement (not found): com.leiyide.data.domain.mapper.LydOperationLogMapper.insertSelective
找了很久，依然无果，最后发现是配置的原因，之前是针对mybatis做的配置，可能存在冲突，换成
mybatis-plus.mapper-locations:classpath:mapper/*.xml
mybatis-plus.type-aliases-package=com.lyd.data.domain.model
则可以解决上述问题
2、nested exception is org.apache.ibatis.reflection.ReflectionException: with value '113838031049008742'
解决方法：
在实体id属性上加入对应的id生成类型，如为自动增长：@TableId(value = "id", type = IdType.AUTO)，测试可以解决此问题。
