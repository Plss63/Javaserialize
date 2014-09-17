package oneHash;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HashDescription implements InterHash {

    private OutputStreamWriter myfile;
    private String output = "";

    public HashDescription(String str) {
        this.str = str;
    }

    private String str;

    /**
     * поиск подстроки и удаление
     * 
     * @param ch
     *            (symbol)
     * @param i
     *            (number)
     * @param str
     *            (symbol in string)
     * @throws IOException
     * @throws IOException
     * @return file 3.txt
     */

    @Override
    public void gather(int i) {
        char ch = (char) i;

        if (i != -1) {
            if (str.indexOf(ch) != -1)
                output = output + ch;
        }
    }

    @Override
    public void returnres() throws IOException {
        try {
            myfile = new OutputStreamWriter(new FileOutputStream("C:\\MyDir\\3.txt"), "cp866");
        } catch (FileNotFoundException exc) {
            System.out.println("Error opening output file");
        }
        try {
            myfile.write(output);
        } catch (IOException exc) {
            System.out.println("Error write");
        }

        try {
            myfile.close();
        } catch (IOException exc) {
            System.out.println("Error closing output file");
        }
    }

    /**
     * вывод символов
     */
    public String toString() {
        return output;
    }

}
