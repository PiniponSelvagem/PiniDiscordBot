package com.piniponselvagem.pinidiscordbot.commands

import com.piniponselvagem.pinidiscordbot.Bot
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class Help : Command {
    override val info: String
        get() = "Show commands list."

    override fun execute(event: GuildMessageReceivedEvent, bot: Bot) {
        event.channel.sendMessage("line 1${System.lineSeparator()}line2").queue()
    }
}