package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise9785 {

    private static class Skill implements Comparable<Skill> {
        int damage, duration;

        Skill(int damage, int duration) {
            this.damage = damage;
            this.duration = duration;
        }

        @Override
        public int compareTo(Skill o) {
            return this.damage != o.damage
                    ? Integer.compare(o.damage, this.damage)
                    : Integer.compare(o.duration, this.duration);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Skill> available = new PriorityQueue<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int damage = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());
            available.offer(new Skill(damage, duration));
        }

        int totalDamage = 0;
        int maxTime = Integer.MAX_VALUE;
        while (!available.isEmpty() && m-- > 0) {
            Skill skill = available.poll();
            totalDamage += skill.damage;
            maxTime = Math.min(skill.duration, maxTime);
        }
        System.out.println(totalDamage + " " + maxTime);
    }
}
