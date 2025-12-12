package com.automationexercise.api.models;

public class Pet {

    private long id;
    private String name;
    private String status;

    public Pet(long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public static Pet getPetData() {
        return new Pet(
                System.currentTimeMillis(),
                "DoggieTest",
                "available"
        );
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}