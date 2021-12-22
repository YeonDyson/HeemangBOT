package com.hope.hopebot.games;

import com.hope.hopebot.games.player.Player;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class fishing extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equals("희망아 낚시")){
            Random random = new Random();
            Player player = new Player(event.getMember().getId());
            String[] fishLine = {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬛"};
            String[] userFishLine = {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬛"};
            fishLine[random.nextInt(10)] = "\uD83D\uDFE6";

            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.ORANGE);
            embed.setAuthor("• 희망봇 낚시", null, "https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
            embed.addField("낚시중", String.join(" ", fishLine), false);
            embed.addField("----------------------------------------------------", String.join(" ", userFishLine), false);
            embed.setFooter(event.getGuild().getTimeCreated().toString());

            event.getMessage().reply(embed.build()).queue(message -> fFishing(message, fishLine));
        }
    }


    public static void fFishing(Message message, String[] fishLine){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int i;
            @Override
            public void run() {
                if(i == 10){
                    return;
                }

                String[] userFishLine = {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬛"};
                userFishLine[i] = "\uD83D\uDFE6";
                i++;

                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(Color.ORANGE);
                embed.setAuthor("• 희망봇 낚시", null, "https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                embed.addField("낚시중", String.join(" ", fishLine), false);
                embed.addField("----------------------------------------------------", String.join(" ", userFishLine), false);
                embed.setFooter(message.getGuild().getTimeCreated().toString());

                message.editMessage(embed.build()).queue();
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }
}
