package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Servicio;

@Repository
public class ServicioJDBC {
	
	@Autowired
	JdbcTemplate conexion;

	//read
		public List<Servicio> readServicios() {
			String sql = "select * from servicios;";
			return conexion.query(sql, new ServicioRM());
		}

		//obtener servicios de un vehiculo
		public List<Servicio> obtenerServicioVehiculo(int id) {
			String sql = "select * from servicios where idvehiculo = ?";
			return conexion.query(sql, new ServicioRM(), id);
		}
		
		//Obtener informacion de un solo servicio
		public Servicio obtenerServicio(int id) {
			String sql = "select * from servicios where idservicio = ?";
			return conexion.queryForObject(sql, new ServicioRM(), id);
		}

		//obtener servicios que ha hecho un taller
		public List<Servicio> serviciosTaller(int id) {
			String sql = "select * from servicios where idtaller = ?";
			return conexion.query(sql, new ServicioRM(), id);
		}

}
