package com.piniponselvagem.pinidiscordbot

import com.piniponselvagem.pinidiscordbot.utils.readConfig

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println(this::class.qualifiedName)

        val list = readConfig("config.bot")
        val bot = Bot(list[0], list[1]).run()

        while(true) {
            println(" - Ready to read from console -")
            println("CONSOLE: " + readLine())
        }
    }

}