package mx.tecnm.itlp.bd;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.itlp.models.Comentario;

@Repository
public class ComentarioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	public List<Comentario> consultarComentarios(){
		String sql = "select * from comentarios ;";
		return conexion.query(sql, new ComentarioRM());
	}
	
	//obtener info individual del comentario por su id
			public Comentario obtenerComentario(int id) {
			String sql = "SELECT * FROM comentarios WHERE idcomentario = ?";
			return conexion.queryForObject(sql,new ComentarioRM(), id);
		}

			//obtener comentarios de un taller por id del taller
			public List<Comentario> comentariosTaller(int id) {
				String sql = "select * from comentarios where idtaller = ? ";
				return conexion.query(sql,new ComentarioRM(), id);
			}

}
