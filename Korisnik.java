package hr.atos.praksa.ivonamatos.zadatak15;

public class Korisnik {
	private String userTypeString;
	private String passwordString;
	//string array with account usernames and passwords
	private String[][] accounts = {{"admin", "java1"},{"super user", "java2"},{"user", "java"}};
	 
	public String getUserTypeString() {
		return userTypeString;
	}

	public void setUserTypeString(String userTypeString) {
		this.userTypeString = userTypeString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	//the constructor
	public Korisnik(String userTyString, String paString) {
		this.userTypeString=userTyString;
		this.passwordString=paString;
	}
	
	public boolean checkPassword()
	{
		boolean chekingLogIn=false;
		//checking if the username and password are correct
		for(int i=0;i<3;i++) {
			if ((this.userTypeString.equals(this.accounts[i][0])) && (this.passwordString.equals(this.accounts[i][1]))){
				chekingLogIn=true;
				break;
				//System.out.println("Ovdje sam");
			}
			else {
				chekingLogIn=false;
				//System.out.println("nisam");
			}
			
		}
		if (chekingLogIn) {
			return true;
		}
		else {
			return false;
		}
	}

	public int accessLevel(){
		//check which level access user has
		if(this.userTypeString.equals("admin")){
			return 1;
		}
		else if(this.userTypeString.equals("super user")){
			return 2;
		}
		else
			return 3;
		}
	}
