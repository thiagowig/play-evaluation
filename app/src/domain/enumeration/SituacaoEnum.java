package src.domain.enumeration;


public enum SituacaoEnum {

	NAO_INICIADO("Não iniciado"),
	EM_CURSO("Em curso"),
	FINALIZADO("Finalizado");
	
	private String value;
	
	private SituacaoEnum(String value) {
		this.value = value;
	}
}
