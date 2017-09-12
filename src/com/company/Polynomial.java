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

    public ArrayList<Term> getPolynomial(){
        return polynomial;
    }

    public String toString(){
        String result = "";
        for (Term t : polynomial){
            result += t.toString();
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
    //TODO: Make it so that it catches terms that don't share an exponent
    public Polynomial subtract(Polynomial poly){
        ArrayList<Term> newPoly = new ArrayList<>();
        for (Term term1 : polynomial){
            for (Term term2: poly.getPolynomial()){
                if(term1.getExponent() == term2.getExponent()){
                    int newCoeff = term1.getCoefficient()-term2.getCoefficient();
                    Term t = new Term(newCoeff, term1.getExponent());
                    newPoly.add(t);
                }
            }

        }
        return new Polynomial(newPoly);
    }
}
