package org.example;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CadastroUsuario {

  private static final Logger logger = LogManager.getLogger(CadastroUsuario.class);

  public void cadastrar(String nome, int idade) {
    logger.info("Iniciando cadastro do usuário: {}", nome);
    if (idade < 18) {
      logger.error("Falha no cadastro do usuário {}: idade inferior a 18 anos.", nome);
      throw new IdadeInvalidaException(idade);
    }
    logger.info("Usuário {} cadastrado com sucesso.", nome);
  }

  public void salvarArquivo(String path) {
    logger.info("Salvando arquivo em: {}", path);
    java.io.File arquivo = new java.io.File(path);
    if (arquivo.getParentFile() != null) {
      arquivo.getParentFile().mkdirs(); // Cria a pasta "logs" se ela não existir
    }

    try (FileWriter fw = new FileWriter(arquivo)) {
      fw.write("Dados do usuário gravados com sucesso.");
      logger.info("Arquivo salvo com sucesso em: {}", path);
    } catch (IOException e) {
      logger.error("Erro ao escrever no arquivo em {}: {}", path, e.getMessage(), e);
    }
  }
}