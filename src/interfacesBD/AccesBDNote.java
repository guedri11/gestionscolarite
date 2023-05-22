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
import Classes.Matiere;
import Classes.Note;

public interface AccesBDNote extends AccesBDEtudiant,AccesBDMatiere {
	String URL = "jdbc:mysql://localhost/gestionpi" ;
	String Driver = "com.mysql.cj.jdbc.Driver" ;
	String Login = "root" ;
	String Password = "" ;
	static void AjouterNote(Note Note) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null;
			PreparedStatement Statement = null ;
			String Query = "INSERT INTO note(IDEtudiant, IDMatiere, Note, Type) VALUES (?,?,?,?)" ;
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, Note.getEtu().getNum_Insc());
			Statement.setInt(2, Note.getMat().getIdMat());
			Statement.setFloat(3, Note.getNote());
			Statement.setString(4, Note.getType());
			
			Statement.executeUpdate();
			
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	static void ModifierNote(Note Note) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			String Query = "UPDATE note SET IDEtudiant=?,IDMatiere=?,Note=?,Type=? WHERE ID=?" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, Note.getEtu().getNum_Insc());
			Statement.setInt(2, Note.getMat().getIdMat());
			Statement.setFloat(3, Note.getNote());
			Statement.setString(4,Note.getType());
			Statement.setInt(5, Note.getIDNote());
			
			Statement.executeUpdate();
			
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	static void SupprimerNote(Note Note) throws SQLException,ClassNotFoundException {
		try {
			Class.forName(Driver);
			Connection Conn = null ;
			PreparedStatement Statement = null ;
			String Query = "DELETE FROM note WHERE ID=?" ;
			
			Conn = DriverManager.getConnection(URL, Login, Password);
			Statement = Conn.prepareStatement(Query);
			Statement.setInt(1, Note.getIDNote());
			
			Statement.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
    static List<Note> getAllNote() throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		Statement Statement = null ;
    		String Query = "SELECT * FROM note";
    		ResultSet Rs = null ;
    		List<Note> ListeNote = new ArrayList<Note>();
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.createStatement();
    		
    		Rs = Statement.executeQuery(Query);
    		
    		while(Rs.next()) {
    			Etudiant Etu = new Etudiant();
    			Matiere Mat = new Matiere();
    			Note Note = new Note();
        		Etu = AccesBDEtudiant.getEtudiantByNumInsc(Rs.getInt("IDEtudiant"));
        		Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMatiere"));
        		
        		Note.setEtu(Etu);
        		Note.setMat(Mat);
        		Note.setIDNote(Rs.getInt("ID"));
        		Note.setNote(Rs.getFloat("Note"));
        		Note.setType(Rs.getString("Type"));
        		
    			ListeNote.add(Note);
    		}
    		return ListeNote ;
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    		return null;
    	}
    }
    static Note getNoteByID(int ID) throws SQLException,ClassNotFoundException {
    	try {
    		Class.forName(Driver);
    		Connection Conn = null ;
    		PreparedStatement Statement = null ;
    		ResultSet Rs = null ;
    		String Query = "SELECT * FROM note WHERE ID=?";
    		Note Note = new Note();
    		
    		Conn = DriverManager.getConnection(URL, Login, Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1, ID);
    		Rs = Statement.executeQuery();
    		
    		Rs.next();
    		
    		
    		Etudiant Etu = new Etudiant();
    		Etu = AccesBDEtudiant.getEtudiantByNumInsc(Rs.getInt("IDEtudiant"));
    		Matiere Mat = new Matiere();
    		Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMatiere"));
    		
    		
    		Note.setEtu(Etu);
    		Note.setMat(Mat);
    		Note.setIDNote(Rs.getInt("ID"));
    		Note.setNote(Rs.getFloat("Note"));
    		Note.setType(Rs.getString("Type"));
    		

    		return Note;
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    		System.out.println("Hey");
    		return null ;
    	}
    }
    static List<Note> getNoteByNumInsc(int NumInsc) throws SQLException,ClassNotFoundException {
    	try {
    		List<Note> ListeNote = new ArrayList<Note>();
    		Class.forName(Driver);
    		Connection Conn = null ;
    		ResultSet Rs = null ;
    		PreparedStatement Statement = null ;
    		String Query = "SELECT * FROM note WHERE IDEtudiant=?";
    		
    		Conn = DriverManager.getConnection(URL,Login,Password);
    		Statement = Conn.prepareStatement(Query);
    		Statement.setInt(1, NumInsc);
    		Rs = Statement.executeQuery();
    		
    		while(Rs.next()) {
    			Etudiant Etu = new Etudiant();
    			Matiere Mat = new Matiere();
    			Note Note = new Note();
        		Etu = AccesBDEtudiant.getEtudiantByNumInsc(Rs.getInt("IDEtudiant"));
        		Mat = AccesBDMatiere.getMatiereByID(Rs.getInt("IDMatiere"));
        		
        		Note.setEtu(Etu);
        		Note.setMat(Mat);
        		Note.setIDNote(Rs.getInt("ID"));
        		Note.setNote(Rs.getFloat("Note"));
        		Note.setType(Rs.getString("Type"));
        		
    			ListeNote.add(Note);
    		}
    		return ListeNote;
    		
    	}catch(SQLException | ClassNotFoundException e) {
    		System.out.println(e);
    		return null ;
    	}
    }
}