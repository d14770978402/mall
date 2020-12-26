package com.deng.malltiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.deng.malltiny.dao","com.deng.malltiny.mbg.mapper"})
public class MybatisConfig {
}
