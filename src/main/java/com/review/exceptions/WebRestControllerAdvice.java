package com.review.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebRestControllerAdvice {

	public class ResponseMsg {
		private String mensajeError;

		public ResponseMsg(String mensajeError) {
			this.mensajeError = mensajeError;
		}
		public String getMensajeError() {
			return mensajeError;
		}

		public void setMensajeError(String mensajeError) {
			this.mensajeError = mensajeError;
		}
		@Override
		public String toString() {
			return "ResponseMsg [mensajeError=" + mensajeError + "]";
		}
	}

	@ExceptionHandler(ReviewException.class)
	public ResponseMsg handleReviewException(ReviewException ex) {
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		System.out.println(responseMsg);
		return responseMsg;
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseMsg handleException(Exception ex) {
		System.out.println(ex);
		ResponseMsg responseMsg = new ResponseMsg("Ocurrio un error inesperado, favor comunicarse con soporte.");
		return responseMsg;
	}
}
