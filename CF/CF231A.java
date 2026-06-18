import java.util.Scanner;

public class CF231A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int implement_count = 0;
                for (char a : sc.nextLine().toCharArray()) {
                    if (a == '1') {
                        implement_count++;
                    }
                    if (implement_count > 1) {
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
