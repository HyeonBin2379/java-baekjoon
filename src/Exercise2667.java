import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise2667 {
    private static int[][] map;
    private static int mapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        List<Integer> cluster = new ArrayList<>();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                int pixelCount = countCells(i, j);
                if (pixelCount > 0) {
                    cluster.add(pixelCount);
                }
            }
        }

        Collections.sort(cluster);
        System.out.println(cluster.size());
        for (Integer single : cluster) {
            System.out.println(single);
        }
    }

    public static int countCells(int x, int y) {
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (x < 0 || x >= mapSize || y < 0 || y >= mapSize) {
            return 0;
        }
        else if (map[y][x] != 1) {
            return 0;
        }
        else {
            map[y][x] = 2;
            int result = 1;
            for (int[] direction : move) {
                result += countCells(x+direction[0], y+direction[1]);
            }
            return result;
        }
    }
}
