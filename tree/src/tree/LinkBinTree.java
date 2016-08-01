package tree;

public class LinkBinTree<E> {
	
	//����������ʽ�洢�ṹ
	class node{
		Object data;	//�ڵ�����
		node left;		//����ָ��
		node rigth;		//�Һ���ָ��
		
	}
	//�����ڵ�
	private node root;	
	
	/***
	 * ����һ�ÿ���
	 */
	public LinkBinTree(){
		this.root = new node();
	}
	
	/***
	 * ��ָ����Ԫ�ع�����
	 * @param data
	 */
	public LinkBinTree(E data){
		this.root = new node();
		this.root.data = data;
	}
	
	/***
	 * Ϊָ���ڵ�����ӽڵ�
	 * @param parent  ָ���ڵ�
	 * @param data  �½ڵ������
	 * @param isLeft  �Ƿ�Ϊ����
	 * @return newNode ��������ӵĽڵ�
	 */
	public node addNode(node parent , E data , boolean isLeft){
		if(parent == null){
			throw new RuntimeException("ָ���ڵ�Ϊnull���޷�����ӽڵ�");
		}
		if(isLeft && parent.left!=null){
			throw new RuntimeException("ָ���ڵ��Ѿ��������ӣ��޷�����ӽڵ�");
		}
		if(!isLeft && parent.rigth!=null){
			throw new RuntimeException("ָ���ڵ��Ѿ������Һ��ӣ��޷�����ӽڵ�");
		}
		
		node newNode = new node();
		newNode.data = data;
		if(isLeft){
			parent.left = newNode;
		}
		else {
			parent.rigth = newNode;
		}
		return newNode;
	}
	
	/***
	 * �ж϶������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return root.data==null;
	}
	
	/***
	 * ���ظ��ڵ�
	 * @return
	 */
	public node getRoot(){
		return root;
	}
	
	/***
	 * ����ָ���ڵ�ĸ��ڵ�
	 * @param n ָ���ڵ�
	 * @return ���ڵ�
	 */
	public node getParent(node n){
		if( n==null){
			throw new RuntimeException("ָ���ڵ�Ϊnull���޷����ʸ��ڵ�");
		}
		if(n==root){
			throw new RuntimeException("ָ���ڵ�Ϊ�����ڵ㣬�����ڵ�û�и��ڵ�");
		}
		return getParent(root, n);
	}
	/***
	 * ����ָ���ڵ�����ӽڵ�
	 * @param parent ָ���ڵ�
	 * @return ָ���ڵ�����ӽڵ㣬�������򷵻�null
	 */
	@SuppressWarnings("unchecked")
	public E leftChild(node parent){
		if(parent == null){
			throw new RuntimeException("ָ���ڵ�Ϊnull���޷������ӽڵ�");
		}
		return  parent.left == null? null:(E)parent.left.data;
	}
	
	public E rigthChild(node parent){
		if(parent == null){
			throw new RuntimeException("ָ���ڵ�Ϊnull���޷������ӽڵ�");
		}
		return parent.rigth==null? null:(E)parent.rigth.data;
	}
	
	/***
	 * �������������ȣ����������
	 * @param root ���ڵ�
	 * @return �������
	 */
	public int deep(node root){
		if(root==null) return 0;	//����ǿ��������Ϊ0���ݹ����
		else {
			int m = deep(root.left);	//�ݹ��������������ȼ�Ϊm
			int n = deep(root.rigth);	//�ݹ��������������ȼ�Ϊn
			
			return m>n? m+1:n+1;	//�����������Ϊ m �� n�Ľϴ��߼�1
		}
	}
	
	/***
	 * ͳ�ƶ������нڵ�ĸ������ݹ飩
	 * @param root ���ڵ�
	 * @return �ڵ����
	 */
	public int nodeCount(node root){
		if(root==null) return 0;	//����ǿ�������ڵ����Ϊ0���ݹ����
		else return nodeCount(root.left)+nodeCount(root.rigth)+1;	//����ڵ����Ϊ�������Ľڵ����+�������Ľڵ����+1
	}
	
	/***
	 * ǰ��������������ݹ飩
	 * @param root ���ĸ��ڵ�
	 * @param n ָ���Ľڵ�
	 * @return ָ���ڵ�ĸ��ڵ�
	 */
	private node getParent(node root , node n){
		node parent = null;
		if(root!=null){
			if(root.left!=null && root.left.equals(n)) return root;
			else if(root.rigth!=null && root.rigth.equals(n)) return root;
			parent = getParent(root.left,n);	//����������ҵ�Ŀ��ڵ��򲻱����������ݹ�
			if(parent == null){
				parent = getParent(root.rigth,n);
			}
		}
		return parent;
	}
}
