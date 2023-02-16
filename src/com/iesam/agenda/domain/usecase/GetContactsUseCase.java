package com.iesam.agenda.domain.usecase;

import com.iesam.agenda.domain.ContactRepository;
import com.iesam.agenda.domain.models.Contact;

import java.util.List;

public class GetContactsUseCase {
    private ContactRepository contactRepository;
    public GetContactsUseCase(ContactRepository contactRepository){
      this.contactRepository = contactRepository;
    }
    public List<Contact> execute(){
        return contactRepository.getAll();
    }
}
