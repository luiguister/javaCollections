package org.curso.interfaces;

public class ImplContract implements Contract{
    @Override
    public void term1() {
        System.out.println("impl: term1");
    }

    @Override
    public void term2() {
        System.out.println("impl: term2");
    }

    @Override
    public void extendedTerm() {
        System.out.println("impl: extendedContract");
    }
}
