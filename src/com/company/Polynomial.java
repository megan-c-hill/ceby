package com.company;

import java.util.ArrayList;

/**
 * Created by megansISU on 9/11/17.
 */
public class Polynomial {
    private ArrayList<Term> polynomial = new ArrayList<>();

    public Polynomial (ArrayList<Term> polynomial){
        this.polynomial = polynomial;
    }

    public Polynomial (){

    }

    public ArrayList<Term> getPolynomial(){
        return polynomial;
    }

    public String toString(){
        String result = "";

        for(int count = 0; count < polynomial.size(); count++){
            Term t = polynomial.get(count);
            if (t.getCoefficient() >= 1  && count != 0){
                result += " + " + t.toString();
            }
            else if (t.getCoefficient() <= -1){
                result += t.toString();
            }
            else{
                result += t.toString();
            }

        }
        return result;
    }

    /**
     * Distributes a single term across a polynomial
     * @param t the term that will be distributed, usually 2x
     * @return the polynomial that is the result of this multiplication
     */
    public Polynomial distribute(Term t){
        ArrayList<Term> newPolynomial = new ArrayList<>();
        for(Term term : polynomial){
            Term newTerm = term.multiply(t);
            newPolynomial.add(newTerm);
        }
        return new Polynomial(newPolynomial);
    }

    /**
     * Subtracts the given poly from this polynomial
     * @param poly the given polynomial which is the one subtracted
     * @return the result of the polynomial subtraction
     */
    public Polynomial subtract(Polynomial poly){
        ArrayList<Term> newPoly = new ArrayList<>();
        boolean[] term2Used = new boolean[poly.getPolynomial().size()];
        boolean Term1Used = false;

        for(int i = 0; i<term2Used.length; i++){
            term2Used[i] = false;
        }

        for (Term term1 : polynomial){
            for (int count = 0; count < poly.getPolynomial().size(); count ++){
                Term term2 = poly.getPolynomial().get(count);
                if(term1.getExponent() == term2.getExponent()){
                    Term1Used = true;
                    term2Used[count] = true;
                    int newCoeff = term1.getCoefficient()-term2.getCoefficient();
                    Term t = new Term(newCoeff, term1.getExponent());
                    newPoly.add(t);
                }
            }
            if (!Term1Used){
                newPoly.add(term1);
            }

        }
        Term negOne = new Term (-1,0);
        for(int i = 0; i<term2Used.length; i++){
            if(!term2Used[i]){
                Term term2 = poly.getPolynomial().get(i);
                Term negativeTerm = new Term();
                negativeTerm = term2.multiply(negOne);
                newPoly.add(negativeTerm);
            }
        }
        return new Polynomial(newPoly);
    }
}
