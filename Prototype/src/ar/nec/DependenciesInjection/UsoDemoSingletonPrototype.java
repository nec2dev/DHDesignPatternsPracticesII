package ar.nec.DependenciesInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDemoSingletonPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Crear un contexto, cargar archivo Xml
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContextPrototype.xml");
		
		//Pedir bean al contenedor
		Empleados nahuel=contexto.getBean("miSecretarioEmpleado", Empleados.class);
		Empleados mayra=contexto.getBean("miSecretarioEmpleado", Empleados.class);
		Empleados debora=contexto.getBean("miSecretarioEmpleado", Empleados.class);
		Empleados hugo=contexto.getBean("miSecretarioEmpleado", Empleados.class);
		
		//Singleton hace que Nahuel y Mayra apunten al mismo objeto
		System.out.println(nahuel);
		System.out.println(mayra);
		
		if(mayra==nahuel) System.out.println("Apuntan al mismo objeto");
		else System.out.println("No es el mismo objeto");
		
		System.out.println(debora);
		System.out.println(hugo);
		
	}

}
