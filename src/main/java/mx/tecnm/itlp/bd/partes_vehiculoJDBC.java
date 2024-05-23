package mx.tecnm.itlp.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class partes_vehiculoJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	public int vidaUtil(String nombre_parte, int idVehiculo, int id) {
		String sql = "SELECT \r\n" + 
				"CAST( \r\n" +
				"LEAST( \r\n" + 
				"(DATEDIFF(CURDATE(), P.fecha_instalacion) / P.vida_util_meses) * 100, \r\n" + 
				"((V.kilometraje - P.kilometraje_instalacion) / P.kilometraje_maximo) * 100 \r\n" + 
				") AS UNSIGNED \r\n" + 
				") AS percentage \r\n" + 
				"FROM  \r\n" + 
				"partes_vehiculos P , vehiculos V \r\n" + 
				"WHERE \r\n" + 
				"P.nombre_parte = ?  \r\n" + 
				"AND P.vehiculo_id = ? \r\n" + 
				"AND v.idvehiculo = ?;";
		
		return conexion.queryForObject(sql, Integer.class, nombre_parte, idVehiculo, id);
	}

}
