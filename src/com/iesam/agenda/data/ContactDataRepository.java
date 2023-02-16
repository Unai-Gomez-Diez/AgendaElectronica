package com.iesam.agenda.data;

import com.iesam.agenda.data.local.ContactMemLocalDataSource;
import com.iesam.agenda.domain.ContactRepository;
import com.iesam.agenda.domain.models.Contact;

import java.util.List;

public class ContactDataRepository implements ContactRepository {

        private ContactMemLocalDataSource localDataSource = ContactMemLocalDataSource.getInstance();
    @Override
    public void save(Contact contact) {

    }

    @Override
    public List<Contact> getAll() {
        return localDataSource.findAll();
    }
}
