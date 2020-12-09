import java.util.Scanner;
public class Lab1
{
   public static void main(String[] args)
   { //main method
      String zip = getZip(); //Prompt user for zip-code
      int intZip = Integer.parseInt(zip); //Parse the zip-code from String to Integer
      int checkDigit = calcCheckDigit(intZip); 
      printBarCode(zip);
      printDigit(checkDigit); //Call printDigit for just the Check Digit due to issues with scope 
      System.out.print("|"); //Print final tall line
   }
   
   public static String getZip()
   {  //requesting zip code input from user
      Scanner in = new Scanner (System.in);
      System.out.println("Input your Zip Code: ");
      String input = in.nextLine();
      return input;
   }
   
   public static void printDigit(int d)
   {
      switch(d) //deciding on what to print
      {
         case 1: 
            System.out.print("...||");
            break;

         case 2: 
            System.out.print("..|.|");
            break;
         
         case 3: 
            System.out.print("..||.");
            break;
            
         case 4: 
            System.out.print(".|..|");
            break;
         
         case 5: 
            System.out.print(".|.|.");
            break;
         
         case 6: 
            System.out.print(".||..");
            break;
         
         case 7: 
            System.out.print("|...|");
            break;
         
         case 8: 
            System.out.print("|..|.");
            break;
         
         case 9: 
            System.out.print("|.|..");
            break;
         
         case 0: 
            System.out.print("||...");
            break;
            
         default:
            break;
      }
        
   }
   
   public static int calcCheckDigit(int sum)
   {  //the checkDigit is the sum of all individual digits of a zip code, rounded up
      int individualSum = 0;
      for(int i = 0; i < 5; i++)
      {
         individualSum += sum % 10;
         sum /= 10;
      }
      int roundedIS = 0; //"IS stands for "individualSum"
      int checkDigit;
      if(individualSum % 10 != 0 ) //check to see of the digits add to a multiple of 10
      {
         roundedIS = individualSum + (10 - (individualSum % 10));
         checkDigit = roundedIS - individualSum;
      }
      else
         checkDigit = 0;
      return checkDigit;
   }

   public static void printBarCode(String zip)
   {  // Using the input from the user, the zip code is reversed for output purposes
      int delivery = Integer.parseInt(zip);
      int temp = 0;
      while(delivery != 0)  //Where the reversing happens
      {
         int digit = delivery % 10;
         temp = temp * 10 + digit;
        delivery /= 10;
      }
      
      System.out.print("|"); //print initial tall line
      for(int i = 0; i < 5; i++)
      {
         printDigit(temp % 10);
         temp /= 10;
      }
   }
}