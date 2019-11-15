package bubblesort;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("set up");
        System.out.flush();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("tear down");
        System.out.flush();
    }

    @org.junit.jupiter.api.Test
    void volume() {
        System.out.println("test volume");
        Box instance0 = new Box(2.0f,4.0f, 2.5f);
        Box instance1 = new Box(3.0f,3.0f, 2.5f);
        Box instance2 = new Box(6.0f,4.5f, 2.5f);
        Box instance3 = new Box(1.0f,4.0f, 2.5f);
        float expRes0 = 20;
        float expRes1 = (float) 22.5;
        float expRes2 = (float) 67.5;
        float expRes3 = 10;
        assertEquals(expRes0, instance0.volume());
        assertEquals(expRes1, instance1.volume());
        assertEquals(expRes2, instance2.volume());
        assertEquals(expRes3, instance3.volume());
    }

    @org.junit.jupiter.api.Test
    void testbubbleSort() {
        System.out.println("test bubbleSort");
        Box instance0 = new Box(2.0f,4.0f, 2.5f);
        Box instance1 = new Box(3.0f,3.0f, 2.5f);
        Box instance2 = new Box(6.0f,4.5f, 2.5f);
        Box instance3 = new Box(1.0f,4.0f, 2.5f);
        Box [] tab = {instance0, instance1, instance2, instance3};
        Box [] expRes = {instance3, instance0, instance1, instance2};
        assertArrayEquals(expRes, instance0.bubbleSort(tab));
    }

    public static void main () {
        BoxTest test = new BoxTest();
        test.volume();
        test.testbubbleSort();
    }
}