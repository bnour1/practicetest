package com.sinerji.models;

public class Funcionario {
    String nome;
    Cargo cargo;
    String inicio;

    public Funcionario(String nome, Cargo cargo, String dataInicio) {
        this.nome = nome;
        this.cargo = cargo;
        this.inicio = dataInicio;
    }

    public String getNome() {
        return nome;
    }

    public String getInicio(){
        return this.inicio;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
