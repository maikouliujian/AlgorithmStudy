package suanfa.wangzhen;


import java.util.TreeMap;

public class BinSearchTreeTest {

    private TreeNode root; //根节点

    //树节点
    public static class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {



    }


    //查找
    public TreeNode find(int data){
        TreeNode node= root;
        while (node!=null){
            if (node.data < data){
                node = node.right; //值大向右
            }else if (node.data > data){
                node = node.left;//值小向左
            }else {
                return node;
            }

        }
        return null;  //未找见
    }
    //插入：插入都是插入到叶子节点
    public void  insert(int data){
        if (root == null){
            root = new TreeNode(data);
            return;
        }

        TreeNode node = root;
        while (node!=null){
            if (data < node.data){
                if (node.left == null){
                    node.left = new TreeNode(data);
                    return;
                }
                node = node.left;
            }else if (data > node.data){
                if (node.right == null){
                    node.right= new TreeNode(data);
                    return;
                }
                node = node.right;
            }
        }
    }

    //删除：删除有三种情况
    //（1）：被删为叶子节点
    //（2）：被删只有一个子节点
    //（3）：被删有两个子节点
    public void delete(int data){
        if (root == null){
            return;
        }
        //先找后删
        //需要维护两个指针：当前节点和其父节点
        TreeNode pp = null; //fu
        TreeNode p = root; //current
        while (p!=null && data!=p.data){
            pp = p;
            if (data < p.data){
                p = p.left;
            }else if (data > p.data){
                p = p.right;
            }
        }
        if (p == null) return; //没找到节点
        //否则则找到了要删除的节点
        //#1:有两个节点,需要找到该节点右子树中的最小节点（重点！！！）
        if (p.left!=null && p.right!=null){
            TreeNode minpp = p;
            TreeNode minp = p.right;

            while (minp.left!=null){
                minpp = minp;
                minp = minp.left;
            }

            //先替换值
            p.data = minp.data;
            pp = minpp;
            p = minp;
            //以下变为统一删除逻辑（删除叶子节点和删除只有一个子节点的节点）
        }

        //删除一个子节点或者无子节点的逻辑
        //找到子节点
        TreeNode child = null;
        if (p.left!=null){
            child  = p.left;
        }else if (p.right!=null){
            child = p.right;
        }else child = null;

//        if (p == pp.left) pp.left = child;
//        if (p == pp.right) pp.right =  child;
        if (pp == null){
            //删除根节点
            root = child;
        }else if (p == pp.left){
            pp.left = child;
        }else {
            pp.right = child;
        }
    }



}
