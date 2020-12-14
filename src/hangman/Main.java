package hangman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	// Globala variabler
	static Scanner input = new Scanner(System.in);
	static ArrayList<Character> word = new ArrayList<Character>();
	static int totalGuesses;
	static int remainingGuesses = 7;
	static String secretWord = "corona";
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collections.addAll(word, '_', '_', '_', '_', '_', '_');
		
		boolean resume = true;
		// menu
		do {
			
		
			System.out.println("let's play Hangman!");
			System.out.println("(1) Game status");
			System.out.println("(2) Guess char");
			System.out.println("(3) Guess word");
			System.out.println("(4) Add word");
			System.out.println("(5) Quit game");
			System.out.print("Selection: ");
		
			int selection = input.nextInt();
		
			if (selection == 5) {
				resume = false;
				System.out.println("quiting game...");
				
			}
			else if(selection == 1) {
				gameStatus();
			}
			else if(selection == 2) {
				guessChar();
			}
			else if(selection == 3) {
				guessWord();
			}
			else if(selection == 4) {
				addWord();
			}
			System.out.println("");
		
		
		
		}while(resume);
		
	
		
		
		

	}

	private static void addWord() {
		// TODO Auto-generated method stub
		
		// reset all values
		word.clear();
		remainingGuesses = 7;
		totalGuesses = 0;
		
		
		System.out.println("add word:  ");
		
		
		String fixIssue = input.nextLine();
		
		// set new word
		secretWord = input.nextLine();
		
		for(int i = 0; i < secretWord.length(); i++) {
			word.add('_');
		}
		
	}

	private static void guessWord() {
		// TODO Auto-generated method stub
		System.out.println("Guess the word: ");
		String fixIssue = input.nextLine();
		String wordGuess = input.nextLine();
		if(wordGuess.equals(secretWord) ) {
			System.out.println("Correct!");
			totalGuesses++;
		}else {
			totalGuesses++;
			remainingGuesses--;
			System.out.println("incorrect.");
			
			// Draw hangman
			switch (remainingGuesses) {
			  case 6:
				  	System.out.println("  ------\n |      |\n |\n |\n |\n |\n |\n ");
			    
				  	break;
			  case 5:
				    System.out.println("  ------\n |      |\n |      O\n |\n |\n |\n |\n ");
				  	
				  	break;
			  case 4:
				    System.out.println("  ------\n |      |\n |      O\n |      |\n |\n |\n ");
				    break;
			  case 3:
				    System.out.println("  ------\n |      |\n |      O\n |     (|\n |\n |\n |\n ");
				    break;	    
			  case 2:
				    System.out.println("  ------\n |      |\n |      O\n |     (|)\n |\n |\n |\n ");
				    break;
			  case 1:
				    System.out.println("  ------\n |      |\n |      O\n |     (|)\n |     (\n |\n |\n ");
				    break;
			  case 0:
				    System.out.println("  ------\n |      |\n |      O\n |     (|)\n |     ( )\n |\n |\n ");
				    break;	    	    
			}
		}
	}

	private static void guessChar() {
		// TODO Auto-generated method stub
		
		boolean correct = false;
		
		System.out.print("Word length:  " + word.size() + ". Guess letter: " );
		char guess = input.next().charAt(0);
		
		// goes through the secretword and check if guessed char matches
		for(int i = 0; i < secretWord.length(); i++) {
			if(secretWord.charAt(i) == guess) {
				correct = true;
				totalGuesses++;
				word.set(i, guess);
				System.out.println("Correct! char added to line: " + (i + 1));
				System.out.println("");
				for(int x = 0; x < word.size(); x++) {
					System.out.print(" " + word.get(x));
				}
				
			}
			
		}
		// if guessed char doesnt match do this
		if(correct == false) {
			totalGuesses++;
			remainingGuesses--;
			System.out.println("incorrect.");
			
			switch (remainingGuesses) {
			  case 6:
				  	System.out.println("  ------\n |      |\n |\n |\n |\n |\n |\n ");
			    
				  	break;
			  case 5:
				    System.out.println("  ------\n |      |\n |      O\n |\n |\n |\n |\n ");
				  	
				  	break;
			  case 4:
				    System.out.println("  ------\n |      |\n |      O\n |      |\n |\n |\n ");
				    break;
			  case 3:
				    System.out.println("  ------\n |      |\n |      O\n |     (|\n |\n |\n |\n ");
				    break;	    
			  case 2:
				    System.out.println("  ------\n |      |\n |      O\n |     (|)\n |\n |\n |\n ");
				    break;
			  case 1:
				    System.out.println("  ------\n |      |\n |      O\n |     (|)\n |     (\n |\n |\n ");
				    break;
			  case 0:
				    System.out.println("  ------\n |      |\n |      O\n |     (|)\n |     ( )\n |\n |\n ");
				    break;	    	    
			}

		}
		// lost message, reset data
		if(remainingGuesses == 0 ) {
			System.out.println("YOU HAVE LOST!");
			
			word.clear();
			remainingGuesses = 7;
			totalGuesses = 0;
			
			
			
			for(int i = 0; i < secretWord.length(); i++) {
				word.add('_');
			}
		}
		
		
	}

	private static void gameStatus() {
		// TODO Auto-generated method stub
		
		// Display total guesses and remaining guesses
		System.out.println("Total Guesses: " + totalGuesses);
		System.out.println("Guesses left: " + remainingGuesses);
	}

}
