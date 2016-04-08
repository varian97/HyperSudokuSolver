import java.util.Scanner;
import java.io.*;

public class HyperSudoku
{
    public static int[][] matrix;
    public static int[] tabrow;
    public static int[] tabcol;
    public static int row;
    public static int column;
    Scanner s = new Scanner(System.in);
    
    private long startTime = 0;
	private long stopTime = 0;
	private boolean counting = false;


	public void start() 
	{
		this.startTime = System.currentTimeMillis();
		this.counting = true;
	}


	public void stop() 
	{
		this.stopTime = System.currentTimeMillis();
		this.counting = false;
	}

	public long ResultTime() 
	{
		long time;
		if (counting) {
			 time = (System.currentTimeMillis() - startTime);
		}
		else {
			time = (stopTime - startTime);
		}
		return time;
	}
    
    void setmatrix()
    {
        row = 9; column = 9;
        matrix = new int [row] [column];
    }
    
    void printmatrix()
    {
        int i,j;
        System.out.println("----------------------");
        for(i = 0; i <= 8; i++)
        {
            for(j = 0; j<=8; j++)
            {
                System.out.print(matrix[i][j] + " ");
                if((j == 2) || (j == 5))
                {
                    System.out.print("| ");
                }
            }
            if((i==2) || (i==5) || (i==8))
            {
                System.out.println();
                System.out.print("----------------------");
            }
            System.out.println();
        }
    }
    
    void load()
    {
        Scanner cc;
        String ss;
        FileReader in;
        int i,j;
        setmatrix();
        System.out.print("Input the file (.txt) : ");
        String input = s.nextLine();
        
        try
        {
            in = new FileReader(input);
            cc = new Scanner(in);
        
            for(i = 0; i<=8; i++)
            {
                for(j=0; j<=8; j++)
                {
                    ss = cc.next();
                    matrix[i][j] = Integer.parseInt(ss);
                }
            }
            in.close();
        }
        catch(IOException e)
        {
            //do nothing
        }
    }

    boolean isRowValid(int i,int j)
    {
        int k = 0;
        boolean finished = false;
        while((k <= 8) && (!finished))
        {
            if((matrix[i][j] == matrix[k][j] ) && (k != i))
                finished = true;
            else
                k++;
        }
        return !finished;
    }
    
    boolean isColValid(int i,int j)
    {
        int k = 0;
        boolean finished = false;
        while((k <= 8) && (!finished))
        {
            if((matrix[i][j] == matrix[i][k] ) && (k != j))
                finished = true;
            else
                k++;
        }
        return !finished;
    }
    
    boolean isSquareValid(int i, int j)
    {
        boolean finished = false;
        int k,l;
        
        if(j <= 2)
        {
            if(i <= 2)
            {
                for(k = 0; k<= 2; k++)
                {
                    for(l = 0; l <= 2; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i > 2) && (i <= 5))
            {
                for(k = 3; k<= 5; k++)
                {
                    for(l = 0; l <= 2; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i > 6) && (i <= 8))
            {
                for(k = 6; k<= 8; k++)
                {
                    for(l = 0; l <= 2; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
        }
        else if((j > 2) && (j <= 5))
        {
            if(i <= 2)
            {
                for(k = 0; k<= 2; k++)
                {
                    for(l = 3; l<= 5; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i > 2) && (i <= 5))
            {
                for(k = 3; k<= 5; k++)
                {
                    for(l = 3; l<= 5; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i > 6) && (i <= 8))
            {
                for(k = 6; k<= 8; k++)
                {
                    for(l = 3; l<= 5; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
        }
        else if((j > 6) && (j <= 8))
        {
            if(i <= 2)
            {
                for(k = 0; k<= 2; k++)
                {
                    for(l = 6; l<= 8; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i > 2) && (i <= 5))
            {
                for(k = 3; k<= 5; k++)
                {
                    for(l = 6; l<= 8; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i > 6) && (i <= 8))
            {
                for(k = 6; k<= 8; k++)
                {
                    for(l = 6; l<= 8; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
        }
        return !finished;
    }
    
    boolean isHyperValid(int i, int j)
    {
        boolean finished = false;
        int k,l;
        
        if((j >= 1) && (j <= 3))
        {
            if((i >= 1) && (i <= 3))
            {
                for(k = 1; k<= 3; k++)
                {
                    for(l = 1; l<= 3; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i >= 5) && (i <= 7))
            {
                for(k = 5; k<= 7; k++)
                {
                    for(l = 1; l<= 3; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
        }
        else if((j >= 5) && (j <= 7))
        {
            if((i >= 1) && (i <= 3))
            {
                for(k = 1; k<= 3; k++)
                {
                    for(l = 5; l <= 7; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
            else if((i >= 5) && (i <= 7))
            {
                for(k = 5; k<= 7; k++)
                {
                    for(l = 5; l <= 7; l++)
                    {
                        if((matrix[i][j]==matrix[k][l])&&(k!=i)&&(l!=j))
                        {
                            finished = true;
                            break;
                        }
                    }
                }
            }
        }
        return !finished;
    }
    
    void solver()
    {
        int counter = 0;
        int i,j;
        int k = 0;
        boolean finished;
        int assign_counter = 0;
        //Stopwatch S = new Stopwatch();
        
        for(i = 0; i<= 8; i++)
        {
            for(j = 0; j<= 8; j++)
            {
                if(matrix[i][j] == 0)
                    counter++;
            }
        }
        tabrow = new int[counter];  tabcol = new int[counter];
        
        for(i = 0; i<= 8; i++)
        {
            for(j = 0; j<= 8; j++)
            {
                if(matrix[i][j] == 0)
                {
                  tabcol[k] = j;    tabrow[k] = i;
                  k++;
                }
            }
        }
        
        k = 0;
        start();
        while(k <= counter-1)
        {
            matrix[tabrow[k]][tabcol[k]] = 1;       assign_counter++;
            while((!isHyperValid(tabrow[k],tabcol[k])) || 
            (!isSquareValid(tabrow[k],tabcol[k])) || 
            (!isRowValid(tabrow[k],tabcol[k])) || 
            (!isColValid(tabrow[k],tabcol[k])))
            {
                matrix[tabrow[k]][tabcol[k]] += 1;
                assign_counter++ ;
            }

            if(matrix[tabrow[k]][tabcol[k]] > 9) // no solution
            {
                finished = false;
                while(!finished)
                {
                    matrix[tabrow[k]][tabcol[k]] = 0; 
                    assign_counter++;
                    k--;
                    
                    do
                    {
                           matrix[tabrow[k]][tabcol[k]] += 1;
                           assign_counter++;
                    }
                    while((!isHyperValid(tabrow[k],tabcol[k])) || 
                    (!isSquareValid(tabrow[k],tabcol[k])) || 
                    (!isRowValid(tabrow[k],tabcol[k])) || 
                    (!isColValid(tabrow[k],tabcol[k])));
                    
                    if(matrix[tabrow[k]][tabcol[k]] <= 9)
                    {
                        finished = true;
                    }
                }
            }
            k++;
        }
        stop();
        printmatrix();
   System.out.println("Total Assignment = " + assign_counter + " time(s)");
   System.out.println("Execute Time = " + ResultTime() + "ms");
    }
}
