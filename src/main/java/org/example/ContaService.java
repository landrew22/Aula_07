package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Serviço responsável pelas operações de conta e controle de saque.
 */
public class ContaService {

  /** Logger do serviço de conta. */
  private static final Logger logger = LogManager.getLogger(ContaService.class);

  /** Limite máximo permitido por operação de saque. */
  private static final double LIMITE_SAQUE = 1000.00;

  /** Saldo atual disponível na conta. */
  private double saldo;

  /**
   * Cria uma conta com o saldo inicial informado.
   *
   * @param saldoInicial valor inicial da conta
   */
  public ContaService(final double saldoInicial) {
    this.saldo = saldoInicial;
  }

  /**
   * Realiza um saque na conta respeitando limite e saldo disponível.
   *
   * @param valor valor solicitado para o saque
   */
  public void sacar(final double valor) {
    logger.info("Iniciando operação de saque no valor de R$ {}", valor);

    if (valor > LIMITE_SAQUE) {
      logger.warn(
          "Tentativa de saque acim da regra de limite: R$ {}", valor);
      throw new LimiteSaqueExcedidoException(valor, LIMITE_SAQUE);
    }

    if (valor > saldo) {
      logger.error(
          "Falha no saque. Valor tentado: R$ {}, Saldo atual: R$ {}",
          valor,
          saldo);
      throw new SaldoInsuficienteException(saldo);
    }

    saldo -= valor;
    logger.info(
        "Saque de R$ {} concluído com sucesso. Novo saldo: R$ {}",
        valor,
        saldo);
  }

  /**
   * Retorna o saldo atual da conta.
   *
   * @return saldo disponível
   */
  public double getSaldo() {
    return saldo;
  }
}