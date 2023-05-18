package Classes;

public class Note {
	private int IDNote;
	private Etudiant Etu ;
	private Matiere Mat ;
	private float Note ;
	private String Type ;
	public Note () {
		Etu = new Etudiant() ;
		Mat = new Matiere() ;
		Note = 0 ;
		Type = "" ;
		IDNote = 0;
	}
	public Etudiant getEtu() {
		return Etu;
	}
	public void setEtu(Etudiant etu) {
		Etu = etu;
	}
	public Matiere getMat() {
		return Mat;
	}
	public void setMat(Matiere mat) {
		Mat = mat;
	}
	public float getNote() {
		return Note;
	}
	public void setNote(float note) {
		Note = note;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Note(int iDNote,Etudiant etu, Matiere mat, float note, String type) {
		IDNote = iDNote;
		Etu = etu;
		Mat = mat;
		Note = note;
		Type = type;
	}
	public int getIDNote() {
		return IDNote;
	}
	public void setIDNote(int iDNote) {
		IDNote = iDNote;
	}
}
