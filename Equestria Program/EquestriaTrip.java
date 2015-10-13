/**
 * Equestria Programming Assignment: distances and angles
 * 
 * @author Alexis Scheerer
 * @version 10/13/15
 */
//import java.lang.Math;
public class EquestriaTrip
{
   public static void main(String[] args){
       System.out.println(distance(30, 13, 34, 9));
       System.out.println(distance(6, 20, 22, 7));
       System.out.println(distance(26, 22, 17, 14));
       System.out.println(roadTrip(4));
       bigTour(6, 20, 22, 7, 26, 22);
       System.out.println(longestTrip(6, 20, 22, 7, 26, 22));
   }
   public static double distance(double x1, double y1, double x2, double y2){
       return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
   }
   public static double roadTrip(double diameter){
       return Math.PI*diameter;
   }
   public static void bigTour(double x1, double y1, double x2, double y2, double x3, double y3){
       double dist1, dist2, dist3;
       dist1=distance(x1, y1, x2, y2);
       dist2=distance(x2, y2, x3, y3);
       dist3=distance(x1, y1, x3, y3);
       double ang1, ang2, ang3;
       ang1=findAngle(dist2, dist3, dist1);
       ang2=findAngle(dist3, dist1, dist2);
       ang3=findAngle(dist1, dist2, dist3);
       System.out.println(ang1+" "+ang2+" "+ang3);
       System.out.println("Total trip distance: "+ (dist1+dist2+dist3));
   }
   public static double findAngle(double a, double b, double c){
       return Math.acos((b*b+c*c-a*a)/(2*b*c))*(180/Math.PI);
   }
   public static double longestTrip(double x1, double y1, double x2, double y2, double x3, double y3){
       double dist1, dist2, dist3;
       dist1=distance(x1, y1, x2, y2);
       dist2=distance(x2, y2, x3, y3);
       dist3=distance(x1, y1, x3, y3);
       return Math.max(Math.max(dist1, dist2), dist3);
   }
}
