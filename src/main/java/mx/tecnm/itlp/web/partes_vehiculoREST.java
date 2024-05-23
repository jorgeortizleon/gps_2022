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

import mx.tecnm.itlp.bd.partes_vehiculoJDBC;

@RestController
@RequestMapping("/partes_vehiculo")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class partes_vehiculoREST {
	
	@Autowired
	partes_vehiculoJDBC repo;
	
	@PostMapping("/vida-util")
    public ResponseEntity<?> vidaUtil(@RequestParam String nombre_parte,@RequestParam int idVehiculo,@RequestParam int id) {
        try {
            int porcentaje = repo.vidaUtil(nombre_parte, idVehiculo, id);
            return new ResponseEntity<Integer>(porcentaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }
	

}
