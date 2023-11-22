package com.sinerji.models;

import java.util.HashMap;

import com.sinerji.models.interfaces.Vendas;

public class Vendedor extends Funcionario implements Vendas{
    HashMap<String, Double> vendas;

    public Vendedor(String nome, Cargo cargo, String inicio) {
        super(nome, cargo, inicio);
        this.vendas = new HashMap<String, Double>();
    }

    @Override
    public HashMap<String, Double> getVendas() {
        
        return this.vendas;
    }

    @Override
    public void inserirVendas(String date, Double valor) {
        this.vendas.put(date, valor);
    }
    
}
