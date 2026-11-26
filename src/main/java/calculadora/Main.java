package calculadora;

import java.util.Scanner;

/** Interface do terminal da calculadora.
 * @author Lucas Torres
 * @version 1.0
 */
public class Main {
        /**
     * Cria uma instância da classe principal. Tive erro a primeira vez e pedi ajuda externa.
     */
    public Main() {
    }
    /** Inicia a interface
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("===== CALCULADORA FINANÇAPP =====");
            while (true) {
                System.out.println("Digite o primeiro número (ou sair):");
                if (!entrada.hasNextLine()) break;
                String texto = entrada.nextLine().trim();
                if (texto.equalsIgnoreCase("sair")) break;
                try {
                    int a = Integer.parseInt(texto);
                    System.out.println("Digite a operação (+, -, *, /):");
                    if (!entrada.hasNextLine()) break;
                    String op = entrada.nextLine().trim();
                    System.out.println("Digite o segundo número:");
                    if (!entrada.hasNextLine()) break;
                    int b = Integer.parseInt(entrada.nextLine().trim());
                    System.out.println("Resultado: " + calculadora.calc(a, b, op));
                } catch (NumberFormatException e) {
                    System.out.println("Erro: informe números inteiros válidos.");
                } catch (ArithmeticException | IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
    }
}
