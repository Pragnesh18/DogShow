package ca.sheridancollege;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ca.sheridancollege.DAO.DAO;
import ca.sheridancollege.beans.Dog;

@Controller
public class HomeController {

		
	private static final String DummyRecords = null;

	@GetMapping("/AddDogs")
	public String addDogs(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String number = "NULL";
		String dogname = request.getParameter("dogname");
		String ownername = request.getParameter("ownername");
		String breed = request.getParameter("breed");
		String group = request.getParameter("group");
		String gender = request.getParameter("gender");
		String dogclass = request.getParameter("dogclass");
		
		
		Dog userinfo = new Dog(number, dogname, ownername, breed, group, gender, dogclass);	
		DAO.addDog(userinfo);
		
		return "index.html";
	}
	
	
	
	
	@GetMapping("/GetDogs")
    public String show(HttpServletRequest request) {
		
    request.setAttribute("dogs", DAO.getDog());
	  return "view.html";
}
	
	
	@GetMapping("/DummyDogs")
	public String dummyDogs(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String number = "NULL";
		String dogname = request.getParameter("dogname");
		String ownername = request.getParameter("ownername");
		String breed = request.getParameter("breed");
		String group = request.getParameter("group");
		String gender = request.getParameter("gender");
		String dogclass = request.getParameter("dogclass");
		
		
		Dog dummydogs = new Dog(number, dogname, ownername, breed, group, gender, dogclass);
	
		DummyRecords dr = new DummyRecords();
		dr.doGet(request, response);
		return "index.html";
}
	
	


	
	@GetMapping("/Search")
    public String search(HttpServletRequest request) {
		
    	  return "search.html";
	}
    	  
    
    	  
    @GetMapping("/searchResults")
     public String searchResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setAttribute("dog", DAO.getSearchResults(request));
    	    	  return "searchResults.html";
}
    
    
    
    @GetMapping("/showList")
    public String Show(HttpServletRequest request, HttpServletResponse response) {
   	
    	DAO sl = new DAO();
		DAO.getShowList(request, response);
		
    	
    	
    	

		
	//Dog all = new Dog(one, two, three, four, five, six, seven);
		
		
		request.setAttribute("one", sl);
		request.setAttribute("two", sl);
		request.setAttribute("three", sl);
		request.setAttribute("four", sl);
		request.setAttribute("five", sl);
		request.setAttribute("seven", sl);
	
  

  	  return "showList.html";
    }
}
