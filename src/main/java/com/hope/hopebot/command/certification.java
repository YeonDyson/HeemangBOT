package com.hope.hopebot.command;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class certification extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String[] arg = msg.getContentRaw().split(" ");
        EmbedBuilder embed = new EmbedBuilder();

        if (event.getAuthor().isBot()) return;

        if (arg[0].equals("희망아")) {
            if (arg[1].equals("인증")) {
                File file = new File("hopebot\\channel\\"+event.getChannel().getId()+"\\certification.json");
                JsonObject object = new JsonObject();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                object.addProperty("name", arg[2]);
                object.addProperty("roleID", arg[3]);

                msg.reply(gson.toJson(object)).queue();
                msg.reply(file.toPath().toString()).queue();

                embed.setColor(Color.ORANGE);
                embed.setTitle(arg[2]);
                event.getChannel().sendMessage(embed.build()).setActionRow(
                        Button.secondary("certification", "인증")
                ).queue();
            }
        }
    }

    @Override
    public void onButtonClick(ButtonClickEvent event) {
        if (event.getComponentId().equals("certification")){
            File file = new File("hopebot\\channel\\"+event.getChannel().getId()+"\\certification.json");
            event.getMessage().reply("<@" + event.getMember().getId() + ">" + "인증완료!").queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
            event.deferEdit().queue();
        }
    }
}