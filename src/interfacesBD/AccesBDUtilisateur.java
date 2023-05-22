package interfacesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Login;
import Classes.Utilisateur;

public interface AccesBDUtilisateur {
	String URL = "jdbc:mysql://localhost/gestionpi" ;
	String Driver = "com.mysql.cj.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static void AjouterUtilisateur(Utilisateur User) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			String Query = "INSERT INTO utilisateur(EmployeeID, Username, Password, Role) VALUES (?,?,?,?)" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			
			
			Statement.setInt(1, User.getEmployeeID());
			Statement.setString(2, User.getLogin().getUsername());
			Statement.setString(3, User.getLogin().getPassword());
			Statement.setString(4, User.getRole());
			
			
			Statement.executeUpdate();
			
			
		}catch(SQLException | ClassNotFoundException e) {
			
		}
	}
	static void ModifierUtilisateur(Utilisateur User) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			String Query = "UPDATE utilisateur SET EmployeeID=?,Username=?,Password=?,Role=? WHERE EmployeeID=?" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			
			Statement.setInt(1, User.getEmployeeID());
			Statement.setString(2, User.getLogin().getUsername());
			Statement.setString(3, User.getLogin().getPassword());
			Statement.setString(4, User.getRole());
			Statement.setInt(5 , User.getEmployeeID());
			
			Statement.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	static void SupprimerUtilisateur(Utilisateur User) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			String Query = "DELETE FROM utilisateur WHERE EmployeeID=?" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			
			Statement.setInt(1, User.getEmployeeID());
			
			Statement.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException e) {
			
		}
	}
	static int VerifierLogin(Login Logins) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			String Query = "SELECT COUNT(*) FROM utilisateur WHERE Username=? AND Password=?" ;
			int Stat = 0 ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			
			Statement.setString(1, Logins.getUsername());
			Statement.setString(2, Logins.getPassword());
			
			Rs = Statement.executeQuery();
			if(Rs.next() ) {
			Stat = Rs.getInt(1);
			}
			if(Stat > 0) {
				return 1 ;
			}
			else {
				return 0 ;
			}
			
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return 0 ;
		}
	}
    static List<Utilisateur> getAllUsers() throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			Statement Statement = null ;
			String Query = "SELECT * FROM utilisateur" ;
			List<Utilisateur> ListUsers = new ArrayList<Utilisateur>();
			
			Conn = DriverManager.getConnection(URL,Login,Password);
			
			Statement = Conn.createStatement();
			Rs = Statement.executeQuery(Query);
			
			while(Rs.next()) {
				Utilisateur User = new Utilisateur();
				User.setEmployeeID(Rs.getInt("EmployeeID"));
				Login Logs = new Login();
				Logs.setUsername(Rs.getString("Username"));
				Logs.setPassword(Rs.getString("Password"));
				User.setLogin(Logs);
				User.setRole(Rs.getString("Role"));
				ListUsers.add(User);
			}
			return ListUsers;
    	}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
    		return null;
    	}
    }
}
