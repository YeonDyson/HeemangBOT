package com.github.nancom20.heemangBOT

import com.github.nancom20.heemangBOT.event.CallEvent
import com.github.nancom20.heemangBOT.manage.message.Message
import com.github.nancom20.heemangBOT.manage.message.Vote
import com.github.nancom20.heemangBOT.manage.user.Certification
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
    eventManager.addListener(Message())
    eventManager.addListener(Vote())
    eventManager.addListener(Certification())

    jda.presence.activity = Activity.playing("나는 한다 명령어실행.")
}

class Main: EventListener {
    override fun onEvent(event: GenericEvent) {
        if (event is ReadyEvent)
            println("ready!")
    }
}