import java.util.List;
import java.util.ArrayList;

public class Calculadora {
    private Stack<Integer> vector;
    private List<Character> operaciones;

    public Calculadora() {
        vector = new VectorStack<>();
        operaciones = new ArrayList<>();
        operaciones.add('+');
        operaciones.add('-');
        operaciones.add('*');
        operaciones.add('/');
        operaciones.add('%');
    }

    /**
     * Corrobora si el caracter es un digito, un espacio, una operacion valida o un caracter no valido.
     * @param caracter El caracter a verificar.
     * @return 0 si es un digito, 1 si es un espacio, 2 si es una operacion valida, -1 si es un caracter no valido.
     */
    public int CorroboraTexto(char caracter) {
        if (Character.isDigit(caracter)) {
            return 0; // Es un digito
        } else if (caracter == ' ') {
            return 1; // Es un espacio en blanco
        } else if (operaciones.contains(caracter)) {
            return 2; // Es una operacion valida
        } else {
            return -1; // Caracter no valido
        }
    }

    /**
     * Realiza la operacion correspondiente cuando el caracter es un operador.
     * @param caracter El operador.
     * @return true si la operacion se realizo correctamente, false si hubo un error.
     */
    public boolean Operar(char caracter) {
        if (vector.size() < 2) {
            return false; // No hay suficientes operandos
        }

        int operandoB = vector.pop();
        int operandoA = vector.pop();
        int resultado = 0;

        switch (caracter) {
            case '+':
                resultado = operandoA + operandoB;
                break;
            case '-':
                resultado = operandoA - operandoB;
                break;
            case '*':
                resultado = operandoA * operandoB;
                break;
            case '/':
                if (operandoB == 0) {
                    return false; // Division por cero
                }
                resultado = operandoA / operandoB;
                break;
            case '%':
                resultado = operandoA % operandoB;
                break;
            default:
                return false; // Operacion no valida
        }

        vector.push(resultado);
        return true;
    }

    /**
     * Evalúa la expresion en notacion postfix y devuelve el resultado.
     * @param expresion La expresion en notacion postfix.
     * @return El resultado de la expresion o -1 si hubo un error.
     */
    public int Resultado(String expresion) {
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            int tipo = CorroboraTexto(caracter);

            switch (tipo) {
                case 0: // Es un digito
                    StringBuilder numero = new StringBuilder();
                    while (i < expresion.length() && Character.isDigit(expresion.charAt(i))) {
                        numero.append(expresion.charAt(i));
                        i++;
                    }
                    i--; // Retroceder porque el bucle for tambien incrementa i
                    vector.push(Integer.parseInt(numero.toString()));
                    break;
                case 1: // Es un espacio en blanco
                    break; // Ignorar espacios
                case 2: // Es una operacion valida
                    if (!Operar(caracter)) {
                        return -1; // Error en la operacion
                    }
                    break;
                default: // Caracter no valido
                    return -1; // Error: caracter no valido
            }
        }

        if (vector.size() == 1) {
            return vector.pop(); // El resultado final esta en la pila
        } else {
            return -1; // Error: la pila no tiene exactamente un resultado
        }
    }
}