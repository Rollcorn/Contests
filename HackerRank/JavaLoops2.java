import java.util.*;
import java.io.*;

/**
 *  We use the integers a, b, and  to create the following series:
 * 
 *  (a + 2^0*b), (a + 2^0*b + 2^1*b), ... , (a + 2^0*b + 2^1*b +...+2^n-1*b)
 *  
 *  You are given q queries in the form of a, b, and n. For each query, print 
 * the series corresponding to the given a, b, and n values as a single line 
 * of  space-separated integers.
 * 
 *  Input Format
 * 
 *  The first line contains an integer, q, denoting the number of queries.
 * 
 *  Each line i of the q subsequent lines contains three space-separated 
 * integers describing the respective ai, bi, and ni values for that query.
 * 
 *  Constraints
 * 
 *  0 <= q <= 500
 *  0 <= a,b <= 50
 *  0 <= n <= 15
 * 
 *  Output Format
 * 
 *  For each query, print the corresponding series on a new line. Each series 
 * must be printed in order as a single line of  space-separated integers.
 * 
 * */

class JavaLoops2{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        
        int t=in.nextInt();

        for( int i=0; i<t; i++ ){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            // Выводит рассчитаныне числа
            for ( int j = 0; j < n; j++ ) {
                int res = 1;
                int sqr2 = 1;
                // Рассчитывает 
                for( int k = 0; k <= j; k++ ){
                    if (k != 0) {
                        sqr2 *= 2;
                        res += sqr2;
                    }
                }
                res = b*res + a; 

                System.out.print(res + " ");
            }
            System.out.println();

        }
        in.close();
    }
}