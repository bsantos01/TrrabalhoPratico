/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import ui.UI;
import ui.gui.GameView;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class Main {
        
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Scanner s= new Scanner(System.in);
        
        System.out.println("###################################################");
        System.out.println("#                                                 #");
        System.out.println("#  MiniRogue                                      #");
        System.out.println("#                                                 #");
        System.out.println("#  1 - Text                                       #");
        System.out.println("#  2 - Graphic                                    #");
        System.out.println("#  3 - Exit                                       #");
        System.out.println("#                                                 #");
        System.out.println("#     Bruno Santos & Miguel Almeida               #");
        System.out.println("#                                                 #");
        System.out.println("###################################################");
        System.out.println();
        System.out.print(">> ");

        int op;
        do{
            op = s.nextInt();
        }while(op<1 && op>3);
        switch (op) {
            case 1:
                UI ui= new UI();
                ui.run();
                return;

            case 2:
                new GameView();
                return;

            case 3:
                System.exit(0);
        }

 
    
        
    }
}
