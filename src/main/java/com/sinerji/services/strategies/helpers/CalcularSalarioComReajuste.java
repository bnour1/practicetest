package com.sinerji.services.strategies.helpers;

import java.util.Date;
import com.sinerji.models.Funcionario;

import java.util.Calendar;

public class CalcularSalarioComReajuste {

    public static Double calcular(Funcionario funcionario, String data) {
        Double total = funcionario.getCargo().getSalario();
        Date inicio = DateStringParser.parseStringToDate(funcionario.getInicio());
        Date escolhida = DateStringParser.parseStringToDate(data);

        if (inicio == null || escolhida == null) {
            throw new RuntimeException("Formato de data inválido");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inicio);

        calendar.add(Calendar.YEAR, 1);
        while (calendar.getTime().before(escolhida)) {
            total = total + funcionario.getCargo().getReajuste();
            calendar.add(Calendar.YEAR, 1);
        }

        return total;
    }

}