package oneHash;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Search implements InterHash {
    private String word = "";
    TreeMap<String, Integer> statisticword = new TreeMap<String, Integer>();
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
       sb.append(wordmaxmin());
       return sb.toString();
        }
        
    

    /**
     * поиск масимального и минимального значения
     * 
     * @return max and min word
     */
    String wordmaxmin() {
        String smin = "", smax = "";
        
        Iterator<Entry<String, Integer>> itr = statisticword.entrySet().iterator();
        Entry<String, Integer> entry = (Entry<String, Integer>) itr.next();
        smin = entry.getKey();
        smax = entry.getKey();
        while (itr.hasNext()) {
            entry = itr.next();
            String key = entry.getKey();
            if (key.length() >= smax.length())
                smax = key;
            if (key.length() < smin.length())
                smin = key;
        }
        return "maxword:" +smax+ " minword:"+ smin +";";
    }

    /**
     * поиск слов
     * 
     * @param i
     *            входной символ
     * 
     */
    @Override
    public void gather(int i) {

        char ch = Character.toLowerCase((char) i);
        if (Character.isLetter(ch))
            word = word + ch;
        else if ("".equals(word) == false) {
            if (statisticword.containsKey(word)) {
                statisticword.put(word, statisticword.get(word) + 1);
                word = "";
            } else {
                statisticword.put(word, 1);
                word = "";
            }
        } else {
            return;

        }
        ;
        if (i == -1) {
            if (statisticword.containsKey(word)) {
                statisticword.put(word, statisticword.get(word) + 1);
                word = "";
            } else {
                statisticword.put(word, 1);
                word = "";
            }
        }

    }

    @Override
    public void returnres() {
        System.out.print(wordmaxmin());

    }
}
