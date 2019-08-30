
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static int numLives = 10;
    public static String[] words = {"sunset", "vacation", "horizon", "trampoline"};
    public static boolean isEnd = false;
    public static boolean isWinner = false;
    public static int correctCount = 0;

    public static void main (String[] args){

        //Use a loop to ask the user for input until the game ends.
        String magicWord = selectWord(words);
        long uniqueCount = countUniqueCharacters(magicWord);


        while (!isEnd && !isWinner){
            //methods that allows a player to start a game, guess a letter
            System.out.println("Select a letter");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            // See if it is correct, and decrement lives as needed

            boolean correct = isContained(magicWord, input);
            printIsCorrect(correct);

            if(!correct){
                decrementLives();
            }else{
                incrementCorrectCount();
            }

            printLives();
            System.out.println();

            isWinner = correctCount >= uniqueCount;
            isEnd = isOver(numLives);
        }

        if(isEnd) {
            System.out.println("Sorry, Game Over!");
        } else {
            System.out.println("Yay! You're a Winner!");
        }

    }

    // method that prints the current number of lives to the console.
    public static void printLives(){
        System.out.println("You have " + numLives + " lives remaining.");
    }

    // method that prints  “correct” or “incorrect” to the console depending on which boolean is passed into the method
    public static void printIsCorrect(boolean isCorrect){
        if(isCorrect){
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect.");
        }
    }

    // method that determines if a letter is in a word and returns a boolean.
    public static boolean isContained(String word, String input){
        return word.contains(input);
    }

    // method that randomly selects 1 random word from the array
    public static String selectWord(String[] words){
        return words[new Random().nextInt(words.length)];
    }

    // method that decrements the lives when called.
    public static void decrementLives(){
        numLives--;
    }

    // method that checks if lives are depleted and returns a boolean.

    public static boolean isOver(int numLives){
        return numLives <= 0;
    }

    //method the counts the unique characters in a word
    public static long countUniqueCharacters(String input) {
        return input.chars()
                .distinct()
                .count();
    }

    // method that increments the correctCount when called.
    public static void incrementCorrectCount(){
        correctCount++;
    }
}



