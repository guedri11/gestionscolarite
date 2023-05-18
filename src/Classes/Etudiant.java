package Classes;


public class Etudiant extends Personne {
	private int Num_Insc ;
	
	
	public Etudiant(int NumIns,String Nom, String Prenom, String Tel, String Mail, int Cin) {
		super(Nom, Prenom, Tel, Mail, Cin);
		Num_Insc = NumIns ;
		
	}
	public Etudiant() {
		super();
		Num_Insc = 0;
	}
	public int getNum_Insc() {
		return Num_Insc;
	}
	public void setNum_Insc(int num_Insc) {
		Num_Insc = num_Insc;
	}
	public static void main(String[] args) {
		
	}
}
