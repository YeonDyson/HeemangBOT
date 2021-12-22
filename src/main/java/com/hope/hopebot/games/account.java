package com.hope.hopebot.games;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;

import java.awt.*;

public class account extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equals("희망봇 가입")){

            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.ORANGE);
            embed.setDescription("희망봇 가입");

            event.getChannel().sendMessage(embed.build()).setActionRow(
                    Button.secondary("consent", "가입"),
                    Button.secondary("cancel", "취소")
            ).queue();

        }
    }

    @Override
    public void onButtonClick(ButtonClickEvent event) {

        if (event.getComponentId().equals("consent")){
            event.reply("가입완료!").queue();
        }else if(event.getComponentId().equals("cancel")){
            event.reply("가입 취소").queue();
        }
    }
}
