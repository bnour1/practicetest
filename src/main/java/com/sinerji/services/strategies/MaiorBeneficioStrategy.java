package com.sinerji.services.strategies;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.services.strategies.helpers.CalcularSalarioComReajuste;
import com.sinerji.services.strategies.interfaces.Seletor;

public class MaiorBeneficioStrategy implements Seletor{

    public MaiorBeneficioStrategy() {
    }

    @Override
    public Object selecionar(List<Funcionario> funcionarios, String data) {
        Double maiorBeneficio = Double.MIN_VALUE;
        String nomeFuncionarioMaiorBeneficio = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().getBeneficioDecimal() > 0) {
                Double salario = CalcularSalarioComReajuste.calcular(funcionario, data);
                Double beneficio = salario * funcionario.getCargo().getBeneficioDecimal();

                if (beneficio > maiorBeneficio) {
                    maiorBeneficio = beneficio;
                    nomeFuncionarioMaiorBeneficio = funcionario.getNome();
                }
            }
        }

        return nomeFuncionarioMaiorBeneficio;
    }
    
}
