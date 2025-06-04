package modelo;

public class Administrador {
    private int ID_administrador;
    private String nombre;
    private String correo;
    private String contraseña;

    public Administrador() {
    }

    public Administrador(int ID_administrador, String nombre, String correo, String contraseña) {
        this.ID_administrador = ID_administrador;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public int getID_administrador() {
        return ID_administrador;
    }

    public void setID_administrador(int ID_administrador) {
        this.ID_administrador = ID_administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}