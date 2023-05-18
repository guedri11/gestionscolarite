package Classes;

public class
Utilisateur {
	private int EmployeeID ;
	private Login Login;
	private String Role ;
	
	public Utilisateur() {
		EmployeeID = 0 ;
		Login = new Login() ;
		Role = "";
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public Login getLogin() {
		return Login;
	}
	public void setLogin(Login login) {
		Login = login;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
	
}
