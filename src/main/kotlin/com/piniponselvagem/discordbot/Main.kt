package com.piniponselvagem.discordbot

import com.piniponselvagem.discordbot.utils.readConfig
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.PropertyConfigurator
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileInputStream
import java.util.*

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        val propFileName = "log4j.properties"
        val f = File("./$propFileName")
        if (f.exists()) {
            try {
                val inStreamLog4j = FileInputStream(f)
                val propertiesLog4j = Properties()

                propertiesLog4j.load(inStreamLog4j)
                PropertyConfigurator.configure(propertiesLog4j)
            } catch (e: Exception) {
                e.printStackTrace()
                BasicConfigurator.configure()
            }

        } else {
            BasicConfigurator.configure()
        }

        val log = LoggerFactory.getLogger(this::class.qualifiedName)
        log.trace("Testing TRACE logging -> OK!")
        log.debug("Testing DEBUG logging -> OK!")
        log.info("Testing INFO logging -> OK!")
        log.warn("Testing WARN logging -> OK!")
        log.error("Testing ERROR logging -> OK!")

        val list = readConfig("config.bot")
        val bot = Bot(list[0], list[1]).run()
        /*
        while(true) {
            println(" - Ready to read from console -")
            println("CONSOLE: " + readLine())
        }
        */
    }
}