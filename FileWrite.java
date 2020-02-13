package hr.atos.praksa.PatrikVinicki.zadatak15;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class FileWrite {
	private File myObj;
	private FileWriter myWriter;
	
	public FileWrite(File obj) {
		// TODO Auto-generated constructor stub
		this.myObj=obj;
		try {
			myWriter = new FileWriter(this.myObj.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createFile() {
	try {
	      //checking wheater file is created
	      if (this.myObj.createNewFile()) {
	        System.out.println("File created: " + this.myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	      
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public void writeToFile(String writingInFile, boolean close) {
		try {
			this.myWriter.write(writingInFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(close) {
				try {
					myWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}

}
