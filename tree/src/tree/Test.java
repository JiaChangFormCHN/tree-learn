package tree;

public class Test {

	public static void main(String[] args) {
		ArrayBinTree<String> binTree = new ArrayBinTree<>("��" , 4);
		System.out.println("���������Ϊ:"+binTree.deep());
		binTree.add(1, "�ڶ������ӽڵ�", true);
		binTree.add(2, "���������ӽڵ�", false);
		binTree.add(1, "�ڶ������ӽڵ�", false);
		System.out.println(binTree.toString());
		System.out.println("���ĸ�Ϊ��"+binTree.getRoot());
		System.out.println(binTree.patent(5));
		System.out.println(binTree.lift(2));
		System.out.println(binTree.right(2));
	}

}
