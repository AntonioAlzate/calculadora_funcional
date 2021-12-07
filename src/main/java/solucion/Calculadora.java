package solucion;

import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculadora {

    public static void main(String[] args) {

        int numero1 = 10, numero2 = 2;

        System.out.println("Suma: " + sumar.apply(numero1, numero2));
        System.out.println("Resta: " + restar.apply(numero1, numero2));
        System.out.println("Multiplicación: " + multiplicar.apply(numero1, numero2));
        System.out.println("División: " + dividir.apply(numero1, numero2));
    }

    // Suma
    private static BiFunction<Integer, Integer, Integer> sumar = (numero1, numero2) -> numero1 + numero2;

    // Resta
    private static BiFunction<Integer, Integer, Integer> restar = (numero1, numero2) -> numero1 - numero2;

    // Multiplicación
    private static BiFunction<Integer, Integer, Integer> multiplicar = (numero1, numero2) -> {
        return IntStream.range(0, numero2 + 1)
                .reduce((acumulador, numero) ->  sumar.apply(acumulador, numero1))
                .getAsInt();
    };

    /* División
     * n1 / n2 = r --> r x n2 = n1
     * */
    private static BiFunction<Integer, Integer, Integer> dividir = (numerador, denominador) -> {
        return IntStream.range(0, denominador > numerador ? denominador + 1 : numerador + 1)
                .reduce((acumulador, numero) ->
                        multiplicar.apply(numero, denominador) <= numerador ? acumulador + 1 : acumulador
                ).getAsInt();
    };
}
