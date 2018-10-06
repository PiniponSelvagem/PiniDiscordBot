package com.piniponselvagem.pinidiscordbot

object Main {

    /** PiniBot **/
    private const val token   = ""
    private const val ownerID = ""

    @JvmStatic
    fun main(args: Array<String>) {
        println(this::class.qualifiedName)

        val bot = Bot(token, ownerID).run()

        while(true) {
            println(" - Ready to read from console -")
            println("CONSOLE: " + readLine())
        }
    }
}