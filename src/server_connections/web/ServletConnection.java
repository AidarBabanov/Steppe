package server_connections.web;

import server_connections.database.DbConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.Gson;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String[]> m = request.getParameterMap();
		System.out.println("Servlet connected.");

		if (m.containsKey("skip")) {
			PrintWriter out = response.getWriter();
			List<String> result;
			result = db.getQuestion();
			Gson gson = new Gson();
			String json = gson.toJson(result);
			response.getWriter().append(json);
		}


		if (m.containsKey("signup")) {
			String[] user = m.get("signup")[0].split(" ");
			String result;
			try {

				db.SignUp(user[0], user[1], user[2]);
				result = "Signed Up Succesfully!";
			} catch (SQLException e) {
				// gavno
				result = "Signed Up not Succesfully!";

			}
			Gson gson = new Gson();
			String json = gson.toJson(result);
			response.getWriter().append(json);
		}
	
		
	if (m.containsKey("signin")) {
		String[] user = m.get("signin")[0].split(" ");
		String result;
		try {
			//System.out.println(user[0]);
			boolean isSignedIn=db.SignIn(user[0], user[1]);
			if(isSignedIn){	
				result = "Signed In Succesfully!";
//				HttpSession s =  request.getSession();
//				s.setAttribute(user[0], user[1]);
			}
			else result = "Signed In not Succesfully!";
		
		
		} catch (SQLException e) {
			// gavno
			//System.out.println("!!!");
			result = "Signed In not Succesfully!";

		}
		Gson gson = new Gson();
		String json = gson.toJson(result);
		response.getWriter().append(json);
	}
}
}
