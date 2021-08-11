/**
 * Purpose : To define properties of address book and also validate user input
 *           using regex expression
 */
package com.bridgelabz.krunal.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class AddressBookDTO {

    private int personID;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$",message = "Person name was Invalid")
    private String personName;

    private String personAddress;

    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:([0-9-]{1}|[a-zA-Z]{3,5})\\.)+[a-zA-Z]{2,3}",message = "Email-ID is Invalid")
    private String personEmail;

    @Pattern(regexp = "(0|91)?[7-9][0-9]{9}",message = "Mobile Number is Invalid")
    private String personMobileNo;

}
