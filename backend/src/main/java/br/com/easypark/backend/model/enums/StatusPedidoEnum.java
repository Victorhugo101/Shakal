package br.com.easypark.backend.model.enums;

public enum StatusPedidoEnum {
	
	FINALIZADO(1),PREPARANDO(2);
	
	private int value;

	StatusPedidoEnum(int value) {
        this.value = value;
    }
}
