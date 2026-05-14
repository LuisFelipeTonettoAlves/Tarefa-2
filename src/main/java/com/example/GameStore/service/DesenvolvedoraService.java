package com.example.GameStore.service;

import com.example.GameStore.dto.DesenvolvedoraRequestDTO;
import com.example.GameStore.dto.DesenvolvedoraResponseDTO;
import com.example.GameStore.exception.RecursoNaoEncontradoException;
import com.example.GameStore.model.Desenvolvedora;
import com.example.GameStore.repository.DesenvolvedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedoraService {

    private final DesenvolvedoraRepository repository;

    public DesenvolvedoraService(DesenvolvedoraRepository repository) {
        this.repository = repository;
    }

    public DesenvolvedoraResponseDTO salvar(DesenvolvedoraRequestDTO dto){
        Desenvolvedora desenvolvedora = toEntity(dto);
        Desenvolvedora salva =repository.save(desenvolvedora);
        return toResponseDTO(salva);

    }

    public DesenvolvedoraResponseDTO buscarId(Long idDesenvolvedora){
        Desenvolvedora desenvolvedora = repository.findById(idDesenvolvedora).orElseThrow(() -> new RecursoNaoEncontradoException("Desenvolvedora não encontrada"));
        return toResponseDTO(desenvolvedora);
    }

    public Desenvolvedora buscarEntidade(Long idDesenvolvedora){
        return repository.findById(idDesenvolvedora).orElseThrow(() -> new RecursoNaoEncontradoException("Desenvolvedora não encontrada"));

    }

    public List<DesenvolvedoraResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public void deletar(Long idDesenvolvedora){
        Desenvolvedora desenvolvedora = repository.findById(idDesenvolvedora).orElseThrow(() -> new RecursoNaoEncontradoException("Desenvolvedora não encontrada"));
        repository.delete(desenvolvedora);
    }

    public DesenvolvedoraResponseDTO atualizar(Long idDesenvolvedora, DesenvolvedoraRequestDTO dto){
        Desenvolvedora desenvolvedora = repository.findById(idDesenvolvedora).orElseThrow(() -> new RecursoNaoEncontradoException("Desenvolvedora não encontrada"));

        desenvolvedora.setNome(dto.nome());
        desenvolvedora.setPais(dto.pais());
        desenvolvedora.setAnoFundacao(dto.anoFundacao());

        Desenvolvedora atualizada = repository.save(desenvolvedora);

        return toResponseDTO(atualizada);
    }

    private Desenvolvedora toEntity(DesenvolvedoraRequestDTO dto){
        Desenvolvedora desenvolvedora = new Desenvolvedora();
        desenvolvedora.setNome(dto.nome());
        desenvolvedora.setPais(dto.pais());
        desenvolvedora.setAnoFundacao(dto.anoFundacao());

        return desenvolvedora;
    }

    private DesenvolvedoraResponseDTO toResponseDTO(Desenvolvedora desenvolvedora){
        return new DesenvolvedoraResponseDTO(
                desenvolvedora.getIdDesenvolvedora(),
                desenvolvedora.getNome(),
                desenvolvedora.getPais(),
                desenvolvedora.getAnoFundacao()
        );
    }


    }
