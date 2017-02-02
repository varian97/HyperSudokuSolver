import java.util.Scanner;
import java.io.* ;
public class mainSudoku
{
    public static void main(String[]args)throws IOException
    {
        HyperSudoku S = new HyperSudoku();
        S.load();
        System.out.println("Your Input : ");
        S.printmatrix();
        System.out.println();
        System.out.println(" The solution :");
        S.solver();
    }
}
