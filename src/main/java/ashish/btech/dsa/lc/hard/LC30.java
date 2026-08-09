package ashish.btech.dsa.lc.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        if (s == null
                || s.length() == 0
                || words == null
                || words.length == 0
                || s.length() < words.length * words[0].length()) {
            return indices;
        }

        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int wordCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            int initialIndx = i;
            int trav = i;
            int count = 0;

            while (trav + wordLength <= s.length()) {
                String curr = s.substring(trav, trav + wordLength);
                trav += wordLength;

                if (wordMap.containsKey(curr)) {
                    temp.put(curr, temp.getOrDefault(curr, 0) + 1);
                    count++;

                    while (temp.get(curr) > wordMap.get(curr)) {
                        String leftWord = s.substring(initialIndx, initialIndx + wordLength);
                        temp.put(leftWord, temp.get(leftWord) - 1);
                        count--;
                        initialIndx += wordLength;
                    }

                    if (count == wordCount) {
                        indices.add(initialIndx);
                    }
                } else {
                    temp.clear();
                    initialIndx = trav;
                    count = 0;
                }
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        LC30 blah = new LC30();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        System.out.println(blah.findSubstring(s, words));
    }
}
