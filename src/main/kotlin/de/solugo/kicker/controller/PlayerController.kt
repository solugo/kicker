package de.solugo.kicker.controller

import de.solugo.kicker.data.Player
import de.solugo.kicker.repository.PlayerRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/leagues/{leagueId}/players")
open class PlayerController(
        val playerRepository: PlayerRepository
) {

    @GetMapping
    open fun list() = this.playerRepository.findAll()

    @GetMapping("/{playerId}")
    open fun get(
            @PathVariable("leagueId") leagueId: UUID,
            @PathVariable("playerId") playerId: UUID
    ) = this.playerRepository.findOneByLeagueIdAndId(leagueId, playerId)

    @PostMapping
    open fun create(
            @PathVariable("leagueId") leagueId: UUID,
            @RequestBody player: Player
    ) = player.also {
        it.id = UUID.randomUUID()
        it.leagueId = leagueId
    }.let {
        this.playerRepository.save(it)
    }

    @DeleteMapping("/{playerId}")
    open fun delete(
            @PathVariable("leagueId") leagueId: UUID,
            @PathVariable("playerId") playerId: UUID
    ) = this.playerRepository.deleteOneByLeagueIdAndId(leagueId, playerId)

}