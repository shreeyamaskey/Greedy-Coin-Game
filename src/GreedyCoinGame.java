/**
 * Plays Greedy Coin game such that the computer never loses.
 * 
 * [ YOUR NAME GOES HERE]
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class GreedyCoinGame {
	
	List <Integer> storage = new ArrayList<Integer>();

	int humans = 0;
	int computer = 0;
	int red = 0;
	int blue = 0;
	
	
	public GreedyCoinGame(String file) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) {
			// TO-DO store each coin in an ArrayList
			storage.add(inFile.nextInt());
		}

		inFile.close();
	}

	// prints the coins and their position
	public void printCoins() {
		System.out.println("+++++++++++");
		
		// TO-DO print out each element and its position in the array list
		System.out.print("Coins: \t \t");

		for (int i = 0; i < storage.size(); i++) {
			System.out.print(storage.get(i)+"\t");
		}
		System.out.println();
		
		System.out.print("Position: \t");
		for (int i = 0; i < storage.size(); i++) {
			System.out.print(i+"\t");
		}
		System.out.println();

		
		System.out.println("+++++++++++");
	}

	public void playGame() {
		System.out.println("Let's play the coin game!");
		printCoins();
		
		System.out.printf("Humans: %d \t Computer: %d\n", humans, computer);


		// get the keyboard for the silly human
		Scanner keyboard = new Scanner(System.in);
		

		while(storage.size() != 0) {
			// TO-DO Play the game using the Red Blue strategy

			for (int i = 0; i < storage.size(); i++) {
				if (i % 2 == 0) {
					red += storage.get(i);
				}
				else if(i % 2 == 1) {
					blue += storage.get(i);
				}
			}
			
			System.out.println("*** red score = " + red);
			System.out.println("*** blue score = " + blue);
			
			if(red > blue) {
				System.out.println("I (the computer) choose position 0");
				computer += storage.remove(0);
			}
			else {
				System.out.println("I (the computer) choose position " + (storage.size() - 1));
				computer += storage.remove((storage.size() - 1));
			}
			
			printCoins();
			
			System.out.println("Indicate the position of the coin you choose: ");
			int humanChoice = keyboard.nextInt();
			
			humans += storage.remove(humanChoice);

			
			System.out.printf("Humans: %d \t Computer: %d", humans, computer);
			System.out.println();
			

		}
		
		System.out.printf("Game over! The final score is You: %d and Me: %d\n", humans, computer);
		
		
		if (humans > computer) {
			System.out.println("Computer lost. Boo! Error");
		}
		else if (humans == computer) {
			System.out.println("Everything went according to plan.");
		}
		else {
			System.out.println("Everything went according to plan.");
		}
		
		keyboard.close();


		

	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Provide a file on the command line");
			System.exit(0);
		}

		GreedyCoinGame game = new GreedyCoinGame(args[0]);

		game.playGame();
	}

}