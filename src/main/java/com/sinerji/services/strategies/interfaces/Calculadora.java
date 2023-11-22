package com.sinerji.services.strategies.interfaces;

import java.util.List;
import com.sinerji.models.Funcionario;

public interface Calculadora {
    Double calcular(List<Funcionario> funcionarios, String data);
}
