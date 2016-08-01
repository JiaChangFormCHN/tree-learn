package tree;

public class Test {

	public static void main(String[] args) {
		ArrayBinTree<String> binTree = new ArrayBinTree<>("根" , 4);
		System.out.println("此树的深度为:"+binTree.deep());
		binTree.add(1, "第二层左子节点", true);
		binTree.add(2, "第三层右子节点", false);
		binTree.add(1, "第二层右子节点", false);
		System.out.println(binTree.toString());
		System.out.println("树的根为："+binTree.getRoot());
		System.out.println(binTree.patent(5));
		System.out.println(binTree.lift(2));
		System.out.println(binTree.right(2));
	}

}
