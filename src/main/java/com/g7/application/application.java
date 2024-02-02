package com.g7.application;

import com.g7.main.LoginJDialog;

public class application {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginJDialog().setVisible(true);
        });
    }

}
