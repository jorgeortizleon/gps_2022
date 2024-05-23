package mx.tecnm.itlp.models;

public class Servicio {
	int idservicio;
	String nombre_servicio;
	String fecha;
	String motivo;
	String proceso;
	int idvehiculo;
	int idtaller;
	String fecha_fin;
	int kilometraje_actual;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	public int getIdvehiculo() {
		return idvehiculo;
	}
	public void setIdvehiculo(int idvehiculo) {
		this.idvehiculo = idvehiculo;
	}
	public int getIdtaller() {
		return idtaller;
	}
	public void setIdtaller(int idtaller) {
		this.idtaller = idtaller;
	}
	public int getKilometraje_actual() {
		return kilometraje_actual;
	}
	public void setKilometraje_actual(int kilometraje_actual) {
		this.kilometraje_actual = kilometraje_actual;
	}
	public int getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}
	public String getNombre_servicio() {
		return nombre_servicio;
	}
	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}
	
	

}
