package oneHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class StaticWord implements InterHash {
    private String word = "";
    TreeMap<String, Integer> statisticword = new TreeMap<String, Integer>();
    private StringBuilder sb = new StringBuilder();

    /**
     * Поиск слов
     * 
     * @param i входной символ
     */
    public void gather(int i) {

        char ch = Character.toLowerCase((char) i);

        if (Character.isLetter(ch) == false) {
            if ("".equals(word))
                return;
            if ("".equals(word) == false) {
                if (statisticword.containsKey(word) == true) {
                    statisticword.put(word, statisticword.get(word) + 1);
                    word = "";
                } else {
                    statisticword.put(word, 1);
                    word = "";
                }
            }
        }
        if (Character.isLetter(ch)) {
            word = word + ch;
            if (i == -1) {
                if (statisticword.containsKey(word) == true) {
                    statisticword.put(word, statisticword.get(word) + 1);
                    word = "";
                } else {
                    statisticword.put(word, 1);
                    word = "";
                }
            }
        }
    }

    /**
     * вывод слов
     * 
     */
    public void returnres() {

        System.out.println(statisticword.entrySet());
        returnSortedList(5);
    }

    public String toString() {
        return sb.toString();
    }

    /**
     * сортировка слов и вывод n-го количества
     * 
     * @param n
     * 
     * @return n elements
     */
    public void returnSortedList(int n) {
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(statisticword.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }

        });
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            sb.append(";");

        }
        System.out.println(sb);
    }

}
