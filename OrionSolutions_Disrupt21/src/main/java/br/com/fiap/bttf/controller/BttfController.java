package br.com.fiap.bttf.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bttf.bean.Location;
import br.com.fiap.bttf.bean.MovieObject;
import br.com.fiap.bttf.connection.ConnectionManager;
import br.com.fiap.bttf.dao.CharacterDao;
import br.com.fiap.bttf.dao.EventDao;
import br.com.fiap.bttf.dao.LocationDao;
import br.com.fiap.bttf.dao.MovieObjectDao;
import br.com.fiap.bttf.exception.DataNotFoundException;

/**
 * Servlet implementation class BttfController
 */
@WebServlet(description = "Servlet para controlar o fluxo de dados do site bttf.", urlPatterns = { "/listObject","/objectSelection","/characters","/events", "/locations"})
public class BttfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BttfController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try { 
			conn = ConnectionManager.getInstance().getConnection();
			String uri = request.getRequestURI();
			System.out.println(uri);
			switch (uri) {
			case "/OrionSolutions_Disrupt21/listObject":
				listObject(request, response);
				break;
			case "/OrionSolutions_Disrupt21/objectSelection":
				objectSelection(request, response);
				break;
			case "/OrionSolutions_Disrupt21/characters":
                character(request, response);
                break;
			case "/OrionSolutions_Disrupt21/events":
                events(request, response);
                break;
			case "/OrionSolutions_Disrupt21/locations":
				location(request, response);
				break;
			}//switch
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void location(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, DataNotFoundException, SQLException, ServletException, IOException {
		LocationDao locDao = new LocationDao(conn);
		List<Location> locList = locDao.list();
		request.setAttribute("locList", locList);
		request.getRequestDispatcher("location.jsp").forward(request, response);
	}
	
	private void events(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, DataNotFoundException, SQLException, ServletException, IOException {
        EventDao eventDao = new EventDao(conn);
        List<br.com.fiap.bttf.bean.Event> eventList = eventDao.list();
        request.setAttribute("eventList", eventList);
        request.getRequestDispatcher("timeLine.jsp").forward(request, response);
    }
	
	private void character(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, DataNotFoundException, SQLException, IOException, ServletException {
	    CharacterDao charDao = new CharacterDao(conn);
	    List<br.com.fiap.bttf.bean.Character> charList = charDao.list();
	    request.setAttribute("charList", charList);
	    request.getRequestDispatcher("character.jsp").forward(request, response);
	
	}
	
	private void objectSelection(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, DataNotFoundException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("objectId"));
		
		MovieObjectDao dao = new MovieObjectDao(conn);
		MovieObject object = dao.searchById(id);
		
		CharacterDao characterDao = new CharacterDao(conn);
		List<br.com.fiap.bttf.bean.Character> characters = characterDao.listCharacterByObjectId(id);
		
		List<MovieObject> objects = dao.list();
		
		request.setAttribute("objectList", objects);
		request.setAttribute("object", object);
		request.setAttribute("characters", characters);
		request.setAttribute("show", true);
		
		request.getRequestDispatcher("object.jsp").forward(request, response);
		
		
	}

	private void listObject(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, DataNotFoundException, SQLException, ServletException{
		MovieObjectDao dao = new MovieObjectDao(conn);
		List<MovieObject> objects = dao.list();
		
		request.setAttribute("objectList", objects);
		request.setAttribute("show", false);
		
		request.getRequestDispatcher("object.jsp").forward(request, response);
		
	}
	
}
