package mx.tecnm.itlp.web;

import java.net.MalformedURLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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

import mx.tecnm.itlp.bd.ComentarioJDBC;
import mx.tecnm.itlp.models.Comentario;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ComentarioREST {
	
	@Autowired
	ComentarioJDBC repo;
	
	//read
		@GetMapping
		public ResponseEntity<?> consultarComentarios(){
			List<Comentario> resultado = null;
			resultado = repo.consultarComentarios();
			return new ResponseEntity<List<Comentario>>(resultado, HttpStatus.OK);
		}
	
		//obtener info individual
		@GetMapping("/obtenerdatos/{id}")
		public ResponseEntity<?> obtenerId(@PathVariable int id){
			Comentario resultado = null;
			resultado = repo.obtenerComentario(id);
			return new ResponseEntity<Comentario>(resultado, HttpStatus.OK);
		}
		
		@GetMapping("/comentariostaller/{id}")
		public ResponseEntity<?> comentariosTaller(@PathVariable int id){
			List<Comentario> resultado = null;
			resultado = repo.comentariosTaller(id);
			return new ResponseEntity<List<Comentario>>(resultado, HttpStatus.OK);
		}
	

}
