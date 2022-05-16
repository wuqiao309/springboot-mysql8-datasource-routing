package wq.cdm.top.springbootdemo.config.datasource;


import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
@Configuration
public class DatasourceConfig {
    @Bean(DatasourceConst.DATASOURCE_MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        log.info("init master datasource");
        return DataSourceBuilder.create().build();
    }

    @Bean(DatasourceConst.DATASOURCE_SLAVE1)
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public DataSource slave1DataSource() {
        log.info("init slave1 datasource");
        return DataSourceBuilder.create().build();
    }

    @Bean(DatasourceConst.DATASOURCE_SLAVE2)
    @ConfigurationProperties(prefix = "spring.datasource.slave2")
    public DataSource slave2DataSource() {
        log.info("init slave1 datasource");
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    DataSource primaryDataSource(Map<String, DataSource> dataSourceMap) {
        log.info("init datasource routing");
        AbstractRoutingDataSource routingDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return DatasourceRoutingContext.get();
            }
        };
        routingDataSource.setTargetDataSources(new HashMap<>(dataSourceMap));
        routingDataSource.setDefaultTargetDataSource(dataSourceMap.get(DatasourceConst.DATASOURCE_MASTER));
        return routingDataSource;
    }
}
