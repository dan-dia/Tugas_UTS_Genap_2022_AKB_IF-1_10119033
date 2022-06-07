package com.dandiahmadin.tugasutsgenap2022akbif_110119033.model;

import java.util.Date;
//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1
public class NoteModel {
    private String title, category, notes;
    private Date created_at;

    public NoteModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
