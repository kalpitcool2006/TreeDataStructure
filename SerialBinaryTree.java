import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Node implements Serializable
{
	//String value;
 int data;
Node left,right;
Node(int data)
{
	//this.value=value;
	this.data=data;
	left=right=null;
}
	
}



public class SerialBinaryTree implements Serializable{

	Node root;
	
	SerialBinaryTree()
	{
		root=null;
	}
	
	
	 void postorder()
	{
		postorder(root);
	}
	
	 void postorder(Node root)
	{
		if (root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SerialBinaryTree sbt= new SerialBinaryTree();
		sbt.root= new Node(50);
		
		sbt.root.left=new Node(40);
		sbt.root.right=new Node(60);
		
		System.out.println("Before Serialization of Binary Tree");
		System.out.println(sbt.root.left.data);
		System.out.println(sbt.root.right.data);
		System.out.println(sbt.root.data);
		
		try {
			FileOutputStream fos= new FileOutputStream("abc.txt");
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(sbt);
			
			FileInputStream fis= new FileInputStream("abc.txt");
			ObjectInputStream ois =new ObjectInputStream(fis);
			SerialBinaryTree sbt2= (SerialBinaryTree)ois.readObject();
			
			
			System.out.println("After Serialization of Binary Tree");
			System.out.println(sbt2.root.left.data);
			System.out.println(sbt2.root.right.data);
			System.out.println(sbt2.root.data);
			
			System.out.println("printing postorder");
			sbt.postorder();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
		
		
		
	}

}
