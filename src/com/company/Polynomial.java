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
}
