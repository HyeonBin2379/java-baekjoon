package bakjoon.bakjoon06XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise6780 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> sumac = new ArrayList<>();
        int t1 = Integer.parseInt(sc.nextLine());
        sumac.add(t1);

        int t2 = Integer.parseInt(sc.nextLine());
        sumac.add(t2);

        while (true) {
            int temp = t1-t2;
            if (temp > sumac.get(sumac.size()-1)) {
                sumac.add(temp);
                break;
            }
            sumac.add(temp);
            t1 = sumac.get(sumac.size()-2);
            t2 = sumac.get(sumac.size()-1);
        }
        System.out.println(sumac.size());
    }
}
