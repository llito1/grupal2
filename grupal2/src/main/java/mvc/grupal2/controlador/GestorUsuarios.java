package mvc.grupal2.controlador;

import mvc.grupal2.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;

    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Admin", "1288888", "1234"));
        usuarios.add(new Usuario("Cliente", "1234567", "1234"));
        usuarios.add(new Usuario("Administrativo", "7654321", "1234"));
        usuarios.add(new Usuario("Profesional", "9876543", "1234"));
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
