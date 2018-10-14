package com.piniponselvagem.discordbot

import com.piniponselvagem.discordbot.commands.*
import com.piniponselvagem.discordbot.data.DChannel
import com.piniponselvagem.discordbot.events.DiscordListener
import com.piniponselvagem.discordbot.parser.CommandParser
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent

class Bot(token: String, ownerID: String) : Thread() {
    private val discordListener = DiscordListener(this)
    val jda = JDABuilder(AccountType.BOT)
            .setToken(token)
            .addEventListener(discordListener)
            .build()

    val channelWhiteList: MutableList<DChannel> = mutableListOf()

    init {
        registerCommands()
    }

    private fun registerCommands() {
        CommandParser["help"]       = { Help()              }
        CommandParser["ping"]       = { Ping()              }
        CommandParser["antimove"]   = { AntiMove()          }
        CommandParser["stats"]      = { Stats()             }
        CommandParser["cWhiteList"] = { ChannelWhiteList()  }
    }

    fun handle(event: GuildMessageReceivedEvent) {
        CommandParser.getCommand(event.message.contentRaw.split(" ")[0])?.execute(event, this)
    }
}