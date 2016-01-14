/**
 * Takes string of numbers, finds max, min, biggest even, and sum of evens
 * 
 * @author Alexis Scheerer 
 * @version 11/4/2015
 */
import java.util.*;
public class ProcessingNumbers
{
    public static Scanner console=new Scanner(System.in);
    public static int numberOfNums;
    public static double next, max, min, sumOfEven, maxEven;
    public static void main(String[] args){
        //calls functions to get first variable values, go through inputed numbers and find
        //what values are wanted, then prints those values out
        setInitialVarVals();
        goThroughSetOfNums();
        printValues();
    }
    public static void setInitialVarVals(){
        //finds first set of values so that the variables can be used in if statements in loop
        System.out.print("How many numbers will you input? ");
        numberOfNums=console.nextInt();
        System.out.print("What are your numbers? ");
        next=console.nextDouble();
        max=next;
        min=next;
        sumOfEven=0;
        if(next%2==0){
            //if first num even, sets sum of even and max even to it, since that is only even
            sumOfEven=next;
            maxEven=next;
        }
        else{
            //if not even, sum of even is zero, max even 1: comparing evens, so if it is still 1
            //by the end, then no evens were entered
            sumOfEven=0;
            maxEven=1;
        }
    }
    public static void goThroughSetOfNums(){
        //goes through line of numbers and sets values of variables according to the numbers
        for (int i=1; i<=numberOfNums-1; i++){
            next=console.nextDouble();
            if(next>max){
                //checks if bigger then max, sets max to it if it is
                max=next;
            }
            else if(next<min){
                //else if because it is inefficient to check if it's smaller if you know it's big
                min=next;
            }
            if(next%2==0){
                if(sumOfEven==0 || next>maxEven){
                    //if there haven't been any even numbers yet, maxeven is set to next
                    //or if bigger than maxeven, also sets it to next
                    maxEven=next;
                }
                //adds next to even
                sumOfEven+=next;
            }
        }
    }
    public static void printValues(){
        //prints out the final values of the variables
        if(max==min){
            //if all numbers inputed were the same, then this will be printed
            System.out.println("The biggest and smallest numbers are the same, "+max);
        }
        else{
            //normal string printed
            System.out.println("The biggest number is "+max+" and the smallest number is "+min);
        }
        System.out.println("The sum of all even numbers is "+sumOfEven);
        if(maxEven==1){
            //if no evens were entered then maxeven will have value from initializing still, 1
            System.out.println("No even numbers were entered, so there is no largest even number.");
        }
        else{
            //normal string printed
            System.out.println("The greatest even number is "+maxEven);
        }
    }
}
