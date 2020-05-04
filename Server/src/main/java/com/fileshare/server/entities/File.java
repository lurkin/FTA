package com.fileshare.server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "myfile")
public class File {

    @Id
    private Long id;
    private String name,
            path;
    @Lob
    private byte[] data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
