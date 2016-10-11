import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	
	
	
	public static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		loadData();
		
		Scanner user = new Scanner(System.in);
		System.out.println("Enter a word you want the definition of:");
		
		String lookUp = user.nextLine();
		if (map.containsKey(lookUp)) {
			System.out.println(map.get(lookUp));
		}
		
		
		
	}
	
	private static void loadData() {
		for (int i = 97; i < 122; i++) {
		LoadMap.loadDataFromFile("data/gcide_" + (char)i + ".xml");
		System.out.println("Loading " + (char)i);
		}
	}

}
