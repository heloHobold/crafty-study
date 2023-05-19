package br.com.github.heloHobold.craftystudy.dto.request

import jakarta.validation.constraints.NotBlank


data class StudySubjectRequestDTO (
    @NotBlank
    var name : String?,
    var contents : List<String>?
) {
}
