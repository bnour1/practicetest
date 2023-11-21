package com.sinerji.services;

import java.util.List;

import java.util.Calendar;
import com.sinerji.entities.Funcionario;
import java.util.Date;

public class CalculadoraFolha {

    String dataFinal;

    private static Double aplicarReajusteMensal(Funcionario funcionario, String data) {
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

        return total + (total * funcionario.getCargo().getBeneficioDecimal());
    }

    public static Double calcularFolhaTotal(List<Funcionario> funcionarios, String data) {
        Double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            total += aplicarReajusteMensal((Funcionario) funcionario, data);
        }
        return total;
    }

}
