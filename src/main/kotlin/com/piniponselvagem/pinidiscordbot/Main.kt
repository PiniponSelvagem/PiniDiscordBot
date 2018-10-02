package com.piniponselvagem.pinidiscordbot

object Main {

    /** PiniBot **/
    private const val token   = "NDc2NDY0MzY0NjMxODgzNzgy.Dkt9sQ.WtgBXes7IC_38JMoPKGcGDGPJ2A"
    private const val ownerID = "226488833053687808"


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