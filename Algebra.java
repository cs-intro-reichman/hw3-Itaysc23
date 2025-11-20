// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		}


	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2>0){
			for (int i = 0 ; i<x2 ; i++){
			x1++; // increment x1 by +1, x2 times
			}
		} else if (x2<0){
			for (int i = 0 ; i<-x2 ; i++){
				x1--; // increment x1 by -1, x2 times	
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2>0){
			for (int i = 0 ; i<x2 ; i++){
				x1--; // increment x1 by +1, x2 times
			}
		} else if (x2<0){
			for (int i = 0 ; i<-x2 ; i++){
				x1++; // increment x1 by -1, x2 times 
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
        return 0;
    }
    boolean resultIsNegative = (x1 < 0) ^ (x2 < 0);
    
    int absX1 = x1 < 0 ? minus(0, x1) : x1;
    int absX2 = x2 < 0 ? minus(0, x2) : x2;

    int smallerAbs = absX1 < absX2 ? absX1 : absX2;
    int largerAbs = absX1 < absX2 ? absX2 : absX1;
    
    int resultAbs = 0;
    
    for (int i = 0; i < smallerAbs; i++) {
        resultAbs = plus(resultAbs, largerAbs);
    }
    
    if (resultIsNegative) {
        return minus(0, resultAbs);
    } else {
        return resultAbs;
    }
}
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n==0){
			return 1; //exception for n=0
		}
		int pow = x;
		for (int i = 1 ; i<n ; i++){
			pow = times(pow,x); //multiply x by x, n times
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
public static int div(int x1, int x2) {
    int quotient = 0; 
    int tempX1 = x1;
    int tempX2 = x2;

    if (x2 == 0) { 
        return -1; // טיפול בחלוקה באפס
    }
    boolean resultIsNegative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);

    if (tempX1 < 0) {
        tempX1 = times(x1, -1); 
    }
    if (tempX2 < 0) {
        tempX2 = times(x2, -1); 
    }

    if (tempX1 < tempX2) { 
        return 0; 
    } // *** תיקון: הוספת סוגר סוגר חסר ***
    
    while (tempX1 >= tempX2) {
        tempX1 = minus(tempX1, tempX2); 
        quotient++; 
    }                     
    if (resultIsNegative) {
        return times(quotient, -1);
    } else {
        return quotient;
    }
}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) { 
        return -1; 
    }
    
    int dividend = x1;
    int divisor = x2;
    
    if (dividend < 0) {
        dividend = minus(0, dividend); 
    }
    if (divisor < 0) {
        divisor = minus(0, divisor); 
    }
    
    if (dividend < divisor) {
    } else {
        while (dividend >= divisor) {
            dividend = minus(dividend, divisor);
        }
    }
    
    if (x1 < 0) {
        return minus(0, dividend);
    } else {
        return dividend;
    }
}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int g = 1;
		if (x==0){     // exception for 0
			return 0;
		} else if (x<0){ // exception for negatives
			return -1;
		} else {
			while (times(g, g)<=x){
				g = plus(g, 1);
			}
		}
		return minus(g, 1);
	}
}

