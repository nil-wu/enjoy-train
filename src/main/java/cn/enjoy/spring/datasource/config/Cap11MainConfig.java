package cn.enjoy.spring.datasource.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("cn.enjoy.spring.datasource")
public class Cap11MainConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("third_party_supplier_dev");
        dataSource.setPassword("Aldp0982");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://10.1.23.10:6033/third_party_supplier_dev?useUnicode=true&characterEncoding=utf8&autoReconnect=true");
        dataSource.setInitialPoolSize(1);
        dataSource.setIdleConnectionTestPeriod(30);
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(false);
        dataSource.setAcquireIncrement(1);
        dataSource.setMaxIdleTime(3600);
        dataSource.setAcquireRetryAttempts(30);
        dataSource.setAcquireRetryDelay(1000);
        dataSource.setCheckoutTimeout(30000);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }

}
