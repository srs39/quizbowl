/** This program is an abstract method that contains methods and variables used in all question types.
*@author Samantha Shoecraft
*@version 3/12/2016
**/
import java.util.*;

public abstract class Questions {

   protected String question;//Holds question.
   protected int points;//Holds points.
   protected String correctAns;//Holds correct answer.
   

   
   /*
   *This method gets points the question is worth.
   *@return int points.
   */
   public  int getPoints(){
      return points;
   }
   /*
   *This method gets the question.
   *@return String question.
   */
   public String getQuestion(){
      return question;
   }
   /*
   *This method gets the correct answer to the question.
   *@return String correctAns.
   */
   public String getAnswer(){
      return correctAns;
   }
}