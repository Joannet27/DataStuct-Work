import java.util.Scanner;

public class StudentInfo {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int NUM_ELEMS = 6;
      int startingNum = 26;
      int i;
   
      //startingNum = scnr.nextInt();
      
      int[] studentNumbers = new int [NUM_ELEMS];
      studentNumbers[0] = startingNum;
      studentNumbers[1] = startingNum - 1;
      studentNumbers[2] = startingNum - 2;
      studentNumbers[3] = startingNum - 3;
      studentNumbers[4] = startingNum - 4;
      studentNumbers[5] = startingNum - 5;
      
      System.out.print("Student numbers: ");
      for (i = 0; i < studentNumbers.length; ++i) {
         System.out.print(studentNumbers[i] + " ");
      }
      System.out.println();
   }
}