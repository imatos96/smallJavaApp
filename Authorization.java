package hr.atos.praksa.PatrikVinicki.zadatak15;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Authorization {
	private int access;
	private String sql;
	private float profit;
	private Scanner reader = new Scanner(System.in);
	
	//making connection object
	public ConnectionClass connect = new ConnectionClass();
	private Connection conn;
	
	private Artikli article;
	private Zaposlenik employeeObject;
	
	private ResultSet result;
	

	public Authorization(int tempAccess){
		this.access=tempAccess;
		conn = connect.connection();
		article = new Artikli();
		employeeObject = new Zaposlenik();
		result = null;
	}
	
	public void authenticate() {
		int submenu;
		
		System.out.print("\n\n------Meni-----\n");
		System.out.print("1.Artikli\n");
		System.out.print("2.Zaposlenici\n\n");
		System.out.print("3.Exit");
		submenu = reader.nextInt();
		
		switch(this.access) {
			case(1): this.printAdminMenu(submenu);
			case(2): this.printSuperUserMenu(submenu);
			case(3): this.printUserMenu(submenu);
		}
	}
	
	public void printAdminMenu(int submenu) {
		int choice;
		while(true) {
			switch(submenu) {
				case(1): 
						 System.out.print("1.Kreiraj artikl\n");
						 System.out.print("2.Izlistaj artikle\n");
						 System.out.print("3.Izmjeni artikl\n");
						 System.out.print("4.Obrisi artikl\n");
						 System.out.print("5.Kreiraj izvještaj o trenutnom profitu\n");
						 System.out.print("6.Return");
						 choice = reader.nextInt();
						 
						 switch(choice) {
						 	case(1): this.getQuery(article.insertArticle());
						 			 break;
						 			 
						 	case(2): this.getResult(article.listArticles());
						 			 this.printArticle();
						 			 break;
						 			 
						 	case(3): this.getQuery(article.updateArticle());
						 			 break;
				 			 		 
						 	case(4): this.getQuery(article.deleteArticle());
						 			 break;
						 			 
						 	case(5):this.getResult(article.listArticles());
						 			profitCount();
						 			break;
				 			 		 
						 	case(6): this.authenticate();
						 			 break;
						 }
						 break;
						 
				case(2): 
						 System.out.print("1.Kreiraj zaposlenika\n");
						 System.out.print("2.Izlistaj zaposlenike\n");
						 System.out.print("3.Izmjeni zaposlenika\n");
						 System.out.print("4.Obrisi zaposlenika\n");
						 System.out.print("5.Kreiraj izvještaj po radnom mjestu\n");
						 System.out.print("6.Return");
						 choice = reader.nextInt();
						 switch(choice) {
						 	case(1):getQuery(employeeObject.kreirajZaposlenika());
						 			break;
						 			
						 	case(2):getResult(employeeObject.izlistajZaposlenike());
						 			this.printEmployee();
						 			break;
						 			
						 	case(3):getQuery(employeeObject.izmjeniZaposlenika());
						 			break;
						 			
						 	case(4):getQuery(employeeObject.obrisiZaposlenika());
						 			break;
						 			
						 	case(5):getResult(employeeObject.employeeReport());
						 			createEmployeeReport();
						 			break;
						 		
						 	case(6):authenticate();
						 			break;
						 }
						 break;
	
				case(3):
						  System.out.println("Goodbye.");
		            	  System.exit(0);
		            	  break;
	
		        default: 
		        		 System.out.println("That is not very nice...Goodbye...");
		        		 System.exit(0);
		            	 break;
			}
		}
	}
	
	public void printSuperUserMenu(int submenu) {
		int choice;
		
		while(true) {
			switch(submenu) {
				case(1): System.out.print("1.Kreiraj artikl\n");
						 System.out.print("2.Izlistaj artikle\n");
						 System.out.print("3.Kreiraj izvjestaj o trenutnom profitu\n");
						 System.out.print("4.Return");
						 choice = reader.nextInt();
						 
						 switch(choice) {
						 	case(1): this.getQuery(article.insertArticle());
						 			 break;
						 			 
						 	case(2): this.getResult(article.listArticles());
						 			 this.printArticle();
						 			 break;
						 			 
						 	case(3):this.getResult(article.listArticles());
						 			profitCount();
				 					break;
						 			 
						 	case(4): this.authenticate();
						 			 break;
						 }
						 
				case(2): System.out.print("1.Kreiraj zaposlenika\n");
						 System.out.print("2.Izlistaj zaposlenike\n");
						 System.out.print("3.Kreiraj izvjestaj po radnom mjestu\n");
						 System.out.print("4.Return");
						 choice = reader.nextInt();
						 switch(choice) {
						 	case(1):getQuery(employeeObject.kreirajZaposlenika());
						 			break;
						 			
						 	case(2):getResult(employeeObject.izlistajZaposlenike());
						 			this.printEmployee();
						 			break;
						 			
						 	case(3):getResult(employeeObject.employeeReport());
				 					createEmployeeReport();
				 					break;
						 		
						 	case(4):authenticate();
						 			break;
						 }
			}
		}
	}
	
	public void printUserMenu(int submenu) {
		int choice;
		
		while(true) {
			switch(submenu) {
				case(1): System.out.print("1.Izlistaj artikle\n");
						 System.out.print("2.Return");
						 choice = reader.nextInt();
						 
						 switch(choice) {
						 	case(1): this.getResult(article.listArticles());
						 			 this.printArticle();
						 			 break;
						 			 
						 	case(2): this.authenticate();
						 			 break;
						 }
						 
				case(2): System.out.print("1.Izlistaj zaposlenike\n");
						 System.out.print("2.Return");
						 choice = reader.nextInt();
						 
						 switch(choice) {
						 	case(1): 
						 			getResult(employeeObject.izlistajZaposlenike());
						 			this.printEmployee();
						 			break;
						 			
						 	case(2):
						 			authenticate();
						 			break;
						 }
			}
		}
	}
	
	public void getQuery(String sql){
			//creating sql statement object
			Statement query;
			try {
				query = conn.createStatement();
				query.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//execute update with received sql query
	}
	
	public void getResult(String sql) {
		//creating sql statement object
		Statement query;
		try {
			query = conn.createStatement();
			this.result = query.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//execute update with received sql quer
	}
	
	public void printArticle() {
		
		try {
			while(this.result.next()) {
				 System.out.format("\n%s:", result.getString("naziv"));
				 System.out.format("\n\tNabavna kolicina: %3d", result.getInt("nabavna_kolicina"));
				 System.out.format("\n\tTrenutno stanje: %3d", result.getInt("trenutno_stanje"));
				 System.out.format("\n\tNabavna cijena: %3f", result.getFloat("nabavna_cijena"));
				 System.out.format("\n\tProdajna cijena: %3f\n", result.getFloat("prodajna_cijena"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printEmployee() {
		
		try {
			while(this.result.next()) {
				 System.out.format("%s %s:", result.getString("ime"), result.getString("prezime") );
				 System.out.format("\n\tRadno mjesto: %3s", result.getString("radno_mjesto"));
				 System.out.format("\n\tOIB:          %3d\n\n", result.getLong("oib"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createEmployeeReport() {
		//creating new simple date format
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		//creating new file with date in title
		File file= new File("employeeReport "+dateFormat.format(date)+".txt");
	    FileWrite fileWrite=new FileWrite(file);
	    fileWrite.createFile();
		try {
			fileWrite.writeToFile("IZVJESTAJ PO RADNOM MJESTU\n",false);
			fileWrite.writeToFile("  ----------------------\n\n", false);
			fileWrite.writeToFile(" radno_mjesto |  kolicina\n", false);
			while(this.result.next()) {
				fileWrite.writeToFile("%8s" + result.getString("radno_mjesto") + " | " + result.getInt("amount") + "\n", false);
				
			}
			fileWrite.writeToFile("  ----------------------\n", true);
			this.result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void profitCount() {
		//creating new simple date format
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		//creating new file with date in title
		File file= new File("profitReport "+dateFormat.format(date)+".txt");
	    FileWrite fileWrite=new FileWrite(file);
	    fileWrite.createFile();
		try {
			while(this.result.next()) {
				 //getting the data from table
				 int nabavnaKolicina=result.getInt("nabavna_kolicina");
				 int trenutnoStanje=result.getInt("trenutno_stanje");
				 float nabavnaCijena=result.getInt("nabavna_cijena");
				 float prodajnaCijena=result.getInt("prodajna_cijena");
				
				 //writing data to .txt
				 fileWrite.writeToFile(result.getString("naziv") + ": \n", false);
				 fileWrite.writeToFile("\tNabavna kolicina:"+ nabavnaKolicina + "\n", false);
				 fileWrite.writeToFile("\tTrenutno stanje:"+ trenutnoStanje + "\n", false);
				 fileWrite.writeToFile("\tNabavna cijena:"+ nabavnaCijena + "kn\n", false);
				 fileWrite.writeToFile("\tProdajna cijena:"+ prodajnaCijena + "kn\n", false);
				 fileWrite.writeToFile("  ---------------------\n", false);
				 
				 this.profit += (((nabavnaKolicina-trenutnoStanje)*prodajnaCijena)-(nabavnaCijena*nabavnaKolicina));
				 
			 }
			fileWrite.writeToFile("\nUkupni profit je:\t"+this.profit+"kn\n", true);
			this.result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
