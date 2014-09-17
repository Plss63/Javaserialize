package oneHashTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import oneHash.HashDescription;
import oneHash.InterHash;
import oneHash.Search;
import oneHash.StaticSym;
import oneHash.StaticWord;

public class Calculate {
    HashDescription gather = new HashDescription("li");
    StaticWord staticWord = new StaticWord();
    StaticSym staticSym = new StaticSym();
    Search search = new Search();
    public InterHash[] mas = { gather, staticWord, staticSym, search };

    public void reedfile(InterHash el, String input) {
        FileInputStream fileinput = null;
        try {
            fileinput = new FileInputStream(input);
            int i = 0;
            do {
                i = fileinput.read();
                if (i != -1)
                    el.gather(i);
                // gather(i, gather, staticWord, staticSym, search);
                staticSym.searchsym('o');
            } while (i != -1);
        } catch (FileNotFoundException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("Error reading file");
        } finally {
            try {
                if (fileinput != null)
                    fileinput.close();
            } catch (IOException exc) {
                System.out.println("Error closing file");
            }
        }
    }

    public String out(InterHash el)  {
        return el.toString();
    }

}
