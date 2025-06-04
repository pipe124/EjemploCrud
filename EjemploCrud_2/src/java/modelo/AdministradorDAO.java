package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {

    // Obtener todos los administradores
    public List<Administrador> obtenerAdministrador() {
        List<Administrador> lista = new ArrayList<>();

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM administrador");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Administrador a = new Administrador();
                a.setID_administrador(rs.getInt("ID_administrador"));
                a.setNombre(rs.getString("nombre"));
                a.setCorreo(rs.getString("correo"));
                a.setContraseña(rs.getString("contraseña"));
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener administradores: " + e.getMessage());
        }

        return lista;
    }

    // Insertar nuevo administrador
    public void crearAdministrador(Administrador admin) {
        String sql = "INSERT INTO administrador (nombre, correo, contraseña) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, admin.getNombre());
            stmt.setString(2, admin.getCorreo());
            stmt.setString(3, admin.getContraseña());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ Error al crear administrador: " + e.getMessage());
        }
    }

    // Actualizar administrador existente
    public void actualizarAdministrador(int id, String nombre, String correo, String contraseña) {
        String sql = "UPDATE administrador SET nombre = ?, correo = ?, contraseña = ? WHERE ID_administrador = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contraseña);
            stmt.setInt(4, id);
            int filas = stmt.executeUpdate();

            if (filas == 0) {
                System.out.println("⚠️ No se encontró ningún administrador con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar administrador: " + e.getMessage());
        }
    }

    // Eliminar administrador por ID
    public void eliminarAdministrador(int id) {
        String sql = "DELETE FROM administrador WHERE ID_administrador = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            if (filas == 0) {
                System.out.println("⚠️ No se encontró ningún administrador con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar administrador: " + e.getMessage());
        }
    }
}