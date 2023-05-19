package br.com.github.heloHobold.craftystudy.dto.request

import br.com.github.heloHobold.craftystudy.entity.StudySubject
import jakarta.validation.Valid
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CardRequestDTO(
    @NotNull
    @Valid
    var studySubject : StudySubject? = null,
    @NotNull
    @Max(10)
    @Min(0)
    var difficulty : Int? = null,
    @NotBlank
    var question : String? = null,
    @NotBlank
    var response : String? = null
) {

}