package com.ule.cerservice.config;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Properties;


@Configuration
public class TxAdiviceConfigByBeanName {
    @Autowired
    private DataSourceTransactionManager transactionManager;

    // 创建事务通知

    @Bean(name = "txAdvice")
    public TransactionInterceptor getAdvisor() throws Exception {

        Properties properties = new Properties();
        properties.setProperty("get*", "PROPAGATION_REQUIRED,-Exception,readOnly");
        properties.setProperty("add*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("save*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("update*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("delete*", "PROPAGATION_REQUIRED,-Exception");

        TransactionInterceptor tsi = new TransactionInterceptor(transactionManager,properties);
        return tsi;

    }

    @Bean
    public BeanNameAutoProxyCreator txProxy() {
        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
        creator.setInterceptorNames("txAdvice");
        creator.setBeanNames("*Service", "*ServiceImpl");
        creator.setProxyTargetClass(true);
        return creator;
    }
}
