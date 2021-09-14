package cn.enjoy.spring.init.config;


import cn.enjoy.spring.bean.JamesFactoryBean;
import cn.enjoy.spring.bean.JamesImportBeanDefinitionRegistrar;
import cn.enjoy.spring.bean.JamesImportSelect;
import cn.enjoy.spring.init.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({JamesImportSelect.class, JamesImportBeanDefinitionRegistrar.class, JamesFactoryBean.class})
@ComponentScan("cn.enjoy.spring.init.bean")
//@EnableAspectJAutoProxy
public class Cap7MainConfig {

    @Bean(initMethod = "myInit",destroyMethod = "myDestroy")
    public Bike bike(){
        return new Bike();
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
