import java.io.*;
import java.util.*;


public class Countries 
{
	
	public static List<String> main(String[] args) throws IOException
	{
	
	String line = "";
	List<String> countriesList = new ArrayList<String>();
	try 
	{
	FileReader fr = new FileReader("coordinates.csv");
	BufferedReader br = new BufferedReader(fr);
	while((line = br.readLine()) != null)
	{
		line.split(",");
		countriesList.add(line.split(",")[3]);
		
	}
	}
	
	catch(IOException e)
	{
		System.out.println("File not found");
	}
	return countriesList;
	}
}


