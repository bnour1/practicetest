package com.sinerji.services.strategies.helpers;

import java.util.HashMap;

import com.sinerji.models.Funcionario;
import com.sinerji.models.Vendedor;

public class CalcularTotalVendas {
        public static Double calcular(Funcionario funcionario, String data) {
        Vendedor vendedor = (Vendedor) funcionario;
        HashMap<String, Double> vendas = vendedor.getVendas();
        double totalVendas = 0.0;
        for (Double valorVenda : vendas.values()) {
            totalVendas += valorVenda;
        }
        return totalVendas;
    }
}
