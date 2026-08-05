package br.com.estudo.postech.domain.usecases;

import br.com.estudo.postech.domain.entities.Estudante;
import br.com.estudo.postech.exceptions.EstudanteNaoEncontradoException;
import br.com.estudo.postech.interfaces.IEstudanteGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BuscarEstudantePorNomeUseCaseTest {

    @Test
    @DisplayName("Busca com sucesso")
    void testeEncontrando() {
        String nomeTestar = "Nome Teste";

        IEstudanteGateway IEstudanteGateway = mock(IEstudanteGateway.class);
        when(IEstudanteGateway.buscarPorNome(anyString())).thenReturn(
                Estudante.create(nomeTestar, 40, "teste@teste.com")
        );
        final Estudante estudante = BuscarEstudantePorNomeUseCase.create(IEstudanteGateway).run(nomeTestar);
        assertNotNull(estudante);
        assertEquals(estudante.getNome(), nomeTestar);
    }

    @Test
    @DisplayName("Busca inexistente")
    void testeNaoEncontrando() {
        String nomeTestar = "Nome Teste";

        IEstudanteGateway IEstudanteGateway = mock(IEstudanteGateway.class);
        when(IEstudanteGateway.buscarPorNome(anyString())).thenReturn(null);

        assertThrows(EstudanteNaoEncontradoException.class, () -> {
            final Estudante estudante = BuscarEstudantePorNomeUseCase.create(IEstudanteGateway).run(nomeTestar);
        });

    }
}