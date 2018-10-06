package com.piniponselvagem.pinidiscordbot.commands

import com.piniponselvagem.pinidiscordbot.Bot
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

interface Command {
    val info: String
    fun execute(event: GuildMessageReceivedEvent, bot: Bot)
}