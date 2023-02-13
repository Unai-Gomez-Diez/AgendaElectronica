package com.iesam.agenda.domain.usecase;

import com.iesam.agenda.domain.ContactRepository;
import com.iesam.agenda.domain.models.Contact;

public class AddContactUseCase {
    private ContactRepository contactRepository;
    public AddContactUseCase(ContactRepository contactRepository){
        this.contactRepository=contactRepository;
    }
    public void execute(Contact contact){
        contactRepository.save(contact);
    }
}
