package br.com.estudo.postech.adapters.presenters;

import br.com.estudo.postech.domain.entities.Estudante;
import br.com.estudo.postech.dto.EstudanteDTO;

public class EstudantePresenter {

    public static EstudanteDTO toDTO(Estudante estudante) {
        final String identificacao = estudante.getIdentificacaoInterna();
        final String identificacaoOfuscada = identificacao.charAt(1) + "..." + identificacao.charAt(identificacao.length() - 1);

        EstudanteDTO estudanteDTO = new EstudanteDTO(
                identificacaoOfuscada,
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getEnderecoEmail()
        );
        return estudanteDTO;
    }

}
