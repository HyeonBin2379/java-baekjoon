package codekata.programmers;

public class MagicElevator {

    public int solution(int storey) {
        int answer = 0;

        // 1의자리부터 확인
        while (storey > 0) {
            int d = storey % 10;

            answer += Math.min(10-d, d);
            storey /= 10;

            if (d >= 5) {
                storey += ((d > 5) || (storey / 10 > 0 && storey % 10 >= 5)) ? 1 : 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int storey = 2554;
        int result = new MagicElevator().solution(storey);
        System.out.println(result);
    }
}
