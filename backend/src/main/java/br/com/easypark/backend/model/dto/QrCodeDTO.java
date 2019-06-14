package br.com.easypark.backend.model.dto;

public class QrCodeDTO {
	
	private String qrcode;
	
	public QrCodeDTO(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	

}
