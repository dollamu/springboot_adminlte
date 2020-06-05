package com.dollamu.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.dollamu.property.WechatProperties;

@Configuration // 开启配置
@EnableConfigurationProperties(WechatProperties.class) // 开启使用映射实体对象
//@ConditionalOnClass(WechatService.class)//存在HelloService时初始化该配置类
@ConditionalOnProperty// 存在对应配置信息时初始化该配置类
(prefix = "wechat", // 存在配置前缀hello
		value = "enabled", // 开启
		matchIfMissing = true// 缺失检查
)
public class WechatAutoConfig {

}
