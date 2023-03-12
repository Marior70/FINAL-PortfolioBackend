package com.portfolio.backend.seguridad.usuarios;

// import com.portfolio.backend.seguridad.usuarios.Usuario;
import java.util.List;

public interface IUsuarioService {
   public List<Usuario> obtenerUsuarios();

   public void crearUsuario(Usuario usr);

   public void borrarUsuario(Long id);

   public Usuario buscarUsuario(Long id);

   public void editarUsuario(Long id, Usuario usr);

}
