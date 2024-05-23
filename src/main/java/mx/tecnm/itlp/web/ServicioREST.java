package mx.tecnm.itlp.web;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mx.tecnm.itlp.bd.ServicioJDBC;
import mx.tecnm.itlp.models.Servicio;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ServicioREST {
	
	@Autowired
	ServicioJDBC repo;
	
	//read
		@GetMapping
		public ResponseEntity<?> readServicios(){
			List<Servicio> resultado = null;
			resultado = repo.readServicios();
			return new ResponseEntity<List<Servicio>>(resultado, HttpStatus.OK);
		}
		
		//obtener servicios de un vehiculo
				@GetMapping("/obtenerServicios/{id}")
				public ResponseEntity<?> obtenerServicioVehiculo(@PathVariable int id){
					List<Servicio> resultado = null;
					resultado = repo.obtenerServicioVehiculo(id);
					return new ResponseEntity<List<Servicio>>(resultado, HttpStatus.OK);
				}
				
				@GetMapping("/obtener/{id}")
				public ResponseEntity<?> obtenerServicio(@PathVariable int id){
					Servicio resultado = null;
					resultado = repo.obtenerServicio(id);
					return new ResponseEntity<Servicio>(resultado, HttpStatus.OK);
				}
				
				//obtener servicios que ha hecho un taller
				@GetMapping("/serviciostaller/{id}")
				public ResponseEntity<?> serviciosTaller(@PathVariable int id){
					List<Servicio> resultado = null;
					resultado = repo.serviciosTaller(id);
					return new ResponseEntity<List<Servicio>>(resultado, HttpStatus.OK);
				}

}
