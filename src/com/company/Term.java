package com.company;

/**
 * Created by megansISU on 9/11/17.
 */
public class Term {
    private int coefficient;
    private int exponent;

    public Term(int coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Term(){

    }

    public int getCoefficient(){
        return coefficient;
    }

    public int getExponent(){
        return exponent;
    }

    /**
     * Multiplies this term by the given term
     * @param t the given term
     * @return the result of the multiplication
     */
    public Term multiply (Term t){
        int newCoeff = t.getCoefficient() * this.getCoefficient();
        int newExp = t.getExponent() + this.getExponent();
        Term newTerm = new Term(newCoeff, newExp);
        return newTerm;
    }

    public String toString(){
        String result = "";

        if(this.getCoefficient() > 1) {
            result += this.getCoefficient();
        }
        else if (this.getCoefficient() < -1){
            result += " - " + this.getCoefficient() * -1;
        }
        else if(this.getExponent() == 0){
            if (this.getCoefficient() == -1) {
                result += " - " + this.getCoefficient() * -1;
            }
            else {
                result += this.getCoefficient();
            }
        }

        if (this.getExponent()!=0){
            result += "x";
            if(this.getExponent()!=1){
                result += "^" + this.getExponent();
            }
        }
        return result;
    }
}
