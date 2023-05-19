package br.com.github.heloHobold.craftystudy.repository

import br.com.github.heloHobold.craftystudy.entity.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : JpaRepository<Card, Long> {
}