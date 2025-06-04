package modelo;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministradorDAO administradorDAO = new AdministradorDAO();

        while (true) {
            System.out.println("\n=== CRUD de Administrador ===");
            System.out.println("1. Agregar Administrador");
            System.out.println("2. Listar Administradores");
            System.out.println("3. Actualizar Administrador");
            System.out.println("4. Eliminar Administrador");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del administrador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese la contraseña: ");
                    String contraseña = scanner.nextLine();

                    Administrador nuevoAdministrador = new Administrador(0, nombre, correo, contraseña);
                    administradorDAO.crearAdministrador(nuevoAdministrador);
                    System.out.println("✅ Administrador agregado correctamente.");
                }

                case 2 -> {
                    List<Administrador> lista = administradorDAO.obtenerAdministrador();
                    System.out.println("\n=== Lista de Administradores ===");
                    for (Administrador admin : lista) {
                        System.out.println("ID: " + admin.getID_administrador() +
                                           ", Nombre: " + admin.getNombre() +
                                           ", Correo: " + admin.getCorreo());
                    }
                }

                case 3 -> {
                    try {
                        System.out.print("Ingrese el ID del administrador a actualizar: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nuevo nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Nuevo correo: ");
                        String correo = scanner.nextLine();
                        System.out.print("Nueva contraseña: ");
                        String contraseña = scanner.nextLine();

                        administradorDAO.actualizarAdministrador(id, nombre, correo, contraseña);
                        System.out.println("✅ Administrador actualizado.");
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ ID inválido.");
                    }
                }

                case 4 -> {
                    try {
                        System.out.print("ID del administrador a eliminar: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        administradorDAO.eliminarAdministrador(id);
                        System.out.println("✅ Administrador eliminado.");
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ ID inválido.");
                    }
                }

                case 5 -> {
                    System.out.println("👋 Saliendo...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("⚠️ Opción no válida.");
            }
        }
    }
}