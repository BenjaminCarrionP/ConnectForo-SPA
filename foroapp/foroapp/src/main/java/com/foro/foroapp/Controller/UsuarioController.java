package com.foro.foroapp.Controller;

import org.springframework.stereotype.Component;

import com.foro.foroapp.Model.Rol;
import com.foro.foroapp.Model.Usuario;
import com.foro.foroapp.Services.UsuarioService;
import com.foro.foroapp.Visual.ConsolaVisual;


@Component
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final ConsolaVisual consolaVisual;
    public UsuarioController(UsuarioService usuarioService, ConsolaVisual consolaVisual) {
        this.usuarioService = usuarioService;
        this.consolaVisual = consolaVisual;
    }
    public void menuInicio() {
        boolean salir = false;

        while (!salir) {
            consolaVisual.mostrar("=== MENÚ PRINCIPAL ===");
            consolaVisual.mostrar("1. Registrarse");
            consolaVisual.mostrar("2. Iniciar sesión");
            consolaVisual.mostrar("3. Salir");

            switch (consolaVisual.leer("Seleccione una opción")) {
                case "1" -> registrarUsuario();
                case "2" -> iniciarSesion();
                case "3" -> salir = true;
                default -> consolaVisual.mostrar("❌ Opción no válida");
            }
        }
    }

    private void registrarUsuario() {
        String nombre_usuario = consolaVisual.leer("Nombre de Usuario");
        String nombre = consolaVisual.leer("Nombre");
        String apellido = consolaVisual.leer("Apellidos");   
        String correo = consolaVisual.leer("Correo");

        if (usuarioService.existeCorreo(correo)) {
            consolaVisual.mostrar("Ya existe un usuario con ese correo");
            return;
        }

        String contrasena = consolaVisual.leer("Contraseña");
        String repetir = consolaVisual.leer("Repite la contraseña");

        if (!contrasena.equals(repetir)) {
            consolaVisual.mostrar("Las contraseñas no coinciden");
            return;
        }

        Usuario nuevo = new Usuario(nombre_usuario, nombre, apellido, correo, contrasena, Rol.USUARIO);
        usuarioService.registrar(nuevo);
        consolaVisual.mostrar("✅ Usuario registrado correctamente");

    }

    private void iniciarSesion() {
        String correo = consolaVisual.leer("Correo");
        String contrasena = consolaVisual.leer("Contraseña");

        usuarioService.login(correo, contrasena).ifPresentOrElse(
                u -> {
                    consolaVisual.mostrar("✅ Bienvenido " + u.getNombre_usuario() + " [" + u.getRol() + "]");
                    mostrarMenuPorRol(u);
                },
                () -> consolaVisual.mostrar("❌ Credenciales incorrectas")
        );
    }
    private void mostrarMenuPorRol(Usuario usuario) {
        boolean salir = false;
        while (!salir) {
            consolaVisual.mostrar("\n=== MENÚ DE USUARIO: " + usuario.getNombre_usuario() + " [" + usuario.getRol() + "] ===");
    
            if (usuario.getRol() == Rol.USUARIO || usuario.getRol() == Rol.MODERADOR || usuario.getRol() == Rol.ADMIN) {
                consolaVisual.mostrar("1. Crear publicación");
                consolaVisual.mostrar("2. Comentar publicación");
            }
    
            if (usuario.getRol() == Rol.MODERADOR || usuario.getRol() == Rol.ADMIN) {
                consolaVisual.mostrar("3. Eliminar publicación");
            }
    
            if (usuario.getRol() == Rol.ADMIN) {
                consolaVisual.mostrar("4. Gestionar roles de usuarios");
            }
    
            consolaVisual.mostrar("0. Cerrar sesión");
    
            String opcion = consolaVisual.leer("Seleccione una opción");
            switch (opcion) {
                case "1":
                    consolaVisual.mostrar("📝 Crear publicación (simulado)");
                    break;
                case "2":
                    consolaVisual.mostrar("💬 Comentar publicación (simulado)");
                    break;
                case "3":
                    if (usuario.getRol() != Rol.USUARIO)
                        consolaVisual.mostrar("❌ Eliminar publicación (simulado)");
                    break;
                case "4":
                    if (usuario.getRol() == Rol.ADMIN)
                        consolaVisual.mostrar("⚙️ Gestión de roles (simulado)");
                    break;
                case "0":
                    consolaVisual.mostrar("👋 Cerrando sesión...");
                    salir = true;
                    break;
                default:
                    consolaVisual.mostrar("❌ Opción no válida");
            }
        }
    }
}
