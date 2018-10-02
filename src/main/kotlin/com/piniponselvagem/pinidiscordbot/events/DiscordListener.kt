package com.piniponselvagem.pinidiscordbot.events

import com.piniponselvagem.pinidiscordbot.Bot
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import net.dv8tion.jda.core.managers.GuildController



class DiscordListener(val bot: Bot) : ListenerAdapter() {

    /*
    override fun onReady(event: ReadyEvent) {
        val txt = StringBuilder()
        for (g: Guild in bot.jda.guilds) {
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
            txt.appendln()
        }
        writeTo("testing", "guilds_channels", txt.toString())
    }
    */

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.channel.id == "476806936029954048") {

            println("${event.channel} - ${event.author.name} [${event.author.id}}: ${event.message.contentRaw}")

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
        }

        //event.channel.sendMessage(event.message.contentRaw).queue()

        /*
        TC:general(495215170021359618) - PiniponSelvagem: J
        [MB:PiniponSelvagem(U:PiniponSelvagem(226488833053687808) / G:PiniServer(495215170021359616)), MB:Sasuke(U:Sasuke(476464364631883782) / G:PiniServer(495215170021359616))]
        [MB:PiniponSelvagem(U:PiniponSelvagem(226488833053687808) / G:PiniServer(495215170021359616))]
        TC:pinibot(476806936029954048) - PiniponSelvagem: owner test
        [MB:Agulha <3(U:Agulha <3(409064623568977920) / G:#ThugLife Community(476050619702968333)), MB:TwitchBot(U:TwitchBot(375805687529209857) / G:#ThugLife Community(476050619702968333)), MB:xick0(U:xick0(386954978649964554) / G:#ThugLife Community(476050619702968333)), MB:🔰 Rodas75(U:🔰 Rodas75(341944666616365057) / G:#ThugLife Community(476050619702968333)), MB:Koty(U:Koty(290455004219834370) / G:#ThugLife Community(476050619702968333)), MB:systemdead1337(U:systemdead1337(217385680932700160) / G:#ThugLife Community(476050619702968333)), MB:Skeetzz(U:Skeetzz(367412000239648769) / G:#ThugLife Community(476050619702968333)), MB:nALRIGHT(U:nALRIGHT(399376752058826762) / G:#ThugLife Community(476050619702968333)), MB:magicz7(U:magicz7(199513255452999680) / G:#ThugLife Community(476050619702968333)), MB:Dank Memer(U:Dank Memer(270904126974590976) / G:#ThugLife Community(476050619702968333)), MB:If I die I'm a legend(U:If I die I'm a legend(341945368012914699) / G:#ThugLife Community(476050619702968333)), MB:Sasuke(U:Sasuke(476464364631883782) / G:#ThugLife Community(476050619702968333)), MB:Kris(U:Kris(324340271934472193) / G:#ThugLife Community(476050619702968333)), MB:Dragon#(U:DragonAsiimov(419837023910625280) / G:#ThugLife Community(476050619702968333)), MB:PiniponSelvagem(U:PiniponSelvagem(226488833053687808) / G:#ThugLife Community(476050619702968333)), MB:carregado(U:carregado(481461539598106624) / G:#ThugLife Community(476050619702968333)), MB:Dr3amS(U:Dr3amS(302535276876660757) / G:#ThugLife Community(476050619702968333)), MB:HypnotizeR(U:HypnotizeR(231874220060049412) / G:#ThugLife Community(476050619702968333)), MB:🔥 SK Fox 🔥(U:🔥 SK Fox 🔥(312976431321841664) / G:#ThugLife Community(476050619702968333)), MB:Dyno(U:Dyno(155149108183695360) / G:#ThugLife Community(476050619702968333)), MB:Rodas75#(U:Rythm(235088799074484224) / G:#ThugLife Community(476050619702968333))]
        [MB:🔰 Rodas75(U:🔰 Rodas75(341944666616365057) / G:#ThugLife Community(476050619702968333))]
         */
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
                event.channel.sendMessage("FOLLOW = $followRodas").queue()
                event.channel.sendMessage("ANTIMOVE = $antiMove").queue()
            }
        }
    }

    private var moving = false
    private var antiMove = false
    private var followRodas = false
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