package mvc.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import mvc.tp.model.Person;
import mvc.tp.util.DBUtility;

public class PersonDao {
	
	private Connection connection;

	public PersonDao() {
		connection = DBUtility.getConnection();
	}

	public void addUser(Person user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into personas (nombre, apellido, mail, tipoDoc, nroDoc, telefono) values (?, ?, ?, ?, ?, ?)");
					
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());			
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getTipDoc());
			preparedStatement.setString(5, user.getNroDoc());
			preparedStatement.setString(6, user.getTelefono());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from personas where idpersona=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(Person user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update personas set nombre=?, apellido=?, mail=?, tipoDoc=?, nroDoc=?, telefono=? where idpersona=?");
			// Parameters start with 1			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());	
			preparedStatement.setInt(4, user.getTipDoc());
			preparedStatement.setString(5, user.getNroDoc());
			preparedStatement.setString(6, user.getTelefono());
			preparedStatement.setInt(7, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Person> getAllUsers() {
		List<Person> users = new ArrayList<Person>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from personas");
			while (rs.next()) {
				Person user = new Person();
				user.setUserid(rs.getInt("idpersona"));
				user.setFirstName(rs.getString("nombre"));
				user.setLastName(rs.getString("apellido"));				
				user.setEmail(rs.getString("mail"));
				user.setTipoDoc(rs.getInt("tipoDoc"));
				user.setNroDoc(rs.getString("nroDoc"));
				user.setTelefono(rs.getString("telefono"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public Person getUserById(int userId) {
		Person user = new Person();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from personas where idpersona=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("idpersona"));
				user.setFirstName(rs.getString("nombre"));
				user.setLastName(rs.getString("apellido"));
				user.setEmail(rs.getString("mail"));
				user.setTipoDoc(rs.getInt("tipoDoc"));
				user.setNroDoc(rs.getString("nroDoc"));
				user.setTelefono(rs.getString("telefono"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
