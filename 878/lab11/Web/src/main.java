

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ArrayList<Keyword> keywordorder;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		String[] data = request.getParameter("keyword").split(" ");
		keywordorder=new ArrayList<Keyword>();
		keywordfilter(data);
		
		SearchEngine google = new SearchEngine(request.getParameter("keyword"));
		HashMap<String, String> query = google.query();
	
		
		Ranking rankList=new Ranking();
		Webpage rootPage;
		Tree tree;
		Html html;
		
		for(Entry<String, String> entry : query.entrySet()) {
			rootPage=new Webpage(entry.getValue().toString().substring(7,entry.getValue().toString().indexOf("&sa")),entry.getKey());
			rankList.add(rootPage);
			tree=new Tree(rootPage);
			html=new Html(rootPage.name);
//    System.out.println(html);
			HashMap<String, String> matchs=html.match();
			int i=1;
			for(Entry<String, String> entry1 : matchs.entrySet()) {
				Webpage subPage = new Webpage(entry1.getValue().toString().substring(7,entry1.getValue().toString().indexOf("&sa")),entry.getKey());
						     tree.root.addChild(new Node(subPage));
					}

//�٦b�Q��k�ѨM������
			tree.setPostOrderScore(keywordorder);
			tree.eularPrintTree();
		
		    
		}
		System.out.print("down1");
		rankList.sort();
		System.out.print("down");
		
		String[][] sort = new String[rankList.getResult().size()][2];
		request.setAttribute("query", sort);
		
		int k = 0;
		for(int a=rankList.getResult().size()-1;a>=0;a--) {
		    String key = rankList.getResult().get(a).name;
		    String value ="/url?q="+rankList.getResult().get(a).url;
		    sort[k][0] = key;
		    sort[k][1] = value;
		    k++;
		}
		rankList.output();
		request.getRequestDispatcher("googleitem.jsp").forward(request, response); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	public ArrayList<Keyword> keywordfilter(String[] keywordorders) throws IOException {
		File file=new File("BasicKeyword.txt");
		Scanner scanner=new Scanner(file);
		while(scanner.hasNext()) {
			String in=scanner.next();
			double weight=scanner.nextDouble();
			keywordorder.add(new Keyword(in,weight));
		}	
		for(String keyword:keywordorders) {
				if(!keywordorder.contains(keyword)) {
					keywordorder.add(new Keyword(keyword,5.5));
				}
		}
		scanner.close();
		return keywordorder;
	}
}



