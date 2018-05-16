package shuwei.improve.leetcode.regular.expression.matching;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author shuwei
 * @version 创建时间：2017年8月31日 上午9:11:24
 * 类说明
 */
public class Bag<Item> implements Iterable<Item>{

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }
}
