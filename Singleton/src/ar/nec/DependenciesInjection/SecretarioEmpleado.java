package ar.nec.DependenciesInjection;

public class SecretarioEmpleado implements Empleados {
	
	public void setNuevoInforme(CreaInformes nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}
	
	
	//Creación de campo tipo creaInforme (interfaz)
	private CreaInformes nuevoInforme;
	

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	private String email;
	private String nomEmpresa;


	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Soy secretario, y hago cosas de secretario";
	}

	@Override
	public String getInformes() {
		// TODO Auto-generated method stub
		return "Informe creado por el Secretario: " + nuevoInforme.getInforme();
	}

}
