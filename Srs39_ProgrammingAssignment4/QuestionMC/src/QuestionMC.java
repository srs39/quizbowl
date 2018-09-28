/** This program creates Multiple choice questiosn objcets that extends the abstract class Questions.
*@author Samantha Shoecraft
*@version 3/12/2016
**/


import java.util.*;

public class QuestionMC extends Questions {

   protected String[] choices;//Initializes array for multiple choices.
   
   /*
   *This is a constructor that creates the mulutiple choice question objects.
   *@param qA is an array full of Strings that contain information about the question.
   *@param mc is an array full of Strings that contains the possible choices for the question answers.
   */
   public QuestionMC (String[] qA, String[] mc){
      this.points = Integer.parseInt(qA[0]);//Sets point amounts.
      this.question = qA[1];
      choices = mc;
      this.correctAns = qA[2];
   }
   public String[] getChoices(){
      return choices;
   }
   
}