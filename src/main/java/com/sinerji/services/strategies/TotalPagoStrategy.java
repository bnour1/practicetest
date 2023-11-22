package com.sinerji.services.strategies;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.services.strategies.helpers.CalcularSalarioComReajuste;
import com.sinerji.services.strategies.interfaces.Calculadora;

public class TotalPagoStrategy implements Calculadora {

    public TotalPagoStrategy() {
    }

    /*
     * Um método que receba uma lista de funcionários, mês e ano e retorne o valor
     * total pago (salário e benefício) a esses funcionários no mês.
     */

    @Override
    public Double calcular(List<Funcionario> funcionarios, String data) {
        Double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            double salario = CalcularSalarioComReajuste.calcular(funcionario, data);
            total += (salario + (salario * funcionario.getCargo().getBeneficioDecimal()));
        }
        return total;
    }
}
