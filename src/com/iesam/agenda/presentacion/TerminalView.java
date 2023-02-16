package com.iesam.agenda.presentacion;

import com.iesam.agenda.data.ContactDataRepository;
import com.iesam.agenda.domain.ContactRepository;
import com.iesam.agenda.domain.models.Contact;
import com.iesam.agenda.domain.usecase.AddContactUseCase;
import com.iesam.agenda.domain.usecase.GetContactsUseCase;

import java.util.List;

public class TerminalView {
    public void init(){
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("Unai");
        contact.setSurname("Gomez");
        contact.setEmail("nose@gmail.es");
        contact.setPhoneNumber("89");

        ContactRepository contactRepository = new ContactDataRepository();

        AddContactUseCase addContactUseCase = new AddContactUseCase(contactRepository);
        addContactUseCase.execute(contact);

        GetContactsUseCase getContactsUseCase = new GetContactsUseCase(contactRepository);
        List<Contact> contactList= getContactsUseCase.execute();
        System.out.println(contactList.size());
    }
}
