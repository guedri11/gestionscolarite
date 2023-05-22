package interfacesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Actions.Prepare;
import Classes.Absences;
import Classes.Cours;
import Classes.Etudiant;

public interface AccesBDAbscences {
	String URL = "jdbc:mysql://localhost/gestionpi" ;
	String Driver = "com.mysql.cj.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static void ModifierAbscences(Absences Abs) throws SQLException,ClassNotFoundException{
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			String Query = "UPDATE absence SET IDEtudiant=?,IDCours=? WHERE ID=?";
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, Abs.getEtu().getNum_Insc());
			Statement.setInt(2, Abs.getCourse().getID());
			Statement.setInt(3, Abs.getID());
			
			Statement.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	static void AjouterAbscences(Absences Abs) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			String Query = "INSERT INTO absence(IDEtudiant, IDCours) VALUES (?,?)";
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, Abs.getEtu().getNum_Insc());
			Statement.setInt(2, Abs.getCourse().getID());
			
			Statement.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	static void SupprimerAbscences(Absences Abs) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			String Query = "DELETE FROM absence WHERE ID=?";
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			
			Statement.setInt(1, Abs.getID());
			
			Statement.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	static List<Absences> getAllAbsences() throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			Statement Statement = null ;
			ResultSet Rs  = null ;
			String Query = "SELECT * FROM absence";
			List<Absences> ListeAbs = new ArrayList<Absences>();
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.createStatement();
			Rs = Statement.executeQuery(Query);
			
			while(Rs.next()) {
				Absences Abs = new Absences();
				//Etudiant Etu = AccesBDEtudiant.getEtudiantByNumInsc(Rs.getInt("IDEtudiant"));
				//Cours Crs = AccesBDCours.getCoursByID(Rs.getInt("IDCours"));
				Abs = Prepare.PrepareAbsence(Rs.getInt("ID"), Rs.getInt("IDEtudiant"), Rs.getInt("IDCours"));
				//Abs.setCrs(Crs);
				//Abs.setEtu(Etu);
				Abs.setID(Rs.getInt("ID"));
				ListeAbs.add(Abs);
			}
			return ListeAbs;
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
	static List<Absences> getAbsencesByEtudiant(Etudiant Etudiant) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			ResultSet Rs  = null ;
			String Query = "SELECT * FROM absence WHERE IDEtudiant=?";
			List<Absences> ListeAbs = new ArrayList<Absences>();
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, Etudiant.getNum_Insc());
			
			Rs = Statement.executeQuery();
			
			while(Rs.next()) {
				Absences Abs = new Absences();
				Etudiant Etu = AccesBDEtudiant.getEtudiantByNumInsc(Rs.getInt("IDEtudiant"));
				Cours Crs = AccesBDCours.getCoursByID(Rs.getInt("IDCours"));
				Abs.setCrs(Crs);
				Abs.setEtu(Etu);
				Abs.setID(Rs.getInt("ID"));
				ListeAbs.add(Abs);
			}
			return ListeAbs;
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
	static Absences getAbsencesByID(int ID) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			ResultSet Rs  = null ;
			String Query = "SELECT * FROM absence WHERE ID=?";
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, ID );
			
			Rs = Statement.executeQuery();
			
			Rs.next();
				Absences Abs = new Absences();
				Etudiant Etu = AccesBDEtudiant.getEtudiantByNumInsc(Rs.getInt("IDEtudiant"));
				Cours Crs = AccesBDCours.getCoursByID(Rs.getInt("IDCours"));
				Abs.setCrs(Crs);
				Abs.setEtu(Etu);
				Abs.setID(Rs.getInt("ID"));
			return Abs;
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null ;
		}
	}
	public static void main(){
		try{
			AccesBDAbscences.AjouterAbscences(new Absences());
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
    
}
