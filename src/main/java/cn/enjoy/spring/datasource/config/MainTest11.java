package cn.enjoy.spring.datasource.config;

import cn.enjoy.spring.datasource.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest11 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap11MainConfig.class);
        OrderService orderService = (OrderService)ac.getBean(OrderService.class);
        orderService.addOrder();
        ac.close();
    }
}
