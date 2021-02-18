package ar.nec.DependenciesInjection;

public class JefeEmpleado  implements Empleados {
	
	public JefeEmpleado(CreaInformes nuevoInforme) {

		this.nuevoInforme = nuevoInforme;
	}

	//Creación de campo tipo creaInforme (interfaz)
	private CreaInformes nuevoInforme;
	
	public String getTareas() {
		
		return "Soy el jefe, y hago cosas de jefe";
	}

	@Override
	public String getInformes() {
		// TODO Auto-generated method stub
		return "Informe creado por el Jefe: " + nuevoInforme.getInforme();
	}

}
