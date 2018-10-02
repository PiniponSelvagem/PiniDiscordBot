package com.piniponselvagem.pinidiscordbot.commands

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class Help : Command {
    override val info: String
        get() = "Show commands list."

    override fun execute(event: GuildMessageReceivedEvent) {
        event.channel.sendMessage("line 1${System.lineSeparator()}line2").queue()
    }
}