package com.piniponselvagem.discordbot.commands

import com.piniponselvagem.discordbot.Bot
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

interface Command {
    val info: String
    fun execute(event: GuildMessageReceivedEvent, bot: Bot)
}