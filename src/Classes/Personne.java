package Classes;

public abstract class Personne {
	private String Nom ;
	private String Prenom ;
	private String Telephone ;
	private String Email ;
	private int CIN ;
	public Personne() {
	  this.Nom = "" ;
	  this.Prenom = "" ;
	  this.Telephone = "" ;
	  this.Email = "" ;
	  this.CIN = 0 ;
	}
	public Personne(String Nom,String Prenom,String Tel,String Mail ,int Cin) {
		this.Nom = Nom ;
		this.Prenom = Prenom ;
		this.Telephone = Tel ;
		this.Email = Mail ;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	
}
