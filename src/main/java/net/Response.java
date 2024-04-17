package net;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
public class Response<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int GENERAL_SUCCESS_CODE = 200;
    public static final String GENERAL_SUCCESS_MESSAGE = "Maskit general success";
    public static final int GENERAL_FAILURE_CODE = 400;
    public static final String GENERAL_FAILURE_MESSAGE = "Maskit general failure";

    @Getter
    @Setter
    @JsonIgnore
    private boolean success;
    @Getter
    @Setter
    private int code = GENERAL_SUCCESS_CODE;
    @Getter
    @Setter
    private String message = GENERAL_SUCCESS_MESSAGE;
    @Getter
    @Setter
    private T result = null;

    public Response(int code, String message, T data, boolean success) {
        this.code = code;
        this.message = message;
        this.result = data;
        this.success = success;
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.result = data;
        this.success = true;
    }


    public static <T> Response<T> yes() {
        return new Response<T>(GENERAL_SUCCESS_CODE, GENERAL_SUCCESS_MESSAGE, null);
    }

    public static <T> Response<T> yes(final T data) {
        return new Response<T>(GENERAL_SUCCESS_CODE, GENERAL_SUCCESS_MESSAGE, data);
    }

    public static <T> Response<T> yes(final T data, final int code) {
        return new Response<T>(code, GENERAL_SUCCESS_MESSAGE, data);
    }


    public static <T> Response<T> no() {
        return new Response<T>(GENERAL_FAILURE_CODE, GENERAL_FAILURE_MESSAGE, null, false);
    }

    public static <T> Response<T> no(final int code) {
        return new Response<T>(code, GENERAL_FAILURE_MESSAGE, null, false);
    }

    public static <T> Response<T> no(final T data, String message) {
        return new Response<T>(GENERAL_FAILURE_CODE, message, data, false);
    }

    public static <T> Response<T> no(final int code, String message, final T data) {
        return new Response<T>(code, message, data, false);
    }
}
