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

import mx.tecnm.itlp.bd.VehiculoJDBC;
import mx.tecnm.itlp.models.Vehiculo;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class VehiculoREST {
	
	@Value("${imagenes.upload.dir}")
	String uploadDir;
	
	@Autowired
	VehiculoJDBC repo;
	
	//read
		@GetMapping
		public ResponseEntity<?> readVehiculos(){
			List<Vehiculo> resultado = null;
			resultado = repo.readVehiculos();
			return new ResponseEntity<List<Vehiculo>>(resultado, HttpStatus.OK);	
		}
		
		//"delete"
		@GetMapping("borrar/{id}")
		public ResponseEntity<?> deleteVehiculo(@PathVariable int id) {
			repo.deleteVehiculo(id);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		//create
		@PostMapping("/crear")
		public ResponseEntity<?> createVehiculo(@RequestParam String marca, @RequestParam String modelo, @RequestParam int anio, @RequestParam int kilometraje, @RequestParam String imagen, @RequestParam int idusuario ){
			repo.createVehiculo(marca, modelo, anio, kilometraje, imagen, idusuario);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		public void subirArch(MultipartFile archivo, int id) {
			String archivo_id =  archivo.getOriginalFilename();
			Path ruta = Paths.get(uploadDir, archivo_id);
			try {
				archivo.transferTo(ruta.toFile());
				repo.actualizarArchivo(id, archivo_id);
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		@PostMapping("/{id}")
		public ResponseEntity<?> subirArchivo(@RequestParam MultipartFile archivo, @PathVariable int id){
			subirArch(archivo, id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		//obtener info individual
		@GetMapping("/obtenerdatos/{id}")
		public ResponseEntity<?> obtenerId(@PathVariable int id){
			Vehiculo resultado = null;
			resultado = repo.obtenerId(id);
			return new ResponseEntity<Vehiculo>(resultado, HttpStatus.OK);
		}
		
		//obtener vehiculos de un usuario 
		@GetMapping("/obtenerVehiculos/{id}")
		public ResponseEntity<?> obtenerVehiculosUsuario(@PathVariable int id){
			List<Vehiculo> resultado = null;
			resultado = repo.obtenerVehiculosUsuario(id);
			return new ResponseEntity<List<Vehiculo>>(resultado, HttpStatus.OK);
		}
}
