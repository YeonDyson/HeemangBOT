package com.github.nancom20.heemangBOT.manage.message

import com.github.nancom20.heemangBOT.event.listener.CommandListener
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

class Message: CommandListener {

    override fun onCommand(event: MessageReceivedEvent, label: String, args: Array<String>) {
        if (label == "ping!"){
            println(label)
            event.message.reply("pong!").queue()
        }
    }
}