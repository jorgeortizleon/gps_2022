package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Servicio;

public class ServicioRM implements RowMapper<Servicio>{
	
	@Override
	public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		Servicio servicio = new Servicio();
		servicio.setIdservicio(rs.getInt("idservicio"));
		servicio.setNombre_servicio(rs.getString("nombre_servicio"));
		servicio.setFecha(rs.getString("fecha"));
		servicio.setMotivo(rs.getString("motivo"));
		servicio.setProceso(rs.getString("proceso"));
		servicio.setIdvehiculo(rs.getInt("idvehiculo"));
		servicio.setIdtaller(rs.getInt("idtaller"));
		servicio.setFecha_fin(rs.getString("fecha_fin"));
		servicio.setKilometraje_actual(rs.getInt("kilometraje_actual"));
		return servicio;
	}

}
