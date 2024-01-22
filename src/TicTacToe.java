import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.midi.MidiFileFormat;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;  // dont need player 2 because when it isn't player's 1 turn, its player's 2

    TicTacToe() {

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(32, 32, 32));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //TEXT ON TOP
        textField.setBackground(new Color(192, 192, 192));
        textField.setForeground(new Color(102, 0, 204));
        textField.setFont(new Font("Arial", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100); //location of the title panel

        //BUTTONS
        button_panel.setLayout(new GridLayout(3, 3)); //grid
        button_panel.setBackground(new Color(150, 150, 150)); //bg

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        //BOUND EVERYTHING TOGETHER
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 102, 102));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(102, 178, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }


    public void firstTurn() {

        //delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
        } else {
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    public void check() {
//check X win conditions
        if ((buttons[0].getText() == "X") &&
            (buttons[1].getText() == "X") &&
            (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);}
        if ((buttons[3].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);}
        if ((buttons[6].getText() == "X") &&
            (buttons[7].getText() == "X") &&
            (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);}


        if ((buttons[0].getText() == "X") &&
            (buttons[3].getText() == "X") &&
            (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);}
        if ((buttons[1].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);}
        if ((buttons[2].getText() == "X") &&
            (buttons[5].getText() == "X") &&
            (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);}


        if ((buttons[0].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);}
        if ((buttons[2].getText() == "X") &&
           (buttons[4].getText() == "X") &&
           (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);}



        //check O win conditions
        if ((buttons[0].getText() == "O") &&
           (buttons[1].getText() == "O") &&
           (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);}
        if ((buttons[3].getText() == "O") &&
           (buttons[4].getText() == "O") &&
           (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);}
        if ((buttons[6].getText() == "O") &&
            (buttons[7].getText() == "O") &&
            (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);}


        if ((buttons[0].getText() == "O") &&
           (buttons[3].getText() == "O") &&
           (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);}
        if ((buttons[1].getText() == "O") &&
           (buttons[4].getText() == "O") &&
           (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);}
        if ((buttons[2].getText() == "O") &&
            (buttons[5].getText() == "O") &&
            (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);}


        if ((buttons[0].getText() == "O") &&
           (buttons[4].getText() == "O") &&
           (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);}
        if ((buttons[2].getText() == "O") &&
            (buttons[4].getText() == "O") &&
             (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {

        buttons[a].setBackground(new Color(255,102,178));
        buttons[b].setBackground(new Color(255,102,178));
        buttons[c].setBackground(new Color(255,102,178));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X WINS");
    }

    public void oWins(int a, int b, int c) {

        buttons[a].setBackground(new Color(255,178,102));
        buttons[b].setBackground(new Color(255,178,102));
        buttons[c].setBackground(new Color(255,178,102));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O WINS");
    }
}
