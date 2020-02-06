package hr.atos.praksa.ivonamatos.zadatak15;
import java.util.Scanner;

import java.util.concurrent.TimeUnit;

public class Aplikacija {
	private static Korisnik user;
	private static Scanner reader;
	
	public static void main(String[] args) {
			String username;
			String password;
			int passwordCounter=3;
			int access;
			reader = new Scanner(System.in);
			//korisnici.add(new Korisnik("pvinicki", "12345", 1));
			System.out.print("\nDobrodošli u aplikaciju\n");
			System.out.print("-----------------------\n\n");
			
			do {
				System.out.print("Unesi korisničke podatke:\n");
				
				System.out.format("%3s", "1.korisničko ime:");
				username = reader.nextLine();
				
				System.out.format("\n%3s", "2.Lozinka:");
				password = reader.nextLine();

				user=new Korisnik(username, password);
				passwordCounter--;
				
				if(passwordCounter==0 && !user.checkPassword()){
					try {
						System.out.print("Tri puta ste krivo unijeli korisničke podatke! \nPokušajte ponovno za 30 sekundi...");
						TimeUnit.SECONDS.sleep(30);
						passwordCounter=3;
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
       				System.out.println("Možete pokušati ponovno!");
				}
				
				if(!user.checkPassword()) {
					System.out.println("Netočno korisničko ime ili lozinka.");
				}
				else {
					System.out.println("Uspješna prijava!");
				}
				
			} while(!user.checkPassword());

			//get access level for user
			access=user.accessLevel();
		
		//add call autorization
		Authorization newAuthorization= new Authorization(access);
		newAuthorization.authenticate();

	}
  }

