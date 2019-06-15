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
    
    
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	public String getDeveloperMessage() {
		return developerMessage;
	}



	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
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
