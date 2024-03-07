package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise10105 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> pair = new TreeMap<>();
        int len = Integer.parseInt(br.readLine());
        String[] name1 = br.readLine().split(" ");
        String[] name2 = br.readLine().split(" ");

        for (int i = 0; i < len; i++) {
            pair.put(name1[i], name2[i]);
        }

        for (int i = 0; i < len; i++) {
            if (name1[i].equals(name2[i])
                    || (pair.get(name2[i]) != null && !pair.get(name2[i]).equals(name1[i]))) {
                System.out.println("bad");
                return;
            }
        }
        System.out.println("good");
    }
}
