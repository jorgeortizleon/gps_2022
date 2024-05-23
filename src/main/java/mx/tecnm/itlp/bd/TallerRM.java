package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Taller;

public class TallerRM implements RowMapper<Taller>{
	
	@Override
	public Taller mapRow(ResultSet rs, int rowNum ) throws SQLException {
		Taller taller = new Taller();
		taller.setIdtaller(rs.getInt("idtaller"));
		taller.setNombre_taller(rs.getString("nombre_taller"));
		taller.setDescripcion_taller(rs.getString("descripcion_taller"));
		taller.setNumero_mecanico(rs.getString("numero_mecanico"));
		taller.setNombre_mecanico(rs.getString("nombre_mecanico"));
		taller.setCorreo_mecanico(rs.getString("correo_mecanico"));
		taller.setActivo(rs.getInt("activo"));
		taller.setImagen_taller(rs.getString("imagen_taller"));
		taller.setCalificacion(rs.getString("calificacion"));
		taller.setMapa(rs.getString("mapa"));
		taller.setEspecialidades(rs.getString("Especialidades"));
		taller.setEstado(rs.getString("Estado"));
		taller.setCiudad(rs.getString("ciudad"));
		taller.setColonia(rs.getString("colonia"));
		taller.setDireccion(rs.getString("direccion"));
		return taller;
	}

}
