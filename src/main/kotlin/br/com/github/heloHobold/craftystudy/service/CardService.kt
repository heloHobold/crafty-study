package br.com.github.heloHobold.craftystudy.service

import br.com.github.heloHobold.craftystudy.dto.request.CardRequestDTO
import br.com.github.heloHobold.craftystudy.dto.response.CardResponseDTO
import br.com.github.heloHobold.craftystudy.entity.Card
import br.com.github.heloHobold.craftystudy.repository.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CardService {

    @Autowired
    lateinit var cardRepository: CardRepository

    fun created(cardRequest: CardRequestDTO) : CardResponseDTO {
        val entity = Card(null, cardRequest.studySubject, cardRequest.difficulty, cardRequest.question, cardRequest.response)
        val save = cardRepository.save(entity)
        return CardResponseDTO(save.id, save.studySubject, save.difficulty, save.question, save.response)
    }

    fun findAll(pageable: Pageable) : Page<CardResponseDTO> {
        val findAll = cardRepository.findAll(pageable)

        val mapResponseDTO = findAll.map { card ->
            CardResponseDTO(
                card.id,
                card.studySubject,
                card.difficulty,
                card.question,
                card.response
            )
        }
        return mapResponseDTO
    }

    fun delete(id: Long) {
        // TODO tratar exceção NOT_FOUND
        with(cardRepository){
            findById(id).ifPresent { deleteById(id) }
        }
    }
}