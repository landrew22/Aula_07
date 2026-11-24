package org.example;


/**
 * Exceção lançada quando o valor de saque ultrapassa o limite permitido.
 */
public class LimiteSaqueExcedidoException extends RuntimeException {

  /**
   * Cria uma nova instância com os valores de tentativa e limite máximo.
   *
   * @param valorTentado valor solicitado para o saque
   * @param limiteMaximo limite máximo permitido por operação
   */
  public LimiteSaqueExcedidoException(
      final double valorTentado, final double limiteMaximo) {
    super(
        "Saque de R$ " + valorTentado
            + " excede o limite máximo permitido por operação: R$ "
            + limiteMaximo);
  }
}