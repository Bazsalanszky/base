package hu.bme.mit.train.system;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TachographTest {

    Tachograph t;

    @Before
    public void before(){
        t = new Tachograph();
    }

    @Test
    public void test() {
        Map<Integer,Integer> row = t.getRows(LocalDateTime.now());
        assert(row.isEmpty());
    }

    @Test
    public void test2() {
        LocalDateTime time = LocalDateTime.now();
        t.recordData(time,2,42);
        Map<Integer,Integer> row = t.getRows(time);
        assertEquals(1,row.size());
        assertEquals(42,row.get(2).intValue());
    }
}
