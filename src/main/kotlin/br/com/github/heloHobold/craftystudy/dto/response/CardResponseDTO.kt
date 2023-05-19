package br.com.github.heloHobold.craftystudy.dto.response

import br.com.github.heloHobold.craftystudy.entity.StudySubject

data class CardResponseDTO (
   var id : Long? = null,
   var studySubject : StudySubject? = null,
   var difficulty : Int? = null,
   var question : String? = null,
   var response : String? = null) {
}