package com.mine.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lj
 * @createDate 2020/5/25 9:15
 **/
public class _146_LRU缓存机制 {
    private Node first;  //虚拟头节点
    private Node end;  //虚拟尾节点
    //private int size;
    private int capacity;
    private Map<Integer, Node> map;



    /***
     * 实现lru的算法通过hashmap和双向链表
     * TODO hashmap方便使用o1去取和赋值，双向链表维护最近最少使用
     * @param capacity
     */
    public _146_LRU缓存机制(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);

        first = new Node();
        end = new Node();
        first.next = end;
        end.pre = first;
        //this.size = 0;

    }

    public int get(int key) {
        //从hashmap中取值
        Node node = map.getOrDefault(key, null);
        if (node == null){
            return -1;
        }else {
            //先维护最近最少使用
            //1、先删除当前节点
            removeNode(node);
            //2、把当前节点放入head后
            addNodeAfterHead(node);
            //返回值
            return node.value;
        }


    }

    private void addNodeAfterHead(Node node) {
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
        //从hashmap中取值
        Node node = map.getOrDefault(key, null);
        if (node == null){
            //节点不存在
            //添加节点，删除最少使用节点
            if (map.size() >=  capacity){
                //删除尾节点的前节点
//                removeNode(end.pre);
//                map.remove(end.pre.key);
                //TODO 先删除map中节点，再删除链表

                map.remove(end.pre.key);
                removeNode(end.pre);
                //removeNode(map.remove(end.pre.key));
                //size--;
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addNodeAfterHead(newNode);
            //size++;

        }else {
            //节点存在，覆盖其值
            node.value = value;
            //先维护最近最少使用
            //1、先删除当前节点
            removeNode(node);
            //2、把当前节点放入head后
            addNodeAfterHead(node);
        }

    }

    private static class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
