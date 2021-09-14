package cn.enjoy.spring.aop.config;


import cn.enjoy.spring.aop.Calculator;
import cn.enjoy.spring.aop.LogAspects;
import cn.enjoy.spring.init.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@Import({JamesImportSelect.class, JamesImportBeanDefinitionRegistrar.class, JamesFactoryBean.class})
//@ComponentScan("cn.enjoy.spring.init.bean")
@EnableAspectJAutoProxy
public class Cap10MainConfig {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

//
//    @Bean
//    public JamesImportBeanDefinitionRegistrar jamesImportBeanDefinitionRegistrar(){
//        return new JamesImportBeanDefinitionRegistrar();
//    }
//
//    @Bean
//    public JamesFactoryBean jamesFactoryBean (){
//        return new JamesFactoryBean();
//    }

}
