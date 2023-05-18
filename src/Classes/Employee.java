package Classes;

public class Employee extends Personne {
	private int ID ;
	private int CNSS ;
	Employee(){
		super();
		ID = 0;
		CNSS = 0;
	}
	public Employee(String Nom,String Prenom,String Tel,String Mail ,int Cin,int iD, int cNSS) {
		super(Nom,Prenom,Tel,Mail,Cin);
		ID = iD;
		CNSS = cNSS;
	}
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	public int getCNSS() {
		return CNSS;
	}
	public void setCNSS(int cNSS) {
		CNSS = cNSS;
	}
}
