import java.util.Scanner;

public class Person {

    public enum MaritalStatus{
        SINGLE, MARRIED, DIVORCED;
    }
    String id;
    String firstName;
    String lastName;
    MaritalStatus status;

    public Person() {  }
//----------------------------------------------------
    public String getId()                   { return id;  }
    public String getFirstName()            { return firstName; }
    public String getLastName()             {   return lastName;  }
    public MaritalStatus getStatus() {  return status; }
//----------------------------------------------------
    public void setId(String id)                              { this.id = id; }
    public void setFirstName(String firstName)                { this.firstName = firstName; }
    public void setLastName(String lastName)                  { this.lastName = lastName; }
    public void setStatus(MaritalStatus status) { this.status = status; }

    public boolean input(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter id");
            setId(in.next());
            System.out.println("Enter first name");
            setFirstName(in.next());
            System.out.println("Enter last name");
            setLastName(in.next());
            System.out.println("Enter marital status, 1-Single, 2-Married, 3-Divorces");
            switch (in.next()) {
                case "1":
                    setStatus(MaritalStatus.SINGLE);
                    break;
                case "2":
                    setStatus(MaritalStatus.MARRIED);
                    break;
                case "3":
                    setStatus(MaritalStatus.DIVORCED);
                    break;
                default:
                    System.out.println("illegal Data");
                    return false;
            }
            return true;
        }catch (Exception e){
            System.out.println("illegal Data");
            return false;
        }
    }

    @Override
    public String toString() {
        return " id = " + id + ", firstName = " + firstName +
                ", lastName = " + lastName + ", maritalStatus = " + status ;
    }
}
