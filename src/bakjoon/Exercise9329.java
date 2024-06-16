package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise9329 {

    private static class PriceInfo {
        int k, price;
        int[] stickerType;

        public PriceInfo(int k, int[] stickerType, int price) {
            this.k = k;
            this.price = price;
            this.stickerType = stickerType;
        }

        public int getMinStickerCount() {
            return Arrays.stream(stickerType)
                    .map(type -> stickerCnt[type-1])
                    .min()
                    .getAsInt();
        }
        public int getPrice() {
            return getMinStickerCount() * price;
        }
    }
    private static int[] stickerCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            PriceInfo[] info = new PriceInfo[n];
            for (int i = 0; i < n; i++) {
                info[i] = makeInfo(br.readLine());
            }

            stickerCnt = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();
            bw.write(IntStream.rangeClosed(0, n-1).map(index -> info[index].getPrice()).sum() + "\n");
        }
        br.close();
        bw.close();
    }

    private static PriceInfo makeInfo(String input) {
        String[] token = input.split(" ");
        int k = Integer.parseInt(token[0]);
        int[] type = IntStream.rangeClosed(1, k).map(index -> Integer.parseInt(token[index])).toArray();
        int price = Integer.parseInt(token[k+1]);
        return new PriceInfo(k, type, price);
    }
}
