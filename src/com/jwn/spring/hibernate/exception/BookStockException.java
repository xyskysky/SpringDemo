package com.jwn.spring.hibernate.exception;

public class BookStockException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8724098943187339038L;

	public BookStockException()
	{
		super();
		
	}

	public BookStockException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public BookStockException(String message, Throwable cause)
	{
		super(message, cause);
		
	}

	public BookStockException(String message)
	{
		super(message);
		
	}

	public BookStockException(Throwable cause)
	{
		super(cause);
		
	}

}
