package com.piniponselvagem.pinidiscordbot.commands

import com.piniponselvagem.pinidiscordbot.Bot
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class Ping : Command {
    override val info: String
        get() = "Check BOT response time."

    override fun execute(event: GuildMessageReceivedEvent, bot: Bot) {
        event.channel.sendMessage("Pong! - ${event.jda.ping}ms").queue()
    }
}