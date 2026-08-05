package br.com.estudo.postech.interfaces;

import br.com.estudo.postech.domain.entities.Estudante;

public interface IEstudanteGateway {
    Estudante buscarPorIdentificacao(String identificacao);
    Estudante incluir(Estudante estudante);
    Estudante buscarPorNome(String nome);
}
