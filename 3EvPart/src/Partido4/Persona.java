package Partido4;

public abstract class Persona {
	// ATRIBUTOS
	protected String aNombre;// nombre
	protected double aAlturaM;// Altura en metros
	protected double aPesoKg;// Peso en kg
	protected double aImc;// imc

	// M�TODO IMC
	public void IMC() {
		double dImc;
		dImc = this.aPesoKg / (this.aAlturaM * this.aAlturaM);// Formula para sacar el IMC
		this.aImc = dImc;// guardamos imc
		//return dImc;// pasamos el resultado del calculo
	}

	// M�TODO ABSTRACTO ESTADO
	public abstract void Estado();
	
	// MOSTRAR DATOS
	public abstract void MostrarDatos();

}
