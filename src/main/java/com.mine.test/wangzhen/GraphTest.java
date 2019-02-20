package com.mine.test.wangzhen;

import org.apache.flink.runtime.query.QueryableStateUtils;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest {

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.bfs(0,7);
        System.out.println("===");
        graph.dfs(0,7);

    }


    //无向图
    public static class Graph{


        private int v; //顶点个数  //用0---v-1 之间的数来表示各个顶点
        private LinkedList<Integer> adj[]; //临界表--->链表数组

        public Graph(int v) {
            this.v = v;
            //有几个顶点，就有几个链表
            this.adj = new LinkedList[v];
            //初始化邻接表
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }

        // 无向图一条边存两次
        public void addEdge(int s,int t){
            adj[s].add(t);
            adj[t].add(s);
        }

        public void bfs(int s,int t){
            if (s == t) return;
            //1、顶点是否被访问过，避免顶点的重复访问
            boolean[] visited = new boolean[v];
            visited[s] = true;  //s被访问
            //2、广度优先遍历用队列。存储已经被访问，但是其周边节点还未被访问的顶点
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(s);
            //3、存储访问路径,初始化都为-1
            int[] pre = new int[v];
            for (int i = 0; i <v; i++) {
                pre[i] = -1;
            }
            while (!queue.isEmpty()){
                //先进先出
                int w = queue.poll();
                //找到q对应的邻接表
                int size = adj[w].size();
                //遍历取q节点的每个周边顶点
                for (int i = 0; i < size; i++) {
                    int q = adj[w].get(i);
                    //找到未访问过的顶点进行处理
                    if (!visited[q]){
                        //q的前置访问顶点为w  w---->q
                        pre[q] = w;
                        //如果找到  则退出遍历
                        if (t == q)
                        {
                            printSearchTrace(pre,s,t);
                            return;
                        }

                        //设置其被访问
                        visited[q] = true;
                        //入队列
                        queue.add(q);
                    }
                }
            }
        }

        private boolean found; //用于深度优先遍历，是否找见，用与跳出递归！！！
        //深度优先，回溯法，用递归
        public void dfs(int s,int t){
            if (s == t) return;
            found = false;
            boolean[] visited = new boolean[v];
            int[] pre = new int[v];
            for (int i = 0; i < v; i++) {
                pre[i] = -1;
            }

            recurDfs(pre,visited,s,t);
            printSearchTrace(pre,s,t);
        }

        private void recurDfs(int[] pre, boolean[] visited, int s, int t) {
            if (found) return;
            visited[s] = true;
            if (s == t){
                found = true;
                return;
            }
            for (int i = 0; i < adj[s].size(); i++) {
                int q = adj[s].get(i);
                if (!visited[q]){
                    pre[q] = s;
                    recurDfs(pre,visited,q,t);
                }
            }
        }

        //递归从后向前找到完整路径
        private void printSearchTrace(int[] pre, int s, int t) {
            //
            if (pre[t]!=-1 && t!=s){
                //递归打印
                printSearchTrace(pre,s,pre[t]);
            }
            System.out.print(t + "--->");
        }
    }


}
