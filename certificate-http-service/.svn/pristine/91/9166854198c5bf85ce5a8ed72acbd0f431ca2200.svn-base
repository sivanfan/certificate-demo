package com.ule.cerservice.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName DruidConfigration
 * @Author fanxl
 * @Description //TODO
 * @Date 10:23  2019/2/26
 * @Version 1.0
 **/
@Component
@Configuration
@PropertySource("classpath:jdbc2.properties")
public class DruidConfigration {
    @Value("${jdbc.ule_certificate-master.url}")
    private String url;
    @Value("${jdbc.ule_certificate-master.username}")
    private String username;
    @Value("${jdbc.ule_certificate-master.password}")
    private String password;
    private String driverClassName="com.mysql.jdbc.Driver";
    @Value("${jdbc.ule_certificate-master.initialSize}")
    private int initialSize;
    @Value("${jdbc.ule_certificate-master.minIdle}")
    private int minIdle;
    @Value("${jdbc.ule_certificate-master.maxActive}")
    private int maxActive;
    @Value("${jdbc.ule_certificate-master.maxWait}")
    private int maxWait;
    private int minEvictableIdleTimeMillis=300000;
    @Value("${jdbc.ule_certificate-master.validationQuery}")
    private String validationQuery;
    private boolean poolPreparedStatements=true;
    private int maxPoolPreparedStatementPerConnectionSize=20;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return datasource;
    }
}
