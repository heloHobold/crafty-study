package br.com.github.heloHobold.craftystudy.controller

import br.com.github.heloHobold.craftystudy.dto.request.StudySubjectRequestDTO
import br.com.github.heloHobold.craftystudy.dto.response.StudySubjectResponseDTO
import br.com.github.heloHobold.craftystudy.service.StudySubjectService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/studySubject")
class StudySubjectController {

    @Autowired
    lateinit var studySubjectService: StudySubjectService

    @PostMapping
    fun created(@RequestBody @Valid studySubjectRequest: StudySubjectRequestDTO) : ResponseEntity<StudySubjectResponseDTO> {
        val created = studySubjectService.created(studySubjectRequest)
        return ResponseEntity.ok().body(created)
    }

    @GetMapping
    fun findAll(@PageableDefault pageable: Pageable) : ResponseEntity<Page<StudySubjectResponseDTO>> {
        val findAll = studySubjectService.findAll(pageable)
        return ResponseEntity.ok().body(findAll)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long) : ResponseEntity<Void> {
        studySubjectService.delete(id);
        return ResponseEntity.noContent().build();
    }

}