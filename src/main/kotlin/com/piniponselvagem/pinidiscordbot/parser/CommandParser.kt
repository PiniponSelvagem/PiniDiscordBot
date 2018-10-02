package com.piniponselvagem.pinidiscordbot.parser

import com.piniponselvagem.pinidiscordbot.commands.Command


object CommandParser {

    private val commands: MutableMap<String, ()-> Command> = mutableMapOf();

    operator fun set(cmdStr: String, cmdFactory: () -> Command) {
        commands[cmdStr] = cmdFactory
    }

    fun getCommand(cmdString: String) : Command? =
            commands[cmdString]?.invoke()

    /*
    private fun String.isCommandOf(commandTemplate: String): Boolean {
        val commandParts: List<String> = this.split("/")
        val commandTemplateParts = commandTemplate.split("/")
        if(commandParts.size != commandTemplateParts.size)
            return false

        val regex = Regex("\\{\\w*\\}")
        for (i in commandParts.indices) {
            if(commandParts[i] != commandTemplateParts[i] && !commandTemplateParts[i].matches(regex))
                return false
        }

        return true
    }
    */
}