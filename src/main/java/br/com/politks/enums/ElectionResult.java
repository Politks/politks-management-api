package br.com.politks.enums;

public enum ElectionResult {
  SECOND_TURN("Segundo Turno"),
  NOT_ELECTED("Não eleito"),
  ELECTED("Eleito"),
  ELECTED_BY_AVERAGE("Eleito por média"),
  ELECTED_BY_QP("Eleito por QP");

  private String result;

  ElectionResult(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }
}
