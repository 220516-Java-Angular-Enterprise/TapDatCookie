package com.revature.cookieTap.ui;

import com.revature.cookieTap.models.User;
import com.revature.cookieTap.services.FontService;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Level1Menu implements MenuTemplate{
    FontService font = new FontService();
    private final User user;

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
        levelOne();
    }
    public void levelOne(){
        System.out.println("INSTRUCTION: TAP ENTER KEY UNTIL YOU REACH 200");
        int goal = 200;
        int count = 0;
        int fiftyPoints = 0;
        long startTime = getTime();
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
        long timeElasped = finishTime - startTime;
        System.out.println(font.yellowBold("GOAL REACHED!"));
        System.out.println(font.yellowBold(cookie));
        System.out.println("Time took:"+ timeElasped+"!");
        System.out.println("Points Earned: 500");


    }

    public int RngScore(){
      int a = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        return a;
    }

    public long getTime(){
       return System.currentTimeMillis();
    }



}
