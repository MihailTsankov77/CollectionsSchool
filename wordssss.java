package intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class wordssss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Vector<String> words = new Vector<>();
			
			try {
				File myObj = new File("text.txt");
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNext()) {
					words.add( myReader.next());
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}


			for(int i = 0; i<words.size();i++) {
				words.set(i,    words.get(i).toLowerCase());
			}

		
			words.sort(null);
			System.out.println(words);

			
	}

}
