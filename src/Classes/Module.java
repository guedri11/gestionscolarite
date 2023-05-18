package Classes;

import java.util.List;
import java.util.ArrayList;

public class Module {
	private int ID ;
	private String Nom ;
	private float Coef ;
	private List<Matiere> ListMat ;
	public Module(int iD, String nom, float coef) {
		ID = iD;
		Nom = nom;
		Coef = coef;
		ListMat = new ArrayList<Matiere>();
	}
	public Module() {
		ID = 0 ;
		Nom = "" ;
		Coef = 0 ;
		ListMat = new ArrayList<Matiere>();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public float getCoef() {
		return Coef;
	}
	public void setCoef(float coef) {
		Coef = coef;
	}
	public List<Matiere> getListMat() {
		return ListMat;
	}
	public void setListMat(List<Matiere> listMat) {
		ListMat = listMat;
	}
	public void AjouterMatiere(Matiere Mat) {
		ListMat.add(Mat);
	}
	public void RetirerMatiere(Matiere Mat) {
		for(Matiere Mati:ListMat) {
			if((Mat.getIdMat() == Mati.getIdMat()) || Mat.getIdMat() == Mati.getIdMat()){
				ListMat.remove(Mati) ;
			}
		}
	}
	
}
