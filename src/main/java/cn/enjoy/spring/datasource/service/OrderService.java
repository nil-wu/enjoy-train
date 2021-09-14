package cn.enjoy.spring.datasource.service;

import cn.enjoy.spring.datasource.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public void addOrder(){
        orderDao.insert();
        System.out.println("操作完成");
    }

}
