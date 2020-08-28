package com.clickhouse.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ClickHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickHouseApplication.class, args);
		log.info("clickHouseServer启动成功......");
	}

}
