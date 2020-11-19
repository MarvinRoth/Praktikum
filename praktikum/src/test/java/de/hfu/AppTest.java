package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
    @Test
    public void testUtil() {
        assertTrue(Util.istErstesHalbjahr(1));
        assertTrue(Util.istErstesHalbjahr(2));
        assertTrue(Util.istErstesHalbjahr(3));
        assertTrue(Util.istErstesHalbjahr(4));
        assertTrue(Util.istErstesHalbjahr(6));
        }

    @Test(expected = IllegalArgumentException.class)
    public void testUtilExcept(){
        Util.istErstesHalbjahr(0);
        Util.istErstesHalbjahr(13);
        assertTrue(Util.istErstesHalbjahr(12));
        assertTrue(Util.istErstesHalbjahr(7));
    }

    @Test
    public void testQ(){
        Queue test = new Queue(3);
        test.enqueue(5);
        test.enqueue(6);
        test.enqueue(9);
        assertEquals(5, test.dequeue());
        assertEquals(6, test.dequeue());
        assertEquals(9, test.dequeue());
        try{
            test.dequeue();
            fail();
        }
        catch(IllegalStateException e){

        }
        test.enqueue(5);
        assertEquals(5, test.dequeue());
        for (int i=0; i < 1000; ++i){
            test.enqueue(i);
        }

        assertEquals(0, test.dequeue());
        assertEquals(1, test.dequeue());
        assertEquals(999, test.dequeue());
    }
}
