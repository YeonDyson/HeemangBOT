package com.hope.hopebot;

import com.hope.hopebot.command.certification;
import com.hope.hopebot.command.cmd;
import com.hope.hopebot.command.message;
import com.hope.hopebot.games.account;
import com.hope.hopebot.games.fishing;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.File;

public class HopeBot{
    public static void main(String[] args) {
        try {
            JDA jda = JDABuilder.createDefault("대충 토큰").build();
            jda.setAutoReconnect(true);

            jda.addEventListener(new cmd());
            jda.addEventListener(new account());
            jda.addEventListener(new fishing());
            jda.addEventListener(new message());
            jda.addEventListener(new certification());
            //jda.addEventListener(new shop());

            jda.getPresence().setActivity(Activity.playing("희망아 도움말을 치면 나에 대해 더 잘 알 수 있어!"));

            hope_file();

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    private static void hope_file(){
        File userDirectory = new File("hopebot\\user");
        File channelDirectory = new File("hopebot\\channel");

    }
}
