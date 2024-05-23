package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Vehiculo;

public class VehiculoRM implements RowMapper<Vehiculo>{
	
	@Override
	public Vehiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setIdvehiculo(rs.getInt("idvehiculo"));
		vehiculo.setMarca(rs.getString("marca"));
		vehiculo.setModelo(rs.getString("modelo"));
		vehiculo.setAnio(rs.getInt("anio"));
		vehiculo.setKilometraje(rs.getInt("kilometraje"));
		vehiculo.setImagen(rs.getString("imagen"));
		vehiculo.setIdusuario(rs.getInt("idusuario"));
		return vehiculo;
	}

}
