package com.piniponselvagem.discordbot.events

import com.piniponselvagem.discordbot.Bot
import net.dv8tion.jda.core.entities.Channel
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Member
import net.dv8tion.jda.core.events.ReadyEvent
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import net.dv8tion.jda.core.managers.GuildController
import org.slf4j.LoggerFactory


class DiscordListener(val bot: Bot) : ListenerAdapter() {
    private var log = LoggerFactory.getLogger(this::class.qualifiedName)

    override fun onReady(event: ReadyEvent) {
        for (g: Guild in bot.jda.guilds) {
            val txt = StringBuilder()
            txt.appendln("${g.name} - ${g.id}")
            txt.appendln("    Text Channels")
            for (c: Channel in g.textChannels) {
                txt.appendln("        ${c.name} - ${c.id}")
            }
            txt.appendln("    Voice Channels")
            for (c: Channel in g.voiceChannels) {
                txt.appendln("        ${c.name} - ${c.id}")
                for (m: Member in c.members) {
                    txt.appendln("            connected: ${m.user.name} - ${m.effectiveName} - ${m.user.id} ${if(m.user.isBot) "[BOT]" else ""}")
                }
            }
            txt.appendln("    Members")
            for (m: Member in g.members) {
                txt.appendln("        ${m.user.name} - ${m.effectiveName} - ${m.user.id} ${if(m.user.isBot) "[BOT]" else ""}")
            }
            //writeTo("guilds\\${g.id}", "info.txt", txt.toString())
        }

        log.debug("Bot listener ready!")
    }

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        //event.channel.id == "476806936029954048"
        //if (event.channel.id == "476806936029954048") {

            log.info("${event.channel} - ${event.author.name} [${event.author.id}}: ${event.message.contentRaw}")


            if (event.author.isBot) return

            bot.handle(event)

            /*
            println(event.guild.memberCache.asList())
            println(event.guild.memberCache.filter { it.isOwner }) // server owner
            println(event.guild.memberCache.filter { it.effectiveName == "PiniponSelvagem" })

            var member = event.guild.memberCache.filter { it.effectiveName == "PiniponSelvagem" }

            println(member[0].effectiveName)

            /* check all users connected to voice chat in all guilds*/
            for (g in bot.jda.guilds) {
                for (v in g.voiceChannels) {
                    for (m in v.members) {
                        println("${v.name} - ${m.effectiveName}")
                    }
                }
            }
            */
//        }

        //event.channel.sendMessage(event.message.contentRaw).queue()
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.author.id == "226488833053687808") {
            if (event.message.contentRaw == "move") {
                antiMove = !antiMove
                event.channel.sendMessage("ANTIMOVE = $antiMove").queue()
            }
            if (event.message.contentRaw == "follow") {
                followRodas = !followRodas
                antiMove = followRodas
                event.channel.sendMessage("FOLLOW = $followRodas\n\"ANTIMOVE = $antiMove\"").queue()
            }
        }
    }

    private var moving = false
    private var antiMove = true
    private var followRodas = true
    override fun onGuildVoiceMove(event: GuildVoiceMoveEvent) {
        if (event.member.user.id == "226488833053687808" || event.member.user.id == "341944666616365057") { //pini || rodas
            val member  = event.guild.memberCache.getElementById("226488833053687808")
            var channel = event.channelLeft

            if (followRodas && event.member.user.id == "341944666616365057") {
                channel = event.channelJoined
            }

            if (!moving && antiMove) {
                val guild = GuildController(event.guild)
                moving = true
                guild.moveVoiceMember(member, channel).queue()
            } else
                moving = false
        }
    }
}