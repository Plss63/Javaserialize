package oneHashTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashSearchTest extends Calculate {

    @Test
    public void testMinMax() {
        reedfile(mas[3], "C:/MyDir/2.txt");
        String result = out(mas[3]);
        System.out.println(result);
        assertEquals("maxword:population minword:in;", result);
    }

}
