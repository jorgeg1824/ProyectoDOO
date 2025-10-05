package co.edu.uco.nose.crosscuting.helper;

public final class BooleanHelper {
	
	private BooleanHelper() {
	}
	
	public static boolean getDefault() {
		return false;
	}
	
	public static boolean getDefault(final Boolean value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	
}
