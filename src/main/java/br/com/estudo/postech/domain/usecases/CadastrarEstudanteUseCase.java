package br.com.estudo.postech.domain.usecases;

import br.com.estudo.postech.dto.NovoEstudanteDTO;
import br.com.estudo.postech.domain.entities.Estudante;
import br.com.estudo.postech.exceptions.EstudanteJaExistenteException;
import br.com.estudo.postech.interfaces.IEstudanteGateway;

public class CadastrarEstudanteUseCase {
    private final IEstudanteGateway gateway;

    private CadastrarEstudanteUseCase(IEstudanteGateway gateway) {
        this.gateway = gateway;
    }

    public static CadastrarEstudanteUseCase create(IEstudanteGateway gateway) {
        return new CadastrarEstudanteUseCase(gateway);
    }

    public Estudante run(NovoEstudanteDTO novoEstudanteDTO) throws EstudanteJaExistenteException {
        final Estudante estudanteExistente = gateway.buscarPorNome(novoEstudanteDTO.nome());

        if (estudanteExistente != null) {
            throw new EstudanteJaExistenteException(novoEstudanteDTO.nome());
        }

        final Estudante novoEstudante = Estudante.create(
                novoEstudanteDTO.nome(),
                novoEstudanteDTO.idade(),
                novoEstudanteDTO.enderecoEmail()
        );

        Estudante estudante = gateway.incluir(novoEstudante);
        return estudante;
    }
}
