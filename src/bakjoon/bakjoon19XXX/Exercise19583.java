package bakjoon.bakjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise19583 {
    private static final Set<String> entered = new HashSet<>();
    private static final Set<String> quited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int[] minutes = new int[time.length];
        for (int i = 0; i < time.length; i++) {
            minutes[i] = getTimeInMinutes(time[i]);
        }

        String input;
        while ((input = br.readLine()) != null) {
            String[] chatInfo = input.split(" ");
            int chatTime = getTimeInMinutes(chatInfo[0]);
            String nickName = chatInfo[1];
            if (chatTime <= minutes[0]) {
                entered.add(nickName);
            } else if (chatTime >= minutes[1] && chatTime <= minutes[2]) {
                quited.add(nickName);
            }
        }

        long count = entered.stream()
                .filter(quited::contains)
                .count();
        System.out.println(count);
    }

    public static int getTimeInMinutes(String time) {
        int[] temp = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return temp[0]*60 + temp[1];
    }
}
