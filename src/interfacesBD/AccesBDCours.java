package interfacesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Cours;
import Classes.Enseignant;
import Classes.Groupe;
import Classes.Matiere;

public interface AccesBDCours extends AccesBDEnseignant,AccesBDMatiere,AccesBDGroupe{
	String URL = "jdbc:mysql://localhost/gestionpi" ;
	String Driver = "com.mysql.cj.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static List<Cours> getCoursByIDEns(int ID) throws SQLException,ClassNotFoundException  {
		try {
			List<Cours> ListeDeCours = new ArrayList<Cours>();
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			String Query = "SELECT * FROM cours WHERE IDEns=?" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, ID );
			Rs = Statement.executeQuery();
			
			while(Rs.next()) {
				Cours Crs = new Cours();				
				Enseignant Ense = AccesBDEnseignant.getEnseignantById(Rs.getInt("IDEns"));
				Matiere Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMat"));
				Groupe Grp = AccesBDGroupe.getGroupeByID(Rs.getInt("IDGrp"));
			    Crs.setAnnee(Rs.getInt("Annee"));
			    Crs.setJours(Rs.getInt("Jours"));
			    Crs.setMois(Rs.getInt("Mois"));
			    Crs.setDuree(Rs.getFloat("Duree"));
			    Crs.setHeureDebut(Rs.getString("HeureDebut"));
			    Crs.setEns(Ense);
			    Crs.setGrp(Grp);
			    Crs.setMat(Mat);
			    ListeDeCours.add(Crs);
			}
			return ListeDeCours;
		}catch(SQLException | ClassNotFoundException e) {
			return null ;
		}
	}
	static List<Cours> getCoursByIDGrp(int ID) throws SQLException,ClassNotFoundException  {
		try {
			List<Cours> ListeDeCours = new ArrayList<Cours>();
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			String Query = "SELECT * FROM cours WHERE IDGrp=?" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, ID);
			Rs = Statement.executeQuery();
			
			while(Rs.next()) {
				Cours Crs = new Cours();				
				Enseignant Ense = AccesBDEnseignant.getEnseignantById(Rs.getInt("IDEns"));
				Matiere Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMat"));
				Groupe Grp = AccesBDGroupe.getGroupeByID(Rs.getInt("IDGrp"));
			    Crs.setAnnee(Rs.getInt("Annee"));
			    Crs.setJours(Rs.getInt("Jours"));
			    Crs.setMois(Rs.getInt("Mois"));
			    Crs.setDuree(Rs.getFloat("Duree"));
			    Crs.setHeureDebut(Rs.getString("HeureDebut"));
			    Crs.setEns(Ense);
			    Crs.setGrp(Grp);
			    Crs.setMat(Mat);
			    ListeDeCours.add(Crs);
			}
			return ListeDeCours;
		}catch(SQLException | ClassNotFoundException e) {
			return null ;
		}
	}
	static List<Cours> getCoursByIDMat(int ID) throws SQLException,ClassNotFoundException  {
		try {
			List<Cours> ListeDeCours = new ArrayList<Cours>();
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
            String Query = "SELECT * FROM cours WHERE IDGrp=?" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, ID);
			Rs = Statement.executeQuery(Query);
			
			while(Rs.next()) {
				Cours Crs = new Cours();				
				Enseignant Ense = AccesBDEnseignant.getEnseignantById(Rs.getInt("IDEns"));
				Matiere Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMat"));
				Groupe Grp = AccesBDGroupe.getGroupeByID(Rs.getInt("IDGrp"));
			    Crs.setAnnee(Rs.getInt("Annee"));
			    Crs.setJours(Rs.getInt("Jours"));
			    Crs.setMois(Rs.getInt("Mois"));
			    Crs.setDuree(Rs.getFloat("Duree"));
			    Crs.setHeureDebut(Rs.getString("HeureDebut"));
			    Crs.setEns(Ense);
			    Crs.setGrp(Grp);
			    Crs.setMat(Mat);
			    ListeDeCours.add(Crs);
			}
			return ListeDeCours;
		}catch(SQLException | ClassNotFoundException e) {
			return null ;
		}
	}
	static List<Cours> getAllCours() throws SQLException,ClassNotFoundException  {
		try {
			List<Cours> ListeDeCours = new ArrayList<Cours>();
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			Statement Statement = null ;
			String Query = "SELECT * FROM cours" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.createStatement();
			Rs = Statement.executeQuery(Query);
			
			while(Rs.next()) {
				Cours Crs = new Cours();				
				Enseignant Ense = AccesBDEnseignant.getEnseignantById(Rs.getInt("IDEns"));
				Matiere Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMat"));
				Groupe Grp = AccesBDGroupe.getGroupeByID(Rs.getInt("IDGrp"));
			    Crs.setAnnee(Rs.getInt("Annee"));
			    Crs.setJours(Rs.getInt("Jours"));
			    Crs.setMois(Rs.getInt("Mois"));
			    Crs.setDuree(Rs.getFloat("Duree"));
			    Crs.setHeureDebut(Rs.getString("HeureDebut"));
			    Crs.setEns(Ense);
			    Crs.setGrp(Grp);
			    Crs.setMat(Mat);
			    ListeDeCours.add(Crs);
			}
			return ListeDeCours;
		}catch(SQLException | ClassNotFoundException e) {
			return null ;
		}
	}
    static Cours getCoursByID(int ID) throws SQLException,ClassNotFoundException  {
		try {
			Cours Crs = new Cours();
			Class.forName(Driver);
			Connection Conn = null ;
			ResultSet Rs = null ;
			PreparedStatement Statement = null ;
			String Query = "SELECT * FROM cours WHERE ID=? " ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, ID);
			Rs = Statement.executeQuery();
			 
			Rs.next();
							
			Enseignant Ense = AccesBDEnseignant.getEnseignantById(Rs.getInt("IDEns"));
			Matiere Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMat"));
			Groupe Grp = AccesBDGroupe.getGroupeByID(Rs.getInt("IDGrp")); // WORKING
		    
			Crs.setID(Rs.getInt("ID"));
			Crs.setAnnee(Rs.getInt("Annee"));
		    Crs.setJours(Rs.getInt("Jours"));
		    Crs.setMois(Rs.getInt("Mois"));
		    Crs.setDuree(Rs.getFloat("Duree"));
		    Crs.setHeureDebut(Rs.getString("HeureDebut"));
		    //Crs.setEns(Ense);
		    //Crs.setGrp(Grp);
			//Crs.setMat(Mat);
			
		    return Crs;
		   	    
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}	
    static void AjouterCours(Cours Crs) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			String Query = "INSERT INTO cours(Jours, Mois, Annee, "
					+ "Duree, HeureDebut, IDMat,"
					+ " IDEns, IDGrp) VALUES (?,?,?,?,?,?,?,?)";
			
			Conn = DriverManager.getConnection(URL,Login,Password);
			Statement = Conn.prepareStatement(Query);
			
			Statement.setInt(1, Crs.getJours());
			Statement.setInt(2, Crs.getMois());
			Statement.setInt(3, Crs.getAnnee());
			Statement.setFloat(4, Crs.getDuree());
			Statement.setString(5, Crs.getHeureDebut());
			Statement.setInt(6, Crs.getMat().getIdMat());
			Statement.setInt(7, Crs.getEns().getID() );
			Statement.setInt(8, Crs.getGrp().getIDGrp());
			
			Statement.executeUpdate();

		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
    static void ModifierCours(Cours Crs) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			
			String Query = "UPDATE cours SET Jours=?, Mois=?, Annee=?, "
					+ "Duree=?, HeureDebut=?, IDMat=?,"
					+ " IDEns=?, IDGrp=? WHERE ID =?";
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			
			Statement.setInt(1, Crs.getJours());
			Statement.setInt(2, Crs.getMois());
			Statement.setInt(3, Crs.getAnnee());
			Statement.setFloat(4, Crs.getDuree());
			Statement.setString(5, Crs.getHeureDebut());
			Statement.setInt(6, Crs.getMat().getIdMat());
			Statement.setInt(7, Crs.getEns().getID() );
			Statement.setInt(8, Crs.getGrp().getIDGrp());
			Statement.setInt(9, Crs.getID());
			
			Statement.executeUpdate();
			
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    static void SupprimerCours(int ID) throws SQLException, ClassNotFoundException {
    	try {
    		String Query = "DELETE FROM cours WHERE ID=?";
        	Class.forName(Driver);
        	Connection Conn = null; 
        	PreparedStatement Statement = null ;
        	
        	Conn = DriverManager.getConnection(URL,Login,Password);
        	Statement = Conn.prepareStatement(Query);
        	Statement.setInt(1, ID);
        	Statement.executeUpdate();
        	
        	
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    	}
    }
    
}
