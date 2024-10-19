package round__2_Cpaste.jan2024.svblog.the100;
//
//public class pattern_xo {
//    public static void main(String[] args) {
//        printPattern(3, 3);
//        System.out.println();
//        printPattern(4, 5);
//        System.out.println();
//        printPattern(6, 7);
//    }
//
//    public static void printPattern(int N, int M) {
//        int centerX = N / 2;
//        int centerY = M / 2;
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (i == 0 || i == N - 1 || j == 0 || j == M - 1 || (N % 2 == 0 && M % 2 == 0 && i == centerX - 1 && j == centerY - 1)) {
//                    System.out.print("X ");
//                } else {
//                    System.out.print("0 ");
//                }
//            }
//            System.out.println();
//        }
//    }
//}

import java.util.Scanner;
/**
 *
 * @author JACK
 * 10-OCT-2015
 * Start 12:50AM
 * Finish 03:03AM
 */
public class pattern_xo//Matrix_XO2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the Row size: ");
        int row = in.nextInt();
        
        System.out.println("Enter the column size: ");
        int col = in.nextInt();
        
        char[][] matrix = new char[row][col];
   
        int top  = 0;
        int down = row-1;
        int left = 0;
        int right= col-1;
        
        char c;
        int test=0;//by lax
        while(true)
        {
            test++;
            if(top % 2 == 0)
                c = 'X';
            else
                c = 'O';
            //print first row
            for(int i=left;i<=right;++i) 
                matrix[top][i] = c;
            top++;
     
            if(top>down || left>right) 
                break;
            //print last column
            for(int i=top;i<=down;++i) 
                matrix[i][right] = c;
            right--;
     
            if(top>down || left>right)
                break;
            //print last row
            for(int i=right;i>=left;--i)
                matrix[down][i] = c;
            down--;
     
            if(top>down || left>right)
                break;
            //print first column
            for(int i=down;i>=top;--i) 
                matrix[i][left] = c;
            left++;
            
            if(top>down || left>right) 
                break;
        }
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
        System.out.println(test);
    }
}