package bakjoon.bakjoon30XXX;

import java.io.*;
import java.util.*;

public class Exercise30068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Boolean> isParking = new TreeMap<>();
        Map<Integer, Integer> parkingTime = new LinkedHashMap<>();
        int logCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < logCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (!isParking.getOrDefault(num, false)) {
                parkingTime.put(num, time);
            } else {
                System.out.println(num + " " + (time-parkingTime.getOrDefault(num, 0)));
            }
            isParking.put(num, !isParking.getOrDefault(num, false));
        }
    }
}
