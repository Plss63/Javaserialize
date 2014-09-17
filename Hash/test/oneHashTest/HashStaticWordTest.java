package oneHashTest;

import static org.junit.Assert.*;


import org.junit.Test;

public class HashStaticWordTest extends Calculate {

    @Test
    public void testMinMax() {
        reedfile(mas[1], "C:/MyDir/2.txt");
        String result = out(staticWord);
        System.out.println(out(staticWord));
        System.out.println(result);
        assertEquals("the=4;is=3;and=2;in=2;its=2;", result);
    }

}
