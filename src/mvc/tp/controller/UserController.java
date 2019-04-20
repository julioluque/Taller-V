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

import mvc.tp.model.User;
import mvc.tp.dao.UserDao;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
    
    public UserController() {
       userDao=new UserDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<User> lstUser=new ArrayList<User>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				lstUser=userDao.getAllUsers();							
				JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<User>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				User user=new User();
				if(request.getParameter("userid")!=null){				   
				   int userid=Integer.parseInt(request.getParameter("userid"));
				   user.setUserId(userid);
				}
				if(request.getParameter("username")!=null){
					String username=(String)request.getParameter("username");
					user.setUsername(username);
				}
				if(request.getParameter("password")!=null){
				   String password=(String)request.getParameter("password");
				   user.setPassword(password);
				}
				if(request.getParameter("estado")!=null){
					int estado=Integer.parseInt(request.getParameter("estado"));
					user.setEstado(estado);
					}
				if(request.getParameter("rol")!=null){
					int rol=Integer.parseInt(request.getParameter("rol"));
					user.setRol(rol);
					}

				try{											
					if(action.equals("create")){//Creo Usuarios
						userDao.addUser(user);					
						lstUser.add(user);
						//Convert Java Object to Json				
						String json=gson.toJson(user);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Actualizo Usuarios
						userDao.updateUser(user);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Borro Usuarios
				try{
					if(request.getParameter("userid")!=null){
						String userid=(String)request.getParameter("userid");
						userDao.deleteUser(Integer.parseInt(userid));
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
