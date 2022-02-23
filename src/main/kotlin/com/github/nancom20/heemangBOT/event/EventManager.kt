package com.github.nancom20.heemangBOT.event

import com.github.nancom20.heemangBOT.event.listener.CommandListener
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

class EventManager: Component {

    private var listeners: ArrayList<CommandListener> = ArrayList()

    override fun addListener(listener: CommandListener) {
        listeners.add(listener)
    }

    override fun removeListener(listener: CommandListener) {
        listeners.remove(listener)
    }

    override fun commandNotifyListeners(event: MessageReceivedEvent, label: String, args: Array<String>) {
        for (l in listeners){
            l.onCommand(event, label, args)
        }
    }
}