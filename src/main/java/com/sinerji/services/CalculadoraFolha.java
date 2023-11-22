package com.sinerji.services;

import java.util.List;

import java.util.Calendar;
import com.sinerji.entities.Funcionario;
import java.util.Date;

public class CalculadoraFolha {

    String dataFinal;

    private static Double calcularSalarioComReajuste(Funcionario funcionario, String data) {
        Double total = funcionario.getCargo().getSalario();
        Date inicio = DateStringParser.parseStringToDate(funcionario.getInicio());
        Date escolhida = DateStringParser.parseStringToDate(data);

        if (inicio == null || escolhida == null) {
            throw new RuntimeException("Formato de data inválido");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inicio);

        while (calendar.getTime().before(escolhida)) {
            total = total + funcionario.getCargo().getReajuste();
            calendar.add(Calendar.YEAR, 1);
        }

        return total;
    }

    /*
     * Um método que receba uma lista de funcionários, mês e ano e retorne o valor
     * total pago (salário e benefício) a esses funcionários no mês.
     */
    public static Double calcularFolhaTotal(List<Funcionario> funcionarios, String data) {
        Double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            double salario = calcularSalarioComReajuste((Funcionario) funcionario, data);
            total += (salario + (salario * funcionario.getCargo().getBeneficioDecimal()));
        }
        return total;
    }

    /*
     * Um método que receba uma lista de funcionários, mês e ano e retorne o total
     * pago somente em salários no mês.
     */
    public static Double calcularFolhaTotalSemBeneficio(List<Funcionario> funcionarios, String data) {
        Double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            double salario = calcularSalarioComReajuste((Funcionario) funcionario, data);
            total += salario;
        }
        return total;
    }

    /*
     * Um método que receba uma lista de funcionários, mês e ano e retorne o que
     * recebeu o valor mais alto no mês.
     */
    public static Funcionario obterFuncionarioComMaiorSalarioMes(List<Funcionario> funcionarios, String dataEscolhida) {
        Double maiorSalario = Double.MIN_VALUE;
        Funcionario funcionarioComMaiorSalario = null;

        for (Funcionario funcionario : funcionarios) {
            Double salario = calcularSalarioComReajuste(funcionario, dataEscolhida);

            if (salario > maiorSalario) {
                maiorSalario = salario;
                funcionarioComMaiorSalario = funcionario;
            }
        }

        return funcionarioComMaiorSalario;
    }

}
