package br.com.politks.entity;

public enum ElectionResult {
    SECOND_TURN("Segundo Turno"),
    NOT_ELECTED("Não eleito"),
    ELECTED("Eleito");

    private String result;

    ElectionResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

