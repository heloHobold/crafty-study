package br.com.github.heloHobold.craftystudy.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
class Card (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studySubject_id", nullable = false)
    var studySubject : StudySubject? = null,
    var difficulty : Int? = null,
    var question : String? = null,
    var response : String? = null
    )
{

}