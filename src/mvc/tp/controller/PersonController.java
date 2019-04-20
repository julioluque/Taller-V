package mvc.tp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import mvc.tp.dao.PersonDao;
import mvc.tp.model.Person;

public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDao personDao;
    
    public PersonController() {
        personDao=new PersonDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Person> lstUser=new ArrayList<Person>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				lstUser=personDao.getAllUsers();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<Person>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				Person user=new Person();
				if(request.getParameter("userid")!=null){				   
				   int userid=Integer.parseInt(request.getParameter("userid"));
				   user.setUserid(userid);
				}
				if(request.getParameter("firstName")!=null){
					String firstname=(String)request.getParameter("firstName");
					user.setFirstName(firstname);
				}
				if(request.getParameter("lastName")!=null){
				   String lastname=(String)request.getParameter("lastName");
				   user.setLastName(lastname);
				}
				if(request.getParameter("email")!=null){
				   String email=(String)request.getParameter("email");
				   user.setEmail(email);
				}
				if(request.getParameter("tipoDoc")!=null){
					int tipoDoc=Integer.parseInt(request.getParameter("tipoDoc"));
					user.setTipoDoc(tipoDoc);
				}
				if(request.getParameter("nroDoc")!=null){
					String nroDoc=(String)request.getParameter("nroDoc");
					user.setNroDoc(nroDoc);
				}
				if(request.getParameter("telefono")!=null){
					String telefono=(String)request.getParameter("telefono");
					user.setTelefono(telefono);
				}
				try{											
					if(action.equals("create")){//Creo nueva persona
						personDao.addUser(user);					
						lstUser.add(user);				
						String json=gson.toJson(user);					
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Actualizo persona existente
						personDao.updateUser(user);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Borro persona
				try{
					if(request.getParameter("userid")!=null){
						String userid=(String)request.getParameter("userid");
						personDao.deleteUser(Integer.parseInt(userid));
						String listData="{\"Result\":\"OK\"}";								
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				response.getWriter().print(error);
			}				
		}
	 }
  }
}
