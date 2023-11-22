package com.sinerji;
import com.sinerji.entities.Vendedor;
import com.sinerji.entities.Cargo;
import java.util.HashMap;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Cargo vendedor = new Cargo("Vendedor", 12000.0, 1000.0, 0.20);
        Vendedor v = new Vendedor("João", vendedor, "10/09/2003");
        v.inserirVendas("11/2023", 10000.0);
        HashMap<String, Double> vendas = v.getVendas();
        Double result = vendas.get("11/2023");
        System.out.println(result);
    }
}
