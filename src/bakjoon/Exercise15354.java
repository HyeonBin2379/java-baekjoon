package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15354 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] people = new char[n];
        for (int i = 0; i < n; i++) {
            people[i] = br.readLine().charAt(0);
        }

        int pos = 1;
        for (int i = 1; i < n; i++) {
            if (people[i] != people[i-1]) {
                pos++;
            }
        }
        System.out.println(pos+1);
    }
}
