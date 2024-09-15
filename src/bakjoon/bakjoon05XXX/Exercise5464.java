package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise5464 {

    private static int[] parkingLot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] rate = new int[n+1];
        for (int i = 1; i <= n; i++) {
            rate[i] = Integer.parseInt(br.readLine());
        }
        int[] weight = new int[m+1];
        for (int i = 1; i <= m; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int answer = 0;
        parkingLot = new int[n+1];
        for (int i = 0; i < 2*m; i++) {
            int carNum = Integer.parseInt(br.readLine());
            if (carNum > 0) {
                if (hasSpace(carNum)) {
                    continue;
                }
                queue.offer(carNum);
            } else if (carNum < 0) {
                for (int j = 1; j <= n; j++) {
                    if (parkingLot[j] == carNum*(-1)) {
                        parkingLot[j] = 0;
                        answer += rate[j]*weight[carNum*(-1)];
                        if (!queue.isEmpty()) {
                            parkingLot[j] = queue.poll();
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean hasSpace(int car) {
        for (int i = 1; i < parkingLot.length; i++) {
            if (parkingLot[i] == 0) {
                parkingLot[i] = car;
                return true;
            }
        }
        return false;
    }
}
