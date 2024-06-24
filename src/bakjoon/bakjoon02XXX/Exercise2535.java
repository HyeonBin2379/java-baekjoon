package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise2535 {
    private static class Student {
        int nation, stuNum, score;

        public Student(int nation, int stuNum, int score) {
            this.nation = nation;
            this.stuNum = stuNum;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Student> totalScore = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int stuNum = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            totalScore.add(new Student(nation, stuNum, score));
        }
        totalScore.sort((o1, o2) -> o2.score - o1.score);

        Map<Integer, List<Student>> medalist = new LinkedHashMap<>();
        int count = 0;
        for (Student stu : totalScore) {
            if (count == 3) {
                break;
            }
            if (!medalist.containsKey(stu.nation)) {
                medalist.put(stu.nation, new ArrayList<>());
            }
            if (medalist.get(stu.nation).size() < 2) {
                medalist.get(stu.nation).add(stu);
                System.out.println(stu.nation + " " + stu.stuNum);
                count++;
            }
        }
    }
}
