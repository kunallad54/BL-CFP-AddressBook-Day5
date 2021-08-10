package com.bridgelabz.krunal.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressBookDTO {

    private int personID;
    private String personName;
    private String personAddress;
    private String personEmail;
    private String personMobileNo;

}
