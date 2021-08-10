package com.bridgelabz.krunal.addressbookapp.service;

import com.bridgelabz.krunal.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.krunal.addressbookapp.entity.AddressBook;
import com.bridgelabz.krunal.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    private ModelMapper mapper = new ModelMapper();

    /**
     * Purpose : To get all the person details in address book from DB and show it on console
     *
     * @return list of person's details in address book
     */
    public List<AddressBookDTO> getAddressBook() {
        return addressBookRepository.findAll().stream().map(element -> {
            return new AddressBookDTO(element.getPersonID(), element.getPersonName(), element.getPersonAddress(),
                    element.getPersonEmail(), element.getPersonMobileNo());
        }).collect(Collectors.toList());
    }

    /**
     * Pupose : Add person details to address book and pass it to DB
     *
     * @param addressBookDTO
     * @return
     */
    public AddressBookDTO addPersonDetails(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = mapper.map(addressBookDTO, AddressBook.class);
        addressBookRepository.save(addressBook);
        return addressBookDTO;
    }

    /**
     * Purpose : To get details of Person from address book by giving their ID
     *
     * @param id
     * @return
     */
    public AddressBook getPersonDetailsByID(int id) {
        AddressBook addressBook = findPersonByID(id);
        return addressBook;
    }

    /**
     * Purpose : To update person details in address book by giving their ID
     *
     * @param id
     * @param addressBookDTO
     * @return
     */
    public AddressBook updatePersonDetails(int id, AddressBookDTO addressBookDTO) {
        AddressBook updateData = findPersonByID(id);
        updateData.setPersonName(addressBookDTO.getPersonName());
        updateData.setPersonAddress(addressBookDTO.getPersonAddress());
        updateData.setPersonEmail(addressBookDTO.getPersonEmail());
        updateData.setPersonMobileNo(addressBookDTO.getPersonMobileNo());
        addressBookRepository.save(updateData);
        return updateData;
    }

    /**
     * Purpose : To delete person details from address book by giving their ID
     *
     * @param id
     * @return
     */
    public String deletePersonDetails(int id) {
        AddressBook addressBook = findPersonByID(id);
        addressBookRepository.delete(addressBook);
        return "Deleted Person Details Sucessfully !!!";
    }

    /**
     * Purpose : To check whether person exists or not with that ID
     *
     * @param id
     * @return
     */
    public AddressBook findPersonByID(int id) {
        return addressBookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Unable to find the person with that ID"));
    }
}
