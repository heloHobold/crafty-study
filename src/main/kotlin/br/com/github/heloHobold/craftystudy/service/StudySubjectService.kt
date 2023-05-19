package br.com.github.heloHobold.craftystudy.service

import br.com.github.heloHobold.craftystudy.dto.request.StudySubjectRequestDTO
import br.com.github.heloHobold.craftystudy.dto.response.StudySubjectResponseDTO
import br.com.github.heloHobold.craftystudy.entity.StudySubject
import br.com.github.heloHobold.craftystudy.repository.StudySubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Collections.list

@Service
class StudySubjectService {

    @Autowired
    lateinit var studySubjectRepository: StudySubjectRepository

    fun created(studySubjectRequest: StudySubjectRequestDTO) : StudySubjectResponseDTO {
        val entity = StudySubject(null, studySubjectRequest.name, studySubjectRequest.contents)
        val save = studySubjectRepository.save(entity)
        return StudySubjectResponseDTO(save.id, save.name, save.contents)
    }

    fun findAll(pageable: Pageable) : Page<StudySubjectResponseDTO> {
        val findAll = studySubjectRepository.findAll(pageable)

        val mapResponseDTO = findAll.map { studySubject ->
            StudySubjectResponseDTO(
                studySubject.id,
                studySubject.name,
                studySubject.contents
            )
        }
        return mapResponseDTO
    }

    fun delete(id: Long) {
        // TODO tratar exceção NOT_FOUND
        with(studySubjectRepository){
            findById(id).ifPresent { deleteById(id) }
        }
    }
}
