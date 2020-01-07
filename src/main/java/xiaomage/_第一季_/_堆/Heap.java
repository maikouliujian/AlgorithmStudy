package xiaomage._第一季_._堆;

/**
 * @author lj
 * @createDate 2020/1/7 10:23
 **/
public interface Heap<E> {

    int size();
    boolean isEmpty();
    void clear();
    void add(E element);
    E get();
    E remove();
    E replace(E element);
}
