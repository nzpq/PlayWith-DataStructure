package com.nzpq.$01array;

/**定义自己的ArrayList
 * @author 鹏
 * @Date 2020-10-13 21:26
 */
public class Array<E> {

    //存放数据的数组
    private E[] data;
    //数组元素的的个数，始终指向最后一个元素的下一个位置
    private int size;

    /**
     * 无参构造，用户如果不传递数组的长度，则默认是10
     */
    public Array(){
        this(10);
    }

    /**
     * 带参构造，用户可以指定数组的长度
     * @param capacity 数组的最大容量
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 获取数组元素个数
     * @return 元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组最大容量
     * @return 数组最大容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 尾插，在数组最后边添加元素
     * @param e 添加的元素
     */
    public void addLast(E e){

//        data[size] = e;
//        size++;

        // //直接调用add方法
        add(size,e);
    }

    /**
     * 头插，在数组第一个位置添加元素
     * @param e 添加的元素
     */
    public void addFirst(E e){
       //直接调用add方法
        add(0,e);
    }

    /**
     * 在指定位置index，添加元素e
     * @param index 数组索引
     * @param e 添加的元素
     */
    public void add(int index,E e){
        //判断数组中是否还有容量
        if(size == data.length){
//            throw new RuntimeException("元素添加失败 原因：数组已满");
            //如果数组满了，则执行扩容方法，2倍扩容
            resize(2 * data.length);

        }
        //判断要插入索引的位置，应在0和size之间，因为要确保数组中存储数据的连续性
        if(index < 0 || index > size){
            throw new RuntimeException("元素添加失败 原因：索引不合法");
        }
        /*
            思路：倒着遍历数组，让元素后移，直到到达索引处
         */
        for(int i = size - 1; i >= index; i--){
            //元素后移
            data[i+1] = data[i];
        }
        //插入数据
        data[index] = e;
        //size一直指向数组的最后一个元素的下一个位置，所以在添加完元素后需要后移一位
        size++;
    }

    /**
     * 改变数组最大容量的方法
     * @param newCapacity 新的数组最大容量
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        //遍历原始数组，复制到新数组
        for(int i = 0; i< size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * @return 输出数组中的所有元素
     */
    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array：size = %d , capacity = %d\n",size,data.length));
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 查看指定索引处的元素
     * @param index 指定索引
     * @return 元素
     */
    public E get(int index){
        if(size == 0){
            throw new RuntimeException("获取元素失败，原因：数组为空");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return 尾元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取头元素
     * @return 头元素，第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 修改指定索引处的元素
     * @param index 指定索引
     * @param e 元素
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new RuntimeException("修改失败，原因：索引不合法");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含元素e
     * @param e 被判断的元素
     * @return 结果
     */
    public boolean contain(E e){
        if(size == 0){
            throw new RuntimeException("数组为空");
        }
        for(int i = 0; i < size; i++ ){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找指定元素的索引
     * @param e 被查找的元素
     * @return 索引，-1表示没有找到
     */
    public int find(E e){
        if(size == 0){
            throw new RuntimeException("数组为空");
        }
        for(int i = 0; i < size; i++ ){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定的元素
     * @param e 被删除的元素
     */
    public void removeElement(E e){
        //先查找该元素
        int i = find(e);
        if(i != -1){
            //元素存在，删除一个
            remove(i);
        }
    }

    /**
     * 删除指定索引处的元素，返回被删除的元素
     * @param index 被删除元素的索引
     * @return 被删除的元素
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new RuntimeException("删除失败，原因：索引不合法");
        }

        /*
            思路：从index+1开始遍历，让索引后边的元素前移
         */
        //先将被删除的元素存起来
        E result = data[index];
        for(int i = index + 1;i < size;i++){
            //元素前移
            data[i - 1] = data[i];
        }
        size--;

        //如果元素的个数只有数组最大容量一半的时候，让数组最大容量减一半
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return result;
    }

    /**
     * 删除头元素
     * @return 头元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 移除尾元素
     * @return 最后一个元素
     */
    public  E removeLast(){
        return remove(size - 1);
    }
}
