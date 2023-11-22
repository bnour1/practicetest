package com.sinerji.services.strategies;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.services.strategies.helpers.CalcularSalarioComReajuste;
import com.sinerji.services.strategies.interfaces.Seletor;

public class MaiorRecebimentoStrategy implements Seletor {

    public MaiorRecebimentoStrategy() {
    }

    /*
     * Um método que receba uma lista de funcionários, mês e ano e retorne o que
     * recebeu o valor mais alto no mês.
     */

    @Override
    public Object selecionar(List<Funcionario> funcionarios, String dataEscolhida) {
        Double maiorSalario = Double.MIN_VALUE;
        Funcionario funcionarioComMaiorSalario = null;

        for (Funcionario funcionario : funcionarios) {
            Double salario = CalcularSalarioComReajuste.calcular(funcionario, dataEscolhida);

            if (salario > maiorSalario) {
                maiorSalario = salario;
                funcionarioComMaiorSalario = funcionario;
            }
        }

        return funcionarioComMaiorSalario;
    }
}
