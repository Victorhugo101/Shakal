package br.com.easypark.backend.model.dto;

public class PedidoOverviewTruckDTO {
	
	public long id;
	public String nomeCliente;
	public int mesa;
	public String status;
	
	
	
	public PedidoOverviewTruckDTO() {
		
	}



	public PedidoOverviewTruckDTO(long id, String nomeCliente, int mesa, String status) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.mesa = mesa;
		this.status = status;
	}
	
	

}
