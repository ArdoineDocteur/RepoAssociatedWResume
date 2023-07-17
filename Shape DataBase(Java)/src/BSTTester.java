
public class BSTTester 
{	
	public static void main(String[]args)
	{ LinkedBST<Integer> iBST= new LinkedBST<Integer>();//<-- Instance of binary search tree class.
//	LinkedBST<Object> oBST= new LinkedBST<Object>();//<-- This is invald because the data MUST be comparable. Classes are NOT comparable by default.
		iBST.add(8);
		iBST.add(2);
		iBST.add(12);
		iBST.add(1);
		iBST.add(4);
		iBST.add(10);
		iBST.add(16);
		iBST.printPreOrder();
		iBST.printInOrder();//<-- This prints the integers in ascending order due to the rules that the BST follows. The nodes to the left of a parent node tend to be less than the parent value while the nodes' values on the right of the parent node tend to be greater than the parent node's values.
		iBST.printPostOrder();//<-- This prints the integers in an order opposite of the pre-order. PN: Knowing this may be useful in the future.
		//Printing values from Binary search trees are more complicated than regularly printing out values from an array or a linked list.
		System.out.println(iBST.search(-2));
		iBST.remove(4);
		iBST.printInOrder();
		iBST.remove(8);
		iBST.printInOrder();
	}
}
