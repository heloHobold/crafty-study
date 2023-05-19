package br.com.github.heloHobold.craftystudy.controller

import br.com.github.heloHobold.craftystudy.dto.request.CardRequestDTO
import br.com.github.heloHobold.craftystudy.dto.response.CardResponseDTO
import br.com.github.heloHobold.craftystudy.service.CardService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/card")
class CardController {

    @Autowired
    lateinit var cardService: CardService

    @PostMapping
    fun created(@RequestBody @Valid cardRequest: CardRequestDTO) : ResponseEntity<CardResponseDTO> {
        val created = cardService.created(cardRequest)
        return ResponseEntity.ok().body(created)
    }

    @GetMapping
    fun findAll(@PageableDefault pageable: Pageable) : ResponseEntity<Page<CardResponseDTO>> {
        val findAll = cardService.findAll(pageable)
        return ResponseEntity.ok().body(findAll)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long) : ResponseEntity<Void> {
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}