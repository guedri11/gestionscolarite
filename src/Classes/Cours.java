package Classes;

public class Cours {
	private int ID ;
	private int Jours ;
	private int Mois ;
	private int Annee ;
	private float Duree ;
	private String HeureDebut ;
	private Matiere Mat ;
	private Enseignant Ens ;
	private Groupe Grp ;
	public Cours() {
		ID = 0 ;
		Jours = 0 ;
		Mois = 0 ;
		Annee = 0 ;
		Duree = 0 ;
		HeureDebut = "";
		Mat = new Matiere() ;
		Ens = new Enseignant() ;
		Grp = new Groupe() ;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getJours() {
		return Jours;
	}
	public void setJours(int jours) {
		Jours = jours;
	}
	public int getMois() {
		return Mois;
	}
	public void setMois(int mois) {
		Mois = mois;
	}
	public int getAnnee() {
		return Annee;
	}
	public void setAnnee(int annee) {
		Annee = annee;
	}
	public float getDuree() {
		return Duree;
	}
	public void setDuree(float duree) {
		Duree = duree;
	}
	public String getHeureDebut() {
		return HeureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		HeureDebut = heureDebut;
	}
	public Matiere getMat() {
		return Mat;
	}
	public void setMat(Matiere mat) {
		Mat = mat;
	}
	public Enseignant getEns() {
		return Ens;
	}
	public void setEns(Enseignant ens) {
		Ens = ens;
	}
	public Groupe getGrp() {
		return Grp;
	}
	public void setGrp(Groupe grp) {
		Grp = grp;
	}
	
}
