package com.github.nancom20.heemangBOT.manage.user

import com.github.nancom20.heemangBOT.event.listener.CommandListener
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

class Certification: CommandListener {
    val gameRole = listOf("발로란트", "배틀그라운드", "래프트", "에이펙스", "마인크래프트", "레식", "로스트 아크")

    override fun onCommand(event: MessageReceivedEvent, label: String, args: Array<String>) {
        if (label == "역할") {
            val gender = args[1]
            val game = gameRole.indexOf(args[2])

            val user = event.member
            val guild = event.guild

            for (role in event.guild.roles) {
                if (gameRole[game] == role.name) {
                    user?.let { guild.addRoleToMember(it, role).queue() }
                }
            }

            if (gender == "여자") {
                user?.let { guild.getRoleById(946041674004578334L)?.let { it1 -> guild.addRoleToMember(it, it1).queue() } }
            } else {
                user?.let { guild.getRoleById(946041603649331251L)?.let { it1 -> guild.addRoleToMember(it, it1).queue() } }
            }
        }
    }
}