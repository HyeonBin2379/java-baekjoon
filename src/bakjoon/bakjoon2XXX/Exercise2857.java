package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> fbi = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String agent = br.readLine();
            if (agent.contains("FBI")) {
                fbi.add(i);
            }
        }
        br.close();
        if (fbi.isEmpty()) {
            System.out.println("HE GOT AWAY!");
        } else {
            fbi.forEach(integer -> System.out.print(integer + " "));
        }
    }
}
