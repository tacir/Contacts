package com.example.tacir.contacts.Model;

public class Contact {
    private String name;
    private String surname;
    private String image;

    public Contact(String name, String surname, String image) {
        this.name = name;
        this.surname = surname;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    private String city;
    private String street;
    private String e_mail;
    private boolean is_comleted;
    private int id;
    private String number;

    public Contact(String city, String street, String e_mail, int id, String number) {
        this.city = city;
        this.street = street;
        this.e_mail = e_mail;
        this.id = id;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public boolean isIs_comleted() {
        return is_comleted;
    }

    public void setIs_comleted(boolean is_comleted) {
        this.is_comleted = is_comleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", image='" + image + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", is_comleted=" + is_comleted +
                ", id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
