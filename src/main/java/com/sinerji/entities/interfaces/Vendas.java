package com.sinerji.entities.interfaces;
import java.util.HashMap;

public interface Vendas {
    HashMap<String, Double> getVendas();
    void inserirVendas(String date, Double valor);
}
