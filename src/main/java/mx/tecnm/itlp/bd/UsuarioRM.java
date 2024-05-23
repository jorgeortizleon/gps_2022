package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Usuario;

public class UsuarioRM implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = new Usuario();
		user.setId(rs.getInt("idusuario"));
		user.setUsuario(rs.getString("nombre_usuario"));
		user.setCorreo(rs.getString("correo_usuario"));
		user.setContrasena(rs.getString("contrasenia"));
		return user;
	}
	
	
	
}
