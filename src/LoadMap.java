import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadMap {
	
	public static void loadDataFromFile(String fileLocation) {
		new Thread(fileLocation) {
			@Override
			public void run() {
				try {
					Scanner sc = new Scanner(new File(fileLocation));
					
					String word = null, definition = null;
					while (sc.hasNextLine()) {
						
						String str = sc.nextLine();
						
						if (str.contains("<ent>")) {
							word = str.substring(str.indexOf("<ent>") + 5, str.indexOf("</ent>"));
						}
						
						if (str.contains("<def>") && str.contains("</def>")) {	
							definition = str.substring(str.indexOf("<def>") + 5, str.indexOf("</def>"));
							if (word != null)
								Driver.map.put(word, definition);
							
							word = null;
						}
						
					}
					
					} catch (FileNotFoundException fnfe) {
						System.out.println("Error reading file");
					}
				System.out.println("Finished Loading " + fileLocation);
			}
	}.start();
	}
	
}
