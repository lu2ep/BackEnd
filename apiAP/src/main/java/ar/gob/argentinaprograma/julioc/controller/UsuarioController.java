package ar.gob.argentinaprograma.julioc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.gob.argentinaprograma.julioc.dto.Mensaje;
import ar.gob.argentinaprograma.julioc.entity.Producto;
import ar.gob.argentinaprograma.julioc.entity.Usuario;
import ar.gob.argentinaprograma.julioc.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listado")
    public ResponseEntity obtenerUsuarios() {

        return new ResponseEntity(usuarioService.list(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity obtenerUsuarios(@RequestBody Usuario usuario) {
        try {
            if (usuario.getNombre() == null || usuario.getContrasenia() == null) {
                return new ResponseEntity("Datos inválidos.", HttpStatus.BAD_REQUEST);
            }
            if (usuarioService.existsByNombre(usuario.getNombre())) {
                return new ResponseEntity("El usuario ya existe", HttpStatus.BAD_REQUEST);
            }
            usuarioService.save(usuario);
        } catch (Exception ex) {
            return new ResponseEntity("ERROR: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Usuario creado con éxito.", HttpStatus.OK);
    }

    @PostMapping("/ingresar")
    public ResponseEntity logearUsuario(@RequestBody Usuario usuario) {
        try {
            if (usuario.getNombre() == null || usuario.getContrasenia() == null) {
                return new ResponseEntity("Datos inválidos.", HttpStatus.BAD_REQUEST);
            }
            if (!usuarioService.existsByNombre(usuario.getNombre())) {
                return new ResponseEntity("El usuario no existe", HttpStatus.BAD_REQUEST);
            }
            Usuario userExistente = usuarioService.getByNombre(usuario.getNombre());

            if(userExistente.getContrasenia().equalsIgnoreCase(usuario.getContrasenia())){
                System.out.println(userExistente.getContrasenia() + " " + usuario.getContrasenia());
                return new ResponseEntity("Ingresaste con éxito.", HttpStatus.OK);
            }else{
                return new ResponseEntity("Contraseña incorrecta", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return new ResponseEntity("ERROR: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        
    }

}
