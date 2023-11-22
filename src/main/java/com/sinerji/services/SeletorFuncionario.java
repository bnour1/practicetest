package com.sinerji.services;

import java.util.List;

import com.sinerji.models.Funcionario;
import com.sinerji.services.strategies.interfaces.Seletor;

public class SeletorFuncionario {
    private Seletor strategy;

    public void setSeletorStrategy(Seletor seletorStrategy) {
        this.strategy = seletorStrategy;
    }

    public Object selecionar(List<Funcionario> funcionarios, String data) {
        if (this.strategy == null) {
            throw new IllegalStateException("A estratégia de cálculo não foi definida.");
        }
        return this.strategy.selecionar(funcionarios, data);
    }
}
