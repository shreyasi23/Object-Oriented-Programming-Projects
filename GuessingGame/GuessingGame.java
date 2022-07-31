/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessinggame;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author SHREYASI
 */

class Game{
    Random rn = new Random();   // object of Random class
    private int userIp, comp, noOfGuess, points, i, flag, actualNoOfGuess;
    
    // Default constructor
    public Game(){
        comp = rn.nextInt(100);  // comp will get numbers from 0 to 100
        noOfGuess = 10;
        actualNoOfGuess = 0;
        points = 0;
        flag = 0;
    }
    
    // Method to print number to be guessed by the player at the end of the game
    public void getNo(){
        System.out.println("The number is "+comp);
    }
    
    // Method to take user input
    public void takeUserIp(int uip){
        userIp = uip;
    }
    
    // Method to compare user input and the guesses number
    public boolean isCorrectNumber(){
        if(userIp > comp){
            System.out.println("Your guess is greater than the number I thought of, try again..");
            //noOfGuess -= 1;
        }
        else if(userIp < comp){
            System.out.println("Your guess is smaller than the number I thought of, try again.."); 
            //noOfGuess -= 1;
        }
        else if(userIp == comp){
            flag = 1;
            System.out.println("Congratulations!! your guess is correct");
        }
        
        if(flag == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    // Method to get the number of guesses left 
    public void setChance(int nguess){
        noOfGuess = nguess;
    }
    
    // Method to display the number of guesses left
    public void getChance(){
        System.out.print("Number of chances left "+noOfGuess);
    }
    
    // Method to calculate the score
    public void score(){
        //System.out.println("no. of guesses: "+noOfGuess);
        actualNoOfGuess =  10 - noOfGuess;
        if(actualNoOfGuess == 1){
            points = 10;
        }
        else if(10 >= actualNoOfGuess && actualNoOfGuess >= 8){
            points = 8;
        }
        else if(8 > actualNoOfGuess && actualNoOfGuess >= 5){
            points = 6;
        }
        else if(5 > actualNoOfGuess && actualNoOfGuess >= 2){
            points = 4;
        }
        System.out.println("Your score is "+points);
    }
}
public class GuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner read = new Scanner(System.in);  // Object of Scanner class
        Game gnobj = new Game();    // Obejct of game class
        int guess, chance = 10;
        boolean result = true;
        
        System.out.println("Guess The Number");
        System.out.println("You have 10 chances to guess the number. All the best!");
        
        while(chance != 0){
            gnobj.setChance(chance);
            gnobj.getChance();
            System.out.println("\nEnter your guess: ");
            guess = read.nextInt();
            gnobj.takeUserIp(guess);
            result = gnobj.isCorrectNumber();
            if(result == true){
                gnobj.score();
                break;
            }
            chance = chance - 1;
        }
        if(result == false){
            gnobj.getNo();
            System.out.println("Better luck next time");
        }
    } 
}
