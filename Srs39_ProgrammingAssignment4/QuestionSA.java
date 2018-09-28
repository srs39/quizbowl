/** This program creates Short answer questiosn objcets that extends the abstract class Questions.
*@author Samantha Shoecraft
*@version 3/12/2016
**/

import java.util.*;
public class QuestionSA extends Questions{

   public QuestionSA (String[] qA){
      this.points = Integer.parseInt(qA[0]);
      this.question = qA[1];
      this.correctAns = qA[2];
   }
}