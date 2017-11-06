package com.example.kevingates.screenoff;

/**
 * Created by kevingates on 11/3/17.
 */

import android.view.Window;
import android.view.WindowManager;

import java.net.*;
import java.io.*;

public class WindowsUtils {

    public static void lockScreenDim(Window window, boolean lock) {
        if (lock) {
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    public String  addWord(String word) {

        return word;
    }

    public String getCurl(String link) {


        return "gates";
    }
}