package com.sinerji;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sinerji.services.CalculadoraFolha;
import com.sinerji.entities.Cargo;
import com.sinerji.entities.Funcionario;

public class AppTest {

    Cargo secretario, vendedor, gerente;
    ArrayList<Funcionario> funcionarios;

    @BeforeEach
    public void setUp() {
        secretario = new Cargo("Secretario", 7000.00, 1000.00, 0.2);
        vendedor = new Cargo("Vendedor", 12000.00, 1800.00, 0.3);
        gerente = new Cargo("Gerente", 20000.00, 3000.00, 0);
        this.funcionarios = new ArrayList<Funcionario>();
    }

    @Test
    public void calcularFolhaTotalTest() {
        double expected = 44000.00;
        Funcionario f1 = new Funcionario("João", secretario, "09/2003");
        Funcionario f2 = new Funcionario("Maria", vendedor, "09/2003");
        Funcionario f3 = new Funcionario("Pedro", gerente, "09/2003");
        this.funcionarios.add(f1);
        this.funcionarios.add(f2);
        this.funcionarios.add(f3);
        double result = CalculadoraFolha.calcularFolhaTotal(this.funcionarios, "09/2023");
        assertEquals(expected, result);
    }
    
}
