package com.sinerji.services.strategies;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.services.strategies.helpers.CalcularSalarioComReajuste;
import com.sinerji.services.strategies.interfaces.Calculadora;

public class TotalBeneficiosStrategy implements Calculadora {

    public TotalBeneficiosStrategy(){
    }

    /*
     * Um método que receba uma lista de funcionários, mês e ano e retorne o total
     * pago somente em benefícios no mês.
     */
    @Override
    public Double calcular(List<Funcionario> funcionarios, String data) {
        Double totalBeneficios = 0.0;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().getBeneficioDecimal() > 0) {
                Double salario = CalcularSalarioComReajuste.calcular(funcionario, data);
                totalBeneficios += salario * funcionario.getCargo().getBeneficioDecimal();
            }
        }

        return totalBeneficios;
    }
}
