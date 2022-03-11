package cn.enjoy.spring.cap9.config;

import cn.enjoy.spring.cap9.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.enjoy.spring.cap9")
public class Cap9MainConfig {

    @Autowired
    private TestService testService;
}
