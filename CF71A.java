import java.util.Scanner;

public class CF71A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = sc.nextLine();
            }
            for (String word : words) {
                int l = word.length();
                if (l > 10) {
                    System.out.println(String.valueOf(word.charAt(0))
                            + String.valueOf(l - 2)
                            + String.valueOf(word.charAt(l - 1)));
                } else {
                    System.out.println(word);
                }
            }
        }
    }
}
