package ashish.btech.dsa.lc.easy;

import java.util.ArrayList;
import java.util.List;

public class LC118 {

    public int combination(int n, int k) {
        double combinations = 1;
        int p = k > n - k ? n - k : k;
        for (int a = n; a > n - (k > n - k ? n - k : k); a--) {
            combinations = combinations * a / p;
            if (p > 0) p--;
        }
        return (int) Math.round(combinations);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalRow = new ArrayList<>();
        for (int index = rowIndex; index >= 0; index--) {
            pascalRow.add(combination(rowIndex, index));
        }
        return pascalRow;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            pascalsTriangle.add(getRow(row));
        }
        return pascalsTriangle;
    }

    public List<Integer> getNextRow(List<Integer> row) {
        List<Integer> nextRow = new ArrayList<Integer>();
        nextRow.add(1);
        for (int a = 0; a < row.size(); a++) {
            if (a != row.size() - 1) {
                nextRow.add(row.get(a) + row.get(a + 1));
            } else nextRow.add(1);
        }
        return nextRow;
    }

    public void run() {
        var testInput = getRow(8);
        System.out.println(testInput);
    }

    public static void main(String[] args) {

        new LC118().run();
    }
}
