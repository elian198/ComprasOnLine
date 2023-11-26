package com.HouseBeer.service;

import com.HouseBeer.entity.Rol;
import com.HouseBeer.entity.Usuario;
import com.HouseBeer.entity.enums.TipoRol;
import com.HouseBeer.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

   public void saveRol(Usuario usuario){
       usuario.getRoles().add(new Rol(TipoRol.BASIC));
       usuarioRepository.save(usuario);
   }

   public List<Usuario> findAll(){
       return usuarioRepository.findAll();
   }

   public  void deleteById(Long id){
       usuarioRepository.deleteById(id);
   }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.HouseBeer.entity.Usuario user = usuarioRepository.findByName(username);
        return UserDetailsMapper.build(user);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


    public Usuario findByUserName(String name) {
        return usuarioRepository.findByName(name);
    }
}
