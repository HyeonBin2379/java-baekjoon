package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise31881 {

    private static final Set<Integer> infected = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int count = n;
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int cmd = Integer.parseInt(stringTokenizer.nextToken());
            int num;
            switch (cmd) {
                case 1 -> {
                    num = Integer.parseInt(stringTokenizer.nextToken());
                    if (!infected.contains(num)) {
                        infected.add(num);
                        count--;
                    }
                }
                case 2 -> {
                    num = Integer.parseInt(stringTokenizer.nextToken());
                    if (infected.contains(num)) {
                        infected.remove(num);
                        count++;
                    }
                }
                case 3 -> bufferedWriter.write(count + "\n");
            }
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
