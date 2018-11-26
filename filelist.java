import java.io.*;

public class filelist {
  public static void main(String args[]) {
    
    String oFile = "/Users/JIN/Desktop/P2"; //YOUR DIRECTORY HERE
    subDirList(oFile);
  }

public static void subDirList(String source){

		File dir = new File(source); 

		File[] fileList = dir.listFiles(); 

		try{

                    for (File file : fileList) {
                        if(file.isFile()){ //IF THERE IS A FILE, PRINT THE NAME
                            
                            System.out.println("\tFILE NAME = " + file.getName() + "\tFILE SIZE = " + file.length()/1024+"MB");
                            
                        }else if(file.isDirectory()){
                            
                            System.out.println("FOLDER = " + file.getName());
                            
                            subDirList(file.getCanonicalPath()); //RECURSIVLY SEARCH
                            
                        }
                    }

		}catch(IOException e){

			

		}

	}

}
