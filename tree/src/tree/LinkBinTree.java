package tree;

public class LinkBinTree<E> {
	
	//二叉树的链式存储结构
	class node{
		Object data;	//节点数据
		node left;		//左孩子指针
		node rigth;		//右孩子指针
		
	}
	//树根节点
	private node root;	
	
	/***
	 * 构造一棵空树
	 */
	public LinkBinTree(){
		this.root = new node();
	}
	
	/***
	 * 按指定根元素构造树
	 * @param data
	 */
	public LinkBinTree(E data){
		this.root = new node();
		this.root.data = data;
	}
	
	/***
	 * 为指定节点添加子节点
	 * @param parent  指定节点
	 * @param data  新节点的数据
	 * @param isLeft  是否为左孩子
	 * @return newNode 返回新添加的节点
	 */
	public node addNode(node parent , E data , boolean isLeft){
		if(parent == null){
			throw new RuntimeException("指定节点为null，无法添加子节点");
		}
		if(isLeft && parent.left!=null){
			throw new RuntimeException("指定节点已经存在左孩子，无法添加子节点");
		}
		if(!isLeft && parent.rigth!=null){
			throw new RuntimeException("指定节点已经存在右孩子，无法添加子节点");
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
	 * 判断二叉树是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return root.data==null;
	}
	
	/***
	 * 返回根节点
	 * @return
	 */
	public node getRoot(){
		return root;
	}
	
	/***
	 * 返回指定节点的父节点
	 * @param n 指定节点
	 * @return 父节点
	 */
	public node getParent(node n){
		if( n==null){
			throw new RuntimeException("指定节点为null，无法访问父节点");
		}
		if(n==root){
			throw new RuntimeException("指定节点为树根节点，树根节点没有父节点");
		}
		return getParent(root, n);
	}
	/***
	 * 返回指定节点的左孩子节点
	 * @param parent 指定节点
	 * @return 指定节点的左孩子节点，不存在则返回null
	 */
	@SuppressWarnings("unchecked")
	public E leftChild(node parent){
		if(parent == null){
			throw new RuntimeException("指定节点为null，无法访问子节点");
		}
		return  parent.left == null? null:(E)parent.left.data;
	}
	
	public E rigthChild(node parent){
		if(parent == null){
			throw new RuntimeException("指定节点为null，无法访问子节点");
		}
		return parent.rigth==null? null:(E)parent.rigth.data;
	}
	
	/***
	 * 计算二叉树的深度（后序遍历）
	 * @param root 根节点
	 * @return 树的深度
	 */
	public int deep(node root){
		if(root==null) return 0;	//如果是空树，深度为0，递归结束
		else {
			int m = deep(root.left);	//递归计算左子树的深度记为m
			int n = deep(root.rigth);	//递归计算右子树的深度记为n
			
			return m>n? m+1:n+1;	//二叉树的深度为 m 与 n的较大者加1
		}
	}
	
	/***
	 * 统计二叉树中节点的个数（递归）
	 * @param root 根节点
	 * @return 节点个数
	 */
	public int nodeCount(node root){
		if(root==null) return 0;	//如果是空树，则节点个数为0，递归结束
		else return nodeCount(root.left)+nodeCount(root.rigth)+1;	//否则节点个数为左子树的节点个数+右子树的节点个数+1
	}
	
	/***
	 * 前序遍历二叉树（递归）
	 * @param root 树的根节点
	 * @param n 指定的节点
	 * @return 指定节点的父节点
	 */
	private node getParent(node root , node n){
		node parent = null;
		if(root!=null){
			if(root.left!=null && root.left.equals(n)) return root;
			else if(root.rigth!=null && root.rigth.equals(n)) return root;
			parent = getParent(root.left,n);	//如果左子树找到目标节点则不必向右子树递归
			if(parent == null){
				parent = getParent(root.rigth,n);
			}
		}
		return parent;
	}
}
