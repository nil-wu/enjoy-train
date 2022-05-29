package cn.enjoy.safeclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里虽然没有用final，但是也是不可变的类，是线程安全的（因为没有提供set或者get方法，自身也没有修改list这个参数）
 */
public class ImmutableToo {

    private List<Integer> list = new ArrayList<>(3);

    public ImmutableToo(){
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public boolean isContains(int i){
        return list.contains(i);
    }


}
