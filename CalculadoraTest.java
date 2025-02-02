import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void testCorroboraTexto() {
        assertEquals(0, calculadora.CorroboraTexto('5'));
        assertEquals(1, calculadora.CorroboraTexto(' '));
        assertEquals(2, calculadora.CorroboraTexto('+'));
        assertEquals(-1, calculadora.CorroboraTexto('x'));
    }

    @Test
    void testOperarSuma() {
        calculadora.vector.push(3);
        calculadora.vector.push(2);
        assertTrue(calculadora.Operar('+'));
        assertEquals(5, calculadora.vector.pop());
    }

    @Test
    void testOperarResta() {
        calculadora.vector.push(5);
        calculadora.vector.push(2);
        assertTrue(calculadora.Operar('-'));
        assertEquals(3, calculadora.vector.pop());
    }

    @Test
    void testOperarMultiplicacion() {
        calculadora.vector.push(3);
        calculadora.vector.push(4);
        assertTrue(calculadora.Operar('*'));
        assertEquals(12, calculadora.vector.pop());
    }

    @Test
    void testOperarDivision() {
        calculadora.vector.push(10);
        calculadora.vector.push(2);
        assertTrue(calculadora.Operar('/'));
        assertEquals(5, calculadora.vector.pop());
    }

    @Test
    void testOperarDivisionPorCero() {
        calculadora.vector.push(10);
        calculadora.vector.push(0);
        assertFalse(calculadora.Operar('/'));
    }

    @Test
    void testOperarFallaPorFaltaDeOperandos() {
        calculadora.vector.push(10);
        assertFalse(calculadora.Operar('+'));
    }

    @Test
    void testResultado() {
        assertEquals(7, calculadora.Resultado("3 4 +"));
        assertEquals(5, calculadora.Resultado("10 2 /"));
        assertEquals(-1, calculadora.Resultado("10 0 /"));
        assertEquals(-1, calculadora.Resultado("3 4 x"));
    }
}
