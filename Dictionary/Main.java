//imports here

public class Main{
	//instance variables
	Dictionary reader;

	//starts the class
	public static void main(String[] arg){
		Main main = new Main();
		main.run();
	}

	//methods
	public void run(){
		reader = new Dictionary();
		reader.readFile();
		reader.writeFile();
		reader.countLetters();
	}
}