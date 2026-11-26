
package calculadora;

/**
 * Classe responsável pelas operações matemáticas básicas
 * do sistema FinançApp(nome temporario).
 *
 * @author Lucas Torres Fernandes
 * @version 2.0
 */
public class Calculadora {

    /**
     * Cria uma nova instância da calculadora.
     */
    public Calculadora() {
    }

    /**
     * Realiza uma operação matemática entre dois números inteiros.
     *
     * @param a primeiro número da operação
     * @param b segundo número da operação
     * @param op operador matemático (+, -, *, /)
     * @return resultado da operação matemática
     * @throws ArithmeticException se ocorrer divisão por zero
     * @throws IllegalArgumentException se a operação for inválida
     */
    public double calc(int a, int b, String op) {

        // Verifica se a operação é nula.
        if (op == null) {
            throw new IllegalArgumentException("Operação inválida.");
        }

        // O switch centraliza a seleção da operação.
        return switch (op) {
            case "+" -> (double) a + b;
            case "-" -> (double) a - b;
            case "*" -> (double) a * b;
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException(
                "Operação inválida."
            );
        };
    }

    /**
     * Valida o divisor antes de realizar a divisão.
     *
     * @param dividendo número a dividir
     * @param divisor número pelo qual dividir
     * @return resultado da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    private double dividir(int dividendo, int divisor) {

        // Impede a divisão por zero.
        if (divisor == 0) {
            throw new ArithmeticException(
                "Não é possível dividir por zero."
            );
        }

        return (double) dividendo / divisor;
    }
}
