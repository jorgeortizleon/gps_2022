package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Taller;
import mx.tecnm.itlp.models.Usuario;

@Repository
public class TallerJDBC {
	@Autowired
	JdbcTemplate conexion;

	//read
	public List<Taller> readTalleres() {
		String sql = "select * from talleres;";
		return conexion.query(sql, new TallerRM());
	}
	
	//obtener info individual 
			public Taller obtenerId(int id) {
			String sql = "SELECT * FROM talleres WHERE idtaller = ?";
			return conexion.queryForObject(sql,new TallerRM(), id);
		}

}
