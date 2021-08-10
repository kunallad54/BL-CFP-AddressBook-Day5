package com.bridgelabz.krunal.addressbookapp.repository;

import com.bridgelabz.krunal.addressbookapp.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook,Integer> {

}
