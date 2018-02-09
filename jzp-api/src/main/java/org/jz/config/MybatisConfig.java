package org.jz.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Hongyi Zheng
 * @date 2018/2/9
 */

@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;

    private final String CONFIG_XML_PATH = "classpath:mybatis-config.xml";

    private final String MAPPER_XML_PATH = "classpath:org.jz.dao.mapper/**.xml";

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setConfigLocation(pathMatchingResourcePatternResolver.getResource(CONFIG_XML_PATH));
        sqlSessionFactory.setMapperLocations(pathMatchingResourcePatternResolver.getResources(MAPPER_XML_PATH));

        try {
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
