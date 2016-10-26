package server_connections.web;
import server_connections.database.DbConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import server_connections.database.DbConnection;
/**
 * Servlet implementation class ServletConnection
 */
@WebServlet("/ServletConnection")
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnection() {
        super();
		db = new DbConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> m = request.getParameterMap();
	   
		if(m.containsKey("skip")){
	    	PrintWriter out = response.getWriter();
	    	List<String> result;
	    	result = db.getQuestion();
	    	//System.out.println(result);
			Gson gson = new Gson();
			String json = gson.toJson(result);
			
			response.getWriter().append(json);
	    }

	}

}
