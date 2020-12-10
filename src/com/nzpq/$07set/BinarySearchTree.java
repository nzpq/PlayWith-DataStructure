package com.nzpq.$07set;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * @author 鹏
 * @Date 2020-10-20 20:56
 */
public class BinarySearchTree<E extends Comparable<E>> {

    /**
     * 节点
     */
    private class Node{
        public E e;
        public Node left; //左孩子
        public Node right; //右孩子

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root; //根节点
    private int size; //节点的个数

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    /**
     *
     * @return 二分搜索树中节点的个数
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @return 二分搜索树是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @param e 向二分搜索树中添加元素
     */
    public void add(E e){
        //如果根节点为空
//        if(root == null){
//            root = new Node(e);
//        }else{
//            add(root,e);
//        }

        //使用优化后的添加节点的递归算法
        root = addNode(root,e);
    }

    /**
     * 递归算法，向以node为跟节点的二分搜索树中添加元素e，不允许重复添加
     * @param node 根节点
     * @param e 被添加的元素
     */
    private void add(Node node,E e){
        //判断当前节点的值是否和被插入的值是否相同
        if(node.e.equals(e)){
            return;
        }else if(e.compareTo(node.e) < 0 && node.left == null){
            //e < node.e
            node.left = new Node(e);
            size++;
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            //e > node.e
            node.right = new Node(e);
            size++;
        }

        if(e.compareTo(node.e) < 0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }

    /**
     * 递归添加元素的优化
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node addNode(Node node,E e){
        //二分搜索树为空，
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = addNode(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = addNode(node.right,e);
        }
        return node;
    }

    /**
     *
     * @param e 二分搜索树中是否包含元素e
     * @return true or false
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 判断以node为根节点的二分搜索树中是否包含元素e
     * @param node 根节点
     * @param e 元素
     * @return 结果
     */
    private boolean contains(Node node,E e){
        //非空判断
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            //e.compareTo(node.e) > 0
            return contains(node.right,e);
        }
    }

    /**
     * 用户调用的前序遍历方法
     */
    public void prevOrder(){
        prevOrder(root);
    }

    /**
     * 递归实现前序遍历
     *      对于当前节点，先输出该节点，然后输出他的左孩子，最后输出他的右孩子。
     * @param node 根节点
     */
    private void prevOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        prevOrder(node.left);
        prevOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 递归实现中序遍历
     *  对于当前结点，先输出它的左孩子，然后输出该结点，最后输出它的右孩子。
     * @param node 根节点
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 非递归实现前序遍历，使用栈
     */
    public void inorderNotRecursion(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.println(curr.e);
            //栈后入先出，所以右孩子先入栈
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 递归实现后序遍历
     * @param node 根节点
     */
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历，使用队列
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            System.out.println(curr.e);
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
    }

    /**
     *
     * @return 二分搜索树最小的元素
     */
    public E minimum(){
        if(isEmpty()) {
            throw new IllegalArgumentException("二分搜索树为空");
        }
        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node 根节点
     * @return 最小值所在的节点
     */
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     *
     * @return 删除最小元素并返回
     */
    public E removeMin(){
        E delE = minimum();
        root = removeMin(root);
        return delE;
    }

    /**
     * 删除以node为根的二分搜索书中最小节点
     * @param node 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node){
        if(node.left == null){
            //先把右孩子存起来
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     *
     * @return 删除最大元素
     */
    public E removeMax(){
        E delE = maximum();
        root =removeMax(root);
        return delE;
    }

    /**
     * 删除以node为根节点的二分搜索树中最大节点
     * @param node 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     *
     * @return 二分搜索树最大的元素
     */
    public E maximum(){
        if(isEmpty()) {
            throw new IllegalArgumentException("二分搜索树为空");
        }
        return maximum(root).e;
    }
    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node 根节点
     * @return 最大值所在的节点
     */
    private Node maximum(Node node){
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }


    /**
     *
     * @param e 删除e元素所在的节点
     */
    public void remove(E e){

    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * @param node 根节点
     * @param e 被删除e
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node,E e){

        if(node == null){
            return null;
        }else if(e.compareTo(node.e) < 0){
            //e小于当前节点的元素
            remove(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            remove(node.right,e);
        }else{
            //e.compareTo(node.e) == 0
            //当前节点就是需要被删除的，此时又有三种情况
            /*
                1、被删除节点的左孩子为null
                1、被删除节点的右孩子为null
                1、被删除节点的左孩子和右孩子都不为null
             */
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点的左右孩子都不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点代替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }


        return null;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    /**
     * 生成以node为根节点，深度威威depth的描述的二叉树字符串
     * @param node 根节点
     * @param depth 深度
     * @param sb 字符串
     */
    private void generateBSTString(Node node,int depth,StringBuilder sb){
        if(node == null){
            sb.append(generateDepthString(depth)).append("null\n");
            return;
        }
        sb.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left,depth + 1,sb);
        generateBSTString(node.right,depth + 1,sb);
    }

    /**
     * 生成深度字符串
     * @param depth 深度
     * @return 字符串
     */
    private String generateDepthString(int depth){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }


}
