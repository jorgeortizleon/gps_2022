package mx.tecnm.itlp.bd;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import mx.tecnm.itlp.models.Usuario;

@Repository
public class UsuarioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	//read
	public List<Usuario> consultarUsuarios(){
		String sql = "select * from usuarios where activo=1";
		return conexion.query(sql, new UsuarioRM());
	}

	/*public Usuario buscarUsuario(int id) {
		String sql = "SELECT * FROM usuarios WHERE idusuario = ?";
		return conexion.queryForObject(sql,new UsuarioRM(), id);
	}*/

	//"delete"
	public void desactivarUsuario(int id) {
		String sql = "UPDATE usuarios SET activo = 0 WHERE idusuario = ?";
		conexion.update(sql,id);
	}

	public void agregarUsuario1(Usuario user) {
		String sql = "INSERT INTO usuario(usuario, contrasena) VALUES(?, ?)";
		conexion.update(sql, user.getUsuario(), user.getContrasena());
	}
	
	public boolean autenticar(String usuario, String passwd) {
		String sql = "SELECT COUNT(*)\r\n" + 
				"FROM usuarios \r\n" + 
				"WHERE correo_usuario = ? AND `contrasenia`=? AND activo=1";
		
		return conexion.queryForObject(sql, Integer.class, usuario, passwd) != 0;
	}

	//create
	public void crearUsuario( String correo, String contrasena,String nombre) {
		String sql = "INSERT INTO usuarios (correo_usuario, contrasenia, nombre_usuario) VALUES (?, ?, ?)";
		conexion.update(sql, correo,contrasena, nombre);
	}
	
	//obtener info individual 
		public Usuario obtenerId(String correo) {
		String sql = "SELECT * FROM usuarios WHERE correo_usuario = ?";
		return conexion.queryForObject(sql,new UsuarioRM(), correo);
	}
		
		public Usuario autenticar2(String username, String password) {
			String sql = "SELECT * FROM usuarios WHERE correo_usuario = ? AND contrasenia = ?";
			return conexion.queryForObject(sql,new UsuarioRM(), username, password);
		}
		
		
}
