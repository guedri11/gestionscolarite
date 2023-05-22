package interfacesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Matiere;
import Classes.Module;

public interface AccesBDModule {
	String URL = "jdbc:mysql://localhost/gestionpi" ;
	String Driver = "com.mysql.cj.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
    static Classes.Module getModuleById(int ID) throws SQLException,ClassNotFoundException {
        try {
        	Class.forName(Driver);
        	ResultSet Rs = null ;
        	Connection Conn = null ;
        	PreparedStatement Statement = null ;
        	String Query = "SELECT * FROM module WHERE ID=?";
        	
        	Conn = DriverManager.getConnection(URL,Login,Password);
        	Statement = Conn.prepareStatement(Query);
        	Statement.setInt(1, ID);
        	Rs = Statement.executeQuery();
        	
        	Rs.next();
        	
        	Module Mod = new Module();
        	Mod.setID(Rs.getInt("ID"));
        	Mod.setNom(Rs.getString("Nom"));
        	Mod.setCoef(Rs.getFloat("Coef"));
        	
        	return Mod ;
        	
        }catch(SQLException | ClassNotFoundException e) {
        	System.out.println(e);
        	return null ;
        }
    }
    static List<Module> getModuleByNom(String Nom) throws SQLException,ClassNotFoundException {
    	try {
        	Class.forName(Driver);
        	ResultSet Rs = null ;
        	Connection Conn = null ;
        	PreparedStatement Statement = null ;
        	List<Module> ListeModule = new ArrayList<Module>();
        	String Query = "SELECT * FROM module WHERE Nom=?";
        	
        	Conn = DriverManager.getConnection(Query, Login, Password);
        	Statement = Conn.prepareStatement(Query);
        	Statement.setString(1, Nom);
        	Rs = Statement.executeQuery();
        	while(Rs.next()) {
        		Module Mod = new Module();
            	Mod.setID(Rs.getInt("ID"));
            	Mod.setNom(Rs.getString("Nom"));
            	Mod.setCoef(Rs.getFloat("Coef"));
            	ListeModule.add(Mod);
        	}
        	return ListeModule ;
        	
        }catch(SQLException | ClassNotFoundException e) {
        	System.out.println(e);
        	return null ;
        }
    }
    static List<Module> getAllModules() throws SQLException,ClassNotFoundException {
    	try {
        	Class.forName(Driver);
        	ResultSet Rs = null ;
        	Connection Conn = null ;
        	Statement Statement = null ;
        	String Query = "SELECT * FROM module";
        	List<Module> ListeModule = new ArrayList<Module>();
        	
        	Conn = DriverManager.getConnection(URL, Login, Password);
        	Statement = Conn.createStatement();
        	Rs = Statement.executeQuery(Query);
        	
        	while(Rs.next()) {
        		Module Mod = new Module();
            	Mod.setID(Rs.getInt("ID"));
            	Mod.setNom(Rs.getString("Nom"));
            	Mod.setCoef(Rs.getFloat("Coef"));
            	ListeModule.add(Mod);
        	}
        	return ListeModule ;
        	
        }catch(SQLException | ClassNotFoundException e) {
        	System.out.println(e);
        	return null ;
        }
    }
    static void AjouterModule(Module Mod) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	Connection Conn = null ;
        	PreparedStatement Statement = null ;
        	String Query = "INSERT INTO module(Nom, Coef) VALUES (?,?)";
        	
        	Conn = DriverManager.getConnection(URL, Login, Password);
        	Statement = Conn.prepareStatement(Query);
        	Statement.setString(1,Mod.getNom());
        	Statement.setFloat(2, Mod.getCoef());
        	
        	Statement.executeUpdate();
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void SupprimerModule(Module Mod) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	Connection Conn = null ;
        	PreparedStatement Statement = null ;
        	String Query = "DELETE FROM module WHERE ID=?";
        	
        	Conn = DriverManager.getConnection(URL, Login, Password);
        	Statement = Conn.prepareStatement(Query);
        	Statement.setInt(1,Mod.getID());
        	
        	Statement.executeUpdate();
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void ModifierModule(Module Mod) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
        	Connection Conn = null ;
        	PreparedStatement Statement = null ;
        	String Query = "UPDATE module SET Nom=?,Coef=? WHERE ID=?";
        	
        	Conn = DriverManager.getConnection(URL, Login, Password);
        	Statement = Conn.prepareStatement(Query);
        	Statement.setInt(3,Mod.getID());
        	Statement.setString(1, Mod.getNom());
        	Statement.setFloat(2,Mod.getCoef());
        	
        	Statement.executeUpdate();
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void AjouterMatiere(int IDMod,Matiere Mat) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "INSERT INTO listematiere(IDModule, IDMatiere) VALUES (?,?)";
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1, IDMod);
    		Statement.setInt(2,Mat.getIdMat());
    		
    		Statement.executeUpdate();
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void RetirerMatiere(int IDMod,Matiere Mat) throws  SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "DELETE FROM listematiere WHERE IDModule=? AND IDMatiere=? ";
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1, IDMod);
    		Statement.setInt(2,Mat.getIdMat());
    		
    		Statement.executeUpdate();
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
}
