import static org.junit.Assert.*;

public class MatrixTest {

    private double NaN;

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

    /*
    @org.junit.Test
    String s= "[[1.0,2.3,4.56], [12.3,  45, 21.8]]";
        s= s.replaceAll("(\\[|\\]|\\s)+","");
        String[] t = s.split("(,)+");
        for(String x:t){
            System.out.println(String.format("\'%s\'",x ));
        }

        double[]d=new double[t.length];
        for(int i=0;i<t.length;i++) {
            d[i] = Double.parseDouble(t[i]);
        }

        double arr[][]=new double[1][];
        arr[0]=d;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
     */

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
        Matrix m = new Matrix(new double[][] {{1,2,3,4},{5,6},{7,8},{9}});
        Matrix instance = new Matrix(new double [][] {{1,0,0,0}, {2}, {3}, {4}});
        Matrix expResult = new Matrix(new double [][] {{2,2,3,4},{7,6},{10,8},{13}});
        Matrix result = instance.add(m);

        assertArrayEquals(expResult.asArray(), result.asArray());

        Matrix s = new Matrix(new double[][] {{0,2},{3,5}});
        try {
            instance.add(s);
        } catch (RuntimeException exception) {
            assertEquals("4 x 4 matrix can't be added to 2 x 2", exception.getMessage());
        }
    }

    @org.junit.Test
    public void sub() {
        Matrix instance = new Matrix(new double[][] {{1,2,3,4},{5,6},{7,8},{9}});
        Matrix m = new Matrix(new double [][] {{1,0,0,0}, {2}, {3}, {4}});
        Matrix expResult = new Matrix(new double [][] {{0,2,3,4},{3,6},{4,8},{5}});
        Matrix result = instance.sub(m);

        assertArrayEquals(expResult.asArray(), result.asArray());

        Matrix s = new Matrix(new double[][] {{0,2},{3,5}});
        try {
            instance.sub(s);
        } catch (RuntimeException exception) {
            assertEquals("2 x 2 matrix can't be subtracted from 4 x 4", exception.getMessage());
        }
    }

    @org.junit.Test
    public void mul() {
        Matrix m = new Matrix(new double[][] {{1,2,3,4}, {5,6},{7,8},{9}});
        Matrix instance = new Matrix(new double [][] {{1,0,0,0}, {2}, {3}, {4}});
        Matrix expResult = new Matrix(new double [][] {{1,0,0,0},{10},{21},{36}});
        Matrix result = instance.mul(m);

        assertArrayEquals(expResult.asArray(), result.asArray());

        Matrix s = new Matrix(new double[][] {{0,2},{3,5}});
        try {
            instance.mul(s);
        } catch (RuntimeException exception) {
            assertEquals("4 x 4 matrix can't be multiplied by 2 x 2", exception.getMessage());
        }
    }

    @org.junit.Test
    public void div() {
        //....
    }

    @org.junit.Test
    public void testAdd() {
        double w = 10;
        Matrix instance = new Matrix(new double[][]{{1, 2, 3, 4}, {5, 6}, {7, 8}, {9}});
        Matrix expResult = new Matrix(new double[][]{{11, 12, 13, 14}, {15, 16, 10, 10},
                {17, 18, 10, 10}, {19, 10, 10, 10}});
        Matrix result = instance.add(w);
        assertArrayEquals(expResult.asArray(), result.asArray());
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
        Matrix m = new Matrix(new double [][] {{2,2},{1,1}});
        assertEquals(10, m.frobenius(), 0.000001);
    }
    
    @org.junit.Test
    public void eye() {
        Matrix m = Matrix.eye(10);
        assertEquals(m.frobenius(), 10, 0.000001);
    }
}