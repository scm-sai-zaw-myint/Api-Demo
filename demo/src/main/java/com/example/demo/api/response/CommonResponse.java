package com.example.demo.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;

    public CommonResponse(boolean success, String message, Date timestamp){
        this.success = success;
        this.message = message;
        this.timestamp = timestamp;
    }
}
