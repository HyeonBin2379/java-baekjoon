package bakjoon.bakjoon16XXX;

import java.util.Scanner;

public class Exercise16727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p_p = sc.nextInt();
        int p_e = sc.nextInt();
        int e_e = sc.nextInt();
        int e_p = sc.nextInt();

        if (p_p+e_p != p_e+e_e) {
            System.out.println(p_p+e_p > p_e+e_e ? "Persepolis" : "Esteghlal");
        } else if (p_e != e_p){
            System.out.println(p_e > e_p ? "Esteghlal" : "Persepolis");
        } else {
            System.out.println("Penalty");
        }
    }
}
