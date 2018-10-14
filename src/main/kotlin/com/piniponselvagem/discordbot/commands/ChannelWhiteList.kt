package com.piniponselvagem.discordbot.commands

import com.piniponselvagem.discordbot.Bot
import com.piniponselvagem.discordbot.data.ChannelType
import com.piniponselvagem.discordbot.data.DChannel
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class ChannelWhiteList : Command {
    override val info: String
        get() = "Set which text channels the BOT can speak at. If none, can speak in any."

    override fun execute(event: GuildMessageReceivedEvent, bot: Bot) {
        println(event.message.contentRaw.split(" ")[1])     //TODO: Can throw exception if no params
        if (event.message.contentRaw.split(" ")[1] == "this") {
            val channel = DChannel(event.channel.name, event.channel.id, ChannelType.TEXT)
            if (!bot.channelWhiteList.contains(channel)) {
                bot.channelWhiteList.add(channel)
            }
            else {
                event.channel.sendMessage("This channel is already on the WhiteList.").queue()
                return
            }
        }
        if (event.message.contentRaw.split(" ")[1] == "removeThis") {
            val channel = DChannel(event.channel.name, event.channel.id, ChannelType.TEXT)
            bot.channelWhiteList.remove(channel)
        }
        event.channel.sendMessage("Channels white listed: \n ${bot.channelWhiteList}").queue()
    }
}