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
import com.bridgelabz.krunal.addressbookapp.entity.AddressBook;
import com.bridgelabz.krunal.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Purpose : Ability to use GetMapping HTTP request to fetch all data from database
     *
     * @return
     */
    @GetMapping(value = "/getAddressBook")
    public ResponseEntity<List<AddressBookDTO>> getAddressBookDetails() {
        return new ResponseEntity<>(addressBookService.getAddressBook(), HttpStatus.OK);
    }

    /**
     * Purpose : Ability to use PostMapping HTTP method to add person details to database
     *
     * @param addressBookDTO
     * @return
     */
    @PostMapping(value = "/addPersonDetails")
    public ResponseEntity<AddressBookDTO> addPersonDetails(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>(addressBookService.addPersonDetails(addressBookDTO), HttpStatus.OK);
    }

    /**
     * Purpose : To get person details by their ID from Database
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getPersonByID")
    public ResponseEntity<AddressBook> getPersonByID(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(addressBookService.findPersonByID(id), HttpStatus.OK);
    }

    /**
     * Purpose : To update person details by giving their ID in the database
     *
     * @param id
     * @param addressBookDTO
     * @return
     */
    @PutMapping(value = "/updatePersonDetails")
    public ResponseEntity<AddressBook> updatePersonDetails(@RequestParam(name = "id") int id,
                                                           @RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>(addressBookService.updatePersonDetails(id, addressBookDTO), HttpStatus.OK);
    }

    /**
     * Purpose : To delete person details by giving their ID from address book database
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletePersonDetails")
    public ResponseEntity<String> deletePersonDetails(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(addressBookService.deletePersonDetails(id), HttpStatus.OK);
    }

}
