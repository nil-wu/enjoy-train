package cn.enjoy.jvm.countset;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 继承
 * @param <E>
 */
public class ExtendsHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public ExtendsHashSet(){}

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount = addCount + c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        ExtendsHashSet<String> s = new ExtendsHashSet<>();
        s.addAll(Arrays.asList("Mark", "Lison", "James"));
        System.out.println(s.getAddCount());
    }


}
