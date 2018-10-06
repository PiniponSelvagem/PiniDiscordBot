package com.piniponselvagem.pinidiscordbot

import com.piniponselvagem.pinidiscordbot.commands.*
import com.piniponselvagem.pinidiscordbot.data.DChannel
import com.piniponselvagem.pinidiscordbot.events.DiscordListener
import com.piniponselvagem.pinidiscordbot.parser.CommandParser
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