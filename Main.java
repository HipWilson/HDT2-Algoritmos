import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        
        System.out.println("=== Calculadora ===");
        System.out.println("Ingresa una expresión en notación postfija");
        System.out.println("Escribe 'salir' para terminar.");

        while (true) {
            System.out.print("\n> ");
            String expresion = scanner.nextLine().trim();

            if (expresion.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo de la calculadora...");
                break;
            }

            int resultado = calculadora.Resultado(expresion);

            if (resultado != -1) {
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Expresión inválida.");
            }
        }

        scanner.close();
    }
}
