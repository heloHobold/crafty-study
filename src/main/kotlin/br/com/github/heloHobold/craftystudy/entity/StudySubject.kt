package br.com.github.heloHobold.craftystudy.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@Entity
class StudySubject (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    var name : String? = null,
    var contents : List<String>? = null,
    @OneToMany(mappedBy = "studySubject")
    var cards : List<Card>? = null
) {
}
