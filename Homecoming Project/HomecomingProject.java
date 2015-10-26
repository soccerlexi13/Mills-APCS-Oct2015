/**
 * The homecoming project: gets you a date then tells you how much it will cost
 * 
 * @author Alexis Scheerer 
 * @version 10/25/15
 */
import java.util.*;
//import java.text.DecimalFormat.*;
public class HomecomingProject
{
   public static final String MY_NAME="Alexis Scheerer";
   static String dateName;
   public static void main(String[] args){
       getADate();
       damage();
   }
   public static void getADate(){
       Scanner console= new Scanner(System.in);
       System.out.println("Hi! My name is " + MY_NAME + ".");
       System.out.println("What's your name?");
       dateName=console.nextLine();
       System.out.println("Nice to meet you "+dateName);
       System.out.println();
       System.out.println("Would you like to go to Homecoming with me?");
       System.out.println();
       System.out.println("Great! It'll be a magical night -- " + MY_NAME + " and " + dateName + 
            "\ngoing to the Mills Homecoming Dance 2015!");
   }
   public static void damage(){
       Scanner console=new Scanner(System.in);
       System.out.println("Let's figure out the damage the evening.");
       System.out.println();
       System.out.println("What are your estimated costs?");
       System.out.print("Tickets (each): ");
       double ticketPrice=console.nextDouble();
       System.out.print("Flowers (total for both of you): ");
       double flowersPrice=console.nextDouble();
       System.out.print("Pictures: ");
       double picturesPrice=console.nextDouble();
       System.out.print("Dinner (per meal): ");
       double oneMealPrice=console.nextDouble();
       System.out.print("New clothes: ");
       double clothesPrice=console.nextDouble();
       System.out.print("Any others expenses: ");
       double otherExpenses=console.nextDouble();
       double taxedItems = (2*oneMealPrice)+clothesPrice+otherExpenses;
       double tax=roundToTwoPlaces(taxedItems*.0825);
       taxedItems += tax;
       taxedItems = roundToTwoPlaces(taxedItems);
       double totalCost=(2*ticketPrice)+taxedItems+flowersPrice+picturesPrice;
       double halfCost=roundToTwoPlaces(totalCost/2);
       System.out.println();
       System.out.println("So, you should expect to spend, including tax, " + totalCost);
       System.out.println("If you split the costs with your date, each will pay: " + halfCost);
       System.out.println();
       statsTable(ticketPrice*2, flowersPrice, picturesPrice, oneMealPrice*2, clothesPrice, 
            otherExpenses, tax);
   }
   public static void statsTable(double ticketsPrice, double flowersPrice, double picturesPrice, 
        double mealsPrice, double clothesPrice, double otherExpenses, double tax){
            double subtotal=ticketsPrice + flowersPrice + picturesPrice + mealsPrice +
                    clothesPrice + otherExpenses;
            double total=subtotal+tax;
            System.out.println("MHS Homecoming 2015");
            System.out.println(MY_NAME+" and "+dateName);
            System.out.println();
            System.out.println("Tickets (Total): "+ticketsPrice);
            System.out.println("Flowers (for both of you): "+flowersPrice);
            System.out.println("Pictures: "+picturesPrice);
            System.out.println("Dinner (for two): "+mealsPrice);
            System.out.println("New clothes: "+clothesPrice);
            System.out.println("Any other expenses: "+otherExpenses);
            System.out.println();
            System.out.println("\t\t\tSubtotal "+subtotal);
            System.out.println("\t\t\tSales tax "+tax);
            System.out.println("\t\t\tTotal "+total);
   }
   public static double roundToTwoPlaces(double origNum){
       //used to round to two decimal places
       return Math.round(origNum*100)/100.0;
   }
}
