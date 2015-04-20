package com.cjduan.www.spring.jpa.sample.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.cjduan.www.spring.jpa.sample.domain.Addr;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 * 
 * mult datasource 
 * https://github.com/drumonii/SpringBootTwoDataSources/blob/master/src/main/java/demo/config/DataSourceConfig.java
 * 
 * @author cjduan
 *
 */
@Configuration
@EnableJpaRepositories
public class RemoteBoneCPConfig {

    @Value("${remote.bonecp.url}")
    private String jdbcUrl;

    @Value("${remote.bonecp.username}")
    private String jdbcUsername;

    @Value("${remote.bonecp.password}")
    private String jdbcPassword;

    @Value("${remote.bonecp.driverClass}")
    private String driverClass;

    @Value("${remote.bonecp.idleMaxAgeInMinutes}")
    private Integer idleMaxAgeInMinutes;

    @Value("${remote.bonecp.idleConnectionTestPeriodInMinutes}")
    private Integer idleConnectionTestPeriodInMinutes;

    @Value("${remote.bonecp.maxConnectionsPerPartition}")
    private Integer maxConnectionsPerPartition;

    @Value("${remote.bonecp.minConnectionsPerPartition}")
    private Integer minConnectionsPerPartition;

    @Value("${remote.bonecp.partitionCount}")
    private Integer partitionCount;

    @Value("${remote.bonecp.acquireIncrement}")
    private Integer acquireIncrement;

    @Value("${remote.bonecp.statementsCacheSize}")
    private Integer statementsCacheSize;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
        dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
        dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
        dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
        dataSource.setPartitionCount(partitionCount);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setStatementsCacheSize(statementsCacheSize);
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean remoteEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource())
                .packages(Addr.class)
                .persistenceUnit("addr")
                .build();
    }

}