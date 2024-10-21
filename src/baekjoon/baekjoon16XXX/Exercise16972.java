package baekjoon.baekjoon16XXX;

public class Exercise16972 {

    public static void main(String[] args) {
        for (int i = 0; i < 814; i++) {
            int rand1 = (int) (Math.random()*16280-8140);
            int rand2 = (int) (Math.random()*16280-8140);
            System.out.printf("%d %d\n", rand1, rand2);
        }
    }
}
