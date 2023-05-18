package Classes;

import java.util.ArrayList;
import java.util.List;

public class Groupe {
	private int IDGrp ;
	private String Niveau ;
	private String Diplome ;
	private String Specialite ;
	private int NumG ;
	private List<Module> ListeModule ;
	private List<Etudiant> ListeEtu ;
	public Groupe() {
		setIDGrp(0) ;
		setNiveau("") ;
		setDiplome("") ;
		setSpecialite("") ;
		setNumG(0) ;
		setListeModule(new ArrayList<Module>()) ;
		setListeEtu(new ArrayList<Etudiant>()) ;
	}
	public int getIDGrp() {
		return IDGrp;
	}
	public void setIDGrp(int iDGrp) {
		IDGrp = iDGrp;
	}
	public String getNiveau() {
		return Niveau;
	}
	public void setNiveau(String niveau) {
		Niveau = niveau;
	}
	public String getDiplome() {
		return Diplome;
	}
	public void setDiplome(String diplome) {
		Diplome = diplome;
	}
	public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}
	public List<Module> getListeModule() {
		return ListeModule;
	}
	public void setListeModule(List<Module> listeModule) {
		ListeModule = listeModule;
	}
	public int getNumG() {
		return NumG;
	}
	public void setNumG(int numG) {
		NumG = numG;
	}
	public List<Etudiant> getListeEtu() {
		return ListeEtu;
	}
	public void setListeEtu(List<Etudiant> listeEtu) {
		ListeEtu = listeEtu;
	}
	public void AjouterEtu(Etudiant Etud) {
		ListeEtu.add(Etud);
	}
	public void SupprimerEtu(Etudiant Etud) {
		for(Etudiant Et : ListeEtu) {
			if((Et.getNum_Insc() == Etud.getNum_Insc()) | (Et.getNom() == Etud.getNom()) ) {
				ListeEtu.remove(Et);
			}
		}
	}
	public void AjouterModule(Module Mod) {
		ListeModule.add(Mod);
	}
	public void SupprimerModule(Module Mod) {
		for(Module Modu : ListeModule) {
			if( (Modu.getID() == Mod.getID() ) | (Modu.getNom() == Mod.getNom()) ) {
				ListeModule.remove(Modu);
			}
		}
	}
}
