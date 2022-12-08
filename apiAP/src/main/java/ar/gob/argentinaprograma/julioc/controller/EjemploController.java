package ar.gob.argentinaprograma.julioc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.gob.argentinaprograma.julioc.dto.Mensaje;
import ar.gob.argentinaprograma.julioc.entity.Producto;
import ar.gob.argentinaprograma.julioc.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EjemploController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/hola")
    public ResponseEntity<String> holaMundo(){
        return new ResponseEntity("Hola mundo!", HttpStatus.OK);
    }

    @PostMapping("/hola")
    public ResponseEntity<String> holaMundoBody(@RequestBody String nombre){
        if(nombre==null)
            return new ResponseEntity(new Mensaje("Nombre no ingresado"), HttpStatus.NOT_FOUND);
        return new ResponseEntity("Hola desde el body, " + nombre, HttpStatus.OK);
    }

    @PostMapping("/holanombre/{nombre}")
    public ResponseEntity<String> holaMundoParametro(@PathVariable("nombre") String nombre){
        if(nombre==null)
            return new ResponseEntity(new Mensaje("Nombre no ingresado"), HttpStatus.NOT_FOUND);
        return new ResponseEntity("Hola, " + nombre, HttpStatus.OK);
    }

    


    /*
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductoDto productoDto){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Producto producto = productoService.getOne(id).get();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    */


}
