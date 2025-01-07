package com.system.responseModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;
import java.util.Objects;

/**
 * The class Response.
 * @author Priyank
 * @param <T> The type of the response payload
 */
public final class Response<T> {
	private final int status;
	private final String message;
	@JsonInclude(value = Include.NON_NULL)
	private final T data;
	private final Date timestamp;

	// Predefined response instances
	public static final Response<Void> SUCCESS = new Response<>(200, "Success");
	public static final Response<Void> CREATED = new Response<>(201, "Created");
	public static final Response<Void> FAILURE = new Response<>(205, "Failed");
	public static final Response<Void> NOT_FOUND = new Response<>(404, "Resource not found");
	public static final Response<Void> BAD_REQUEST = new Response<>(400, "Bad Request");
	public static final Response<Void> SERVER_ERROR = new Response<>(500, "Server Error");

	// Constructors
	private Response(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
		this.timestamp = new Date();
	}

	private Response(int status, String message) {
		this(status, message, null);
	}


	// Factory methods for convenience
	public static <T> Response<T> of(int status, String message, T data) {
		return new Response<>(status, message, data);
	}

	public static <T> Response<T> of(int status, String message) {
		return new Response<>(status, message, null);
	}

	public static <T> Response<T> success(T data) {
		return new Response<>(200, "Success", data);
	}

	// Getters
	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public Date getTimestamp() {
		return new Date(timestamp.getTime()); // Return defensive copy
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Response<?> response = (Response<?>) o;
		return status == response.status &&
				Objects.equals(message, response.message) &&
				Objects.equals(data, response.data) &&
				Objects.equals(timestamp, response.timestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, message, data, timestamp);
	}

	@Override
	public String toString() {
		return "Response{" +
				"status=" + status +
				", message='" + message + '\'' +
				", data=" + data +
				", timestamp=" + timestamp +
				'}';
	}
}
