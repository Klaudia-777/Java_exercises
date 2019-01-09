package lab1;

//Napisz program umożliwiający dodawanie, odejmowanie oraz mnożenie dwóch macierzy.
//Stwórz klasę Macierz, która będzie posiadała metody add, sub, mul przyjmujące jako
// parametr drugą macierz do operacji i zwracające macierz będącą wynikiem danej operacji.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrix {
    private int dim1, dim2;
    private List<List<Integer>> outer;

    public Matrix(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
        outer = new ArrayList<>(dim1);
        ArrayList<Integer> inner = new ArrayList<>(dim2);

        Random generator = new Random();

        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                inner.add(generator.nextInt(7));
            }
            outer.add(inner);
            inner = new ArrayList<>(dim2);

        }
        // display();

    }


    public Matrix add(Matrix obj) {
        System.out.println("+");
        int tmp = 0;
        if (dim1 == obj.dim1 && dim2 == obj.dim2) {
            for (int i = 0; i < dim1; i++) {
                for (int j = 0; j < dim2; j++) {
                    tmp = outer.get(i).get(j) + obj.outer.get(i).get(j);
                    outer.get(i).set(j, tmp);
                }
            }
        }
        return this;
    }

    public Matrix subtract(Matrix obj) {
        System.out.println("-");
        int tmp = 0;
        if (dim1 == obj.dim1 && dim2 == obj.dim2) {
            for (int i = 0; i < dim1; i++) {
                for (int j = 0; j < dim2; j++) {
                    tmp = outer.get(i).get(j) - obj.outer.get(i).get(j);
                    outer.get(i).set(j, tmp);
                }
            }
        }
        return this;
    }

    public Matrix multiply(Matrix obj) {
        System.out.println("*");
        int tmp1 = 0;
        int tmp2 = 0;
        Matrix result = new Matrix(dim1, obj.dim2);
        for (int i = 0; i < result.dim1; ++i)
            for (int j = 0; j < obj.dim2; ++j) {
                result.outer.get(i).set(j, 0);
            }

        for (int i = 0; i < dim1; ++i)
            for (int j = 0; j < obj.dim2; ++j)
                for (int k = 0; k < dim2; ++k) {
                    tmp1 = outer.get(i).get(k) * obj.outer.get(k).get(j);
                    tmp2 = result.outer.get(i).get(j) + tmp1;
                    result.outer.get(i).set(j, tmp2);
                }
        return result;
    }


    public void display() {
        System.out.println("Matrix");
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                System.out.print(outer.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] arg) {
        Matrix mat = new Matrix(3, 3);
        mat.display();
        Matrix mat1 = new Matrix(3, 3);
        mat1.display();
        Matrix mat2 = new Matrix(3, 2);
        mat2.display();
        mat.add(mat1);
        mat.display();
        mat.subtract(mat1);
        mat.display();
        mat.multiply(mat2).display();
        String klaudia="klaudia";
    }


}
