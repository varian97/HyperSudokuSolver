import java.util.Scanner;
import java.io.* ;
public class mainSudoku
{
    public static void main(String[]args)throws IOException
    {
        HyperSudoku S = new HyperSudoku();
        S.load();
        System.out.println("Sudoku yang anda input adalah : ");
        S.printmatrix();
        System.out.println();
        System.out.println(" Solusinya adalah :");
        S.solver();
    }
}
