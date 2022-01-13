
import java.io.IOException;
import java.util.ArrayList;

public class Webpage {
	public String url;
	public String name;
	public double score;
	public wordCounter counter;
	
	public Webpage(String url,String name){
		this.url = url;
		this.name = name;
		counter=new wordCounter(url);
		}
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		score = 0;
		for(Keyword k : keywords){	
			score+=counter.countKeyword(k.name)*k.weight;
		}
	}
	public String getUrl() {
		return url;
	}

}
