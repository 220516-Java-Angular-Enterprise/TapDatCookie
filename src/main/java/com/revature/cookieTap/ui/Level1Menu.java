package com.revature.cookieTap.ui;

import com.revature.cookieTap.daos.level1DAO;
import com.revature.cookieTap.models.Level1;
import com.revature.cookieTap.models.User;
import com.revature.cookieTap.services.FontService;
import com.revature.cookieTap.services.Level1Service;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Level1Menu implements MenuTemplate{
    FontService font = new FontService();
    private final User user;

    Level1Service level1Service = new Level1Service(new level1DAO());

    Scanner scan = new Scanner(System.in);
    public Level1Menu(User user) {
        this.user = user;
    }
    String Welcome = """
             _______              _____      _____               _______      _____    ____     ____    _  __  _____   ______\s
            |__   __|     /\\     |  __ \\    |  __ \\      /\\     |__   __|    / ____|  / __ \\   / __ \\  | |/ / |_   _| |  ____|
               | |       /  \\    | |__) |   | |  | |    /  \\       | |      | |      | |  | | | |  | | | ' /    | |   | |__  \s
               | |      / /\\ \\   |  ___/    | |  | |   / /\\ \\      | |      | |      | |  | | | |  | | |  <     | |   |  __| \s
               | |     / ____ \\  | |        | |__| |  / ____ \\     | |      | |____  | |__| | | |__| | | . \\   _| |_  | |____\s
               |_|    /_/    \\_\\ |_|        |_____/  /_/    \\_\\    |_|       \\_____|  \\____/   \\____/  |_|\\_\\ |_____| |______|
                                                                                                                        
            """;

    String level1 = """
              _        ______  __      __  ______   _          __\s
             | |      |  ____| \\ \\    / / |  ____| | |       /_ |
             | |      | |__     \\ \\  / /  | |__    | |        | |
             | |      |  __|     \\ \\/ /   |  __|   | |        | |
             | |____  | |____     \\  /    | |____  | |____    | |
             |______| |______|     \\/     |______| |______|   |_|
            """;


    String cookie = """
                 
              _____                   _      _       \s
             / ____|                 | |    (_)      \s
            | |        ___     ___   | | __  _    ___\s
            | |       / _ \\   / _ \\  | |/ / | |  / _ \\
            | |____  | (_) | | (_) | |   <  | | |  __/
             \\_____|  \\___/   \\___/  |_|\\_\\ |_|  \\___|
                                                     \s
                                                     \s
                  """;
    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println(font.purpleBold(Welcome));
        System.out.println(font.greenBold("\n                                           PRESS ENTER FOR NEXT"));
        scan.nextLine();
        System.out.println(font.cyanBold(level1));
        levelOne(user);
    }
    public void levelOne(User user){
        System.out.println("INSTRUCTION: TAP ENTER KEY UNTIL YOU REACH 200");
        int goal = 200;
        int count = 0;
        int fiftyPoints = 0;
        long startTime = getTime();
        int score = 0;
        while(count < goal){
            scan.nextLine();

            count += RngScore() * 2;

            if(fiftyPoints == ThreadLocalRandom.current().nextInt(1, 20+1)){
                count += 50;
                System.out.println(font.yellowBold("**BONUS 50 POINTS**"));
            }
            System.out.println(font.whiteBold(count+"/"+goal));
        }
        long finishTime = getTime();
        double timeElasped = (finishTime - startTime)/1000.0;
        System.out.println(font.yellowBold("GOAL REACHED!"));
        System.out.println(font.yellowBold(cookie));

        try{
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Thread was interrupted.");
        }

        if (timeElasped <= 10) score = 100;
        if(timeElasped <= 7) score = 300;
        if (timeElasped <= 5) score = 500;
        if (timeElasped<= 3) score = 700;
        if (timeElasped <= 2) score = 900;
        if(timeElasped <= 1) score = 1000;

        System.out.println("Time took:"+ timeElasped+"s!");
        System.out.println("Points Earned: "+score);
        String date = LocalDateTime.now().toString();

        Level1 oneSave = new Level1(UUID.randomUUID().toString(), user.getId(), score, timeElasped, date);
        level1Service.register(oneSave);

        Level2Menu level2Menu = new Level2Menu(user);
        level2Menu.start();
    }

    public int RngScore(){
      int a = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        return a;
    }

    public long getTime(){
       return System.currentTimeMillis();
    }



}
