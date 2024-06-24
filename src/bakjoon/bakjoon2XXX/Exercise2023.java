package bakjoon.bakjoon2XXX;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Exercise2023 {
    private static int numberLength;
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        numberLength = sc.nextInt();
        sc.close();

        dfs(2);
        dfs(3);
        dfs(5);
        dfs(7);
        bw.flush();
        bw.close();
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number/2+1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void dfs(Integer number) throws IOException {
        if (number.toString().length() == numberLength) {
            bw.write(number+"\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            int newNumber = 10*number+i;

            if (i % 2 == 0) {
                continue;
            }
            if (isPrimeNumber(newNumber)) {
                dfs(newNumber);
            }
        }
    }
}
