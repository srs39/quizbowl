/**This program creates a player and keeps track of their score.
*
*@author Samantha Shoecraft
*@version 3/12/2016
**/

import java.util.*; //Import for Scanner and Random.
import java.io.*; //Import for file reading.

public class Player {
   protected String first;//holds first name.
   protected String last;//holds last name;
   protected int score = 0;//holds player score.
   
   /*This is the constructor to create player.
   *@param f player first name.
   *@param l player last name.
   */
   public Player(String f, String l){
     first = f;//sets to user input first name.
     last = l;//sets to user input last name.
   }
   /*This method allows program to add to player score.
   *@param n is the amount of points to be added to player score.
   */
   public void addScore(int n){
      score += n;
   }
   /*This method returns the players score.
   *@return int returns the players score.
   */
   public int getScore(){
      return score;
   }
   /*this returns a string containing the player name and score.
   *@return Sting that contans player name and score.
   */
   public String toString(){
      String s = first + " " + last +  ", your game is over!\nYour final Score is " + score + " points.";
      return s;
   }
   
      
   

}
      