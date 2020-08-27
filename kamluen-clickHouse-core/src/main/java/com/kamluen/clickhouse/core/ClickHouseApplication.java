package com.kamluen.clickhouse.core;

import com.kamluen.common.plugin.EncryptBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class ClickHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickHouseApplication.class, args);
		log.info("kamluen-clickhouse-server启动成功......");
	}

	/**
	 * 自定义引入需要解密的密码bean对象(防止有些项目引用不到抛出空指针异常)
	 */
	Map<String,String> map = new HashMap<>();
	{
		map.put("org.springframework.boot.autoconfigure.jdbc.DataSourceProperties", "password");
	}

	@Bean
	public EncryptBeanPostProcessor encryptBeanPostProcessor(){
		EncryptBeanPostProcessor processor = new EncryptBeanPostProcessor(map);
		return processor;
	}

}
