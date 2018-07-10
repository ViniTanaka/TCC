package com.example.raquelmitietanaka.tcc;


import android.graphics.Bitmap;

public class Compras {

    private Bitmap imgBitmap;
    private String name;
    private double valor;
    private int qtd;

    public Compras(Bitmap imgBitmap, String name, double valor, int qtd){
        this.imgBitmap =imgBitmap;
        this.name = name;
        this.valor = valor;
        this.qtd = qtd;
    }

    public Bitmap getImgBitmap() {
        return imgBitmap;
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

    public void setImgBitmap(Bitmap imgBitmap){
        this.imgBitmap = imgBitmap;
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
