package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Vehiculo;

@Repository
public class VehiculoJDBC {
	
	@Autowired
	JdbcTemplate conexion;

	//read
	public List<Vehiculo> readVehiculos() {
		String sql = "select * from vehiculos where activo = 1;";
		return conexion.query(sql, new VehiculoRM());
	}
	
	//"delete"
		public void deleteVehiculo(int id) {
			String sql = "UPDATE vehiculos SET activo = 0 WHERE idvehiculo = ?";
			conexion.update(sql,id);
		}

		public void createVehiculo(String marca, String modelo, int anio, int kilometraje, String imagen,
				int idusuario) {
			String sql = "INSERT INTO vehiculos (marca, modelo, anio, kilometraje, imagen, idusuario) VALUES (?, ?, ?, ?, ?, ?)";
			conexion.update(sql, marca, modelo, anio, kilometraje, imagen, idusuario);
		}
		
		public String getArchivo(int id) {
			String sql = "Select imagen from vehiculos where idvehiculo = ?";
			return conexion.queryForObject(sql, String.class, id);
		}
		
		public void actualizarArchivo(int id, String archivo_id) {
			String sql = "Update vehiculos set imagen = ?, content_type = ? WHERE idvehiculo = ?";
			conexion.update(sql, archivo_id, id);
		}
		
		public Vehiculo obtenerId(int id) {
			String sql = "SELECT * FROM vehiculos WHERE idvehiculo = ?";
			return conexion.queryForObject(sql,new VehiculoRM(), id);
		}
		
		public List<Vehiculo> obtenerVehiculosUsuario(int id) {
			String sql = "SELECT * FROM vehiculos WHERE idusuario = ? and activo = 1";
			return conexion.query(sql,new VehiculoRM(), id);
		}

}
