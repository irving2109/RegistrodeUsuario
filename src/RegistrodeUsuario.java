import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrodeUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        while (!validarNombre(nombre)) {
            System.out.println("El nombre ingresado no es válido. Debe contener solo letras y espacios.");
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine();
        }

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        while (!validarCorreoElectronico(correo)) {
            System.out.println("El correo electrónico ingresado no es válido.");
            System.out.print("Ingrese su correo electrónico: ");
            correo = scanner.nextLine();
        }

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        while (!validarContraseña(contraseña)) {
            System.out.println("La contraseña ingresada no es válida. Debe tener al menos 8 caracteres, incluyendo al menos una letra mayúscula, una letra minúscula, un número y un carácter especial.");
            System.out.print("Ingrese su contraseña: ");
            contraseña = scanner.nextLine();
        }

        System.out.println("¡Registro exitoso! Bienvenido, " + nombre + ".");

        scanner.close();
    }

    private static boolean validarNombre(String nombre) {
        Pattern patrón = Pattern.compile("^[a-zA-Z ]+$");
        Matcher matcher = patrón.matcher(nombre);
        return matcher.matches();
    }

    private static boolean validarCorreoElectronico(String correo) {
        Pattern patrón = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = patrón.matcher(correo);
        return matcher.matches();
    }

    private static boolean validarContraseña(String contraseña) {
        Pattern patrón = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = patrón.matcher(contraseña);
        return matcher.matches();
    }
}