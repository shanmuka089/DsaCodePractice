package org.example.recursion;

public class Fibonacie
{
    
    public static void printFibonacieNumbers(int n) {
        System.out.println(printParticularFibonacieNum(n));
    }
    
    public static int printParticularFibonacieNum(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        
        int firstFibNum = printParticularFibonacieNum(n - 1);
        int secondFibNum = printParticularFibonacieNum(n - 2);
        int fibNum = firstFibNum + secondFibNum;
        return fibNum;
    }
    
    public static void printAllFibonacie(int x, int y, int limit) {
        if(limit == 0) return;
        int res = x + y;
        System.out.println(x);
        printAllFibonacie(y, res, limit-1);
    }
}
