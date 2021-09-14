package cn.enjoy.spring.cap6.config;


import cn.enjoy.spring.bean.JamesFactoryBean;
import cn.enjoy.spring.bean.JamesImportBeanDefinitionRegistrar;
import cn.enjoy.spring.bean.JamesImportSelect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JamesImportSelect.class, JamesImportBeanDefinitionRegistrar.class, JamesFactoryBean.class})
public class Cap6MainConfig {

//    @Bean
//    public JamesImportSelect jamesImportSelect(){
//        return new JamesImportSelect();
//    }
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
