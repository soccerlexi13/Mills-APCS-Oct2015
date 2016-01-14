/**
 * The homecoming project: gets you a date then tells you how much it will cost
 * 
 * @author Alexis Scheerer 
 * @version 10/25/15
 * 
 *
 */
import java.util.*;
public class HomecomingProject
{
   public static final String MY_NAME="Alexis Scheerer";
   //dateName and console can be used anywhere in class
   static String dateName;
   static Scanner console= new Scanner(System.in);
   public static void main(String[] args){
       getADate();
       damage();
   }
   public static void getADate(){
       //part 1, introduces self and gets date's name
       System.out.println("Hi! My name is " + MY_NAME + ".");
       System.out.println("What's your name?");
       dateName=console.nextLine();
       System.out.println("Nice to meet you "+dateName+"!");
       System.out.println();
       System.out.println("Would you like to go to Homecoming with me?");
       System.out.println();
       System.out.println("Great! It'll be a magical night -- " + MY_NAME + " and " + dateName + 
            "\ngoing to the Mills Homecoming Dance 2015!");
       System.out.println();
   }
   public static void damage(){
       //part 2, gets prices of all parts of homecoming, calculates total/half
       System.out.println("Let's figure out the damage the evening.");
       System.out.println();
       System.out.println("What are our estimated costs?");
       double ticketPrice=getPrice("Tickets (each): ");
       double flowersPrice=getPrice("Flowers (total for both of us): ");
       double picturesPrice=getPrice("Pictures: ");
       double oneMealPrice=getPrice("Dinner (per meal): ");
       double clothesPrice=getPrice("New clothes: ");
       double otherExpenses=getPrice("Any others expenses: ");
       double taxedItems = (2*oneMealPrice)+clothesPrice+otherExpenses;
       double tax=roundToTwoPlaces(taxedItems*.0825);
       taxedItems += tax;
       taxedItems = roundToTwoPlaces(taxedItems);
       double totalCost=(2*ticketPrice)+taxedItems+flowersPrice+picturesPrice;
       double halfCost=roundToTwoPlaces(totalCost/2);
       System.out.println();
       System.out.println("So, we should expect to spend, including tax: " + totalCost);
       System.out.println("If we split the costs, each of us will pay: " + halfCost);
       System.out.println();
       statsTable(ticketPrice*2, flowersPrice, picturesPrice, oneMealPrice*2, clothesPrice, 
            otherExpenses, tax);
   }
   public static void statsTable(double ticketsPrice, double flowersPrice, double picturesPrice, 
        double mealsPrice, double clothesPrice, double otherExpenses, double tax){
            //prints out stats table with all prices and totals
            double subtotal=ticketsPrice + flowersPrice + picturesPrice + mealsPrice +
                    clothesPrice + otherExpenses;
            double total=subtotal+tax;
            System.out.println("MHS Homecoming 2015");
            System.out.println(MY_NAME+" and "+dateName);
            System.out.println();
            printTableLine("Tickets (Total):", ticketsPrice);
            printTableLine("Flowers (for both of you):", flowersPrice);
            printTableLine("Pictures:", picturesPrice);
            printTableLine("Dinner (for two):", mealsPrice);
            printTableLine("New clothes:", clothesPrice);
            printTableLine("Any other expenses:", otherExpenses);
            System.out.println();
            printTotalLine("Subtotal:", subtotal);
            printTotalLine("Sales tax:", tax);
            printTotalLine("Total:", total);
   }
   public static double roundToTwoPlaces(double origNum){
       //used to round to two decimal places
       return Math.round(origNum*100)/100.0;
   }
   public static void printSpaces(int numSpaces){
       //prints number of spaces passed through
       for (int i=1; i<=numSpaces; i++){
           System.out.print(" ");
       }
   }
   public static void printTableLine(String nextString, double nextPrice){
       //prints line of stats table with aligned prices
       System.out.print(nextString);
       printSpaces(40-nextString.length());
       System.out.println(nextPrice);
   }
   public static void printTotalLine(String nextString, double nextTotal){
       //prints line of subtotal, tax or total, aligns names and values
       printSpaces(35-nextString.length());
       System.out.print(nextString);
       printSpaces(5);
       System.out.println(nextTotal);
   }
   public static double getPrice(String prompt){
       //prompts the user and returns the value of prices for items
       System.out.print(prompt);
       return console.nextDouble();
   }
}
