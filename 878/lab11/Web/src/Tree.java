
import java.io.IOException;
import java.util.ArrayList;

public class Tree {
	public Node root;
	
	public Tree(Webpage webpage) {
		this.root=new Node(webpage);
	}
	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
		setPostOrderScore(root, keywords);
	}
	
	private void setPostOrderScore(Node startNode, ArrayList<Keyword> keywords) throws IOException{ //整顆tree的分數、把keyword丟到node
		//1.compute the score of children nodes postorder
		for(Node child : startNode.children){
			child.setNodeScore(keywords);
		}
		//**setNode score of startNode
		startNode.setNodeScore(keywords);
		}
 //灰色是拿來看執行路徑的功能，非主要功能
	public void eularPrintTree(){
		eularPrintTree(root);
	}
	
	private void eularPrintTree(Node startNode){
		int nodeDepth = startNode.getDepth();
		
		if(nodeDepth > 1) System.out.print("\n" + repeat("\t", nodeDepth-1));
		//print "("
		System.out.print("(");
		//print "name","score"
		System.out.print(startNode.element.name+","+startNode.Nscore);
		
		//2.print child preorder
		for(Node child : startNode.children){
			nodeDepth=child.getDepth();
			if(nodeDepth > 1) System.out.print("\n" + repeat("\t", nodeDepth-1));
			System.out.print("(");
			System.out.print(child.element.name+","+child.Nscore);
			System.out.print(")");
		}
		
		//print ")"
		
		/*for example
		(Soslab,459.0
				(Publication,286.2)
				(Projects,42.0
						(Stranger,0.0)
				)
				(MEMBER,12.0)
				(Course,5.3999999999999995)
		)
		*/
		if(startNode.isTheLastChild()) System.out.print("\n" + repeat("\t", nodeDepth-2));
		System.out.print(")");
	}
	
	private String repeat(String str,int repeat){
		String retVal  = "";
		for(int i=0;i<repeat;i++){
			retVal+=str;
		}
		return retVal;
	}

}
