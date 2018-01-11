package de.solugo.kicker.repository

import de.solugo.kicker.data.Player
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlayerRepository : MongoRepository<Player, UUID> {
    fun findOneByLeagueIdAndId(leagueId: UUID, id: UUID): Player
    fun findAllByLeagueId(leagueId: UUID): Player
    fun deleteOneByLeagueIdAndId(leagueId: UUID, id: UUID): Player
}