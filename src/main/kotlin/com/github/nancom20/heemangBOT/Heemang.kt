package com.github.nancom20.heemangBOT

import com.github.nancom20.heemangBOT.event.EventManager

object Heemang {
    private val eventManager = EventManager()

    fun getEventManager(): EventManager{
        return eventManager
    }
}