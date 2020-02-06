package hr.atos.praksa.ivonamatos.zadatak15;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class FileWrite {
	private File myObj;
	
	public FileWrite(File obj) {
		// TODO Auto-generated constructor stub
		this.myObj=obj;
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
		FileWriter myWriter;
		try {
			//initializing File writer
			myWriter = new FileWriter(this.myObj);
			//writinig in File
			myWriter.write(writingInFile);
			myWriter.append(writingInFile);
			myWriter.flush();
			if(close) {
				myWriter.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
