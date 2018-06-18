package exceptions;

public class ExcFortNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String EXC_FORT_NO_FOUND = "Fortaleza no encontrada";
	
	public ExcFortNotFound() {
		super(EXC_FORT_NO_FOUND);
	}
}
