package br.com.politks.entity;

public enum Municipality {
    SAOPAULO("São Paulo");

    private final String name;

    Municipality(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
