package com.github.nancom20.heemangBOT.event

import com.github.nancom20.heemangBOT.Heemang
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class CallEvent: ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val eventManager = Heemang.getEventManager()
        val msg = event.message
        val arg = msg.contentRaw.split(" ").toTypedArray()

        if (event.author.isBot) return

        if (arg[0] == "희망아") {
            eventManager.commandNotifyListeners(event, arg[1], arg)
        }

    }
}