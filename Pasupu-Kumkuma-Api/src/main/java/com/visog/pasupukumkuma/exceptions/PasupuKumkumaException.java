package com.visog.pasupukumkuma.exceptions;


public class PasupuKumkumaException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String erroMsg;
	
	private Throwable e;
	
	public PasupuKumkumaException(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public PasupuKumkumaException(Throwable e) {
		this.e = e;
	}

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public Throwable getE() {
		return e;
	}

	public void setE(Throwable e) {
		this.e = e;
	}
	
	

}
