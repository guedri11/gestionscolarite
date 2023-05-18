package Classes;

public class Absences {
	private int ID;
	private Etudiant Etu ;
	private Cours Course ;
	public Absences(int ID,Etudiant etu, Cours crs) {
		this.ID = ID ;
		Etu = etu ;
		Course = crs ;
	}
	public Absences() {
		this.ID = ID ;
		Etu = new Etudiant() ;
		Course = new Cours() ;
	}
	public Etudiant getEtu() {
		return Etu;
	}
	public void setEtu(Etudiant etu) {
		Etu = etu;
	}
	public Cours getCourse() {
		return Course;
	}
	public void setCrs(Cours crs) {
		Course = crs;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}
