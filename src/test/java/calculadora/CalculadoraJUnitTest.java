package calculadora;
import org.junit.jupiter.api.Test;
class CalculadoraJUnitTest {
    private final TesteCalculadora teste = new TesteCalculadora();
    @Test void soma() { teste.soma(); }
    @Test void subtracao() { teste.subtracao(); }
    @Test void multiplicacao() { teste.multiplicacao(); }
    @Test void divisao() { teste.divisao(); }
    @Test void divisaoPorZero() { teste.divisaoPorZero(); }
    @Test void operacaoInvalida() { teste.operacaoInvalida(); }
}
