package com.mycakeapp.exceptions;

import com.mycakeapp.entities.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
//import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
//@ApiIgnore
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseDto handleInvalidReportid(HttpServletRequest req, UserNotFoundException ex) {
        ResponseDto responseDto = ResponseDto.builder()
                .data(null)
                .status("601")
                .message("Invalid Report Id : " + ex.getLocalizedMessage())
                .build();
        return responseDto;
    }
}
