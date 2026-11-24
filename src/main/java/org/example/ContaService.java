package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContaService {

  private static final Logger logger = LogManager.getLogger(ContaService.class);
  private static final double LIMITE_SAQUE = 1000.00;
  private double saldo;

  public ContaService(double saldoInicial) {
    this.saldo = saldoInicial;
  }

  public void sacar(double valor) {
    logger.info("Iniciando operação de saque no valor de R$ {}", valor);

    if (valor > LIMITE_SAQUE) {
      logger.warn("Tentativa de saque acim da regra de limite: R$ {}", valor);
      throw new LimiteSaqueExcedidoException(valor, LIMITE_SAQUE);
    }

    if (valor > saldo) {
      logger.error("Falha no saque. Valor tentado: R$ {}, Saldo atual: R$ {}", valor, saldo);
      throw new SaldoInsuficienteException(saldo);
    }

    saldo -= valor;
    logger.info("Saque de R$ {} concluído com sucesso. Novo saldo: R$ {}", valor, saldo);
  }

  public double getSaldo() {
    return saldo;
  }
}