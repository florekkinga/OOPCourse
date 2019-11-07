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
        int r = 3;
        int c = 3;
        double value = 0.345;
        Matrix instance = new Matrix(new double [][] {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {10}});
        instance.set(r, c, value);
        assertEquals(value, instance.get(r,c), 0.000001); // ?????????
    }

    @org.junit.Test
    public void testToString() {
    }

    @org.junit.Test
    public void reshape() {
    }

    @org.junit.Test
    public void shape() {
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