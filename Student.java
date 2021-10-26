import java.util.LinkedList;
import java.util.List;

public class Student extends Person {

    List<Score> scores=new LinkedList<>();

    public double getAverageScore(){
        int index=0;
        double result=0;
        for (Score element:scores) {
            result+=element.getValue();
            index++;
        }
        if(index<=0)
            return result;    // return 0. it's mean that no elements in list
        return result/index;
    }

    // getting 2 Strings , parsing to needed parameters  and creating new score with this parameters
    public void setScores(String courseName, String value){
        Score sc =new Score(courseName, Integer.parseInt(value));
        scores.add(sc);
    }

    @Override
    public String toString() {
        return super.toString()+", average score = "+getAverageScore();
    }
}
