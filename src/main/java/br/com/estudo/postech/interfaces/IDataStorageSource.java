package br.com.estudo.postech.interfaces;

import br.com.estudo.postech.dto.EstudanteDTO;
import br.com.estudo.postech.dto.NovoEstudanteDTO;

public interface IDataStorageSource {
    EstudanteDTO obterEstudantePorIdentificacao(String identificacao);

    EstudanteDTO incluirEstudante(NovoEstudanteDTO novoEstudante);

    EstudanteDTO obterEstudantePorNome(String nome);
}
