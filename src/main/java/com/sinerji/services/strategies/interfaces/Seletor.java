package com.sinerji.services.strategies.interfaces;

import java.util.List;
import com.sinerji.models.Funcionario;

public interface Seletor {
    Object selecionar(List<Funcionario> funcionarios, String data);
}