package com.piniponselvagem.pinidiscordbot.commands

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class AntiMove : Command {
    override val info: String
        get() = "Currently private and hardcoded."

    override fun execute(event: GuildMessageReceivedEvent) {
        //event.getTextChannel().getGuild().getManager().kick(victim);

        var memberList = event.guild.memberCache.filter { it.effectiveName == "PiniponSelvagem" }
        var member = memberList[0]
    }
}