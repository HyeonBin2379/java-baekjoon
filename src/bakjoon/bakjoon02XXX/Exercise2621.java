package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise2621 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> colorSet = new HashSet<>();   // 색 저장
        int[] numCount = new int[10];   // 같은 숫자 카운트
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            colorSet.add(color);
            numCount[number]++;
        }

        Map<Integer, List<Integer>> cardNumByCount = new TreeMap<>();
        IntStream.rangeClosed(1, 5).forEach(i -> cardNumByCount.put(i, new ArrayList<>()));
        for (int i = 1; i <= 9; i++) {
            if (numCount[i] != 0) {
                cardNumByCount.get(numCount[i]).add(i);
            }
        }
        IntStream.rangeClosed(1, 5).forEach(i -> cardNumByCount.get(i).sort(null));

        // 사용된 카드의 숫자 & 연속된 숫자의 개수 구하기
        List<Integer> numList = IntStream.rangeClosed(1, 9)
                .filter(i -> numCount[i] != 0)
                .boxed()
                .toList();
        int continued = 1;
        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i) == numList.get(i-1)+1) {
                continued++;
            }
        }

        int score;
        if (colorSet.size() == 1 && continued == 5) { // 1번
            score = numList.get(numList.size()-1) + 900;
        }
        else if (!cardNumByCount.get(4).isEmpty()) {  // 2번
            score = cardNumByCount.get(4).get(0) + 800;
        }
        else if (!cardNumByCount.get(3).isEmpty() && !cardNumByCount.get(2).isEmpty()) {  // 3번
            score = cardNumByCount.get(3).get(0)*10 + cardNumByCount.get(2).get(0) + 700;
        }
        else if (colorSet.size() == 1) {  // 4번
            score = numList.get(numList.size()-1) + 600;
        }
        else if (continued == 5) {  // 5번
            score = numList.get(numList.size()-1) + 500;
        }
        else if (!cardNumByCount.get(3).isEmpty()) {  // 6번
            score = cardNumByCount.get(3).get(0) + 400;
        }
        else if (cardNumByCount.get(2).size() == 2) {  // 7번
            score = cardNumByCount.get(2).get(0) + cardNumByCount.get(2).get(1)*10 + 300;
        }
        else if (cardNumByCount.get(2).size() == 1) {  // 8번
            score = cardNumByCount.get(2).get(0) + 200;
        }
        else {    // 9번
            score = numList.get(numList.size()-1) + 100;
        }
        System.out.println(score);
    }
}
