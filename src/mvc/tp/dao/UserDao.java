package mvc.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import mvc.tp.model.User;
import mvc.tp.util.DBUtility;


public class UserDao {
	
	private Connection connection;

	public UserDao() {
		connection = DBUtility.getConnection();
	}
	
	public void addUser(User user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into usuarios (usuario, password, estado, rol) values (?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getEstado());
			preparedStatement.setInt(4, user.getRol());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from usuarios where idusuario=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update usuarios set usuario=?, password=?, estado=?, rol=? where idusuario=?");
			// Parameters start with 1			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getEstado());
			preparedStatement.setInt(4, user.getRol());
			preparedStatement.setInt(5, user.getUserId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from usuarios");
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("idusuario"));
				user.setUsername(rs.getString("usuario"));
				user.setPassword(rs.getString("password"));
				user.setEstado(rs.getInt("estado"));
				user.setRol(rs.getInt("rol"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public User getUserById(int userId) {
		User user = new User ();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from personas where idpersona=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserId(rs.getInt("idusuario"));
				user.setUsername(rs.getString("usuario"));
				user.setPassword(rs.getString("password"));
				user.setEstado(rs.getInt("estado"));
				user.setRol(rs.getInt("rol"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

}
