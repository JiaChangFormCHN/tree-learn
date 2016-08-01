package tree;

import java.util.Arrays;

public class ArrayBinTree<E> {
	
	//ʹ�����鱣�����е�ÿһ���ڵ�
	private Object [] nodes;
	//Ĭ�����
	private final int DEFAULT_DEEP = 8;
	//�������
	private int deep;
	//�ײ�����ĳ��ȣ����Ľڵ�ĸ�����
	private int arraySize;
	
	/***
	 * ��Ĭ����ȴ����ײ�����
	 */
	public ArrayBinTree(){
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int) Math.pow(2, deep)-1;
		nodes = new Object[arraySize];
	}
	
	/***
	 * ָ��������ȴ�����
	 * @param deep
	 */
	public ArrayBinTree(int deep){
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep)-1;
		nodes = new Object[arraySize];
	}
	
	/***
	 * �ƶ����ڵ����ȴ�����
	 * @param data  ָ�����ڵ�
	 * @param deep  �������
	 */
	public ArrayBinTree(E data , int deep){
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep)-1;
		nodes = new Object[arraySize];
		nodes[1] = data;
	}
	
	/***
	 * Ϊָ���ڵ���Ӻ��ӽڵ�
	 * @param index  ָ���ڵ�
	 * @param data  ��ӵĽڵ�
	 * @param isLift  �Ƿ�Ϊ����
	 */
	public void add(int index , E data , boolean isLift){
		if(index>arraySize||index<1){
			throw new RuntimeException("�ײ������±�Խ�磬�޷�����ӽڵ�");
		}
		if(2*index+1>=arraySize){
			throw new RuntimeException("�ײ������������޷�����ӽڵ�");
		}
		if(nodes[index]==null){
			throw new RuntimeException("ָ���ڵ�Ϊnull���޷�����ӽڵ�");
		}
		if(isLift){
			nodes[2*index] = data;
		}
		else {
			nodes[2*index+1] = data;
		}

	}
	
	/***
	 * �ж����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return nodes[1]==null;
	}
	
	/***
	 * ���ظ��ڵ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E getRoot(){
		return (E) nodes[1];
	}
	
	/***
	 * ����ָ���ڵ㣨�Ǹ��ڵ㣩�ĸ��ڵ�
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E patent(int index){
		if(index==1){
			throw new RuntimeException("���ڵ�û�и��ڵ�");
		}
		
		return (E) nodes[index/2];
	}
	
	/***
	 * ����ָ���ڵ㣨��Ҷ�ӽڵ㣩������
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E lift(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("Ҷ�ӽڵ�û�����ӽڵ�");
		}
		return (E) nodes[2*index];
	}
	
	/***
	 * ����ָ���ڵ㣨��Ҷ�ӽڵ㣩���Һ���
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E right(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("Ҷ�ӽڵ�û���Һ��ӽڵ�");
		}
		return (E) nodes[2*index+1];
	}
	
	/***
	 * �����������
	 * @return deep
	 */
	public int deep(){
		return deep;
	}
	
	/***
	 * ����ָ���ڵ��ڵײ������λ�ã��Ҳ�������-1
	 * @param data
	 * @return
	 */
	public int pos(E data){
		//��ѭ��ʵ���Ͼ��ǰ���ȱ��������
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
