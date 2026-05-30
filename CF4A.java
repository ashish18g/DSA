import java.util.Scanner;

public class CF4A {
    public static void main(String[] args) {
        int w;
        try (Scanner sc = new Scanner(System.in)) {
            w = sc.nextInt();
        }
        if (w > 3 && w % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
