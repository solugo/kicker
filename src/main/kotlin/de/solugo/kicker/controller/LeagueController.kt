package de.solugo.kicker.controller

import de.solugo.kicker.data.League
import de.solugo.kicker.repository.LeagueRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/leagues")
open class LeagueController(
        val leagueRepository: LeagueRepository
) {

    @GetMapping
    open fun list() = this.leagueRepository.findAll()

    @GetMapping("/{leagueId}")
    open fun get(@PathVariable("leagueId") leagueId: UUID) = this.leagueRepository.findById(leagueId)

    @PostMapping
    open fun create(@RequestBody league: League) = league.also {
        it.id = UUID.randomUUID()
    }.let {
        this.leagueRepository.save(it)
    }

    @DeleteMapping("/{leagueId}")
    open fun delete(@PathVariable("leagueId") leagueId: UUID) = this.leagueRepository.deleteById(leagueId)

}