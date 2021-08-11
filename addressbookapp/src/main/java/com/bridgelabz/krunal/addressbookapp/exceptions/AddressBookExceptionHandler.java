/**
 * Purpose : To handle all the exceptions of the address book program
 */
package com.bridgelabz.krunal.addressbookapp.exceptions;

import com.bridgelabz.krunal.addressbookapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressBookExceptionHandler {

    /**
     * Purpose : To handle all the exceptions of if the user input are not valid
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException
                                                                                          exception){
        List<ObjectError>errorList = exception.getBindingResult().getAllErrors();
        List<String>errMsg = errorList.stream()
                                .map(objectError -> objectError.getDefaultMessage())
                                .collect(Collectors.toList());
        ResponseDTO responseDTO =
                new ResponseDTO("Exception while processing the REST request",errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Purpose : To handle the runtime exception thrown during execution
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(AddressBookCustomException.class)
    public ResponseEntity<ResponseDTO>handleAddressBookException(
            AddressBookCustomException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing the REST request"
                ,exception.getMessage());
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}
