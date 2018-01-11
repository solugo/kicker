@file:JvmName("Kicker")

import de.solugo.kicker.Application
import org.springframework.boot.SpringApplication

fun main(arguments: Array<String>) {
    SpringApplication.run(Application::class.java, *arguments)
}