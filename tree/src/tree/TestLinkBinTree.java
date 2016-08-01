package tree;

public class TestLinkBinTree {

	public static void main(String[] args) {
		LinkBinTree<String> linkBinTree = new LinkBinTree<>("A");
		
		LinkBinTree.node node1 = linkBinTree.addNode(linkBinTree.getRoot(), "B", true);
		LinkBinTree.node node2 = linkBinTree.addNode(linkBinTree.getRoot(), "C", false);
		LinkBinTree.node node3 = linkBinTree.addNode(node1, "D", true);
		LinkBinTree.node node4 = linkBinTree.addNode(node1, "E", false);
		System.out.println("���Ƿ�Ϊ�� :"+linkBinTree.isEmpty());
		System.out.println(linkBinTree.leftChild(node1));
		System.out.println(linkBinTree.rigthChild(node1));
		System.out.println("���Ľڵ�����Ϊ"+linkBinTree.nodeCount(linkBinTree.getRoot()));
		System.out.println("�������Ϊ:"+linkBinTree.deep(linkBinTree.getRoot()));
		System.out.println(linkBinTree.getParent(node1).data);
		
	}

}
