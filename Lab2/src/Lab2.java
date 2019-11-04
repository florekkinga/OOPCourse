public class Lab2 {
    public static void main(String[] args) {
        //Matrix m = new Matrix(4, 4);
        Matrix m = new Matrix(new double[][]{{1,2,3,4,6,8,9},{5,6},{7,8},{9}});
        System.out.println(m.toString());
        System.out.println(m.forbenius());
        Matrix s = m.div(m);
        System.out.println(s.toString());
        System.out.println(s.forbenius());

    }
}