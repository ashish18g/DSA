package ashish.btech.dsa.lc.easy;

import java.util.ArrayList;
import java.util.List;

public class LC119 {
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
}
