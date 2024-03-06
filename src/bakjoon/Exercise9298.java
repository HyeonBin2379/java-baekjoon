package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise9298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());     // 테스트케이스

        for (int i = 1; i <= testCase; i++) {
            int antCount = Integer.parseInt(br.readLine()); // 개미의 수
            double[] x = new double[antCount];              // x좌표, y좌표 최소값 초기화
            double[] y = new double[antCount];

            // 직사각형 모양의 개미 우리를 만들기 위해 좌하단, 우상단에 있는 개미의 좌표 찾기 수행
            for (int j = 0; j < antCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); // 각 개미들의 좌표 입력
                x[j] = Double.parseDouble(st.nextToken()); // 한 개미의 x좌표
                y[j] = Double.parseDouble(st.nextToken()); // 한 개미의 y좌표
            }
            Arrays.sort(x);
            Arrays.sort(y);

            double width = x[antCount-1] - x[0];
            double height = y[antCount-1] - y[0];
            double a = width*height;     // 개미우리의 넓이
            double p = 2*width+2*height; // 개미우리의 둘레
            sb.append(String.format("Case %d: Area %.9f, Perimeter %.9f\n", i, a, p));
        }
        System.out.print(sb);
    }
}