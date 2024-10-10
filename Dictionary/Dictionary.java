//imports
import java.util.*;
import java.io.*;

class Dictionary{
	//instance variables 
	//store dictionary words
	ArrayList<String> dictWords = new ArrayList<String>();
	ArrayList<Integer> total = new ArrayList<Integer>();
	String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	public Dictionary(){
		//constructor This Runs when object is created
	}

	//methods
	public void readFile(){
		try{
			File myObj = new File("dictionary-1.txt");
			Scanner myReader = new Scanner(myObj);
			int position = 1;
			dictWords.add("A");
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				int end = data.indexOf(",");
				if(end > 1){
					if(data.substring(1,2).equalsIgnoreCase("-") || data.substring(1,2).equalsIgnoreCase("'")){
						data = data.substring(2,end-1);
					}
					else{
						data = data.substring(1,end-1);
					}
				}
				if(!dictWords.get(position-1).equals(data))
				{
					dictWords.add(data);
					position++;
				}

			}
			Collections.sort(dictWords, String.CASE_INSENSITIVE_ORDER);
			System.out.println(dictWords);
			System.out.println("The size of the array is " + dictWords.size() +" words long");
		myReader.close();
	} catch(FileNotFoundException e) {
		System.out.println("An error occured. ");
		e.printStackTrace();
	}
	}
	public void writeFile(){
		try {
      		FileWriter myWriter = new FileWriter("newDictionary.txt");
      		 for(int i = 0; i < dictWords.size(); i++){
                myWriter.write(dictWords.get(i) + System.lineSeparator());
            }
     		myWriter.close();
     		System.out.println("Successfully wrote to the file.");
    	} catch (IOException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
	}
	public void countLetters(){
		int ammount = 0; 
			int alph = 0;
			int j = 2;  
			while(j <= dictWords.size()-1){
				String word = dictWords.get(j);
				if(word.substring(0,1).equalsIgnoreCase(alphabet[alph])){
					ammount++; 
					j++;
				}

				else{
					alph++;
					total.add(ammount);
					ammount = 0; 
				}
			}
			total.add(ammount);
			for(int k = 0; k < total.size()-1; k++){
				System.out.println("There are " + total.get(k) + " words that start with the letter " + '"' + alphabet[k] + '"' + " in the file");
			}
	}
}

