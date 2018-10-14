package com.piniponselvagem.discordbot.data

enum class ChannelType {
    TEXT, VOICE
}

data class DGuild(val name: String, val id: String, val channels: List<DChannel>)

data class DChannel(val name: String, val id: String, val type: ChannelType)