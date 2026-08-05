package br.com.estudo.postech.domain.usecases;

import br.com.estudo.postech.domain.entities.Estudante;
import br.com.estudo.postech.exceptions.EstudanteNaoEncontradoException;
import br.com.estudo.postech.interfaces.IEstudanteGateway;

public class BuscarEstudantePorNomeUseCase {

    private final IEstudanteGateway gateway;

    private BuscarEstudantePorNomeUseCase(IEstudanteGateway gateway) {
        this.gateway = gateway;
    }

    public static BuscarEstudantePorNomeUseCase create(IEstudanteGateway gateway) {
        return new BuscarEstudantePorNomeUseCase(gateway);
    }

    public Estudante run(String nome) throws EstudanteNaoEncontradoException {
        Estudante estudante = gateway.buscarPorNome(nome);
        if (estudante == null) {
            throw new EstudanteNaoEncontradoException(nome);
        }
        return estudante;
    }
}
