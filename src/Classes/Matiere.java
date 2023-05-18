package Classes;

public class Matiere {
	private int IdMat;
	private String NomMat;
	private float Coef;
	public Matiere() {
		IdMat = 0 ;
		NomMat = "" ;
		Coef = 0 ;
	}
	
	public Matiere(int idMat, String nomMat, float coef) {
		IdMat = idMat;
		NomMat = nomMat;
		Coef = coef;
	}

	public int getIdMat() {
		return IdMat;
	}

	public void setIdMat(int idMat) {
		IdMat = idMat;
	}

	public String getNomMat() {
		return NomMat;
	}

	public void setNomMat(String nomMat) {
		NomMat = nomMat;
	}

	public float getCoef() {
		return Coef;
	}

	public void setCoef(float coef) {
		Coef = coef;
	}
}
