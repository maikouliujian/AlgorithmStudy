package xiaomage._第二季_._跳表;


import java.security.InvalidParameterException;
import java.util.Comparator;

public class SkipList<K,V> {
    private int size;
    //最高层数
    private static final int MAX_LEVEL = 32;
    //有效层数
    private int level;
    private Comparator<K> comparator;
    //不存放任何k-v
    private Node<K,V> first;
    //新加入节点的层级计算
    private static final double P = 0.25;


    public SkipList() {
        this(null);
    }

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        this.first = new Node<>(null,null,MAX_LEVEL);
        this.first.nexts = new Node[MAX_LEVEL];
    }

    public int size(){
        return size;
    }

    private void keyCheck(K key){
        if (key == null)
            throw  new InvalidParameterException("key is null");

    }




    public boolean isEmpty(){
        return size == 0;
    }


    //插入节点一定是从最底层开始插入的！！！
    public V put(K key,V value){
        keyCheck(key);
        //查找要插入的节点位置
        Node<K,V> node = first;
        //TODO :引入一个数组来存储待插入节点的前驱结点,这些个前驱结点其实就是会往下层级走的结点；
        Node<K,V>[] prevs = new Node[level];

        for (int i = level-1; i >=0 ; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key,node.nexts[i].key)) > 0){
                //如果key大，就继续往后找
                node = node.nexts[i];
            }
            //如果key存在，则覆盖值
            if (cmp == 0) {
                V oldV = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldV;
            }
            //这里是改变层级
            prevs[i] = node;
        }

        //创建新的节点
        int randomLevel = randomLevel();
        Node<K,V> newNode = new Node<>(key,value,randomLevel);
        //设置前驱和后继节点
        for (int i = 0; i < randomLevel; i++) {
            //如果新节点的层级大于前驱节点，则让first直接指向新节点
            if (i > level){
                first.nexts[i] = newNode;
            }else {
                //后继节点
                newNode.nexts[i] = prevs[i].nexts[i];
                prevs[i].nexts[i] = newNode;
            }
        }


        size++;

        //计算跳表的最终层数
        level = Math.min(level,randomLevel);
        return null;
    }

    public V get(K key){
        keyCheck(key);
        //从有效层的最顶层开始查找
//        Node<K,V>[] tmp = first.nexts;
//        for (int i = level-1; i >=0 ; i--) {
//            while (compare(key,tmp[i].key) > 0){
//                //如果key大，就继续往后找
//                tmp = tmp[i].nexts;
//                //如果相等就说明找到了
//                if (compare(key,tmp[i].key) == 0)
//                    return tmp[i].value;
//            }
//            //如果没找见，需要降低层级进行寻找
//        }

        Node<K,V> tmp = first;
        for (int i = level-1; i >=0 ; i--) {
            int cmp = -1;
            while (tmp.nexts[i] != null && (cmp = compare(key,tmp.nexts[i].key)) > 0){
                //如果key大，就继续往后找
                tmp = tmp.nexts[i];
            }
            if (cmp == 0) return tmp.nexts[i].value;
            //如果没找见，需要降低层级进行寻找
        }
        return null;
    }

    public V remove(K key){
        keyCheck(key);
        //查找要插入的节点位置
        Node<K,V> node = first;
        //TODO :引入一个数组来存储待插入节点的前驱结点,这些个前驱结点其实就是会往下层级走的结点；
        Node<K,V>[] prevs = new Node[level];
        boolean exist = false;//节点是否存在
        for (int i = level-1; i >=0 ; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key,node.nexts[i].key)) > 0){
                //如果key大，就继续往后找
                node = node.nexts[i];
            }
            //这里是改变层级
            prevs[i] = node;
            if (cmp == 0) exist = true;
        }
        //节点不存在，不删除
        if (!exist) return null;
        //需要被删除的节点
        Node<K,V> removedNode = node.nexts[0];
        //设置后继节点
        for (int i = 0; i < removedNode.nexts.length; i++) {
            prevs[i].nexts[i] = removedNode.nexts[i];
        }

        //更新跳表的层级
        int newLevel = level;
        while (--newLevel >= 0 && first.nexts[newLevel] == null){
            level = newLevel;
        }

        size--;


        return node.nexts[0].value;
    }

    private int randomLevel(){
        int level = 1; //最少一层！！！
        while (Math.random() < P && level <= MAX_LEVEL){
            level++;
        }
        return level;
    }

    //比较方法；
    private int compare(K k1,K k2){
        return comparator != null? comparator.compare(k1,k2) :
                ((Comparable<K>)k1).compareTo(k2);
    }

    private static class Node<K,V>{
        K key;
        V value;
        //一个节点有多个next
        Node<K,V>[] nexts;

        public Node(K key, V value,int level) {
            this.key = key;
            this.value = value;
            this.nexts = new Node[level];
        }
    }
}
