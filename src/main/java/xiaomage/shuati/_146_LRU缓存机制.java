package xiaomage.shuati;

import xiaomage._第二季_.mysort.tools.Asserts;

import java.util.HashMap;
import java.util.Map;

class LRUCache {


    public static void main(String[] args) {
        LRUCacheJdk cache = new LRUCacheJdk(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        Asserts.test(cache.get(1) == 1); // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        Asserts.test(cache.get(2) == -1);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        Asserts.test(cache.get(1) == -1);       // 返回 -1 (未找到)
        Asserts.test(cache.get(3) == 3);       // 返回  3
        Asserts.test(cache.get(4) == 4);       // 返回  4
    }

    //todo : 思路：采用hashmap和双线链表来实现

    private Map<Integer, Node> map;
    //虚拟头节点
    private Node first;
    //虚拟尾节点
    private Node end;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        first = new Node();
        end = new Node();
        first.next = end;
        end.pre = first;

    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node == null) return -1;
        //如果节点存在，先维护最近使用状态
        //1、删除双向链表中节点
        removeNode(node);
        //2、将节点加入到虚拟头节点后面
        addNodeAfterFirst(node);
        return node.value;

    }

    private void addNodeAfterFirst(Node node) {
        node.next = first.next;
        first.next.pre = node;

        first.next = node;
        node.pre = first;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if (node != null) {
            //存在就更新值
            node.value = value;
            //维护状态
            removeNode(node);
            addNodeAfterFirst(node);
        } else {
            //添加
            if (map.size() == capacity) {
                //移除最少使用的元素
                removeNode(map.remove(end.pre.key));
            }
            //添加元素
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            addNodeAfterFirst(newNode);
        }
    }

    private static class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
