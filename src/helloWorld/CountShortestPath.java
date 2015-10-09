package helloWorld;
import java.util.*;
public class CountShortestPath{

     public static void main(String []args){
         Point start= new Point(0, 0);
         Point dest= new Point(1, 3);
         Point bottomRight= new Point(3,3); //matrix dimensions
         Set<Point> blocked= new HashSet<>(); //blocked locations
         blocked.add(new Point(1,1));
         blocked.add(new Point(0,2));
         blocked.add(new Point(0,3));
 
         System.out.println(countMinPathLength(start, dest, bottomRight, blocked));
     }
     
     public static int countMinPathLength(Point start, Point dest, Point bottomRight, Set<Point> blocked){
         List<Integer> countList= new ArrayList<>();
         countMinPathLength(start, dest, bottomRight, blocked, countList, 0);
         Collections.sort(countList);
         if(countList.size()==0){
             return -1;
         }
         return countList.get(0);
       
     }
     
     private static void countMinPathLength(Point point, Point dest, Point bottomRight, Set<Point> blocked,
            List<Integer> countList, int count){
         
         if(point.equals(dest)){
             countList.add(count);
             return;
         }
         
         if(count> (bottomRight.x+1)*(bottomRight.y+1)){
             return; //no soln
         }
         
         Point pLeft= point.left();
         if(allowed(pLeft, bottomRight, blocked)){
             countMinPathLength(pLeft, dest, bottomRight, blocked, countList, count+1);
         } 
         
         Point pRight= point.right();
         if(allowed(pRight, bottomRight, blocked)){
             countMinPathLength(pRight, dest, bottomRight, blocked, countList, count+1);
         }
         
         Point pUp= point.up();
         if(allowed(pUp, bottomRight, blocked)){
             countMinPathLength(pUp, dest, bottomRight, blocked, countList, count+1);
         }
         
         Point pDown= point.down();
         if(allowed(pDown, bottomRight, blocked)){
             countMinPathLength(pDown, dest, bottomRight, blocked, countList, count+1);
         }
     }
     
     private static boolean allowed(Point p, Point endP, Set<Point> set){
         return (!set.contains(p)) && (p.x>=0 && p.x<=endP.x && p.y>=0 && p.y <= endP.y);
     }
     
     static final class Point {
         int x;
         int y;
         public Point(int x, int y){
             this.x= x;
             this.y= y;
         }
         
         public Point left(){
             return new Point(x-1, y);
         }
         
         public Point right(){
             return new Point(x+1, y);
         }
         
         public Point down(){
             return new Point(x, y+1);
         }
         
         public Point up(){
             return new Point(x, y-1);
         }
         
         public String toString(){
             return "x= "+x+"\ty= "+y;
         }
         

         public boolean equals(Object o){
             if(o==null || (!(o instanceof Point))){
                 return false;
             }
             Point p= (Point) o;
             return (p.x==x) && (p.y==y);
         }
         
         public int hashCode() {
            return Integer.valueOf(x).hashCode()+Integer.valueOf(y).hashCode();
         }
     }
}
