package com.sinerji.models;

public class Cargo {
    String nome;
    double salario;
    double reajuste;
    double beneficioDecimal;


    public Cargo(String nome, double salario, double reajuste, double beneficioDecimal) {
        this.nome = nome;
        this.salario = salario;
        this.reajuste = reajuste;
        this.beneficioDecimal = beneficioDecimal;
    }


    public String getNome() {
        return this.nome;
    }


    public double getSalario() {
        return this.salario;
    }


    public double getReajuste() {
        return this.reajuste;
    }


    public double getBeneficioDecimal() {
        return this.beneficioDecimal;
    }


    

}
