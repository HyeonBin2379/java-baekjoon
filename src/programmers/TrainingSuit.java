package programmers;

import java.util.Arrays;

class TrainingSuitSolution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        Arrays.fill(student, 1);

        for (int num : reserve) {
            student[num-1] = 2;
        }
        for (int num : lost) {
            student[num-1]--;
        }

        Arrays.sort(lost);
        for (int num : lost) {
            int idx = num-1;

            if (student[idx] == 1) {
                continue;
            }

            if (student[idx] == 0) {
                if (idx > 0 && student[idx-1] == 2) {
                    student[idx]++;
                    student[idx-1]--;
                } else if (idx < n-1 && student[idx+1] == 2) {
                    student[idx]++;
                    student[idx+1]--;
                }
            }
        }

        return (int) Arrays.stream(student)
                .filter(value -> value > 0)
                .count();
    }
}

public class TrainingSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {4,2};
        int[] reserve = {5,3};
        System.out.println(new TrainingSuitSolution().solution(n, lost, reserve));
    }
}
