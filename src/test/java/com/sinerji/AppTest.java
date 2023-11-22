package com.sinerji;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sinerji.models.Cargo;
import com.sinerji.models.Funcionario;
import com.sinerji.models.Gerente;
import com.sinerji.models.Secretario;
import com.sinerji.models.Vendedor;
import com.sinerji.services.CalculadorValor;
import com.sinerji.services.SeletorFuncionario;
import com.sinerji.services.strategies.MaiorBeneficioStrategy;
import com.sinerji.services.strategies.MaiorRecebimentoStrategy;
import com.sinerji.services.strategies.MaiorVendedorStrategy;
import com.sinerji.services.strategies.TotalBeneficiosStrategy;
import com.sinerji.services.strategies.TotalPagoStrategy;
import com.sinerji.services.strategies.TotalSalariosStrategy;

public class AppTest {

    Cargo secretario, vendedor, gerente;
    ArrayList<Funcionario> funcionarios;
    CalculadorValor calculadoraFolha;
    SeletorFuncionario seletorFuncionario;

    @BeforeEach
    public void setUp() {

        //Instancia de cargos
        secretario = new Cargo("Secretario", 7000.00, 1000.00, 0.2);
        vendedor = new Cargo("Vendedor", 12000.00, 1800.00, 0.3);
        gerente = new Cargo("Gerente", 20000.00, 3000.00, 0);

        this.funcionarios = new ArrayList<Funcionario>();

        //Lista de Funcionarios
        this.funcionarios.add(new Secretario("Jorge Carvalho", secretario, "01/2018"));
        this.funcionarios.add(new Secretario("Maria Souza", secretario, "12/2015"));
        this.funcionarios.add(new Vendedor("Ana Silva", vendedor, "12/2021"));
        this.funcionarios.add(new Vendedor("João Mendes ", vendedor, "12/2021"));
        this.funcionarios.add(new Gerente("Juliana Alves", gerente, "07/2017"));
        this.funcionarios.add(new Gerente("Bento Albino", gerente, "03/2014"));

        //Tabela de vendas
        Vendedor v1 = (Vendedor) this.funcionarios.get(2);
        Vendedor v2 = (Vendedor) this.funcionarios.get(3);

        //Inserindo Registro de vendas
        v1.inserirVendas("12/2021", 5200.00);
        v2.inserirVendas("12/2021", 3400.00);
        v1.inserirVendas("01/2022", 4000.00);
        v2.inserirVendas("01/2022", 7700.00);
        v1.inserirVendas("02/2022", 4200.00);
        v2.inserirVendas("02/2022", 5000.00);
        v1.inserirVendas("03/2022", 5850.00);
        v2.inserirVendas("03/2022", 5900.00);
        v1.inserirVendas("04/2022", 7000.00);
        v2.inserirVendas("04/2022", 6500.00);

        calculadoraFolha = new CalculadorValor();
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

    @Test
    //teste para o metodo 5
    public void obterFuncionarioComMaiorBeneficioMesTest(){
        String expected = this.funcionarios.get(4).getNome();
        seletorFuncionario.setSeletorStrategy(new MaiorBeneficioStrategy());
        Funcionario result = (Funcionario) seletorFuncionario.selecionar(this.funcionarios, "11/2023");
        assertEquals(expected, result);
    }

    @Test
    //teste para o metodo 6
    public void obterFuncionarioMaiorVendedorMesTest(){
        Funcionario expected = this.funcionarios.get(2);
        seletorFuncionario.setSeletorStrategy(new MaiorVendedorStrategy());
        Funcionario result = (Funcionario) seletorFuncionario.selecionar(this.funcionarios, "04/2022");
        assertEquals(expected, result);
    }

    
    
}
