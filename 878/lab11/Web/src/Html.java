
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class Html {
 private Webpage urlPage;
 private String urlstr;
    private String content;
   
    
    
    public Html(String string){
     this.urlstr = "http://www.google.com/search?q="+string+"&oe=utf8&num=10";
    }
    
    private String fetchContent(){
     URL url;
  String retVal = "";
  try {
   url = new URL(this.urlstr);
   System.out.println(url+"\n");
   URLConnection conn;
   try {
    conn = url.openConnection();
    InputStream in = conn.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    
    String line = null;
    long start = System.currentTimeMillis() ;
    long ending = start + 10;
    while ((line = br.readLine()) != null){
        retVal = retVal + line + "\n";
        if((System.currentTimeMillis()/1000)>ending) {
         return "runtime error";
        }
    }
   } catch (IOException e) {
    // TODO Auto-generated catch block
    //e.printStackTrace();
   }
  } catch (MalformedURLException e) {
   // TODO Auto-generated catch block
   //e.printStackTrace();
  }
  return retVal;
  
    }

    
    public HashMap<String,String> match() throws IOException{ 
     if(content==null){
      content = fetchContent();
  }  
          
  
     HashMap<String, String> retVal = new HashMap<String, String>(2);
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
//    e.printStackTrace();
   }
  }
  return retVal;
    }
    
}