package tree;

import java.util.Arrays;

public class ArrayBinTree<E> {
	
	//使用数组保存树中的每一个节点
	private Object [] nodes;
	//默认深度
	private final int DEFAULT_DEEP = 8;
	//树的深度
	private int deep;
	//底层数组的长度（树的节点的个数）
	private int arraySize;
	
	/***
	 * 以默认深度创建底层数组
	 */
	public ArrayBinTree(){
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int) Math.pow(2, deep)-1;
		nodes = new Object[arraySize];
	}
	
	/***
	 * 指定树的深度创建树
	 * @param deep
	 */
	public ArrayBinTree(int deep){
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep)-1;
		nodes = new Object[arraySize];
	}
	
	/***
	 * 制定根节点和深度创建树
	 * @param data  指定根节点
	 * @param deep  树的深度
	 */
	public ArrayBinTree(E data , int deep){
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep)-1;
		nodes = new Object[arraySize];
		nodes[1] = data;
	}
	
	/***
	 * 为指定节点添加孩子节点
	 * @param index  指定节点
	 * @param data  添加的节点
	 * @param isLift  是否为左孩子
	 */
	public void add(int index , E data , boolean isLift){
		if(index>arraySize||index<1){
			throw new RuntimeException("底层数组下标越界，无法添加子节点");
		}
		if(2*index+1>=arraySize){
			throw new RuntimeException("底层数组已满，无法添加子节点");
		}
		if(nodes[index]==null){
			throw new RuntimeException("指定节点为null，无法添加子节点");
		}
		if(isLift){
			nodes[2*index] = data;
		}
		else {
			nodes[2*index+1] = data;
		}

	}
	
	/***
	 * 判断树是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return nodes[1]==null;
	}
	
	/***
	 * 返回根节点
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E getRoot(){
		return (E) nodes[1];
	}
	
	/***
	 * 返回指定节点（非根节点）的父节点
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E patent(int index){
		if(index==1){
			throw new RuntimeException("根节点没有父节点");
		}
		
		return (E) nodes[index/2];
	}
	
	/***
	 * 返回指定节点（非叶子节点）的左孩子
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E lift(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("叶子节点没有左孩子节点");
		}
		return (E) nodes[2*index];
	}
	
	/***
	 * 返回指定节点（非叶子节点）的右孩子
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E right(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("叶子节点没有右孩子节点");
		}
		return (E) nodes[2*index+1];
	}
	
	/***
	 * 返回树的深度
	 * @return deep
	 */
	public int deep(){
		return deep;
	}
	
	/***
	 * 返回指定节点在底层数组的位置，找不到返回-1
	 * @param data
	 * @return
	 */
	public int pos(E data){
		//该循环实际上就是按广度遍历这棵树
		for(int i = 1 ; i<=arraySize ; i++){
			if(nodes[i].equals(data)){
				return i;
			}
		}
		return -1;
	}
	
	public String toString(){
		return Arrays.toString(nodes);
	}
	
	
}
