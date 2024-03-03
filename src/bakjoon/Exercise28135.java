package bakjoon;

import java.util.*;

public class Exercise28135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> number = new ArrayList<>();
        int num = sc.nextInt();
        int count = 0;
        while (count <= num) {
            String temp = Integer.toString(count);
            if (temp.contains("50")) {
                number.add(Integer.parseInt(temp));
            }
            number.add(Integer.parseInt(temp));
            count++;
        }
        System.out.println(number.indexOf(num));
    }
}
