package org.example;

public class LimiteSaqueExcedidoException extends RuntimeException {
  public LimiteSaqueExcedidoException(double valorTentado, double limiteMaximo) {
    super("Saque de R$ " + valorTentado + " excede o limite máximo permitido por operação: R$ " + limiteMaximo);
  }
}