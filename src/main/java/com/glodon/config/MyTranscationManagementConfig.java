package com.glodon.config;

import com.glodon.bean.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@Configuration
public class MyTranscationManagementConfig {

    /**
     * 声明式事务
     * @param dataSource
     * @return
     */

    @Qualifier("myRoutingDataSource")
    @Autowired(required = false)
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
