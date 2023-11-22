package com.sinerji.services.strategies;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.services.strategies.helpers.CalcularSalarioComReajuste;
import com.sinerji.services.strategies.interfaces.Calculadora;

public class TotalSalariosStrategy implements Calculadora {

    public TotalSalariosStrategy(){
    }

    /*
     * Um método que receba uma lista de funcionários, mês e ano e retorne o total
     * pago somente em salários no mês.
     */
    @Override
    public Double calcular(List<Funcionario> funcionarios, String data) {
        Double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            double salario = CalcularSalarioComReajuste.calcular((Funcionario) funcionario, data);
            total += salario;
        }
        return total;
    }
}
