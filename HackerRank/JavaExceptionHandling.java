import java.io.*;
import java.util.*;   

public class JavaExceptionHandling {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        Integer x;
        Integer y;

        try{
            x = scanner.nextInt();
            y = scanner.nextInt();
            
            if( y == 0 ){
                throw new ArithmeticException("/ by zero");
            }
            
            System.out.println( x / y );

        } catch(ArithmeticException e) {
            System.out.println( e.fillInStackTrace() );
        } catch(InputMismatchException e) {
            System.out.println("java.util.InputMismatchException" );
        }
    }
    

}
