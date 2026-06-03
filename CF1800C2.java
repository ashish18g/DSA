import java.util.Scanner;

public class CF1800C2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long[] armies = new long[n];
            for (int i = 0; i < n; i++) {
                UpdatingLinkedList bonus_deck = new UpdatingLinkedList();
                long army_strength = 0;
                for (long a = Long.parseLong(sc.next()); a > 0; a--) {
                    long power = Long.parseLong(sc.next());
                    if (power == 0) {
                        try {
                            army_strength += bonus_deck.removeLast();
                        } catch (RuntimeException e) {

                        }
                    } else {
                        bonus_deck.insertNumber(power);
                    }
                }
                armies[i] = army_strength;
            }
            for (long a : armies) {
                System.out.println(a);
            }
        }
    }
}
