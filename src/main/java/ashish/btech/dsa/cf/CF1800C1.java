package ashish.btech.dsa.cf;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF1800C1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long[] armies = new long[n];
            for (int i = 0; i < n; i++) {
                Deque<Long> bonus_deck = new ArrayDeque<>();
                long army_strength = 0;
                for (int a = Integer.parseInt(sc.next()); a > 0; a--) {
                    long power = Long.parseLong(sc.next());
                    if (power == 0) {
                        if (bonus_deck.isEmpty()) {
                            continue;
                        }
                        army_strength += bonus_deck.pop();
                    } else if (bonus_deck.isEmpty() || bonus_deck.peek() <= power) {
                        bonus_deck.push(power);
                    } else if (bonus_deck.peek() > power) {
                        Deque<Long> temp_stack = new ArrayDeque<>();
                        while (!bonus_deck.isEmpty() && bonus_deck.peek() > power) {
                            temp_stack.push(bonus_deck.pop());
                        }
                        bonus_deck.push(power);
                        while (!temp_stack.isEmpty()) {
                            bonus_deck.push(temp_stack.pop());
                        }
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
