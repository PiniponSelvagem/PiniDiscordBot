package com.piniponselvagem.pinidiscordbot.commands

import com.piniponselvagem.pinidiscordbot.Bot
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class Stats : Command {
    override val info: String
        get() = "Bot statistics."

    override fun execute(event: GuildMessageReceivedEvent, bot: Bot) {
        event.channel.sendMessage("STATISTICS //TODO").queue() //TODO statistics
    }
}