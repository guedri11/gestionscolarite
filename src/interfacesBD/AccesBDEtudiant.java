package interfacesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Etudiant;



public interface AccesBDEtudiant {
	String URL = "jdbc:mysql://localhost/polyechintl" ;
	String Driver = "com.mysql.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static List<Etudiant> getAllEtudiant() throws SQLException , ClassNotFoundException {
		try {
		Class.forName(Driver);
		List<Etudiant> ListeEtudiant = new ArrayList<Etudiant>() ;
		String Query = "SELECT * FROM etudiant" ;
		Connection Conn = null ;
		ResultSet Rs = null ;
		Statement Statement = null ;
		
		Conn = DriverManager.getConnection(URL,Login,"");
		Statement = Conn.createStatement();
		Rs = Statement.executeQuery(Query) ;
		
		while(Rs.next()) {
			Etudiant Etud = new Etudiant();
			Etud.setCIN(Rs.getInt("Cin"));
			Etud.setNom(Rs.getString("Nom"));
			Etud.setNum_Insc(Rs.getInt("NumInsc"));
			Etud.setPrenom(Rs.getString("Prenom"));
			Etud.setTelephone(Rs.getString("Telephone"));
			Etud.setEmail(Rs.getString("Mail"));
			ListeEtudiant.add(Etud);
		}
		
		
		return ListeEtudiant;
		
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
	static Etudiant getEtudiantByNumInsc(int NumIns) throws SQLException,ClassNotFoundException {
		try {
			 Etudiant Etu = new Etudiant(); 
			 Class.forName(Driver);
			 Connection Conn = null ;
			 PreparedStatement Statement = null ;
			 ResultSet Rs = null ;
			 String Query = "SELECT * FROM etudiant WHERE NumInsc = ?" ;
			 
			 Conn = DriverManager.getConnection(URL,Login,Password);
			 Statement = Conn.prepareStatement(Query);
			 Statement.setInt(1, NumIns);
			 Rs = Statement.executeQuery();

			 Rs.next();

			 Etu.setCIN(Rs.getInt("Cin"));
			 Etu.setNum_Insc(Rs.getInt("NumInsc"));
			 Etu.setNom(Rs.getString("Nom"));
			 Etu.setPrenom(Rs.getString("Prenom"));
			 Etu.setTelephone(Rs.getString("Telephone"));
			 Etu.setEmail(Rs.getString("Mail"));
			 return Etu ;
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
    static List<Etudiant> getEtudiantByNomOuPrenom(Etudiant Etu) throws SQLException , ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	List<Etudiant> ListeEtudiant = new ArrayList<Etudiant>();
        	Connection Conn = null ;
        	PreparedStatement Statement = null ;
        	String Query = "SELECT * FROM etudiant WHERE Nom =? OR Prenom =? ";
        	ResultSet Rs = null ;
        	
        	Conn = DriverManager.getConnection(URL,Login,Password) ;
        	Statement = Conn.prepareStatement(Query);
        	Statement.setString(1, Etu.getNom());
        	Statement.setString(2, Etu.getPrenom());
        	Rs = Statement.executeQuery() ;

        	while(Rs.next()) {
        		Etudiant Etud = new Etudiant();
    			Etud.setCIN(Rs.getInt("Cin"));
    			Etud.setNom(Rs.getString("Nom"));
    			Etud.setNum_Insc(Rs.getInt("NumInsc"));
    			Etud.setPrenom(Rs.getString("Prenom"));
    			Etud.setTelephone(Rs.getString("Telephone"));
    			Etud.setEmail(Rs.getString("Mail"));
    			ListeEtudiant.add(Etud);
        	}
        	return ListeEtudiant ;
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    		return null ;
    	}
    	
    }
    static void AjouterEtudiant(Etudiant Etu) throws SQLException , ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	Connection Conn = null;
        	PreparedStatement Statement = null;
        	String Query = "INSERT INTO etudiant (Nom,Prenom,Mail,Telephone,Cin)  VALUES (?,?,?,?,?)";
        	
            Conn = DriverManager.getConnection(URL,Login,Password);
            
            
            Statement = Conn.prepareStatement(Query);
            
            Statement.setInt(5, Etu.getCIN());
            Statement.setString(1, Etu.getNom());
            Statement.setString(2, Etu.getPrenom());
            Statement.setString(3, Etu.getEmail());
            Statement.setString(4, Etu.getTelephone());
            
            Statement.executeUpdate();
            
    	} catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
        
    	
    }
    static void SupprimerEtudiant(Etudiant Etu) throws SQLException , ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	Connection Conn = null;
        	PreparedStatement Statement = null;
        	String Query = "DELETE FROM etudiant WHERE NumInsc=? ";
        	
            Conn = DriverManager.getConnection(URL,Login,Password);
            Statement = Conn.prepareStatement(Query);
            Statement.setInt(1,Etu.getNum_Insc());
            
            Statement.executeUpdate();
                       
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    	
    }
    static void ModifierEtudiant(Etudiant Etu) throws SQLException , ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	Connection Conn = null;
        	PreparedStatement Statement = null;
        	String Query = "UPDATE etudiant SET Nom=?,Prenom=?,Mail=?,Telephone=?,Cin=? WHERE NumInsc=?";
        	
        	Conn = DriverManager.getConnection(URL,Login,Password);
        	Statement = Conn.prepareStatement(Query);
        	
        	Statement.setInt(5, Etu.getCIN());
            Statement.setString(1, Etu.getNom());
            Statement.setString(2, Etu.getPrenom());
            Statement.setString(3, Etu.getEmail());
            Statement.setString(4, Etu.getTelephone());
            Statement.setInt(6, Etu.getNum_Insc());
            
        	Statement.executeUpdate() ;
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    	
    }
}
