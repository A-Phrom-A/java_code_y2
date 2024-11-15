class House implements Cloneable, Comparable<House> {
    private int id;
    private double area;
    private java.util.Date whenBuilt;
    public House(int id, double area) {
    this.id = id;
    this.area = area;
    whenBuilt = new java.util.Date();
    }
    public int getId() {
    return id;
    }
    public double getArea() {
    return area;
    }
    public java.util.Date getWhenBuilt() {
    return whenBuilt;
    }
       @Override
       public Object clone() {
           try {
               return super.clone();
           } catch (CloneNotSupportedException ex) {
               return null; // Or handle exception in a better way if needed
           }
       }
   
    
    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(House o) {
           if (area > o.area)
           return 1;
           else if (area < o.area)
           return -1;
           else
           return 0;
           }
       @Override
       public String toString() {
           return String.format("House[id=%d, area=%.2f, whenBuilt=%s]", id, area, whenBuilt.toString());
       }
    }
   public class W8_2{
       public static void main(String[] args){
           House house1 = new House(1, 1750.50);
           House house2 = (House)house1.clone();
            System.out.println(house1);
           System.out.println(house2);
            System.out.println(house1.compareTo(house2));
       }
   }
