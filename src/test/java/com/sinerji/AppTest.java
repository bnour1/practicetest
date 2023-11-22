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
        this.funcionarios.add(new Funcionario("Jorge Carvalho", secretario, "01/2018"));
        this.funcionarios.add(new Funcionario("Maria Souza", secretario, "12/2015"));
        this.funcionarios.add(new Funcionario("Ana Silva", vendedor, "12/2021"));
        this.funcionarios.add(new Funcionario("João Mendes ", vendedor, "12/2021"));
        this.funcionarios.add(new Funcionario("Juliana Alves", gerente, "07/2017"));
        this.funcionarios.add(new Funcionario("Bento Albino", gerente, "03/2014"));
    }

    @Test
    public void calcularFolhaTotalTest() {
        double expected = 44000.00;
        double result = CalculadoraFolha.calcularFolhaTotal(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }

    @Test
    public void calcularFolhaTotalSemBeneficioTest() {
        double expected = 39000.00;
        double result = CalculadoraFolha.calcularFolhaTotalSemBeneficio(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }

    @Test
    public void obterMaiorSalarioMes() {
        Funcionario expected = this.funcionarios.get(5);
        Funcionario result = CalculadoraFolha.obterFuncionarioComMaiorSalarioMes(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }
    
}
