package com.github.nancom20.heemangBOT.event

import com.github.nancom20.heemangBOT.event.listener.CommandListener
import net.dv8tion.jda.api.events.message.MessageReceivedEvent


interface Component {
    fun addListener(listener: CommandListener)
    fun removeListener(listener: CommandListener)
    fun commandNotifyListeners(event: MessageReceivedEvent, label: String, args: Array<String>)
}