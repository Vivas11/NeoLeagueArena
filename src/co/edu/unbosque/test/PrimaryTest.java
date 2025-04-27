package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrimaryTest {

	@Test
	public void ejecutarPrimeraPrueba() {
		System.out.println("Ejecutada la primera prueba");
      	assertEquals(2,2);
	}
	
	@Test 
	public void probarPariedad() {
		int num = 12;
		int res = num;
		assertEquals(0, res);
	}
	
	//hacer funcion q me mire si hay vocales en una oracion
	//hacer q verifique todos los numeros primos desde 0 hasta .....
	//verifique si un texto si un texto tienen caracteres especiales, cuales y cuantos
	//verifique, q muestre los factores primos de un numero
	//prueba unitaria q imprima una matriz de nxm y q llene la matriz de ese nxm 
}
