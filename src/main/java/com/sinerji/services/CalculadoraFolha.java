package com.sinerji.services;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.services.strategies.interfaces.Calculadora;

public class CalculadoraFolha {
    private Calculadora strategy;

    public void setCalculadoraStrategy(Calculadora calculadoraStrategy) {
        this.strategy = calculadoraStrategy;
    }

    public Double calcular(List<Funcionario> funcionarios, String data) {
        if (this.strategy == null) {
            throw new IllegalStateException("A estratégia de cálculo não foi definida.");
        }
        return this.strategy.calcular(funcionarios, data);
    }

}
