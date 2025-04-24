package com.foro.foroapp.Controller;

import java.util.Optional;

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
        String nombre_usuario;
        do {
            nombre_usuario = consolaVisual.leer("Nombre de Usuario");
            if (nombre_usuario.isBlank()) {
                consolaVisual.mostrar("❌ El nombre de usuario no puede estar vacío.");
            }
        } while (nombre_usuario.isBlank());
        String nombre;
        do {
            nombre = consolaVisual.leer("Nombre");
            if (nombre.isBlank()) {
                consolaVisual.mostrar("❌ El nombre no puede estar vacío.");
            }
        } while (nombre.isBlank());

        String apellido;
        do {
            apellido = consolaVisual.leer("Apellidos");
            if (apellido.isBlank()) {
                consolaVisual.mostrar("❌ Los apellidos no pueden estar vacíos.");
            }
        } while (apellido.isBlank());

        String correo;

        boolean correoValido = false;

        do {
            correo = consolaVisual.leer("Correo");

            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                consolaVisual.mostrar("❌ El formato del correo es inválido.");
            } else if (usuarioService.buscarPorCorreo(correo).isPresent()) {
                consolaVisual.mostrar("❌ Ya existe un usuario registrado con ese correo.");
            } else {
                correoValido = true;
            }

        } while (!correoValido);

        String contrasena;
        String repetir;

        boolean contrasenaValida = false;

        do {
            contrasena = consolaVisual.leer("Contraseña");
            repetir = consolaVisual.leer("Repite la contraseña");

            if (!contrasena.equals(repetir)) {
                consolaVisual.mostrar("❌ Las contraseñas no coinciden.");
            } else if (contrasena.length() < 6) {
                consolaVisual.mostrar("❌ La contraseña debe tener al menos 6 caracteres.");
            } else {
                contrasenaValida = true;
            }
        } while (!contrasenaValida);

        Usuario nuevo = new Usuario(nombre_usuario, nombre, apellido, correo, contrasena, Rol.USUARIO);
        usuarioService.registrar(nuevo);
        consolaVisual.mostrar("✅ Usuario registrado correctamente");

    }

    private void iniciarSesion() {
        consolaVisual.mostrar("=== INICIO DE SESIÓN ===");

        String correo;
        Usuario usuario = null;

        // Validar correo correcto y que exista
        while (true) {
            correo = consolaVisual.leer("Correo");

            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                consolaVisual.mostrar("❌ Formato de correo inválido. Intenta de nuevo.");
                continue;
            }

            Optional<Usuario> usuarioOpt = usuarioService.buscarPorCorreo(correo);
            if (usuarioOpt.isEmpty()) {
                consolaVisual.mostrar("❌ No existe una cuenta con ese correo.");
            } else {
                usuario = usuarioOpt.get();
                break; // Salir del bucle si el correo es válido y existe
            }
        }

        // Verificar contraseña
        int intentos = 3;
        boolean accesoConcedido = false;

        while (intentos > 0) {
            String contrasena = consolaVisual.leer("Contraseña");

            if (usuarioService.verificarContra(usuario, contrasena)) {
                consolaVisual.mostrar("✅ Bienvenido, " + usuario.getNombre_usuario());
                accesoConcedido = true;
                break;
            } else {
                intentos--;
                consolaVisual.mostrar("❌ Contraseña incorrecta. Te quedan " + intentos + " intento(s).");
            }
        }

        if (!accesoConcedido) {
            consolaVisual.mostrar("❌ Demasiados intentos. Vuelve al menú principal.");
            return;
        }

        mostrarMenuPorRol(usuario); // Esto puede ir a otra función
    }

    private void mostrarMenuPorRol(Usuario usuario) {
        boolean salir = false;
        while (!salir) {
            consolaVisual.mostrar(
                    "\n=== MENÚ DE USUARIO: " + usuario.getNombre_usuario() + " [" + usuario.getRol() + "] ===");

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
