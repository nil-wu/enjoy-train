package cn.enjoy.spring.cap9.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sun {

    private Moon moon;

//    public Sun() {
//        System.out.println(toString());
//    }

    public Sun(Moon moon) {
        this.moon = moon;
    }

    public Moon getMoon() {
        return moon;
    }

    @Autowired
    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "moon=" + moon +
                '}';
    }
}
