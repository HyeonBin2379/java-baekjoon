package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise25192 {
    public static void main(String[] args) throws IOException {
        Set<String> chatMember = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chatLogCount = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < chatLogCount; i++) {
            String log = br.readLine();
            if (log.equals("ENTER")) {
                count += chatMember.size();
                chatMember = new HashSet<>();
            } else {
                chatMember.add(log);
            }
        }
        count += chatMember.size();
        System.out.println(count);
    }
}
