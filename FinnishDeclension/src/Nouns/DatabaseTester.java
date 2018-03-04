package Nouns;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class DatabaseTester {
 public static void main(String[] args) throws IOException, ClassNotFoundException {
	// Read from disk using FileInputStream
	 FileInputStream f_in = new 
	 	FileInputStream("FinnishDictionary");

	 // Read object using ObjectInputStream
	 ObjectInputStream obj_in = 
	 	new ObjectInputStream (f_in);

	 // Read an object
	 Object obj = obj_in.readObject();

	 if (obj instanceof HashMap<?, ?>)
	 {
	 	
		 System.out.println("successfully loaded finnish database");
		 HashMap<String, String> data = (HashMap<String, String>) obj;
		 System.out.println(data.size());
		 System.out.println(data.get("symboli"));
		 System.out.println(data.get("vaarassa"));
		 System.out.println(data.get("murmeleita"));
	 }
}

}
