// NOT YET WORKING

package src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame{
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfUsername, tfPassword;
    JLabel lbwelcome;


    public void init() {
        // Username Label and Text
        JLabel lbUsername = new JLabel("Username");
        lbUsername.setFont(mainFont);
        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        // Password Label and Text
        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);
        tfPassword = new JTextField();
        tfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4,1,5,5));
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(tfPassword);

        // WELCOME LABEL //
        lbwelcome = new JLabel();
        lbwelcome.setFont(mainFont);

        // Buttons
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String userName = tfUsername.getText();
                String password = tfPassword.getText();
            }
            
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                tfUsername.setText("");
                tfPassword.setText("");
                lbwelcome.setText("");
            }

        });

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,2,5,5));
        buttons.add(btnOK);
        buttons.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.add(formPanel, BorderLayout.NORTH);

        add(mainPanel);


        setTitle("Welcome");
        setSize(500,600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.init();
    }
    
}
