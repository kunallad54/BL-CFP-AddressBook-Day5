/**
 * Purpose : To catch runtime exception and provide desired message
 */
package com.bridgelabz.krunal.addressbookapp.exceptions;

public class AddressBookCustomException extends RuntimeException{

    public AddressBookCustomException(String message) {
        super(message);
    }
}
