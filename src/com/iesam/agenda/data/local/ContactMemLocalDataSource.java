package com.iesam.agenda.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.agenda.domain.models.Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class ContactMemLocalDataSource {
    private static ContactMemLocalDataSource instance = null;
    private Map<Integer, Contact> storage = new TreeMap<>();
    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Contact>>() {
    }.getType();

    private ContactMemLocalDataSource() {
    }

    public void save(Contact contact) {
        List<Contact> contacts = findAll();
        contacts.add(contact);
        saveToFile(contacts);
    }

    private void saveToFile(List<Contact> contacts) {
        try {
            FileWriter myWriter = new FileWriter("alumnos.txt");
            myWriter.write(gson.toJson(contacts));
            myWriter.close();
            System.out.println("Alumno guardado correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public Contact findById(Integer contactId) {
        List<Contact> contacts = findAll();
        for (Contact contact : contacts) {
            if (Objects.equals(contact.id, alumnoId)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> findAll() {
        try {
            File myObj = new File("alumnos.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAlumnList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<Contact>();
    }

    public static ContactMemLocalDataSource getInstance() {
        if (instance == null) {
            instance = new ContactMemLocalDataSource();
        }
        return instance;
    }
}
