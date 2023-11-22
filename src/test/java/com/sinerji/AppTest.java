package com.sinerji;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sinerji.models.Cargo;
import com.sinerji.models.Funcionario;
import com.sinerji.services.CalculadoraFolha;
import com.sinerji.services.SeletorFuncionario;
import com.sinerji.services.strategies.MaiorBeneficioStrategy;
import com.sinerji.services.strategies.MaiorRecebimentoStrategy;
import com.sinerji.services.strategies.TotalBeneficiosStrategy;
import com.sinerji.services.strategies.TotalPagoStrategy;
import com.sinerji.services.strategies.TotalSalariosStrategy;

public class AppTest {

    Cargo secretario, vendedor, gerente;
    ArrayList<Funcionario> funcionarios;
    CalculadoraFolha calculadoraFolha;
    SeletorFuncionario seletorFuncionario;

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
        calculadoraFolha = new CalculadoraFolha();
        seletorFuncionario = new SeletorFuncionario();
    }


    //teste para o metodo 1
    @Test
    public void calcularFolhaTotalTest() {
        double expected = 44000.00;
        calculadoraFolha.setCalculadoraStrategy(new TotalPagoStrategy());
        double result = calculadoraFolha.calcular(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }

    //teste para o metodo 2
    @Test
    public void calcularFolhaTotalSemBeneficioTest() {
        double expected = 39000.00;
        calculadoraFolha.setCalculadoraStrategy(new TotalSalariosStrategy());
        double result = calculadoraFolha.calcular(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }

    //teste para o metodo 3
    @Test
    public void calcularTotalBeneficiosMesTest() {
        double expected = 39000.00;
        calculadoraFolha.setCalculadoraStrategy(new TotalBeneficiosStrategy());
        double result = calculadoraFolha.calcular(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }

    //teste para o metodo 4
    @Test
    public void obterMaiorRecebimentoMesTest() {
        Funcionario expected = this.funcionarios.get(5);
        seletorFuncionario.setSeletorStrategy(new MaiorRecebimentoStrategy());
        Funcionario result = (Funcionario) seletorFuncionario.selecionar(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }

    //teste para o metodo 5
    public void obterFuncionarioComMaiorBeneficioMesTest(){
        String expected = this.funcionarios.get(4).getNome();
        seletorFuncionario.setSeletorStrategy(new MaiorBeneficioStrategy());
        Funcionario result = (Funcionario) seletorFuncionario.selecionar(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }
    
}
