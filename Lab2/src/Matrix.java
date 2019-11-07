import java.util.Random;

public class Matrix {
    double[] data;
    int rows;
    int cols;

    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        data = new double[rows * cols];
    }

    Matrix(double[][] d) {
        rows = d.length;
        cols = 0;

        for (int i=0; i<rows; i++)
            cols = Math.max(cols, d[i].length);

        data = new double[rows*cols];

        for (int i=0; i<d.length; i++)
            for (int j=0; j<d[i].length; j++)
                data[i*cols+j] = d[i][j];
    }

    double[][] asArray() {
        double[][] array_2d = new double[rows][cols];

        for (int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                array_2d[i][j] = data[i*cols+j];

        return array_2d;
    }

    double get(int r, int c){
        return data[r*cols+c];
    }

    void set(int r, int c, double value){
        data[r*cols+c] = value;
    }

    @Override
    public String toString(){
        StringBuilder buf = new StringBuilder();
        //buf.append("[");
        for(int i=0;i<rows;i++){
            buf.append("[");
            for(int j=0; j<cols; j++){
                if (j==cols-1) buf.append(data[i*cols+j]);
                else{
                    buf.append(data[i*cols+j]);
                    buf.append(", ");
                }
            }
            if (i==rows-1) buf.append("]");
            else{
                //buf.append("], ");
                buf.append("]\n");
            }
        }
        //buf.append("]");
        return buf.toString();
    }

    void reshape(int newRows, int newCols){
        if(rows*cols != newRows*newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d", rows, cols, newRows, newCols));
        rows = newRows;
        cols = newCols;
    }

    int[] shape(){
        int[] dimensions = {rows, cols};
        return dimensions;
    }

    Matrix add(Matrix m){
        if(rows == m.rows && cols == m.cols){
            Matrix newMatrix = new Matrix(rows, cols);
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    newMatrix.set(i, j, this.get(i,j) + m.get(i,j));
                }
            }
            return newMatrix;
        }
        else{
            throw new RuntimeException(String.format("%d x %d matrix can't be added to %d x %d", rows, cols, m.rows, m.cols));
        }
    }

    Matrix sub(Matrix m){
        if(rows == m.rows && cols == m.cols){
            Matrix newMatrix = new Matrix(rows, cols);
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    newMatrix.set(i, j, this.get(i,j) - m.get(i,j));
                }
            }
            return newMatrix;
        }
        else{
            throw new RuntimeException(String.format("%d x %d matrix can't be subtracted from %d x %d", m.rows, m.cols, rows, cols));
        }
    }

    Matrix mul(Matrix m){
        if(rows == m.rows && cols == m.cols){
            Matrix newMatrix = new Matrix(rows, cols);
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    newMatrix.set(i, j, this.get(i,j) * m.get(i,j));
                }
            }
            return newMatrix;
        }
        else{
            throw new RuntimeException(String.format("%d x %d matrix can't be multiplied by to %d x %d", rows, cols, m.rows, m.cols));
        }
    }

    Matrix div(Matrix m){
        if(rows == m.rows && cols == m.cols){
            Matrix newMatrix = new Matrix(rows, cols);
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    newMatrix.set(i, j, this.get(i,j) / m.get(i,j));
                }
            }
            return newMatrix;
        }
        else{
            throw new RuntimeException(String.format("%d x %d matrix can't be divided by %d x %d", rows, cols, m.rows, m.cols));
        }
    }

    Matrix add(double w){
        Matrix newMatrix = new Matrix(rows, cols);
        for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    newMatrix.set(i, j, this.get(i,j) + w);
                }
            }
            return newMatrix;
    }

    Matrix sub(double w){
        Matrix newMatrix = new Matrix(rows, cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                newMatrix.set(i, j, this.get(i,j) - w);
            }
        }
        return newMatrix;
    }

    Matrix mul(double w){
        Matrix newMatrix = new Matrix(rows, cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                newMatrix.set(i, j, this.get(i,j) * w);
            }
        }
        return newMatrix;
    }

    Matrix div(double w){
        Matrix newMatrix = new Matrix(rows, cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                newMatrix.set(i, j, this.get(i,j) / w);
            }
        }
        return newMatrix;
    }

    Matrix dot(Matrix m){
        if(cols == m.rows){
            Matrix newMatrix = new Matrix(rows, m.cols);
            for(int i=0; i<rows; i++){
                for(int j=0; j<m.cols; j++) {
                    for (int k = 0; k < cols; k++) {
                        double value = newMatrix.get(i, j) + this.get(i, k) * m.get(k, j);
                        newMatrix.set(i, j, value);
                    }
                }
            }
            return newMatrix;
        }
        else{
            throw new RuntimeException(String.format("%d x %d matrix can't be multiplied by %d x %d", rows, cols, m.rows, m.cols));
        }
    }

    double frobenius(){
        double result = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result += Math.pow(this.get(i, j),2);
            }
        }
        return result;
    }

    public static Matrix random(int rows, int cols){
        Matrix m = new Matrix(rows,cols);
        Random r = new Random();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                    m.set(i, j, r.nextDouble());
            }
        }
        return m;
    }

    public static Matrix eye(int n){
        Matrix m = new Matrix(n,n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) m.set(i, j, 1);
                else m.set(i, j, 0);
            }
        }
        return m;
    }

    //optional: implement the matrix inversion
    /*
    void Matrix::swapRows(int i1,int i2)
{
 for(int j=0;j<n;j++){
	double tmp=x[i1][j];
	x[i1][j]=x[i2][j];
	x[i2][j]=tmp;
 }
}
void Matrix::invert()
{
 int i,j,k;
 Matrix out(n);
 for(i=0; i<n; i++){
	// Find pivot row
	double max=fabs(x[i][i]);
	int pivot=i;
	for(k=i;k<n;k++){
		if(max<fabs(x[k][i])){
			max=fabs(x[k][i]);
			pivot=k;
		}
	}
	if(i!=pivot)swapRows(i,pivot);
	if(i!=pivot)out.swapRows(i,pivot);
	if(x[i][i] != 1.0){
		double divby=x[i][i];
		if( fabs(divby)>verySmall ){
			for(j=0;j<n;j++){
				out.x[i][j]/=divby;
				x[i][j]/=divby;
			}
		}else {
			throw -1;
		}
	}
	for(j=0;j<n;j++){
		if(j!=i){
			if(x[j][i]!=0){
				double mulby=x[j][i];
				for(k=0;k<n;k++){
					x[j][k]-=mulby*x[i][k];
					out.x[j][k]-=mulby*out.x[i][k];
				}
			}
		}
	}
 }
 *this=out;
}
     */
}