package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String answer = "";
        for (int i = 0; i < count; i++) {
            String name = br.readLine();
            if (name.contains("S")) {
                answer = name;
                break;
            }
        }
        System.out.print(answer);
        br.close();
    }
}
