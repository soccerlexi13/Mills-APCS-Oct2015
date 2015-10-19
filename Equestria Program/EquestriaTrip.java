/**
 * Equestria Programming Assignment: distances and angles
 * 
 * @author Alexis Scheerer
 * @version 10/13/15
 */
public class EquestriaTrip
{
   public static final double MANEHATX= 34;
   public static final double MANEHATY= 9;
   public static final double BALTIMAREX= 30;
   public static final double BALTIMAREY= 13;
   public static final double PONYVILLEX= 17;
   public static final double PONYVILLEY= 14;
   public static final double LOSPEGX= 6;
   public static final double LOSPEGY= 20;
   public static final double NEIGHFALLSX= 22;
   public static final double NEIGHFALLSY= 7;
   public static final double BADLANDSX= 26;
   public static final double BADLANDSY= 22;
   public static void main(String[] args){
       System.out.println("The distance between Baltimare and Manehatten is: " + 
            roundToTwoPlaces(distance(BALTIMAREX, BALTIMAREY, MANEHATX, MANEHATY)));
            
       System.out.println("The distance between Los Pegasus and Neighagra Falls is: " + 
            roundToTwoPlaces(distance(LOSPEGX, LOSPEGY, NEIGHFALLSX, NEIGHFALLSY)));
            
       System.out.println("The distance between Badlands and Ponyville is: " + 
            roundToTwoPlaces(distance(NEIGHFALLSX, NEIGHFALLSY, PONYVILLEX, PONYVILLEY)));
       //Prints the distances listed in exercise 1
       
       System.out.println("Distance of circular trip: " + roadTrip(BALTIMAREX, BALTIMAREY, MANEHATX, MANEHATY));
       //prints out length of roadtrip as described in exercise 2
       
       bigTour(LOSPEGX, LOSPEGY, NEIGHFALLSX, NEIGHFALLSY, BADLANDSX, BADLANDSY);
       //prints out the angles and total distance in a trip with three points, exercise 3
       
       System.out.println("The greatest distance from these points is: " + 
            longestTrip(LOSPEGX, LOSPEGY, NEIGHFALLSX, NEIGHFALLSY, BADLANDSX, BADLANDSY));
       //prints greatest distance in trip, exercise 4
       
       System.out.println("For extra credit, the greatest distance between four points on the map is: " +
            extraCreditExercise4(MANEHATX, MANEHATY, BALTIMAREX, BALTIMAREY, PONYVILLEX, PONYVILLEY, 
                    LOSPEGX, LOSPEGY) + " units");
       //extra credit for exercise 4
                    
       //feel free to change the points used in the extra credit function, or any method
   }
   public static double distance(double x1, double y1, double x2, double y2){
       //finds/returns distance between two points on the map
       return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
   }
   public static double roadTrip(double x1, double y1, double x2, double y2){
       //finds circumference of circle when given points on a diameter of the circle
       double diameter=(distance(x1, y1, x2, y2));
       return roundToTwoPlaces(Math.PI*diameter);
   }
   public static void bigTour(double x1, double y1, double x2, double y2, double x3, double y3){
       //prints angles at each city and total distance
       double dist1, dist2, dist3;
       dist1=distance(x1, y1, x2, y2);
       dist2=distance(x2, y2, x3, y3);
       dist3=distance(x1, y1, x3, y3);
       double ang1, ang2, ang3;
       ang1=findAngle(dist2, dist3, dist1);
       ang2=findAngle(dist3, dist1, dist2);
       ang3=findAngle(dist1, dist2, dist3);
       System.out.println("Angle of point 1: " + ang1 + " Angle of point 2: " + ang2 + 
            " Angle of point 3: " + ang3);
       System.out.println("Total trip distance: "+ roundToTwoPlaces(dist1+dist2+dist3) + " units");
   }
   public static double findAngle(double a, double b, double c){
       //method to find angles used in bigTour
       return roundToTwoPlaces(Math.acos((b*b+c*c-a*a)/(2*b*c))*(180/Math.PI));
   }
   public static double longestTrip(double x1, double y1, double x2, double y2, double x3, 
            double y3){
       //finds longest distance in a trip of three points
       double dist1, dist2, dist3;
       dist1=distance(x1, y1, x2, y2);
       dist2=distance(x2, y2, x3, y3);
       dist3=distance(x1, y1, x3, y3);
       return roundToTwoPlaces(Math.max(Math.max(dist1, dist2), dist3));
   }
      public static double extraCreditExercise4(double x1, double y1, double x2, double y2, 
            double x3, double y3, double x4, double y4){
       //extra credit, compares four points instead of three
       double dist1, dist2, dist3, dist4, dist5, dist6;
       dist1=distance(x1, y1, x2, y2);
       dist2=distance(x2, y2, x3, y3);
       dist3=distance(x1, y1, x3, y3);
       dist4=distance(x1, y1, x4, y4);
       dist5=distance(x4, y4, x2, y2);
       dist6=distance(x4, y4, x3, y3);
       double max1=Math.max(Math.max(dist1, dist2), dist3);
       double max2=Math.max(Math.max(dist4, dist5), dist6);
       return roundToTwoPlaces(Math.max(max1, max2));
   }
   public static double roundToTwoPlaces(double origNum){
       //used to round to two decimal places
       return Math.round(origNum*100)/100.0;
   }
}
