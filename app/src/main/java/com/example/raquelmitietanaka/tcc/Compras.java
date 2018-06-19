package com.example.raquelmitietanaka.tcc;


public class Compras {

    private String name;
    private double valor;
    private int qtd;

    public Compras(String name, double valor, int qtd){
        this.name = name;
        this.valor = valor;
        this.qtd = qtd;
    }

    public String getName() {
        return name;
    }

    public double getValor() {
        return valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void incrementQtd() {

        qtd++;
    }
}
