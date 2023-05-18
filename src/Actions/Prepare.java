package Actions;

import java.sql.SQLException;

import Classes.*;
import interfacesBD.AccesBDCours;
import interfacesBD.AccesBDEtudiant;
import interfacesBD.AccesBDMatiere;

public interface Prepare {
	static Absences PrepareAbsence(int IDAbs,int IDEtudiant,int IDCours) {
			Etudiant Etu;
			try {
				Etu = AccesBDEtudiant.getEtudiantByNumInsc(IDEtudiant);
				Cours Crs = AccesBDCours.getCoursByID(IDCours);
				Absences Abs = new Absences(IDAbs,Etu,Crs);
				if(Crs == null || Etu == null)
					return null ;
				return Abs;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null ;
			}
	}

	static Note PrepareNote(int IDNote,int IDEtu,int IDMat,float Note,String Type) {
		try {
			Etudiant Etu = AccesBDEtudiant.getEtudiantByNumInsc(IDEtu);
			Matiere Mat = AccesBDMatiere.getMatiereByID(IDMat);
			Note Grad = new Note();
			Grad.setEtu(Etu);
			Grad.setMat(Mat);
			Grad.setIDNote(IDNote);
			Grad.setNote(Note);
			Grad.setType(Type);
			return Grad ;
		}catch(ClassNotFoundException | SQLException e) {
			return null;
		}
	}
}
