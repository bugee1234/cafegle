
import java.util.ArrayList;

public class Ranking {
	private ArrayList<Webpage> lst;
	
	public Ranking(){
		this.lst = new ArrayList<Webpage>();
    }
	
	public void add(Webpage webpage){
		lst.add(webpage);
//		System.out.println("Done");
    }
	public void sort(){
		if(lst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			for(int i=0;i<lst.size();i++) {
				if(lst.get(i).score==0) {
					lst.remove(i);
					i--;
				}
			}
			quickSort(0,lst.size()-1);
		}
	}
	private void quickSort(int leftbound, int rightbound){
		//1. implement quickSort algorithm
		if(leftbound<rightbound) {
			double pi=lst.get(rightbound).score;
			int i=leftbound-1;
			for(int j=leftbound;j<rightbound;j++) {
				if(lst.get(j).score<=pi) {
					i++;
					swap(i, j);
				}
			}
			swap(i+1, rightbound);
			quickSort(leftbound, i);
			quickSort(i+2,rightbound);
		}
	}
	private void swap(int aIndex, int bIndex){
		Webpage temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	public void output(){
		//TODO: write output and remove all element logic here...
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<lst.size();i++){
			Webpage k = lst.get(i);
			if(i>0)sb.append(" ");
			sb.append(k.url);
		}
		System.out.print(sb.toString());
	}
	public ArrayList<Webpage> getResult() {
		return lst;
	}

}






