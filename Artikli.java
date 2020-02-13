package hr.atos.praksa.PatrikVinicki.zadatak15;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Artikli {
	private String naziv;
	private int nabavna_kolicina;
	private int trenutno_stanje;
	private float nabavna_cijena;
	private float prodajna_cijena;
	private static final Logger logger = Logger.getLogger(Artikli.class.getName());
	private static FileHandler fh;
	
	public Artikli() {
		try {
			fh = new FileHandler("/home/pvinicki/Downloads/Atos/logs/artikli.log");
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
	
	public String insertArticle() {
		this.enterArticleInfo();
		String sqlstring = "INSERT INTO articles(naziv, nabavna_kolicina, trenutno_stanje, nabavna_cijena, prodajna_cijena) VALUES('" + this.naziv + "', " + this.nabavna_kolicina + ", " + this.trenutno_stanje + ", " + this.nabavna_cijena + ", " + this.prodajna_cijena + ")";
		this.makeLog(sqlstring);
		return sqlstring;
		
	}
	
	public String listArticles() {
		String sqlstring = "SELECT * FROM  articles";
		this.makeLog(sqlstring);
		return sqlstring;
	}
	
	public String updateArticle() {
		this.enterArticleInfo();
		String sqlstring = "UPDATE articles SET naziv='" + naziv + "', nabavna_kolicina=" + nabavna_kolicina + ", trenutno_stanje=" + trenutno_stanje + ", nabavna_cijena=" + nabavna_cijena + ", prodajna_cijena=" + prodajna_cijena + "WHERE naziv='" + this.naziv + "'";	
		this.makeLog(sqlstring);
		return sqlstring;
	}
	
	public String deleteArticle() {
		Scanner reader = new Scanner(System.in);
		System.out.print("\nUnesi naziv artikla: ");
		this.naziv = reader.nextLine();
		String sqlstring = "DELETE FROM articles WHERE naziv='" + naziv + "'";
		this.makeLog(sqlstring);
		return sqlstring;
	}
	
	public void enterArticleInfo() {
		Scanner reader = new Scanner(System.in);
		
		System.out.print("\nUnesi naziv:");
		this.naziv = reader.nextLine();
		
		System.out.print("\nUnesi nabavnu kolicinu:");
		this.nabavna_kolicina = reader.nextInt();
		
		System.out.print("\nUnesi trenutno stanje");
		this.trenutno_stanje = reader.nextInt();
		
		System.out.print("\nUnesi nabavnu cijenu");
		this.nabavna_cijena = reader.nextFloat();
		
		System.out.print("\nUnesi prodajnu cijenu");
		this.prodajna_cijena = reader.nextFloat();
	}
	
	public void makeLog(String sqlstring) {
		try {
			logger.info(sqlstring);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	
	}
	
}
