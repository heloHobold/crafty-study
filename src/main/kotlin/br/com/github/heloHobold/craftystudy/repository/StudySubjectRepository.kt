package br.com.github.heloHobold.craftystudy.repository

import br.com.github.heloHobold.craftystudy.entity.StudySubject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudySubjectRepository : JpaRepository<StudySubject, Long> {

}