package com.piniponselvagem.discordbot.commands

import com.piniponselvagem.discordbot.Bot
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class Stats : Command {
    override val info: String
        get() = "Bot statistics."

    override fun execute(event: GuildMessageReceivedEvent, bot: Bot) {
        event.channel.sendMessage("STATISTICS //TODO").queue() //TODO statistics
    }
}