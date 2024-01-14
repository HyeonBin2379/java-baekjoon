package programmers;

import java.util.Arrays;

class LifeBoatSolution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if (start == end) {
                answer++;
                break;
            }

            if (people[start] + people[end] <= limit) {
                start++;
            }
            answer++;
            end--;
        }
        return answer;
    }
}
public class LifeBoat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(new LifeBoatSolution().solution(people, limit));
    }
}
