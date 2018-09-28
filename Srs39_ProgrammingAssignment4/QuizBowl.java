/*This program initiates the quiz bowl program and implements metthods in Quiz interface.
*@author Samantha Shoecraft
*@version 3/12/2016
**/
import java.util.*;//import for random and scanner.
import java.io.*;//Import for file reading.
import java.lang.*;
public class QuizBowl implements Quiz{
   public static void main(String[] args) throws FileNotFoundException{
      QuizBowl bowl = new QuizBowl();//creates new Quizbowl object.
      Set<Integer> Qs= new HashSet<Integer>();//creates new set to hold question numbers.
      Scanner input = new Scanner(System.in); // Initialize scanner to get user data.
      boolean flag = true;//Initiates flag for while loop.
      System.out.println("What is your first name? ");
      String first = input.next();//captures user first name.
      System.out.println("What is your last name? ");
      String last = input.next();//caputres user last name.
      Player p1 = new Player(first, last);//creates new Player object.
      
      System.out.println("What is the file that stores your questions?");
      String ufile = input.next();//Captures file name input by user.
      File uFile = new File(ufile);//Creates new file.
      Scanner file = new Scanner(uFile);//New scanner to read file student requests.
      int questions = file.nextInt();//read file to get number of questions.
      System.out.println("How many questions would you like (out of " + questions +" )?");
      
      while (flag) {//In case they do not input number or input number that is too large.
         if (input.hasNextInt()){//checks that studen inputs integer.
            int userqs = input.nextInt();//captures integer input.
            
            
            if (userqs <= 0 || userqs > questions){//checks that is between 1 and n questions.
               System.out.println("Sorry that number is out of range.");
               System.out.println("How many questions would you like (out of " + questions +" )?");
            }else {
               flag = false;//changes flag to false to end while loop.
               Qs = bowl.randomNum(userqs,questions);//gets correct number of random integers available from question numbers.
               bowl.getQuestion(Qs, ufile, p1);//creates questions from file.
            }
         }else {
            input.next();//to get rid of invalid input.
            System.out.println("Sorry that is an invalid response.\nPlease input a whole number between 1 and " + questions + ": ");
         }
         
      }
      
      
    
    
     
    
    
    System.out.println();
    System.out.println(p1);//Prints player name and final sccore.  
   }
   public QuizBowl(){//constructor for Quizbowl object.
   }
   /**
   *This object creates a list of random numbers from all available questions
   *@param m is the desired number of questions.
   *@param n is the number of available questions.
   *@return returns set of random integers.
   */
   public Set<Integer> randomNum(int m, int n){
      Set<Integer> qs = new HashSet<Integer>();
      Random r = new Random();
     
      while (qs.size()< m){ 
         qs.add(r.nextInt(n)+1);
      }
      
      return qs;
   }
   /*
   *This method takes in a file and creates questions.
   *@pram gnum is a set of numbers representing the desired question numbers.
   *@param ufile is the name of the user's file containing the questions.
   *@param p1 is the player's information, used for keeping track of score.
   *@throws FileNotFoundException if file name given is not found.
   */
   public void getQuestion(Set<Integer> qnum, String ufile,Player p1 )throws FileNotFoundException{
      
      File qFile = new File(ufile);//creates file from ufile.
      Scanner qfile = new Scanner(qFile);//creates new scanner for file.
      int qnums =qfile.nextInt();//gets number of questions contained in file.
      
      for (int j = 1; j <= qnums; j++) {//iterates over the questions.
         String qtype = qfile.next();//gets question type.
         String points = qfile.nextLine();//gets number of points.
         points = points.substring(1);//seperates number.
         if (qtype.equals("TF")){//checks if true falls question.
            String question = qfile.nextLine();//captures question.
            String ans = qfile.nextLine();//captures correct answer to question.
            String[] tQ = {points, question, ans};//creates string to pass into QuestionTF object.
            QuestionTF tempQ = new QuestionTF(tQ);//creates new QuestionTF object.
              if (qnum.contains(j)){//Checks to see if this question was chosen for quiz.
                 printQ(tempQ, p1);//Calls method that prints question.
             }
            
         }else if (qtype.equals("MC")){//Checks if is multiple choice question.
            String question = qfile.nextLine();//Captures Question.
            int anum = Integer.parseInt(qfile.nextLine());//captures number of answer choices.
            String[] choices = new String[anum];//creates an array to hold answer choices.
            for (int i = 0; i< anum; i ++){//fills array with answer choices.
               choices[i] = qfile.nextLine();
            }
            String ans = qfile.nextLine();//Captures correct answer.
            String[] tQ = {points, question, ans};//holds objects to pass into new questionMc.
            
            QuestionMC tempQ = new QuestionMC(tQ , choices);//Creates a new QuestionMC object
            if (qnum.contains(j)){//Checks if desired question number.
               printQ(tempQ, anum, p1);//Calls method to print question.
            }
         }else if (qtype.equals("SA")){//Checks for Short answer Question.
            String question = qfile.nextLine();// Captures short answer question.
            String ans = qfile.nextLine();//Captures correct answer.
            String[] tQ = {points, question, ans};//String to hold objects to pass into new question constructor.
            
            QuestionSA tempQ = new QuestionSA(tQ);//Creates a new QuestionSA object.
            if (qnum.contains(j)){//Checks if that Question is in desired question list.
              printQ(tempQ, p1);//Sends question to be printed.
               
          
         }
      }
      
      }
            
         
        System.out.println();
          
      
   }
   
