package com.iesam.agenda.domain;

import com.iesam.agenda.domain.models.Contact;

public interface ContactRepository {
    public void save(Contact contact);
}
