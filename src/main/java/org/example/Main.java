package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe principal para execução dos testes da Aula 05.
 */
public class Main {

  /** Logger da aplicação. */
  private static final Logger logger = LogManager.getLogger(Main.class);

  /**
   * Executa os cenários de teste de conta e cadastro de usuário.
   *
   * @param args argumentos de linha de comando
   */
  public static void main(final String[] args) {
    logger.info("=== INICIANDO EXECUTÁVEL DA AULA 05 ===");

    // Teste 1: Operações Válidas
    ContaService conta = new ContaService(1500.00);
    conta.sacar(200.00);

    // Teste 2: Exceção de Limite de Saque
    try {
      conta.sacar(1200.00);
    } catch (LimiteSaqueExcedidoException e) {
      logger.error("Exceção capturada: {}", e.getMessage());
    }

    // Teste 3: Exceção de Saldo Insuficiente
    try {
      conta.sacar(900.00);
      conta.sacar(900.00);
    } catch (SaldoInsuficienteException e) {
      logger.error("Exceção capturada: {}", e.getMessage());
    }

    // Teste 4: Desafio Prático
    CadastroUsuario cadastro = new CadastroUsuario();
    try {
      cadastro.cadastrar("João", 16);
    } catch (IdadeInvalidaException e) {
      logger.error("Exceção capturada: {}", e.getMessage());
    }

    cadastro.salvarArquivo("logs/cadastro_teste.txt");
    logger.info("=== FINALIZANDO EXECUTÁVEL DA AULA 05 ===");
  }
}