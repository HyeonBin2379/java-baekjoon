package bakjoon;

import java.util.Scanner;

public class Exercise30917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int a = 1; a <= 9; a++){
            System.out.println("? A " + a);
            int resp = sc.nextInt();

            if(resp == 1){
                int b;
                for (b = 1; b <= 9; b++) {
                    System.out.println("? B " + b);
                    resp = sc.nextInt();
                    if (resp == 1) {
                        System.out.println("! " + (a + b));
                        break;
                    }
                }
                break;
            }
        }
    }
}
