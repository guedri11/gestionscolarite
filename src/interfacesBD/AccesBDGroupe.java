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
import Classes.Groupe;
import Classes.Module;

public interface AccesBDGroupe extends AccesBDEtudiant,AccesBDModule{
	String URL = "jdbc:mysql://localhost/polyechintl" ;
	String Driver = "com.mysql.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static List<Groupe> getAllGroupe() throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null;
			ResultSet Rs = null ;
			Statement Statement = null ;
			String Query = "SELECT * FROM groupe";
			List<Groupe> ListeGrp = new ArrayList<Groupe>();

			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.createStatement();
			Rs = Statement.executeQuery(Query);

			while(Rs.next()){
				Groupe Grp = new Groupe();
				Grp.setIDGrp(Rs.getInt("IDGrp"));
				Grp.setDiplome(Rs.getString("Diplome"));
				Grp.setSpecialite(Rs.getString("Specialite"));
				Grp.setNiveau(Rs.getString("Niveau"));
				Grp.setNumG(Rs.getInt("NumG"));
				ListeGrp.add(Grp);
			}
			return ListeGrp ;
		}catch(ClassNotFoundException | SQLException e){
			System.out.println(e);
			return null ;
		}
	}
	static Groupe getGroupeByID(int ID) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			String Query = "SELECT * FROM groupe WHERE IDGrp=?";

			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1,ID);
			Rs = Statement.executeQuery();

			Rs.next();
				Groupe Grp = new Groupe();
				Grp.setIDGrp(Rs.getInt("IDGrp"));
				Grp.setDiplome(Rs.getString("Diplome"));
				Grp.setSpecialite(Rs.getString("Specialite"));
				Grp.setNiveau(Rs.getString("Niveau"));
				Grp.setNumG(Rs.getInt("NumG"));
			return Grp;
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
    static List<Groupe> getGroupeByString(String Anything) throws SQLException,ClassNotFoundException {
		try{
			Class.forName(Driver);
			PreparedStatement Statement = null ;
			Connection Conn = null ;
			ResultSet Rs = null ;
			String Query = "SELECT * FROM groupe WHERE Niveau=? OR Diplome=? OR Specialite=?";
			List<Groupe> ListeGrp = new ArrayList<Groupe>();

			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setString(1,Anything);
			Statement.setString(2,Anything);
			Statement.setString(3,Anything);
			Rs = Statement.executeQuery();

			while(Rs.next()){
				Groupe Grp = new Groupe();
				Grp.setIDGrp(Rs.getInt("IDGrp"));
				Grp.setDiplome(Rs.getString("Diplome"));
				Grp.setSpecialite(Rs.getString("Specialite"));
				Grp.setNiveau(Rs.getString("Niveau"));
				Grp.setNumG(Rs.getInt("NumG"));
				ListeGrp.add(Grp);
			}
			return ListeGrp;
		}catch(SQLException | ClassNotFoundException e){
			System.out.println(e);
			return null ;
		}
	}
    static List<Etudiant> getListeEtudiant(int IDGrp)  throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			List<Etudiant> ListeEtudiant = new ArrayList<Etudiant>() ;
			String Query = "SELECT * FROM listeetudiant WHERE IDGrp=?" ;
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;

			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1,IDGrp);
			Rs = Statement.executeQuery();
			
			while(Rs.next()){
				Etudiant Etu = new Etudiant();
				Etu = AccesBDEtudiant.getEtudiantByNumInsc(Rs.getInt("NumInsc"));
				ListeEtudiant.add(Etu);
			}

			return ListeEtudiant ;

		}catch(SQLException | ClassNotFoundException e){
			System.out.println(e );
			return null;
		}
	}
    static List<Module> getListeModule(int IDGrp) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			List<Module> ListeModule = new ArrayList<Module>();
			String Query = "SELECT * FROM listemodule WHERE IDGrp=?";
			Connection Conn = null;
			ResultSet Rs = null;
			PreparedStatement Statement = null;

			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, IDGrp);
			Rs = Statement.executeQuery();
			while (Rs.next()) {
				Module Mod = new Module();
				Mod = AccesBDModule.getModuleById(Rs.getInt("IDModule"));
				ListeModule.add(Mod);
			}
			return ListeModule;
		}catch (SQLException | ClassNotFoundException e){
			System.out.println(e);
			return null ;
		}
	}
    static Groupe AjouterGroupe(Groupe Grp) throws SQLException,ClassNotFoundException {
		try{
			Class.forName(Driver);
			PreparedStatement Statement = null ;
			Connection Conn = null ;
			String Query = "INSERT INTO groupe(Niveau, Diplome, Specialite,NumG) VALUES (?,?,?,?)";

			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setString(1,Grp.getNiveau());
			Statement.setString(2,Grp.getDiplome());
			Statement.setString(3,Grp.getSpecialite());
			Statement.setInt(4,Grp.getNumG());

			int affectedRows = Statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = Statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                Grp.setIDGrp(generatedKeys.getInt(1));
	                return Grp;
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }

		}catch(SQLException | ClassNotFoundException e){
			System.out.println(e);
			return null;
		}
	}
	static void SupprimerGroupe(int IDGrp) throws SQLException,ClassNotFoundException {
		try{
			Class.forName(Driver);
			PreparedStatement Statement = null ;
			Connection Conn = null ;
			String Query = "DELETE FROM groupe WHERE IDGrp=?";

			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1,IDGrp);
			Statement.executeUpdate();

		}catch(SQLException | ClassNotFoundException e){
			System.out.println(e);
		}
	}
	static void ModifierGroupe(Groupe Grp) throws SQLException,ClassNotFoundException {
		try{
			Class.forName(Driver);
			String Query = "UPDATE groupe SET Niveau=?,Diplome=?,Specialite=?,NumG=? WHERE IDGrp=?";
			Connection Conn = null;
			PreparedStatement Statement = null;
			
			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(5, Grp.getIDGrp());
			Statement.setString(1, Grp.getNiveau());
			Statement.setString(2, Grp.getDiplome());
			Statement.setString(3, Grp.getSpecialite());
			Statement.setInt(4, Grp.getNumG());
			
			Statement.executeUpdate();
			
		}catch (SQLException | ClassNotFoundException e){
			System.out.println(e);
		}
	}
    static void AjouterEtudiant(int IDGrp,Etudiant Etu) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "INSERT INTO listeetudiant(IDGrp,NumInsc) VALUES (?,?)";
    		
    		
    		Conn = DriverManager.getConnection(URL,Login,Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1,IDGrp);
    		Statement.setInt(2, Etu.getNum_Insc());
    		Statement.executeUpdate();
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void SupprimerEtudiant(Etudiant Etu) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "DELETE FROM listeetudiant WHERE NumInsc=?";
    		
    		
    		Conn = DriverManager.getConnection(URL,Login,Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1, Etu.getNum_Insc());
    		Statement.executeUpdate();
    		
    	} catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void AjouterModule(int IDGrp,Module Mod) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "INSERT INTO listemodule(IDGrp, IDModule) VALUES (?,?)";
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1, IDGrp);
    		Statement.setInt(2, Mod.getID());
    		
    		Statement.executeUpdate();
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void SupprimerModule(int IDGrp,Module Mod) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "DELETE FROM listemodule WHERE IDGrp=? AND IDModule=?";
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1, IDGrp);
    		Statement.setInt(2, Mod.getID());
    		
    		Statement.executeUpdate();
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }

}
