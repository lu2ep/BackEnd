package ar.gob.argentinaprograma.julioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.gob.argentinaprograma.julioc.entity.Usuario;
import ar.gob.argentinaprograma.julioc.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getOne(int id){
        return usuarioRepository.findById(id);
    }

    public Usuario getByNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    public void  save(Usuario producto){
        usuarioRepository.save(producto);
    }

    public void delete(int id){
        usuarioRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return usuarioRepository.existsByNombre(nombre);
    }


}
