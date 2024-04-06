package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30272 {

    private static final String[] num = {
            """
..#####..
.##...##.
##.....##
##.....##
##.....##
.##...##.
..#####..
.........""",
            """
....##...
..####...
....##...
....##...
....##...
....##...
..######.
.........""",
            """
.#######.
##.....##
.......##
.#######.
##.......
##.......
#########
.........""",
            """
.#######.
##.....##
.......##
.#######.
.......##
##.....##
.#######.
.........""",
            """
##.......
##....##.
##....##.
##....##.
#########
......##.
......##.
.........""",
            """
.########
.##......
.##......
.#######.
.......##
.##....##
..######.
.........""",
            """
.#######.
##.....##
##.......
########.
##.....##
##.....##
.#######.
.........""",
            """
.########
.##....##
.....##..
....##...
...##....
...##....
...##....
.........""",
            """
.#######.
##.....##
##.....##
.#######.
##.....##
##.....##
.#######.
.........""",
            """
.#######.
##.....##
##.....##
.########
.......##
##.....##
.#######.
........."""
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder input = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                input.append(br.readLine()).append("\n");
            }

            for (int j = 0; j < 10; j++) {
                String temp = num[j] + "\n";
                if (temp.contentEquals(input)) {
                    answer.append(j);
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