      /**
      *This method prints true false questions.
      *@param q is the question you want printed.
      *@param p1 is the player object to keep track of player score
      */
      public void printQ(QuestionTF q, Player p1){
         Scanner uans = new Scanner(System.in);//Scanner object to capture user answer.
         int points = q.getPoints();//call to object that retrieves the number of points a question is worth.
         String question = q.getQuestion();//call to object to get the question that is to be printed.
         String answer = q.getAnswer();//call to object to retrieve the correct answer.
         System.out.println("Points: " + points);//prints number of points worth.
         System.out.println("Question: " + question);//prints question.
         String uanswer = uans.next();// captures user answer.
         System.out.println(varifyans(answer, uanswer, points, p1));//Prints result of vartifyans method.
         
      }
      /**
      *This method prints Multiple choice questions.
      *@param q is the question you want printed.
      *@param anum is the posible number of answers for the question.
      *@param p1 is the player object to keep track of player score.
      */
      public  void printQ(QuestionMC q, int anum, Player p1){
         String choiceLetter = "ABCDEFGHI";//String of possible answer letters.
         Scanner uans = new Scanner(System.in);//Scanner to get user ans.
         int points = q.getPoints();//call to object to retrieve point value.
         String question = q.getQuestion();//Call to object to retrieve question.
         String answer = q.getAnswer();//Call to object to retrieve correct answer.
         String [] choices = q.getChoices();//Call to object to get possible answer choices.
         System.out.println("Points: " + points);//Prints question point value.
         System.out.println("Question: " + question);//Prints Question.
         for(int i = 0; i < choices.length ; i++){
            System.out.println(choiceLetter.charAt(i) + ") " + choices[i]);//For the possible number of choices, prints out letter from string and choices for answer.
         }
         String uanswer = uans.next();//Captures user input for answer.
         System.out.println(varifyans(answer, uanswer, points, p1));//Prints result of varifyans method.
         
      }
      /**
      *This method prints Short answer questions.
      *@param q is the question you want printed.
      *@param p1 is the player object to keep track of player score.
      */
      
      public void printQ(QuestionSA q, Player p1){
         Scanner uans = new Scanner(System.in);//Scanner object to collect user input.
         int points = q.getPoints();//Call to object to obtain point value.
         String question = q.getQuestion();//call to object to obtain question.
         String answer = q.getAnswer();//Call to object to get the correct answer.
         System.out.println("Points: " + points);//Prints point value of question.
         System.out.println("Question: " + question);//Prints question.
         String uanswer = uans.next();//Captures user answer.
         System.out.println(varifyans(answer, uanswer, points, p1));//Prints result of varifyans Method.
      }
      /**
      *This method vaifies that the answers given are correct and adjust score accordingly.
      *@param ans is a String containing the correct answer.
      *@param uans is a String containing the user's answer.
      *@param points is an interger that contains the total number of points the question is worth.
      *@param p1 is the player object to keep track of player score.
      *@returns String containing the results of the question.
      */
     public  String varifyans(String ans, String uans, int points, Player p1){
      String s = "";//Initiates String to later be returned.
      String uAns = uans.toUpperCase();//Changes user answer to String containing uppercase letters.
      if (uAns.equals("SKIP")){//Checks to see if user wants to skip.
         s = "You have chosen to Skip the question";//Equate String to apropriate phrase.
      }else if (uAns.equals(ans.toUpperCase())){//Checks if correct answer and user answer are the same.
         s = "Correct! You get " + points + " points.";//Equates String to apropriate phrase.
         p1.addScore(points);//Adds appropriate number of points to player score.
      }else{
         s = "Incorrect, The answer was " + ans + ". You loose " + points + " points. ";//Equetes String to apropriate phrase.
         p1.addScore(0-points);//Subtracts appropriate number of points from player score.
      }
      return s;//Returns String.
   }
         
}