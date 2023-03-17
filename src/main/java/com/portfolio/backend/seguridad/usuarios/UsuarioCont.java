package com.portfolio.backend.seguridad.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

// import com.portfolio.backend.seguridad.usuarios.IUsuarioService;
// import com.portfolio.backend.seguridad.usuarios.Usuario;

@RestController
@RequestMapping("/api/auth/usuario")
@CrossOrigin
public class UsuarioCont {

   @Autowired
   private IUsuarioService usuarioServ;

   @GetMapping("/listar")
   @ResponseBody
   public List<Usuario> obtenerUsuarios() {
      return usuarioServ.obtenerUsuarios();
   }

   @GetMapping("/buscar/{id}")
   @ResponseBody
   public Usuario buscarUsuario(@PathVariable Long id) {
      return usuarioServ.buscarUsuario(id);
   }

   @PostMapping("/nuevo")
   public void crearUsuario(@RequestBody Usuario usr) {
      usuarioServ.crearUsuario(usr);
   }

   @DeleteMapping("/borrar/{id}")
   public void borrarUsuario(@PathVariable Long id) {
      usuarioServ.borrarUsuario(id);
   }

   @PutMapping("/editar/{id}")
   public void editarTitulo(@PathVariable("id") Long id, @RequestBody Usuario usr) {
      usuarioServ.editarUsuario(id, usr);
   }

}
