package de.solugo.kicker.repository

import de.solugo.kicker.data.League
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LeagueRepository : MongoRepository<League, UUID> {
    fun findByName(name: String): League
}