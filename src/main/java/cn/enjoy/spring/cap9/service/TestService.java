package cn.enjoy.spring.cap9.service;

import cn.enjoy.spring.cap9.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public TestDao getTestDao() {
        return testDao;
    }

    public void printLn() {
        System.out.println(testDao);
    }

}
