package GS;

import java.util.HashMap;
import java.util.Map;

public class BestAverageGrade {

    static Map<String,Integer> frequency = new HashMap<>();
    static Map<String,Integer> sum = new HashMap<>();


    static int bestAverageGrades(String[][] score){
        if(score == null || score.length == 0) return 0;
        int res = 0;


        for(String[] each: score){
            String name = each[0];
            int grade = Integer.parseInt(each[1]);
            int fre = (frequency.get(name) == null)? 1: frequency.get(name) + 1;
            int gra = (sum.get(name) == null)? grade:sum.get(name) + grade;
            frequency.put(name, fre);
            sum.put(name,gra);
        }

        for(String name: frequency.keySet()){
            int grade = (sum.get(name) < 0)? (int) Math.floor((double) sum.get(name) / frequency.get(name)) : sum.get(name)/ frequency.get(name);
            if(grade > res){
                res = grade;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((int) Math.floor((double) -123 / 10));


        String[][] arr = {{"bob", "88"}, {"ted", "100"}, {"ted", "20"}};
        System.out.println(bestAverageGrades(arr));
    }
}
