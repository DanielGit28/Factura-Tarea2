package cr.ac.ucenfotec.clase9.composicion.iu;


import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Daniel Zúñiga Rojas
 * @version 1.0
 */
public class IU {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void mostrarMenu() {
        output.println("Bienvenido, escoja una opción");
        output.println("1. Registrar factura");
        output.println("2. Registrar cliente");
        output.println("3. Registrar producto");
        output.println("4. Imprimir factura");
        output.println("5. Listar clientes");
        output.println("6. Listar productos");
        output.println("7. Salir");
    }
    /**
     * @return input.nextInt() el entero que devuelve es la entrada para ingresar un numero entero
     */
    public int leerOpcion() {
        output.println("Su opción es: ");
        return input.nextInt();
    }

    /**
     *
     * @return input.nextInt() el entero que devuelve es la entrada para ingresar un numero entero
     */
    public int leerEntero() {
        return input.nextInt();
    }
    public void imprimirMensaje(String mensaje) {
        output.println(mensaje);
    }
    /**
     * @return input.next() la cadena de caracteres que devuelve es la entrada para ingresar una cadena de caracteres
     */
    public String leerTexto() {
        return input.next();
    }
    public char leerChar() {
        return input.next().charAt(0);
    }
}
