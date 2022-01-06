package com.github.nancom20.heemangBOT.event.listener

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

interface CommandListener {
    fun onCommand(event: MessageReceivedEvent, label: String, args: Array<String>)
}