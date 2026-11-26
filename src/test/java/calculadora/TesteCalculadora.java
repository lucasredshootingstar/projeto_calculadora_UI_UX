package calculadora;

/** Testes unitários executáveis sem dependências externas. */
public class TesteCalculadora {
    private final Calculadora calculadora = new Calculadora();
    private void verificar(int a, int b, String op, double esperado) {
        double obtido = calculadora.calc(a, b, op);
        System.out.printf("%d %s %d | esperado: %s | obtido: %s%n", a, op, b, esperado, obtido);
        if (Double.compare(esperado, obtido) != 0) throw new AssertionError("Resultado incorreto");
    }
    private void verificarErro(int a, int b, String op, Class<? extends RuntimeException> tipo, String esperado) {
        try {
            calculadora.calc(a, b, op);
            throw new AssertionError("Exceção não lançada");
        } catch (RuntimeException e) {
            System.out.printf("%d %s %d | esperado: %s | obtido: %s%n", a, op, b, esperado, e.getMessage());
            if (!tipo.isInstance(e) || !esperado.equals(e.getMessage())) throw new AssertionError("Erro incorreto", e);
        }
    }
    public void soma() { verificar(10, 5, "+", 15); }
    public void subtracao() { verificar(10, 5, "-", 5); }
    public void multiplicacao() { verificar(10, 5, "*", 50); }
    public void divisao() { verificar(10, 4, "/", 2.5); }
    public void divisaoPorZero() { verificarErro(10, 0, "/", ArithmeticException.class, "Não é possível dividir por zero."); }
    public void operacaoInvalida() { verificarErro(10, 5, "%", IllegalArgumentException.class, "Operação inválida."); }
    public static void main(String[] args) {
        TesteCalculadora teste = new TesteCalculadora();
        teste.soma();
        teste.subtracao();
        teste.multiplicacao();
        teste.divisao();
        teste.divisaoPorZero();
        teste.operacaoInvalida();
        System.out.println("6 testes aprovados.");
    }
}
