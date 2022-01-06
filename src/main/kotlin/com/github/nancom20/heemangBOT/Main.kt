package com.github.nancom20.heemangBOT

import com.github.nancom20.heemangBOT.event.CallEvent
import com.github.nancom20.heemangBOT.manage.message.Message
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.EventListener

fun main(args: Array<String>) {
    val jda: JDA = JDABuilder.createDefault(args[0])
        .addEventListeners(Main())
        .addEventListeners(CallEvent()).build()
    val eventManager = Heemang.getEventManager()
        .addListener(Message())

    jda.presence.activity = Activity.playing("희망아 도움말을 치면 나에 대해 더 잘 알 수 있어!")
}

class Main: EventListener {
    override fun onEvent(event: GenericEvent) {
        if (event is ReadyEvent)
            println("ready!")
    }
}