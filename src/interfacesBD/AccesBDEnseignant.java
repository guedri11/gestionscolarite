package interfacesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Enseignant;

public interface AccesBDEnseignant {
	String URL = "jdbc:mysql://localhost/polyechintl" ;
	String Driver = "com.mysql.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static List<Enseignant> getAllEnseignant() throws SQLException,ClassNotFoundException {
		try {
			List<Enseignant> ListeEnseignant = new ArrayList<Enseignant>() ;
			String Query = "SELECT * FROM enseignant" ;
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			Statement Statement = null ;
			
			Conn = DriverManager.getConnection(URL,Login,"");
			Statement = Conn.createStatement();
			Rs = Statement.executeQuery(Query) ;
			
			while(Rs.next()) {
				Enseignant Ens = new Enseignant();
				Ens.setCIN(Rs.getInt("Cin"));
				Ens.setNom(Rs.getString("Nom"));
				Ens.setID(Rs.getInt("ID"));
				Ens.setCNSS(Rs.getInt("Cnss"));
				Ens.setPrenom(Rs.getString("Prenom"));
				Ens.setTelephone(Rs.getString("Telephone"));
				Ens.setEmail(Rs.getString("Mail"));
				ListeEnseignant.add(Ens);
			}
			
			return ListeEnseignant;
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
    static Enseignant getEnseignantById(int ID) throws SQLException,ClassNotFoundException {
    	try {
    		Enseignant Ens = new Enseignant();
			 Class.forName(Driver);
			 Connection Conn = null ;
			 PreparedStatement Statement = null ;
			 ResultSet Rs = null ;
			 String Query = "SELECT * FROM enseignant WHERE ID=?" ;
			 
			 Conn = DriverManager.getConnection(URL,Login,Password);
			 Statement = Conn.prepareStatement(Query);
			 Statement.setInt(1, ID);
			 Rs = Statement.executeQuery();
			 
			 Rs.next();
			 Ens.setCIN(Rs.getInt("Cin"));
  			 Ens.setNom(Rs.getString("Nom"));
			 Ens.setID(Rs.getInt("ID"));
			 Ens.setCNSS(Rs.getInt("Cnss"));
			 Ens.setPrenom(Rs.getString("Prenom"));
			 Ens.setTelephone(Rs.getString("Telephone"));
			 Ens.setEmail(Rs.getString("Mail"));
				
			 return Ens ;
			 
    	}catch(SQLException | ClassNotFoundException e) {
    	   System.out.println(e);
    	   return null ;
    	}
    }
    static void AjouterEnseignant(Enseignant Ens) throws SQLException,ClassNotFoundException {
    	try {
    	String Query = "INSERT INTO enseignant (Nom, Prenom, Mail, Telephone, Cin, Cnss) VALUES (?, ?, ?, ?, ?, ?)";
    	Class.forName(Driver);
    	Connection Conn = null;
    	PreparedStatement Statement = null;
    	
    	Conn = DriverManager.getConnection(URL,Login,Password);
    	Statement = Conn.prepareStatement(Query);
    	
    	Statement.setString(1,Ens.getNom());
    	Statement.setString(2,Ens.getPrenom());
    	Statement.setString(3,Ens.getEmail());
    	Statement.setString(4,Ens.getTelephone());
    	Statement.setInt(5,Ens.getCIN());
    	Statement.setInt(6,Ens.getCNSS());
    		
    	Statement.executeUpdate();
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void SupprimerEnseignant(Enseignant Ens) throws SQLException,ClassNotFoundException {
    	try {
    		String Query = "DELETE FROM enseignant WHERE ID=? ";
    		Class.forName(Driver);
        	Connection Conn = null;
        	PreparedStatement Statement = null;
        	
        	Conn = DriverManager.getConnection(URL,Login,Password);
        	Statement = Conn.prepareStatement(Query);
        	Statement.setInt(1, Ens.getID());
        	Statement.executeUpdate();
    		
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void ModifierEnseignant(Enseignant Ens )  throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	Connection Conn = null;
        	PreparedStatement Statement = null;
        	String Query = "UPDATE enseignant SET Nom=?,Prenom=?,Mail=?,Telephone=?,Cin=?,Cnss=? WHERE ID=? ";
        	
        	Conn = DriverManager.getConnection(URL,Login,Password);
        	
        	Conn = DriverManager.getConnection(URL,Login,Password);
        	Statement = Conn.prepareStatement(Query);
        	
        	Statement.setString(1,Ens.getNom());
        	Statement.setString(2,Ens.getPrenom());
        	Statement.setString(3,Ens.getEmail());
        	Statement.setString(4,Ens.getTelephone());
        	Statement.setInt(5,Ens.getCIN());
        	Statement.setInt(6,Ens.getCNSS());
        	Statement.setInt(5,Ens.getID());
        	
        	Statement.executeUpdate();
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    public static void main() {
    	try {
			Enseignant ens = AccesBDEnseignant.getEnseignantById(12);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
