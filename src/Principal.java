import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tasaCambio;
        double cantidad;
        int opcion;

        do {
            System.out.println("***************************************************************************");
            System.out.println("¡Bienvenido al Conversor de Monedas!");
            System.out.println();
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Peso chileno");
            System.out.println("4) Peso chileno => Dólar");
            System.out.println("5) Dólar => Peso Mexicano");
            System.out.println("6) Peso Mexicano => Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");
            System.out.println();
            System.out.println("***************************************************************************");

            // Verificamos que la entrada sea un número entero
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número entero válido.");
                scanner.next(); // Limpiar la entrada
            }
            opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el valor que desee convertir: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Limpiar la entrada
                        }
                        cantidad = scanner.nextDouble();
                        tasaCambio = ConversorDeMoneda.obtenerTasaCambio("ARS");
                        System.out.println("El valor " + cantidad + " USD corresponde al valor final de = >>> " + (cantidad * tasaCambio) + " ARS");
                        break;
                    case 2:
                        System.out.print("Ingrese el valor que desee convertir: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Limpiar la entrada
                        }
                        cantidad = scanner.nextDouble();
                        tasaCambio = ConversorDeMoneda.obtenerTasaCambio("ARS");
                        double tasaCambioARSToUSD = 1 / tasaCambio; // Convertir ARS a USD
                        System.out.println("El valor " + cantidad + " ARS corresponde al valor final de = >>> " + (cantidad * tasaCambioARSToUSD) + " USD");
                        break;
                    case 3:
                        System.out.print("Ingrese el valor que desee convertir: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Limpiar la entrada
                        }
                        cantidad = scanner.nextDouble();
                        tasaCambio = ConversorDeMoneda.obtenerTasaCambio("CLP");
                        System.out.println("El valor " + cantidad + " USD corresponde al valor final de = >>> " + (cantidad * tasaCambio) + " CLP");
                        break;
                    case 4:
                        System.out.print("Ingrese el valor que desee convertir: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Limpiar la entrada
                        }
                        cantidad = scanner.nextDouble();
                        tasaCambio = ConversorDeMoneda.obtenerTasaCambio("CLP");
                        double tasaCambioCLPToUSD = 1 / tasaCambio; // Convertir CLP a USD
                        System.out.println("El valor " + cantidad + " CLP corresponde al valor final de = >>> " + (cantidad * tasaCambioCLPToUSD) + " USD");
                        break;
                    case 5:
                        System.out.print("Ingrese el valor que desee convertir: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Limpiar la entrada
                        }
                        cantidad = scanner.nextDouble();
                        tasaCambio = ConversorDeMoneda.obtenerTasaCambio("MXN");
                        System.out.println("El valor " + cantidad + " USD corresponde al valor final de = >>> " + (cantidad * tasaCambio) + " MXN");
                        break;
                    case 6:
                        System.out.print("Ingrese el valor que desee convertir: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Limpiar la entrada
                        }
                        cantidad = scanner.nextDouble();
                        tasaCambio = ConversorDeMoneda.obtenerTasaCambio("MXN");
                        double tasaCambioMXNToUSD = 1 / tasaCambio; // Convertir MXN a USD
                        System.out.println("El valor " + cantidad + " MXN corresponde al valor final de = >>> " + (cantidad * tasaCambioMXNToUSD) + " USD");
                        break;
                    case 7:
                        System.out.println("Finalizando la aplicación. ¡Gracias por utilizar el conversor de monedas!");
                        break;
                    default:
                        System.out.println("No se ha podido realizar la conversión. Favor elija una opción válida e intente nuevamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer del scanner
            }

        } while (opcion != 7); // Continuar hasta que el usuario elija salir

        scanner.close();
    }
}

class ConversorDeMoneda {
    public static double obtenerTasaCambio(String moneda) {
        switch (moneda) {
            case "ARS":
                return 200.0; // Ejemplo: tasa de cambio de 1 USD a ARS
            case "CLP":
                return 800.0; // Ejemplo: tasa de cambio de 1 USD a CLP
            case "MXN":
                return 20.0; // Ejemplo: tasa de cambio de 1 USD a MXN
            default:
                return 1.0; // Valor por defecto (puedes ajustar esto según sea necesario)
        }
    }
}