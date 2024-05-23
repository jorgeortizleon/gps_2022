package mx.tecnm.itlp.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import mx.tecnm.itlp.bd.TallerJDBC;
import mx.tecnm.itlp.models.Taller;
import mx.tecnm.itlp.models.Usuario;

@RestController
@RequestMapping("/talleres")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class TallerREST {
	
	@Autowired
	TallerJDBC repo;
	
	//read
		@GetMapping
		public ResponseEntity<?> readTalleres(){
			List<Taller> resultado = null;
			resultado = repo.readTalleres();
			return new ResponseEntity<List<Taller>>(resultado, HttpStatus.OK);
		}
		
		//obtener info individual
		@GetMapping("/obtenerdatos/{id}")
		public ResponseEntity<?> obtenerId(@PathVariable int id){
			Taller resultado = null;
			resultado = repo.obtenerId(id);
			return new ResponseEntity<Taller>(resultado, HttpStatus.OK);
		}

}