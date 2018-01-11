package de.solugo.kicker.data

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*

data class Player(
        var id: UUID? = null,
        var name: String? = null,
        @JsonIgnore
        var leagueId: UUID? = null
)