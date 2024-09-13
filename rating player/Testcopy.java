import java.util.Scanner;

public class Testcopy{
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int ELEMENT_NUM = 5;
      //int [] jerseyNum =  new int[ELEMENT_NUM];
      //int [] rating = new int[ELEMENT_NUM];
      int[][] playerInfo = new int[ELEMENT_NUM][2];
      int i;
      String menuOption = "";
      
      for(i = 0; i < playerInfo.length; ++i)
      {
         System.out.println("Enter player " + (i+1) +"\'s jersey number:");  
         playerInfo[i][0] = scnr.nextInt();
         System.out.println("Enter player " + (i+1) +"\'s rating:");
         playerInfo[i][1]= scnr.nextInt();
         System.out.println();
      }
      
      rosterDisplay(playerInfo,0);
       
      
      while(!(menuOption.equalsIgnoreCase("q")))
      {
        // the menu option
         menuDisplay();
         menuOption = scnr.nextLine();
         scnr.nextLine();
         // if statements
         if(menuOption.equalsIgnoreCase("u"))
         {
            int jerseyLook = scnr.nextInt();
            int newRating = scnr.nextInt();
            for(i=0; i<playerInfo.length; ++i)
            {
               if(playerInfo[i][0] == jerseyLook)
               {
                  playerInfo[i][1] = newRating;
               }
            }  
         }
         else if (!(menuOption.equalsIgnoreCase("a")))
         {
            int playerRate = scnr.nextInt();
            rosterDisplay(playerInfo,playerRate);
         }
         else if(!(menuOption.equalsIgnoreCase("r")))
         {
            int jNum = scnr.nextInt();
            for(i=0; i<playerInfo.length; ++i)
            {
               playerInfo[i][0] = scnr.nextInt();
               playerInfo[i][1] = scnr.nextInt();
            }
         }
         else if(!(menuOption.equalsIgnoreCase("o")))
         {
            rosterDisplay(playerInfo,0);
         }
      }
      
      
     
   }
   
   public static void rosterDisplay(int[][]player, int ara)
   {
      int x = 1;
      int a = 0;
      if( a > 0)
      {
         System.out.println("ABOVE "+ a);
      }else{
         System.out.println("ROSTER");  
      }
      for(int [] players: player)
      {
         if(players[1] > a)
         {
            System.out.println("Player " +(x)+" -- Jersey number: "+  players[0]+", Rating: "+ players[1]);
         }
         x++;
      } 
     //System.out.println();
      
   }
  
   
   public static void menuDisplay()
   {
      //Menu
      System.out.println("");
      System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit");
      System.out.println("");
      System.out.println("Choose an option:");
   }
   
   
   
}
