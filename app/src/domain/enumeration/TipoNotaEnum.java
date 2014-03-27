package src.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum TipoNotaEnum {

	AVAL_1("Aval 1"),
	AVAL_2("Aval 2"),
	ATIVIDADES_AUTOINSTRUCIONAIS("Atividades autoinstrucionais"),
	REVISAO_CONTEUDO("Revisao Conteúdo"),
	AVAL_3("Aval 3"),
	EX_EXP("Ex Esp");
	
	public String value;
	
	private TipoNotaEnum(String value) {
		this.value = value;
	}
	
	public static Map<String, String> findAllConvertedToSelect() {
		Map<String, String> valores = new HashMap<String, String>();
		
		for (TipoNotaEnum tipoNota : TipoNotaEnum.values()) {
			valores.put(tipoNota.name(), tipoNota.value);
		}
		
		return valores;
	}
	
	public static TipoNotaEnum findByName(String name) {
		for (TipoNotaEnum tipoNota : TipoNotaEnum.values()) {
			if (tipoNota.name().equals(name)) {
				return tipoNota;
			}
		}
		
		return null;
	}
	
}
