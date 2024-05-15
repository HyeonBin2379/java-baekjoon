package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31832 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String teamName = br.readLine();
            if (teamName.length() > 10) {
                continue;
            }

            int numCnt = 0, lowerCnt = 0, upperCnt = 0;
            for (int j = 0; j < teamName.length(); j++) {
                char temp = teamName.charAt(j);
                if (Character.isDigit(temp)) {
                    numCnt++;
                } else if (temp >= 'a' && temp <= 'z') {
                    lowerCnt++;
                } else if (temp >= 'A' && temp <= 'Z') {
                    upperCnt++;
                }
            }
            if (upperCnt <= lowerCnt && numCnt != teamName.length()) {
                System.out.println(teamName);
                break;
            }
        }
    }
}
