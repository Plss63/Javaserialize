package oneHash;

import java.util.HashMap;
import java.util.Map;

public class StaticSym implements InterHash {
    HashMap<Character, Integer> statisticsym = new HashMap<Character, Integer>();
    private String sym = "";

    /**
     * поиск символов
     * 
     * @param i
     *            входной символ
     */

    @Override
    public void gather(int i) {

        char ch = Character.toLowerCase((char) i);
        if (statisticsym.containsKey(ch) == true)
            statisticsym.put(ch, statisticsym.get(ch) + 1);
        else
            statisticsym.put(ch, 1);

    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e: statisticsym.entrySet() ){
            sb.append(e.getKey());
            sb.append(":");
            sb.append(e.getValue());
            sb.append(";");
        }
        return sb.toString();
    }

    
    
    
    /**
     * return symbol table
     */
    @Override
    public void returnres() {

        System.out.println(statisticsym.entrySet());
    }

    public void searchsym(char ch) {
        sym = sym + ch + "=" + statisticsym.get(ch);
    }

}
