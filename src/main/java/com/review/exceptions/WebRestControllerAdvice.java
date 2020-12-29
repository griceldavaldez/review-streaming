package com.review.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ReviewException.class)
	public ResponseMsg handleReviewException(ReviewException ex) {
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		System.out.println(responseMsg);
		return responseMsg;
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	public ResponseMsg handleException(Exception ex) {
		System.out.println(ex);
		ResponseMsg responseMsg = new ResponseMsg("Ocurrio un error inesperado, favor comunicarse con soporte.");
		return responseMsg;
	}
}
