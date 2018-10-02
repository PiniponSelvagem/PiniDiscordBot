package com.piniponselvagem.pinidiscordbot.commands

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

interface Command {
    val info: String
    fun execute(event: GuildMessageReceivedEvent)
}