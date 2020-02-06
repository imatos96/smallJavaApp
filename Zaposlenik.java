package hr.atos.praksa.ivonamatos.zadatak15;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Zaposlenik {
	private String ime;
	private String prezime;
	private String radno_mjesto;
	private long oib;
	private static final Logger logger = Logger.getLogger(Zaposlenik.class.getName());
	private static FileHandler fh;
	
	public Zaposlenik() {
		try {
			fh = new FileHandler("/home/pvinicki/Downloads/Atos/logs/zaposlenici.log");
			logger.addHandler(this.fh);
			SimpleFormatter formatter = new SimpleFormatter();
			this.fh.setFormatter(formatter);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String kreirajZaposlenika() {
		this.enterEmployeeInfo();
		String sqlstring = "INSERT INTO employees(ime, prezime, radno_mjesto, oib) VALUES('" + this.ime + "', '" + this.prezime + "', '" + this.radno_mjesto + "', " + this.oib +")";
		this.makeLog(sqlstring);
		//while petlja != 11
		this.oib = 0;
		return sqlstring;
	}

	public String izlistajZaposlenike() {
		String sqlstring = "SELECT * FROM employees";
		this.makeLog(sqlstring);
		return sqlstring;
	}
	
	public String izmjeniZaposlenika() {
		this.enterEmployeeInfo();
		String sqlstring = "UPDATE employees SET ime='" + this.ime + "', prezime='" + this.prezime + "', radno_mjesto='" + this.radno_mjesto + "' WHERE oib=" + this.oib ; 
		this.makeLog(sqlstring);
		return sqlstring;
	}
	
	public String obrisiZaposlenika() {
		Scanner reader = new Scanner(System.in);
		while(String.valueOf(this.oib).length() != 11) {
			System.out.print("\nUnesi oib:");
			this.oib = reader.nextLong();
		}
		
		String sqlstring = "DELETE FROM employees WHERE oib=" + this.oib;
		
		this.makeLog(sqlstring);
		this.oib = 0;
		return sqlstring;
	}
	
	public void enterEmployeeInfo() {
		Scanner reader = new Scanner(System.in);
		System.out.print("\nUnesi ime: ");
		this.ime = reader.nextLine();
		
		System.out.print("\nUnesi prezime: ");
		this.prezime = reader.nextLine();
		
		System.out.print("\nUnesi radno mjesto: ");
		this.radno_mjesto = reader.nextLine();
		
		while(String.valueOf(this.oib).length() != 11) {
			if(String.valueOf(this.oib).length() != 11) {
				System.out.println("\nOIB mora imati 11 znamenki!\n");
			}
			System.out.print("\nUnesi oib: ");
			this.oib = reader.nextLong();
		}
		
	}
	
	public void makeLog(String sqlstring) {
		try {
			logger.info(sqlstring);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	
	}
	
	public String employeeReport() {
		String sqlstring = "SELECT radno_mjesto, COUNT(radno_mjesto) AS amount FROM employees GROUP BY radno_mjesto ORDER BY amount DESC";
		this.makeLog(sqlstring);
		return sqlstring;
	}
}
