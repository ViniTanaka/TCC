package com.example.raquelmitietanaka.tcc;


import android.graphics.Bitmap;

public class Compras {

    private String name;
    private double valor;
    private int qtd;

    public Compras( String name, double valor, int qtd){
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


    public void setName(String name){
        this.name = name;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

}
