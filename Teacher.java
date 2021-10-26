import java.util.Scanner;

public class Teacher extends Person{

    private int wage;

    public Teacher() {  super();    }
    public int getWage() { return wage; }
    public void setWage(int wage) { this.wage = wage; }

    /* input is boolean because i want be sure that "super" finished his part successful
    *  and this added all data. Then this object adding to list
    */
    @Override
    public boolean input() {
        if(!super.input())
            return false;
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter wage");
            int i=Integer.parseInt(in.next());
            setWage(i);
            return true;
        }catch (Exception e){
            System.out.println("illegal Data");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", wage = " + getWage();
    }
}
