/**************************************************************************************************
 *
 * Purpose : 1: Address Book Spring Project Setup
 *           2: Make sure all CURL Calls – GET, GET by ID, POST,
 *              PUT to Update by ID, and DELETE work with simple Controller
 *           3: Make sure all CURL Calls – GET, GET by ID, POST, PUT to Update by ID, and
 *              DELETE work with simple Service Layer and storing in a Local List.
 *
 * @author Krunal Lad
 * @since 10-08-2021
 *
 ***************************************************************************************************/

package com.bridgelabz.krunal.addressbookapp.controller;

import com.bridgelabz.krunal.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.krunal.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.krunal.addressbookapp.entity.AddressBook;
import com.bridgelabz.krunal.addressbookapp.service.AddressBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;
    private static final Logger logger = LoggerFactory.getLogger(AddressBookController.class);

    /**
     * Purpose : Ability to use GetMapping HTTP request to fetch all data from database
     *
     * @return
     */
    @GetMapping(value = "/getAddressBook")
    public ResponseEntity<ResponseDTO> getAddressBookDetails() {
        List<AddressBookDTO> personDetails = addressBookService.getAddressBook();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull",personDetails);
        logger.debug("Inside getAddressBookDetails() method");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to use PostMapping HTTP method to add person details to database
     *
     * @param addressBookDTO
     * @return
     */
    @PostMapping(value = "/addPersonDetails")
    public ResponseEntity<ResponseDTO> addPersonDetails(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookDTO newPersonDetails = addressBookService.addPersonDetails(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Post Call Successfull",newPersonDetails);
        logger.debug("Inside addPersonDetails() method");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : To get person details by their ID from Database
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getPersonByID")
    public ResponseEntity<ResponseDTO> getPersonByID(@RequestParam(name = "id") int id) {
        AddressBook personByID = addressBookService.findPersonByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call with Person ID Successfull",
                personByID);
        logger.debug("Inside getPersonByID() method");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : To update person details by giving their ID in the database
     *
     * @param id
     * @param addressBookDTO
     * @return
     */
    @PutMapping(value = "/updatePersonDetails")
    public ResponseEntity<ResponseDTO> updatePersonDetails(@Valid @RequestParam(name = "id") int id,
                                                           @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook updatedDetails = addressBookService.updatePersonDetails(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Call Successfull",updatedDetails);
        logger.debug("Inside updatePersonDetails() method");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : To delete person details by giving their ID from address book database
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletePersonDetails")
    public ResponseEntity<ResponseDTO> deletePersonDetails(@RequestParam(name = "id") int id) {
        AddressBook addressBookAfterDeletion = addressBookService.deletePersonDetails(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Successfull",addressBookAfterDeletion);
        logger.debug("Inside deletePersonDetails() method");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
