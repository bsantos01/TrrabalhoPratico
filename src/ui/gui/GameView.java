/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import trabalhopratico.Data.ObservableGame;

/**
 *
 * @author Bruno Santos
 */
public class GameView extends JFrame implements Observer{

    ObservableGame game;
    GamePanel panel;
    Starting start;
    JFrame topFrame = this;

    
    public GameView(){
        super("Mini Rogue");
        this.game= new ObservableGame();
        game.addObserver(this);
        start=new Starting(game);
        panel= new GamePanel(game);      
        addComponents();      
        menus();
        setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();    
    }
    
    
    
    @Override
    public void update(Observable o, Object arg) {
        repaint();    
    }

    private void addComponents() {
        Container cp= getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(panel, BorderLayout.NORTH);
        cp.add(start, BorderLayout.CENTER);
    }
        private void menus() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);

        JMenuItem newGameJMI = new JMenuItem("New Game");
        newGameJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem loadObjJMI = new JMenuItem("Load");
        loadObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        JMenuItem saveObjJMI = new JMenuItem("Save");
        saveObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem exitObjJMI = new JMenuItem("Exit");
        exitObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        gameMenu.add(newGameJMI);
        gameMenu.add(loadObjJMI);
        gameMenu.add(saveObjJMI);
        gameMenu.addSeparator();
        gameMenu.add(exitObjJMI);

        menuBar.add(gameMenu);

        newGameJMI.addActionListener(new NewGameMenuBarListener());
        loadObjJMI.addActionListener(new LoadObjMenuBarListener());
        saveObjJMI.addActionListener(new SaveObjMenuBarListener());
        exitObjJMI.addActionListener(new ExitObjMenuBarListener());
    }

    private class NewGameMenuBarListener implements ActionListener {
         
        @Override
        public void actionPerformed(ActionEvent ae) {
            new GameView();
            topFrame.dispose();        
        }
    }

    private class LoadObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                game.LoadGame();
            } catch (FileNotFoundException ex) {
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class SaveObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            game.SaveGame();
        }
    }

    private class ExitObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }

}
    

