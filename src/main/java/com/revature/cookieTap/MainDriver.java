package com.revature.cookieTap;

import com.revature.cookieTap.ui.StartMenu;
import com.revature.cookieTap.utils.DatabaseConnection;

public class MainDriver {
    public static void main(String args[]){
        StartMenu start = new StartMenu();

        start.start();
//        System.out.println(DatabaseConnection.getCon());

    }

}
