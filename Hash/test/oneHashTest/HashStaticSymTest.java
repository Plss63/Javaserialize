package oneHashTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashStaticSymTest extends Calculate{

    @Test
    public void testMinMax() {
        reedfile(mas[0], "C:/MyDir/2.txt");
        String result = out(mas[0]);
        System.out.println(out(mas[0]));
        System.out.println(result);
        assertEquals("iiliiiliiliililiiilliiliiilli", result);
    }

}
