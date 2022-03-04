import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/***
 * 
 * Objective
 * 
 * In this challenge, we're going to use loops to help us do some simple math.
 * 
 * Task
 * 
 * Given an integer, N , print its first 10 multiples. Each multiple 
 * N x i (where 2 < i <= 10 ) should be printed on a new line in the form: 
 * N x i = result.
 * 
 * Input Format
 * 
 * A single integer, N.
 * 
 * Constraints
 * 
 * 2 <= N <= 20
 * 
 * Output Format
 * Print 10 lines of output; each line i (where 1 <= i < =10 ) contains the 
 * of result of N x i in the form:
 * N x i = result.
 * 
 */


public class JavaLoops1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        for ( int i = 1; i <= 10; i++ ) {
            System.out.println( N + " x " + i + " = " + N*i );
        }


        bufferedReader.close();
    }
}
