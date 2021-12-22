package com.hope.hopebot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class message extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String[] arg = msg.getContentRaw().split(" ");
        TextChannel textChannel = event.getTextChannel();
        EnumSet<Permission> permissionList = msg.getMember().getPermissions();
        EmbedBuilder embed = new EmbedBuilder();

        if (arg[0].equals("희망아")) {
            if (arg[1].equals("청소")) {
                //if(permissionList.contains(Permission.ADMINISTRATOR)){
                    try {
                        int Count = Integer.parseInt(arg[2]);

                        if (Count <= 1 || 100 < Count){
                            msg.reply("1이상 100이하로 적어줘").queue();
                            return;
                        }

                        MessageHistory messageHistory = new MessageHistory(event.getChannel());
                        List<Message> list = messageHistory.retrievePast(Count).complete();

                        event.getTextChannel().deleteMessages(list).queue();
                        msg.reply(Count + "개의 메시지를 청소했어!").queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));

                    } catch (NumberFormatException e){
                        msg.reply("숫자로 적어줘").queue();
                    } catch (InsufficientPermissionException e){
                        embed.setColor(Color.RED);
                        embed.setAuthor("• 희망봇", null, "https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                        embed.setTitle("권한이 부족해");
                        embed.addField("필요한 권한", "```"+ e.getPermission() +"```", true);
                        msg.reply(embed.build()).queue();
                    } catch (ArrayIndexOutOfBoundsException e){
                        msg.reply("``희망아 청소 (청소할 메시지 개수)``").queue();
                    }
                //}else {
                //    msg.reply("서버 관리자만 쓸 수 있어").queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                //}
            }
        }

    }
}
