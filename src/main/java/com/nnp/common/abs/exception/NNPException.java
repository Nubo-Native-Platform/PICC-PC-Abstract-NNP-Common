package com.nnp.common.abs.exception;

import lombok.Getter;

@Getter
public class NNPException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errCd;
	private String message;
	private String debugErrMsg;

	public NNPException() {
		super();
	}

	public NNPException(NNPErrorCodes errCd) {
		super();
		this.errCd = String.valueOf(errCd.getCode());
		this.message = errCd.getMessage();
		this.debugErrMsg = errCd.getMessage();
	}

	public NNPException(NNPErrorCodes errCd, String detailErrMsg) {
		super();
		this.errCd = String.valueOf(errCd.getCode());
		this.message = errCd.getMessage();
		this.debugErrMsg = detailErrMsg;
	}

	public NNPException(NNPErrorCodes errCd, Throwable ex) {
		super(ex);
		this.errCd = String.valueOf(errCd.getCode());
		this.message = errCd.getMessage();
		this.debugErrMsg = ex.getLocalizedMessage();
	}
}
