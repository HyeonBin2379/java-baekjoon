package programmers;

class DuplicatedPaintingSolution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int standard = section[0];
        for (int index : section) {
            if (standard+m-1 < index) {
                standard = index;
                answer++;
            }
        }
        return answer;
    }
}
public class DuplicatedPainting {
    public static void main(String[] args) {
        int n = 6;
        int m = 4;
        int[] section = {2, 3, 6};
        System.out.println(new DuplicatedPaintingSolution().solution(n, m, section));
    }
}
