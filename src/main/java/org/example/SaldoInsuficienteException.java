package org.example;

public class SaldoInsuficienteException extends RuntimeException {
  public SaldoInsuficienteException(double saldoAtual) {
    super("Saldo insuficiente. Disponível: R$ " + saldoAtual);
  }
}