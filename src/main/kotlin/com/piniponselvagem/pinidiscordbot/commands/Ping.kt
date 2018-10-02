package com.piniponselvagem.pinidiscordbot.commands

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class Ping : Command {
    override val info: String
        get() = "Check BOT response time."

    override fun execute(event: GuildMessageReceivedEvent) {
        event.channel.sendMessage("Pong! - ${event.jda.ping}ms").queue()
    }
}