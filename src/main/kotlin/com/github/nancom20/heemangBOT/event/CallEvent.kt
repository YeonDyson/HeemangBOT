package com.github.nancom20.heemangBOT.event

import com.github.nancom20.heemangBOT.Heemang
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class CallEvent: ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val eventManager = Heemang.getEventManager()
        val msg = event.message
        val arg = msg.contentRaw.split(" ").toTypedArray()
        val args = arg.toMutableList()

        args.remove("HL!")

        if (event.author.isBot) return

        if (arg[0] == "HL!") {
            try {
                eventManager.commandNotifyListeners(event, arg[1], args.toTypedArray())
            }catch (e: ArrayIndexOutOfBoundsException) {
                event.message.reply("음ㅁ").queue()
            }
        }
    }
}