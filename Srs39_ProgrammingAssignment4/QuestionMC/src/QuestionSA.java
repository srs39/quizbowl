import java.util.*;
public class QuestionSA extends Questions{

   public QuestionSA (String[] qA){
      this.points = Integer.parseInt(qA[0]);
      this.question = qA[1];
      this.correctAns = qA[2];
   }
}