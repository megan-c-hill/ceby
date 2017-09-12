package com.company;

import java.util.ArrayList;
/*
    This program generates the first 10 cebysev polynomials
 */
public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Polynomial> ceby = new ArrayList<Polynomial>();

        ArrayList<Term> term1 = new ArrayList<Term>();
        Term t1 = new Term(1,0);
        term1.add(t1);
        Polynomial a = new Polynomial(term1);
        ceby.add(a);

        ArrayList<Term> term2 = new ArrayList<Term>();
        Term t2 = new Term(1,1);
        term2.add(t2);
        Polynomial b = new Polynomial(term2);
        ceby.add(b);

        for (int count = 2; count < 10; count++){
            Polynomial Tn = ceby.get(count - 1);
            Polynomial Tnminus1 = ceby.get(count - 2);
            Polynomial Tnplus1;
            Term twoX = new Term(2,1);
            Polynomial intermediate = Tn.distribute(twoX);
            Tnplus1 = intermediate.subtract(Tnminus1);

            ceby.add(Tnplus1);
        }

        for(Polynomial p : ceby){
            System.out.println(p.toString());
        }


    }
}
