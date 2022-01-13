
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Node {
	public Node parent;
	public Webpage element;
	public ArrayList<Node> children;
	public double Nscore;
	
	public Node(Webpage webpage){
		element=webpage;
		this.children=new ArrayList<Node>();
	}
	public void addChild(Node child){
		this.children.add(child);
		child.parent = this;
	}
	public void setNodeScore(ArrayList<Keyword> keywords) throws IOException{
		element.setScore(keywords);
		Nscore = element.score;

		for(Node child : children){
			Nscore += child.Nscore;
		}	
	}
	public boolean isTheLastChild(){
		if(this.parent == null) return true;
		ArrayList<Node> siblings = this.parent.children;
		return this.equals(siblings.get(siblings.size() - 1));
	}
	
	public int getDepth(){
		int retVal = 1;
		Node currNode = this;
		while(currNode.parent!=null){
			retVal ++;
			currNode = currNode.parent;
		}
		return retVal;
	}
}





