/* Enzo Galbo
 * This is a program that calculates various probabilities based on
 * desired distribution type.
 * TODO:
 * Add continuous distribtuions and expected value/variance
 * add descriptions of when each dist should be used?
 * Restructure with Distribution object, probability/EV/var methods
 * changing based on type of object with polymorphism.
 * Encapsulation for protecting against bad data inputs,
 * currently unnecessary since only personal use.
 */
package probdists;

import java.util.Scanner;

public class ProbDists {

    public static void main(String[] args) {
        // Uncomment desired distribution type
        // discreteUniform();
        // binomial();
        // poisson();
        // geometric();
        // negativeBinomial();
        // hypergeometric();
    }
    
    //method to calculate factorial for future use
    public static int calculateFactorial(int n) {
        int factTotal = 1;
        for (int i = 1; i <= n; i++) {
            factTotal *= i;
        }
        return factTotal;
    }

    // methods used to calculate each distribution type
    
    public static void discreteUniform() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input A value.");
        double a = input.nextDouble();        
        System.out.println("Please input B value.");
        double b = input.nextDouble();
        
        double ans = (1/(b-a+1));
        System.out.println("The probability of x is " + ans);
}
    
    public static void binomial() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input n value.");
        int n = input.nextInt();
        System.out.println("Please input x value.");
        int x = input.nextInt();
        System.out.println("Please input p value.");
        double p = input.nextDouble();
        double q = 1-p;
        
        double ans;
        int combination;
        combination = ((calculateFactorial(n))/((calculateFactorial(x))*(calculateFactorial(n-x))));
        ans = combination*((Math.pow(p,(double)x))*(Math.pow(q, (double)n-x)));
        System.out.println("The probability of x = " + x + " is "  + ans);
    }
    
    public static void poisson() {
        Scanner input = new Scanner(System.in);
        System.out.println("please input e value.");
        int e = input.nextInt();
        System.out.println("Please input lamba.");
        int l = input.nextInt();
        System.out.println("Please input x value");
        int x = input.nextInt();
        
        double ans;
        ans = ((Math.pow(e,-l))*(Math.pow(l,x))/calculateFactorial(x));
        System.out.println("The probability of x is " + ans);
    }
    
    public static void geometric() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input p value.");
        double p = input.nextDouble();
        System.out.println("Please input x value.");
        int x = input.nextInt();
        double q = 1-p;
        
        double ans;
        ans = Math.pow(q,x-1)*p;
        System.out.println("The probability of x is " + ans);
    }
    
    public static void negativeBinomial() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input x value.");
        int x = input.nextInt();
        System.out.println("Please input k value.");
        int k = input.nextInt();
        System.out.println("Please input p value");
        double p = input.nextDouble();
        
        double q = 1-p;
        double ans;
        double combination;
        combination = ((calculateFactorial(x-1))/((calculateFactorial(k-1))*(calculateFactorial((x-1)-(k-1)))));
        ans = combination*(Math.pow(q, x-k))*Math.pow(p, k);
        System.out.println("The probability of x = " + k + " is " + ans);
    }
    
    public static void hypergeometric() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter M value.");
        int M = input.nextInt();
        System.out.println("Please input x value.");
        int x = input.nextInt();
        System.out.println("Please input N value.");
        int N = input.nextInt();
        System.out.println("Please input n value");
        int n = input.nextInt();
        
        double combination1;
        double combination2;
        double combination3;
        combination1 = ((calculateFactorial(M))/((calculateFactorial(M))*(calculateFactorial(M-x))));
        combination2 = ((calculateFactorial(N-M))/((calculateFactorial(n-x))*(calculateFactorial((N-M)-(n-x)))));
        combination3 = ((calculateFactorial(N))/((calculateFactorial(n))*(calculateFactorial(N-n))));
        double ans = (combination1*combination2)/combination3;
        System.out.println("The probability of x is " + ans);
    }
    
}
