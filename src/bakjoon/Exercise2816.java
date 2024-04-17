package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise2816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String>  channels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            channels.add(name);
        }

        int kbs1 = channels.indexOf("KBS1");
        int kbs2 = channels.indexOf("KBS2");
        if (kbs1 > kbs2) {
            kbs2 += 1;
        }
        String sb = "1".repeat(kbs1) + "4".repeat(kbs1)
                + "1".repeat(kbs2) + "4".repeat(kbs2 - 1);
        System.out.println(sb);
    }
}
