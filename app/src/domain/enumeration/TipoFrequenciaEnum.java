package src.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum TipoFrequenciaEnum {

	FEV("Fev"),
	MAR("Mar"),
	ABR("Abr"),
	MAI("Mai"),
	JUN("Jun"),
	JUL("Jul"),
	AGO("Ago"),
	SET("Set"),
	OUT("Out"),
	NOV("Nov"),
	DEZ("Dez"),
	MAX("Max.");
	
	public String value;
	
	private TipoFrequenciaEnum(String value) {
		this.value = value;
	}
	
	public static Map<String, String> findAllConvertedToSelect() {
		Map<String, String> valores = new HashMap<String, String>();
		
		for (TipoFrequenciaEnum tipoFrequencia : TipoFrequenciaEnum.values()) {
			valores.put(tipoFrequencia.name(), tipoFrequencia.value);
		}
		
		return valores;
	}
	
	public static TipoFrequenciaEnum findByName(String name) {
		for (TipoFrequenciaEnum tipoFrequencia : TipoFrequenciaEnum.values()) {
			if (tipoFrequencia.name().equals(name)) {
				return tipoFrequencia;
			}
		}
		
		return null;
	}
	
}
