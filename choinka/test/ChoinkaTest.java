import static org.junit.jupiter.api.Assertions.*;

class ChoinkaTest {

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
    void testsort() {
        System.out.println("testSort");
        Choinka instace0 = new Choinka(143.25, "jodla");
        Choinka instace1 = new Choinka(130.25, "jodla");
        Choinka instace2 = new Choinka(150.25, "jodla");
        Choinka instace3 = new Choinka(100.25, "swierk");
        Choinka instace4 = new Choinka(180.25, "swierk");
        Choinka instace5 = new Choinka(140.25, "sosna");
        Choinka [][] expResult = new Choinka[][]{{instace1,instace0,instace2},{instace3, instace4},{instace5}};
        Choinka [] list = {instace0,instace1,instace2,instace3,instace4,instace5};
        assertArrayEquals(expResult, (instace0.sort(list)));

    }

    public static void main (String args[]) {
        ChoinkaTest test = new ChoinkaTest();
        test.testsort();
    }
}