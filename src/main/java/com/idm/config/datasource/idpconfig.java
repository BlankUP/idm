package com.idm.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * api服务数据源
 */
@Configuration
@MapperScan(basePackages = "com.idm.app.**.*.mapper", sqlSessionTemplateRef  = "idpSqlSessionTemplate")
public class idpconfig {

    @Autowired
    Environment env;

    @Bean(name = "idpDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.primary-datasource") // application.yml中对应属性的前缀
    public DataSource apiDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.primary-datasource.driver-class-name"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.primary-datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.primary-datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.primary-datasource.password"));
        return dataSource;
    }

    @Bean(name = "idpSqlSessionFactory")
    public SqlSessionFactory idmSqlSessionFactory(@Qualifier("idpDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/idm/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "idpTransactionManager")
    public DataSourceTransactionManager idmTransactionManager(@Qualifier("idpDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "idpSqlSessionTemplate")
    public SqlSessionTemplate idmSqlSessionTemplate(@Qualifier("idpSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
