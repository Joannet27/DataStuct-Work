import java.util.Scanner;

public class DescendingOrder {
   // TODO: Write a void method selectionSortDescendTrace() that takes 
   //       an integer array and the number of elements in the array as arguments, 
   //       and sorts the array into descending order.
   public static void selectionSortDescendTrace(int [] numbers, int numElements) 
   {
      for (int i = 0; i < numElements - 1; i++)
      {
         int maxElementIndex = i;
         if (numbers[i] > 0)
         {
            
            for(int j = i +1; j < numbers.length; i++)
            {
               maxElementIndex = j;  
            }
         }
         int temp = numbers[i];
         numbers[i] = numbers[maxElementIndex];
         numbers[maxElementIndex] = temp;
            
         for (int element: numbers)
         {
            if (element >0)
            {
               System.out.print(element + "");  
            }
            System.out.println();
         }
         
      }
   }
   
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int input, i = 0;
      int numElements = 0;
      int [] numbers = new int[10];
   
      // TODO: Read in a list of up to 10 positive integers; stop when
      //       -1 is read. Then call selectionSortDescendTrace() method.
      do{
         input = scnr.nextInt();
         if(input != -1)
         {
            numbers[i] = input;
            i++;
            numElements++;
         }
      }while(input != -1);
      
      selectionSortDescendTrace(numbers, numElements);
   
   }
}

