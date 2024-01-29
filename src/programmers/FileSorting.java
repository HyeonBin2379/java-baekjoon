package programmers;

import java.util.Arrays;

class FileSortingSolution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] token1 = parsingFileName(o1.toLowerCase());
            String[] token2 = parsingFileName(o2.toLowerCase());

            int comparison = token1[0].compareTo(token2[0]);
            if (comparison == 0) {
                return Integer.parseInt(getNumber(token1[1].toCharArray()))
                        - Integer.parseInt(getNumber(token2[1].toCharArray()));
            }
            return comparison;
        });
        return files;
    }

    public String[] parsingFileName(String file) {
        String head = file.split("[0-9]")[0];
        String number = file.substring(head.length());
        return new String[] {head, number};
    }

    public String getNumber(char[] token) {
        StringBuilder sb = new StringBuilder();
        for (char c : token) {
            if (!Character.isDigit(c) || sb.length() > 5) {
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
public class FileSorting {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(new FileSortingSolution().solution(files)));
    }
}
