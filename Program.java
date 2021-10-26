import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Program {

    static List<Person> personList =new LinkedList<>();
    public static void main(String[] args) {

        while (true){
            System.out.println("1-Add Teacher, 2-Add Student, 3-Show All People, 4-Show All Teacher, " +
                            "5-Show All Student, 6-Show Teacher by ID, 7-Show Student by ID, 8-Show Students by Score Range, 0-Quit");
            Scanner in = new Scanner(System.in);
            switch (in.next()) {
                case "1":   addTeacher();       break;
                case "2":   addStudent();       break;
                case "3":   showAllPeople();    break;
                case "4":   showAllTeacher();   break;
                case "5":   showAllStudent();   break;
                case "6":   showTeacherByID();  break;
                case "7":   showStudentByID();  break;
                case "8":   showStudentsByScoreRange(); break;
                case "0":
                    System.out.println("Good Buy!");
                    return;
                default:
                    System.out.println("illegal Data");
                    break;
            }
        }
    }
    static void addTeacher(){
        Teacher t = new Teacher();
        if(!t.input()) {
            System.out.println("Error !!! By some reasons Teacher didn't added to list");
            return;
        }
        personList.add(t);
        System.out.println("One Teacher was added to list");
    }
    static void addStudent(){
        Student s = new Student();
        if(!s.input()) {
            System.out.println("Error !!! By some reasons Student didn't added to list");
            return;
        }
        personList.add(s);
        System.out.println("One Student was added to list");
    }
    static void showAllPeople(){
        int index=1;
        for(Person p:personList){
            System.out.println( index + ")-"+p);
            index++;
        }
        if(index == 1)
            System.out.println("There are No Persons in list! The list is empty");
    }
    static void showAllTeacher(){
        boolean flag=true;
        int index=1;
        for(Person p:personList){
            if(p instanceof Teacher){
                System.out.println( index + ")-"+p);
                index++;
            }
        }
        if(index == 1)
            System.out.println("There are No Teachers in list!");
    }
    static void showAllStudent(){
        int index=1;
        for(Person p:personList){
            if(p instanceof Student){
                System.out.println( index + ")-"+p);
                index++;
            }
        }
        if(index == 1)
            System.out.println("There are No Students in list!");
    }

    //getting id from user and return person with this id
    //if no right person so return "empty" person
    static Person returnRightPerson(){
        System.out.println("Please enter an ID");
        Scanner in = new Scanner(System.in);
        String askedID = in.next();
        for(Person p:personList){
            if(p.getId().equals(askedID))
                return p;
        }
        return new Person();
    }

    //get person from returnRightPerson() and checking if it is a teacher
    static void showTeacherByID(){
        Person p = returnRightPerson();
        if(p instanceof Teacher){
            System.out.println(p);
            return;
        }
        else if(p instanceof Student){
            System.out.println("Not a Teacher");
            return;
        }
        else
            System.out.println("Doesn't exists");
    }

    //get person from returnRightPerson() and checking if it is a student
    static void showStudentByID(){
        Person p = returnRightPerson();
        if(p instanceof Student){
            System.out.println(p);
            Student st = (Student) p;
            subMenu(st);
        }
        else if(p instanceof Teacher){
            System.out.println("Not a Student");
            return;
        }
        else
            System.out.println("Doesn't exists");
    }

    static void showStudentsByScoreRange(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter MIN Score (INTEGER)");
        int min = Integer.parseInt(in.next());
        System.out.println("Enter MAX Score (INTEGER)");
        int max = Integer.parseInt(in.next());
        boolean noElements = true;
        for(Person p:personList){
            if(p instanceof Student){
                if(((Student) p).getAverageScore()>=min && ((Student) p).getAverageScore()<=max){
                    System.out.println(p);
                    noElements = false;
                }
            }
        }
        if(noElements)
            System.out.println("There are No Students with this parameters");
    }

    static void subMenu(Student s){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1- Show All Scores, 2- Insert a New Score, 3- Show Average Score, 4- Return to the Main Menu");
            switch (in.next()) {
                case "1":   showAllScores(s);       break;
                case "2":   insertNewScore(s);      break;
                case "3":   showAverageScore(s);    break;
                case "4":
                    System.out.println("Back to main menu");
                    return;
                default:
                    System.out.println("illegal Data");
                    break;
            }
        }
    }
    static void showAllScores(Student s){
        System.out.println(s.scores);
    }
    static void insertNewScore(Student s){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter course name");
        String courseName = in.next();
        System.out.println("Enter Score (INTEGER)");
        String value = in.next();
        s.setScores(courseName,value);
    }
    static void showAverageScore(Student s){
        System.out.println(s.getAverageScore());
    }
}
