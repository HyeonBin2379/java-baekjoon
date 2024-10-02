package baekjoon.baekjoon10XXX;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Exercise10093 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long numCount = (a != b) ? Math.max(a, b) - Math.min(a, b) - 1 : 0;
        bw.write(numCount+"\n");
        for (long i = Math.min(a, b)+1; i < Math.max(a, b); i++) {
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }
}
