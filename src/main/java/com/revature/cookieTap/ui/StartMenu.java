package com.revature.cookieTap.ui;

import com.revature.cookieTap.daos.level1DAO;
import com.revature.cookieTap.daos.level2DAO;
import com.revature.cookieTap.daos.level3DAO;
import com.revature.cookieTap.daos.userDAO;
import com.revature.cookieTap.models.Level1;
import com.revature.cookieTap.models.Level2;
import com.revature.cookieTap.models.Level3;
import com.revature.cookieTap.models.User;
import com.revature.cookieTap.services.*;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StartMenu implements MenuTemplate{
    Scanner scan = new Scanner(System.in);
    FontService font = new FontService();
    UserService userService = new UserService(new userDAO());

    Level1Service level1Service = new Level1Service(new level1DAO());
    Level2Service level2Service = new Level2Service(new level2DAO());
    Level3Service level3Service = new Level3Service(new level3DAO());
    String startMenu = """
+---------------------------------------------------------------------------------------------------------------------+
              _____   _______              _____    _______         __  __   ______   _   _   _    _\s
             / ____| |__   __|     /\\     |  __ \\  |__   __|       |  \\/  | |  ____| | \\ | | | |  | |
            | (___      | |       /  \\    | |__) |    | |          | \\  / | | |__    |  \\| | | |  | |
             \\___ \\     | |      / /\\ \\   |  _  /     | |          | |\\/| | |  __|   | . ` | | |  | |
             ____) |    | |     / ____ \\  | | \\ \\     | |          | |  | | | |____  | |\\  | | |__| |
            |_____/     |_|    /_/    \\_\\ |_|  \\_\\    |_|          |_|  |_| |______| |_| \\_|  \\____/\s
                                                                                                    \s
+----------------------------------------------------------------------------------------------------------------------+                                                           
            """;
    @Override
    public void start() {
        displayStart();
        System.out.println(font.greenBold("                                           PRESS ENTER TO START"));
        scan.nextLine();
        createUser(); // Create new user


    }

    public void displayStart(){
        System.out.println(font.whiteBold(startMenu));
    }

    public void createUser(){
        System.out.println("ENTER NEW USER NAME TO CREATE NEW USER OR ENTER PREVIOUS USERNAME TO VIEW PREVIOUS SCORES");
        System.out.print(font.whiteBold("Enter Username: "));
        String username = scan.nextLine();
        if(userService.isDuplicateUser(username)){
            displayScore(userService.getUserByUsername(username));
        } else {
            User user = new User(UUID.randomUUID().toString(), username, "0", "0", "0");
            userService.registerUser(user);
            System.out.println(font.whiteBold("New User:"+username+" successfully created!"));
            System.out.println(font.greenBold("PRESS ENTER TO START LEVEL 1"));
            scan.nextLine();
            new Level1Menu(user).start();
        }

    }

    public void displayScore(User user){
        List<Level1> levelOneScores = level1Service.getAllByUserID(user.getId());
        List<Level2> levelTwoScores = level2Service.getAllByUserID(user.getId());
        List<Level3> levelThreeScores = level3Service.getAllByUserID(user.getId());
        System.out.println("BELOW ARE ALL THE SCORES FOR "+user.getUsername()+"!");

        System.out.println("+------------------------------------------------+");
        System.out.println("LEVEL 1");
        for (Level1 one:levelOneScores) {
            System.out.println("Date: "+one.getDate());
            System.out.println("Score: "+one.getScore());
            System.out.println("Time: "+one.getTime());
            System.out.println("<--------------------------------->");
        }
        System.out.println("+------------------------------------------------+");
        System.out.println("Level 2");
        for (Level2 two:levelTwoScores){
            System.out.println("Date: "+two.getDate());
            System.out.println("Score: "+two.getScore());
            System.out.println("Time: "+two.getTime());
            System.out.println("<--------------------------------->");
        }
        for (Level3 three:levelThreeScores){
            System.out.println("Date: "+three.getDate());
            System.out.println("Score: "+three.getScore());
            System.out.println("Time: "+three.getTime());
            System.out.println("<--------------------------------->");
        }
        System.out.println("+------------------------------------------------+");

        System.out.println("Press 'Y' TO START GAME FROM LEVEL 1 OR PRESS 'N' TO GO BACK TO MAIN MENU");
        String input = scan.nextLine();

        switch(input){
            case"Y":
               new Level1Menu(user).start();
                break;
            case"N":
                displayStart();
                break;
            default:
                break;
        }
    }

}
