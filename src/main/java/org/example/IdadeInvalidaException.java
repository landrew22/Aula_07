package org.example;

public class IdadeInvalidaException extends RuntimeException {
  public IdadeInvalidaException(int idade) {
    super("Usuário menor de idade (" + idade + " anos). Idade mínima permitida: 18.");
  }
}