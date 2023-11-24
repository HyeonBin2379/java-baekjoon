import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 리스트 크기, 테스트케이스 개수 입력
        int size = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        // 원본 배열 & 합 배열 선언
        int[][] original = new int[size+1][size+1];
        int[][] dSum = new int[size+1][size+1];

        // 원본 배열 데이터 저장
        for (int i = 1; i < original.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < original.length; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 원본 배열에 관한 합 배열 저장
        for (int i = 1; i < original.length; i++) {
            for (int j = 1; j < original.length; j++) {
                dSum[i][j] = dSum[i][j-1] + dSum[i-1][j] - dSum[i-1][j-1] + original[i][j];
            }
        }

        // 각 테스트케이스별 결과 계산 및 출력
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = dSum[x2][y2] - dSum[x1-1][y2] - dSum[x2][y1-1] + dSum[x1-1][y1-1];
            System.out.println(result);
        }
        br.close();
    }
}
