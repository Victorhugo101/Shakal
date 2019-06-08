package br.com.easypark.backend.exception;


public class ResourceNotFoundExceptionDetail {

    private String title;
    private int status;
    private String detail;
    private String developerMessage;
    
    private ResourceNotFoundExceptionDetail(Builder builder) {
    	this.title = builder.title;
    	this.status = builder.status;
    	this.detail = builder.detail;
    	this.developerMessage = builder.developerMessage;
    	
    }
	
	public static class Builder {
		 private String title;
		    private int status;
		    private String detail;
		    private String developerMessage;
		    
		    public Builder() {
		    	
		    }
		    
		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}
		public Builder developerMessage(String devMessage) {
			this.developerMessage = devMessage;
			return this;
		}

		public ResourceNotFoundExceptionDetail build() {
			return new ResourceNotFoundExceptionDetail(this);
		}
	}

	
    
}
