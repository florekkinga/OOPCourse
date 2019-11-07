import static org.junit.Assert.*;

public class MatrixTest {

    @org.junit.Test
    public void correctDimensions() {
        Matrix instance = new Matrix(5,8);
        assertEquals(instance.rows, 5);
        assertEquals(instance.cols, 8);
    }

    @org.junit.Test
    public void isFilledWithZeros() {
        Matrix instance = new Matrix(2,2);
        assertEquals(instance.data[0], 0, 0.000001);
        assertEquals(instance.data[1], 0, 0.000001);
        assertEquals(instance.data[2], 0, 0.000001);
        assertEquals(instance.data[3], 0, 0.000001);
    }

    @org.junit.Test
    public void asArray() {
        Matrix instance = new Matrix(new double [][] {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {10}});
        double[][] expectedResult = new double [][] {{1, 2, 3, 4,}, {5, 6, 7, 0}, {8, 9, 0, 0}, {10, 0, 0, 0}};
        assertArrayEquals(expectedResult, instance.asArray());
    }

    @org.junit.Test
    public void get() {
        Matrix instance = new Matrix(new double [][] {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {10}});
        assertEquals(0, instance.get(3,3), 0.000001);
        assertEquals(4, instance.get(0,3), 0.000001);
        assertEquals(8, instance.get(2,0), 0.000001);
    }

    @org.junit.Test
    public void set() {
        Matrix instance = new Matrix(new double [][] {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {10}});
        instance.set(3, 3, 0.345);
        instance.set(2, 1, 2.80);
        assertEquals(0.345, instance.get(3,3), 0.000001);
        assertEquals(2.80, instance.get(2,1), 0.000001);
    }

    @org.junit.Test
    public void testToString() {
        Matrix instance = new Matrix(new double [][] {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {10}});
        int expResultCommas = 12;
        int expResultBrackets = 8;
        String result = instance.toString();
        int resCommas = 0;
        int resBrackets = 0;
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) == ',') resCommas++;
            else if(result.charAt(i) == '[' || result.charAt(i) == ']') resBrackets++;
        }
        assertEquals(expResultCommas, resCommas);
        assertEquals(expResultBrackets, resBrackets);
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void reshape() {
        Matrix instance = new Matrix(new double [][] {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {10}});
        instance.reshape(2,2);
    }

    @org.junit.Test
    public void reshape2() {
        Matrix instance = new Matrix(new double[][] {{1, 2, 3, 4}, {5, 6}, {7, 8}, {9}});
        try {
            instance.reshape(2, 2);
        } catch (RuntimeException exception) {
            assertEquals("4 x 4 matrix can't be reshaped to 2 x 2", exception.getMessage());
        }
    }

    @org.junit.Test
    public void shape() {
        Matrix instance = new Matrix(new double [][] {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {10}});
        int expResCols = 4;
        int expResRows = 4;
        int[] tab = new int []{expResRows, expResCols};
        assertArrayEquals(tab, instance.shape());
    }

    @org.junit.Test
    public void add() {
    }

    @org.junit.Test
    public void sub() {
    }

    @org.junit.Test
    public void mul() {
    }

    @org.junit.Test
    public void div() {
    }

    @org.junit.Test
    public void testAdd() {
    }

    @org.junit.Test
    public void testSub() {
    }

    @org.junit.Test
    public void testMul() {
    }

    @org.junit.Test
    public void testDiv() {
    }

    @org.junit.Test
    public void dot() {
    }

    @org.junit.Test
    public void frobenius() {
    }

    @org.junit.Test
    public void random() {
    }

    @org.junit.Test
    public void eye() {
    }
}