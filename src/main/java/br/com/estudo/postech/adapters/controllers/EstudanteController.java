package br.com.estudo.postech.adapters.controllers;

import br.com.estudo.postech.adapters.gateways.EstudanteGateway;
import br.com.estudo.postech.adapters.presenters.EstudantePresenter;
import br.com.estudo.postech.domain.usecases.CadastrarEstudanteUseCase;
import br.com.estudo.postech.dto.EstudanteDTO;
import br.com.estudo.postech.dto.NovoEstudanteDTO;
import br.com.estudo.postech.exceptions.EstudanteJaExistenteException;
import br.com.estudo.postech.interfaces.IDataStorageSource;

public class EstudanteController {

    private final IDataStorageSource dataStorageSource;

    private EstudanteController (IDataStorageSource dataStorageSource) {
        this.dataStorageSource = dataStorageSource;
    }

    public static EstudanteController create (IDataStorageSource dataStorageSource) {
        return new EstudanteController(dataStorageSource);
    }

    public EstudanteDTO Cadastrar(NovoEstudanteDTO novoEstudanteDTO) {
        var estudanteGateway = EstudanteGateway.create(this.dataStorageSource);
        var useCase = CadastrarEstudanteUseCase.create(estudanteGateway);
        try {
            var estudante = useCase.run(novoEstudanteDTO);
            var estudanteDto = EstudantePresenter.ToDTO(estudante);
            return estudanteDto;
        } catch (EstudanteJaExistenteException e) {
            return null;  // deve retornar algo melhor
        }
    }

}
