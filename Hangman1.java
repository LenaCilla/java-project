import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Hangman1 {
    final String WORDLIST_FILENAME = "words.txt";
    final int MAX_GUESSES = 8;

    public void Hangman() {
        ArrayList<String> wordList = loadWords();
        String secretWord = chooseWord(wordList).toLowerCase();
        startGame(secretWord);
    }

    ArrayList<String> loadWords() {
        ArrayList<String> wordList = new ArrayList<>();
        System.out.println("Loading word list from file...");
        try {
            Scanner input = new Scanner(new File(WORDLIST_FILENAME));
            while (input.hasNext()) {
                wordList.add(input.next());
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        System.out.println(wordList.size() + " words loaded.");
        return wordList;
    }

    String chooseWord(ArrayList<String> wordList) {
        Random rand = new Random();
        return wordList.get(rand.nextInt(wordList.size()));
    }

    boolean isWordGuessed(String secretWord, ArrayList<Character> lettersGuessed) {
        for (char letter : secretWord.toCharArray()) {
            if (!lettersGuessed.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    String getGuessedWord(String secretWord, ArrayList<Character> lettersGuessed) {
        StringBuilder guessedWord = new StringBuilder();
        for (char letter : secretWord.toCharArray()) {
            if (lettersGuessed.contains(letter)) {
                guessedWord.append(letter);
            } else {
                guessedWord.append("_");
            }
        }
        return guessedWord.toString();
    }

    String getAvailableLetters(ArrayList<Character> lettersGuessed) {
        StringBuilder availableLetters = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!lettersGuessed.contains(c)) {
                availableLetters.append(c);
            }
        }
        return availableLetters.toString();
    }

    void startGame(String secretWord) {
        System.out.println("Welcome to Hangman!");
        System.out.println("The word contains " + secretWord.length() + " letters.");
        ArrayList<Character> lettersGuessed = new ArrayList<>();
        int guessesLeft = MAX_GUESSES;

        Scanner scanner = new Scanner(System.in);
        while (guessesLeft > 0) {
            System.out.println("You have " + guessesLeft + " guesses left.");
            System.out.println("Available letters: " + getAvailableLetters(lettersGuessed));
            System.out.print("Please guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (lettersGuessed.contains(guess)) {
                System.out.println("You've already guessed that letter. Try again.");
                continue;
            }

            lettersGuessed.add(guess);

            if (secretWord.contains(String.valueOf(guess))) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Oops! That letter is not in the word.");
                guessesLeft--;
            }

            String guessedWord = getGuessedWord(secretWord, lettersGuessed);
            System.out.println("Partial word: " + guessedWord);

            if (isWordGuessed(secretWord, lettersGuessed)) {
                System.out.println("Congratulations! You've guessed the word: " + secretWord);
                return;
            }
        }

        System.out.println("Sorry, you ran out of guesses. The word was: " + secretWord);
    }

    public static void main(String[] args) {
        Hangman1 = new Hangman1();
    }
}
