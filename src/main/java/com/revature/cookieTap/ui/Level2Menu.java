package com.revature.cookieTap.ui;

import com.revature.cookieTap.daos.level2DAO;
import com.revature.cookieTap.models.Level2;
import com.revature.cookieTap.models.User;
import com.revature.cookieTap.services.FontService;
import com.revature.cookieTap.services.Level2Service;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Level2Menu implements MenuTemplate{
    FontService font = new FontService();
    private final User user;

    Level2Service level2Service = new Level2Service(new level2DAO());
    Scanner scan = new Scanner(System.in);
    public Level2Menu(User user) {
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

    String level2 = """
                
                     _        ______  __      __  ______   _        ___ \s
                    | |      |  ____| \\ \\    / / |  ____| | |      |__ \\\s
                    | |      | |__     \\ \\  / /  | |__    | |         ) |
                    | |      |  __|     \\ \\/ /   |  __|   | |        / /\s
                    | |____  | |____     \\  /    | |____  | |____   / /_\s
                    |______| |______|     \\/     |______| |______| |____|
                        
            """;


    String cookie = """
                 
                        )       )        )   (          \s
               (     ( /(    ( /(     ( /(   )\\ )       \s
               )\\    )\\())   )\\())    )\\()) (()/(   (   \s
             (((_)  ((_)\\   ((_)\\   |((_)\\   /(_))  )\\  \s
             )\\___    ((_)    ((_)  |_ ((_) (_))   ((_) \s
            ((/ __|  / _ \\   / _ \\  | |/ /  |_ _|  | __|\s
             | (__  | (_) | | (_) |   ' <    | |   | _| \s
              \\___|  \\___/   \\___/   _|\\_\\  |___|  |___|\s
                                                        \s
                
                  """;
    @Override
    public void start() {
        System.out.println(font.purpleBold(Welcome));
        System.out.println(font.greenBold("\n                                           ROUND 2 STARTS IN..."));
        //creates delay
        System.out.println("                                                    3...");
        try{
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Thread was interrupted.");
        }
        System.out.println("                                                    2...");
        try{
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Thread was interrupted.");
        }
        System.out.println("                                                    1...");
        try{
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Thread was interrupted.");
        }

        System.out.println(font.cyanBold(level2));
        levelTwo(user);
    }

    public void levelTwo(User user){
        System.out.println("INSTRUCTION: TAP ENTER KEY UNTIL YOU REACH 300");
        int goal = 300;
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
        if (timeElasped <= 10) score = 100;
        if(timeElasped <= 7) score = 300;
        if (timeElasped <= 5) score = 500;
        if (timeElasped<= 3) score = 700;
        if (timeElasped <= 2) score = 900;
        if(timeElasped <= 1) score = 1000;

        System.out.println(font.purpleBold("+-------------------- YOU FINISHED! --------------------+"));
        System.out.println(font.whiteBold("Time took: ")+ font.purpleBold(timeElasped+"s!"));
        System.out.println(font.whiteBold("Points Earned: ")+font.purpleBold(score+""));
        System.out.println(font.purpleBold("+--------------------------------------------------------+"));
        String date = LocalDateTime.now().toString();

        Level2 twoSave = new Level2(UUID.randomUUID().toString(), user.getId(), score, timeElasped, date);
        level2Service.register(twoSave);
    }
    public int RngScore(){
        int a = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        return a;
    }

    public long getTime(){
        return System.currentTimeMillis();
    }



}
