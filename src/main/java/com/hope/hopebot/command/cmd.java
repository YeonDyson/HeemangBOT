package com.hope.hopebot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;

import java.awt.*;

public class cmd extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String[] arg = msg.getContentRaw().split(" ");

        if (event.getAuthor().isBot()) return;

        if (arg[0].equals("희망아")) {
            if (arg[1].equals("정보")) {

                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(Color.ORANGE);
                embed.setAuthor("• 희망봇 정보", null, "https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                embed.setThumbnail("https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                embed.addField("정보", "정보정보정보", true);
                embed.addField("정보", "정보정보정보", true);
                embed.setFooter(event.getGuild().getTimeCreated().toString());

                msg.reply(embed.build()).setActionRow(
                        Button.link("https://www.youtube.com/c/Hongmin%ED%99%8D%EB%AF%BC", "홍민님유튜브"),
                        Button.link("https://github.com/nancom20/HopeBot2", "깃허브")
                ).queue();

            }

            if (arg[1].equals("도움말")) {

                EmbedBuilder Page1 = new EmbedBuilder();
                Page1.setColor(Color.ORANGE);
                Page1.setAuthor("• 희망봇 도움말", null, "https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                Page1.setThumbnail("https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                Page1.addField("관리 1/3", "서버관리를 편하게할수있는 명령어들이야!", true);
                Page1.addField("청소", "``메세지를 꺠끗하게 청소해! (희망아 청소 (청소할 메시지 개수))``", false);
                Page1.addField("뮤트", "부우족", false);
                Page1.addField("밴", "아이디어좀", false);
                Page1.setFooter(event.getGuild().getTimeCreated().toString());

                EmbedBuilder Page2 = new EmbedBuilder();
                Page2.setColor(Color.ORANGE);
                Page2.setAuthor("• 희망봇 도움말", null, "https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                Page2.setThumbnail("https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                Page2.addField("관리 2/3", "서버관리를 편하게할수있는 명령어들이야!", true);
                Page2.addField("투표", "메세지를 꺠끗하게 청소해! (희망아 청소 (청소할 메시지 개수))", false);
                Page2.addField("인증", "부우족", false);
                Page2.addField("밴", "아이디어좀", false);
                Page2.setFooter(event.getGuild().getTimeCreated().toString());

                EmbedBuilder Page3 = new EmbedBuilder();
                Page3.setColor(Color.ORANGE);
                Page3.setAuthor("• 희망봇 도움말", null, "https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                Page3.setThumbnail("https://cdn.discordapp.com/attachments/773727937069056000/857254590218371082/526_B39FCE5.png");
                Page3.addField("관리 3/3", "서버관리를 편하게할수있는 명령어들이야!", true);
                Page3.addField("설정", "삭제", false);
                Page3.setFooter(event.getGuild().getTimeCreated().toString());

                msg.reply(Page1.build()).setActionRow(
                        Button.secondary("aa", "뒤로"),
                        Button.secondary("a", "넘기기")
                ).queue();

            }

            if (arg[1].equals("a")) {
                if (event.getMember().getId().equals("401282433426653186")) {
                    for (Role Roles : event.getMessage().getGuild().getRoles()) {
                        event.getMessage().reply(Roles.getId() + Roles.getName()).queue();
                        event.getMessage().reply("<@&" + Roles.getId() + ">").queue();
                    }
                    for (Guild guild: event.getJDA().getGuilds())
                        for (GuildChannel channel: guild.getChannels())
                            System.out.println(channel.getName());
                }
            }

            if (arg[1].equals("별명")) {
                try {
                    event.getMember().modifyNickname(arg[2]).queue();
                } catch (HierarchyException e) {
                    msg.reply("높은 권한").queue();
                } catch (InsufficientPermissionException e){
                    msg.reply("권한부족" + e.getPermission()).queue();
                } catch (ArrayIndexOutOfBoundsException e){
                    msg.reply("접두사 별명 (별명)").queue();
                }
            }
        }
    }

    @Override
    public void onButtonClick(ButtonClickEvent event) {
        if(event.getComponentId().equals("aa")){

        }

        if(event.getComponentId().equals("a")){

        }
    }
}
