
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SearchEngine {
	public String url;
	public String content;
	public Ranking rank;
	
	public SearchEngine(String searchKeyword) throws IOException{
		this.url = "http://www.google.com/search?q="+searchKeyword+"+捷運站"+"+咖啡廳"+"&oe=utf8&num=10";
	}
	private String fetchContent() throws IOException{
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
			conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
			InputStream in = conn.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in,"utf-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = null;
			long start = System.currentTimeMillis() ;
			long ending = start + 10;
			while((line=bufReader.readLine())!=null){
				retVal += line;
				if((System.currentTimeMillis()/1000)>ending) {
			    	return "runtime error";
			    }
			}
		return retVal;
	}
	public HashMap<String, String> query() throws IOException{
		if(content==null){
			content= fetchContent();
		}
		HashMap<String, String> retVal = new HashMap<String, String>();
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		for(Element li : lis){
			try{
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				if(title.equals("")) {
					continue;
				}
					retVal.put(title, citeUrl);
			} catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}
		}
		return retVal;
	}
}


