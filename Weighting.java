package countdown;

// Import the Scanner class to read text files
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner; // Import the Scanner class to read text files


public class Weighting {
	public static LetterBag addLetterWeights(String type) {

		//Initialize the files and make sure they don't throw errors.
		File vowFile = new File("src/countdown/vowelfileweights.txt");
		Scanner vowScanner = null;
		try {
			vowScanner = new Scanner(vowFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File constFile = new File("src/countdown/constfileweights.txt");
		Scanner constScanner = null;
		try {
			constScanner = new Scanner(constFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println("THIS ERROR");
			e.printStackTrace();
		}
		
        LetterBag letterBag = new LetterBag();
        LetterBag letterBag2 = new LetterBag();

        List<Character> vowelList = new ArrayList<Character>();
        List<Character> constList = new ArrayList<Character>();
		
        if(type == "vowel") {
        	while(vowScanner.hasNextLine()) {
				Character vowel = vowScanner.next().charAt(0);
				int weight = vowScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					vowelList.add(vowel);
				}
			}
        	vowScanner.close();
        	letterBag.fillLetters("vowel", vowelList);
        	return letterBag;
        }
		else if(type == "const") {
			while(constScanner.hasNextLine()) {
				Character cons = constScanner.next().charAt(0);
				int weight = constScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					constList.add(cons);
				}
			}
			constScanner.close();
			letterBag2.fillLetters("const", constList);
			return letterBag2;
		}
		
    return null;
	}
	
	public static NumberBag addNumberWeights(String type) {

		//Initialize the files and make sure they don't throw errors.
		File bigFile = new File("src/countdown/bigfileweights.txt");
		Scanner bigScanner = null;
		try {
			bigScanner = new Scanner(bigFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File smallFile = new File("src/countdown/smallfileweights.txt");
		Scanner smallScanner = null;
		try {
			smallScanner = new Scanner(smallFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NumberBag numberBag = new NumberBag();
        NumberBag numberBag2 = new NumberBag();
        
        List<Integer> smallList = new ArrayList<Integer>();
        List<Integer> bigList = new ArrayList<Integer>();
		
		if(type == "big") {
			while(bigScanner.hasNextLine()) {
				int number = bigScanner.nextInt();
				int weight = bigScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					bigList.add(number);
				}
			}
			bigScanner.close();
			numberBag.fillNumbers("big", bigList);
			return numberBag;
		}
		else if(type == "small") {
			while(smallScanner.hasNextLine()) {
				int number = smallScanner.nextInt();
				int weight = smallScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					smallList.add(number);
				}
			}
			smallScanner.close();
			numberBag2.fillNumbers("small", smallList);
			return numberBag2;
		}
    return null;
	}
}
