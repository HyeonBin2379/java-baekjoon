package bakjoon.bakjoon06XXX;

import java.util.Scanner;

public class Exercise6825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        double bmi = weight / (height * height);
        sc.close();

        if (Double.compare(bmi, 18.5) < 0) {
            System.out.println("Underweight");
        } else if (Double.compare(18.5, bmi) <= 0 && Double.compare(bmi, 25.0) <= 0) {
            System.out.println("Normal weight");
        } else if (Double.compare(25, bmi) <= 0){
            System.out.println("Overweight");
        }
    }
}
