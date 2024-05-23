package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Comentario;

public class ComentarioRM implements RowMapper<Comentario>{
	
	@Override
	public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comentario comentario = new Comentario();
		comentario.setIdcomentario(rs.getInt("idcomentario"));
		comentario.setComentario(rs.getString("comentario"));
		comentario.setIdusuario(rs.getInt("idusuario"));
		comentario.setIdtaller(rs.getInt("idtaller"));
		comentario.setIdservicio(rs.getInt("idservicio"));
		comentario.setCalificacion(rs.getString("calificacion"));
		return comentario;
	}
	

}
