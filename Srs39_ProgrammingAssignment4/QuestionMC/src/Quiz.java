/** This program is an interface that contains all of the methods in quizbowl
*@author Samantha Shoecraft
*@version 3/12/2016
**/
import java.util.*;//import for set
import java.io.*;//import for file

public interface Quiz {
   
   Set<Integer> randomNum(int m, int n);
   void getQuestion(Set<Integer> qnum, String ufile,Player p1 ) throws FileNotFoundException;
   void printQ(QuestionTF q, Player p1);
   void printQ(QuestionMC q, int anum, Player p1);
   void printQ(QuestionSA q, Player p1);
   String varifyans(String ans, String uans, int points, Player p1); 
    
   
   
   
}