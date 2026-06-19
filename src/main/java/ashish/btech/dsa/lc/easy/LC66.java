package ashish.btech.dsa.lc.easy;

public class LC66 {
    public int[] plusOne(int[] digits) {
        int[] temp_digits = new int[digits.length + 1];
        temp_digits[0] = 1;
        for (int reversePointer = digits.length - 1; reversePointer >= 0; reversePointer--) {
            if (digits[reversePointer] != 9) {
                digits[reversePointer] += 1;
                return digits;
            } else {
                digits[reversePointer] = 0;
            }
        }
        return temp_digits;
    }

    public void run() {
        int[] testInput = plusOne(new int[] {9});
        for (int digit : testInput) {
            System.out.print(digit + " ");
        }
    }

    public static void main(String[] args) {

        new LC66().run();
    }
}
