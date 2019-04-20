package mvc.tp.model;

public class User {
	
	private int userid;
	private String username;
	private String password;
	private int estado;
	private int rol;

	public User() {
		
	}
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	//userId
	public int getUserId(){
		return userid;
	}
	
	public void setUserId(int userId){
		this.userid = userId;
	}
	
	//usuario
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//estado
	public int getEstado(){
		return estado;
	}
	public void setEstado(int estado){
		this.estado = estado;
	}
	
	//rol
	public int getRol(){
		return rol;
	}
	
	public void setRol(int rol){
		this.rol = rol;
	}
	
	@Override
	  public String toString() {
	   return "User [userid=" + userid + ", username=" + username
	     + ", password=" + password + "]";
	  }

}
