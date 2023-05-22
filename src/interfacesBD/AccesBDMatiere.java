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

public interface AccesBDMatiere {
	String URL = "jdbc:mysql://localhost/gestionpi" ;
	String Driver = "com.mysql.cj.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static Matiere getMatiereByID(int ID) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			String Query = "SELECT * FROM matiere WHERE IDMAT=?";
			Matiere Mat = new Matiere() ;
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, ID);
			Rs =Statement.executeQuery();
			Rs.next();
			
			Mat.setIdMat(Rs.getInt("IDMAT"));
			Mat.setNomMat(Rs.getString("Nom"));
			Mat.setCoef(Rs.getFloat("Coef"));
			
			return Mat ;
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
	static List<Matiere> getAllMatiere() throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			String Query = "SELECT * FROM matiere";
			List<Matiere> ListeMat = new ArrayList<Matiere>() ;
			Connection Conn = null ;
			ResultSet Rs = null ;
			Statement Statement = null ;
			
			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.createStatement();
			Rs = Statement.executeQuery(Query);
			
			while(Rs.next()) {
				Matiere Mat = new Matiere();
				Mat.setIdMat(Rs.getInt("IDMAT"));
				Mat.setNomMat(Rs.getString("Nom"));
				Mat.setCoef(Rs.getFloat("Coef"));
				ListeMat.add(Mat);
			}
			return ListeMat;
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
		
	}
    static List<Matiere> getMatiereByNom(String Nom ) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			String Query = "SELECT * FROM matiere WHERE Nom=?";
			List<Matiere> ListeMat = new ArrayList<Matiere>();
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			
			
			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setString(1, Nom);
			Rs =Statement.executeQuery(Query);
			
			
			while(Rs.next()) {
			Matiere Mat = new Matiere() ;
			Mat.setIdMat(Rs.getInt("IDMAT"));
			Mat.setNomMat(Rs.getString("Nom"));
			Mat.setCoef(Rs.getFloat("Coef"));
			ListeMat.add(Mat);
			}
			return ListeMat ;
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
		
	}
    static void AjouterMatiere(Matiere Mat) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "INSERT INTO matiere(Nom,Coef) VALUES (?,?)";
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		
    		Statement.setString(1, Mat.getNomMat());
    		Statement.setFloat(2, Mat.getCoef());
    		    		
    		Statement.executeUpdate();
    		
    	}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
    }
    static void ModifierMatiere(Matiere Mat) throws SQLException,ClassNotFoundException {
        try {
        	Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "UPDATE matiere SET Nom=?,Coef=? WHERE IDMAT=?";
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		
    		Statement.setString(1, Mat.getNomMat());
    		Statement.setFloat(2, Mat.getCoef());
    		Statement.setInt(3, Mat.getIdMat());
    		
    		Statement.executeUpdate();
    	}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
    }
    static void SupprimerMatiere(int IDMat) throws SQLException,ClassNotFoundException {
        try {
        	Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		String Query = "DELETE FROM matiere WHERE IDMAT=?";
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		
    		Statement.setInt(1, IDMat);
    		
    		Statement.executeUpdate();
    		
    		
    	}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
    }
}
