package com.iesam.agenda.domain;

import com.iesam.agenda.domain.models.Contact;

import java.util.List;

public interface ContactRepository {
    public void save(Contact contact);

    public List<Contact> getAll();
}
