package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2110 {

    private static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        upperBound(n, c);
    }

    private static void upperBound(int n, int needed) {
        int low = 1;
        int high = house[n-1]-house[0]+1;

        int answer = 0;
        while (low < high) {
            int mid = (low+high) / 2;
            // 최적화: 공유기 c개를 설치할 수 있는, 가장 인접한 집들 간 최대 거리
            int count = countInstalled(n, mid);

            // 결정 문제: 가장 인접했을 때의 거리가 mid일 때, 공유기의 개수는 c개 이상인가?
            if (count >= needed) {  // 공유기 개수가 c개 이상일 때의 가장 인접한 최대 거리를 구한다.
                answer = mid;
                low = mid+1;
            } else {
                high = mid;
            }
        }
        System.out.println(answer);
    }

    private static int countInstalled(int n, int lowerBound) {
        int count = 1;
        int lastLocate = house[0];

        for (int i = 1; i < n; i++) {
            int dist = house[i]-lastLocate;
            if (dist >= lowerBound) {
                lastLocate = house[i];
                count++;
            }
        }
        return count;
    }
}
