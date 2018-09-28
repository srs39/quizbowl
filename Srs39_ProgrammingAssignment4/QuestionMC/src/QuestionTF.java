/** This program creates True false questiosn objcets that extends the abstract class Questions.
*@author Samantha Shoecraft
*@version 3/12/2016
**/

import java.util.*;

public class QuestionTF extends Questions{
   /*constructor to create objcet
   * @param qA is an array of strings containing the information for building the questison.
   */
   public QuestionTF (String[] qA){
      this.points = Integer.parseInt(qA[0]);//Sets point value
      this.question = qA[1];//Sets question
      this.correctAns = qA[2];//Sets answer.
   }

}