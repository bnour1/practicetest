package com.sinerji.services.strategies;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.models.Vendedor;
import com.sinerji.services.strategies.interfaces.Seletor;

public class MaiorVendedorStrategy implements Seletor {

    /*
     * Um método que receba uma lista de vendedores, mês e ano e retorne o que mais
     * vendeu no mês.
     */

    @Override
    public Object selecionar(List<Funcionario> vendedores, String data) {
        Funcionario maiorVendedor = null;
        Double maior = Double.MIN_VALUE;

        double vendas;
        for (Funcionario funcionario : vendedores) {
            if (funcionario instanceof Vendedor) {
                Vendedor vendedor = (Vendedor) funcionario;
                try {
                    vendas = vendedor.getVendas().get(data);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (vendas > maior) {
                    maior = vendas;
                    maiorVendedor = vendedor;
                }
            }
        }

        return maiorVendedor;
    }
}
