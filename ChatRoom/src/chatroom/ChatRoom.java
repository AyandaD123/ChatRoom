
package chatroom;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChatRoom {
  

        JFrame frame = new JFrame ("Chat Room"); 
        JPanel panelB = new JPanel(new GridLayout(1,4));
        JTextArea TXarea = new JTextArea();
        
        JScrollPane scroll = new
        JScrollPane (TXarea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JLabel lblEnter = new JLabel("Enter Text");
        
        JTextField txtHi = new JTextField();
        
        JButton btnSend = new JButton("Send");
        JButton btnResend = new JButton("Resend");
        JButton btnExit = new JButton("Exit");
        
        JMenuBar menuBar = new JMenuBar();
        JMenu Mfile = new JMenu("File");
        JMenu Mhelp = new JMenu("Help");
        
        public void createGUI(){
       
        menuBar.add(Mfile);
        menuBar.add(Mhelp);
        
        TXarea.setLineWrap(true);
        TXarea.setWrapStyleWord(true);
        
        panelB.add(lblEnter);
        panelB.add(txtHi);
        panelB.add(btnSend);
        panelB.add(btnResend);
        panelB.add(btnExit);
        
        Container con = frame.getContentPane();
        con.add(scroll,BorderLayout.CENTER);
        frame.add(panelB,BorderLayout.SOUTH);
        
        btnSend.addActionListener(new Send());
        btnResend.addActionListener(new Resend());
        btnExit.addActionListener(new Exit());
        
        frame.setJMenuBar(menuBar);
        frame.setSize(400,400);
        frame.setLocation(100,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    private class Send implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String str = TXarea.getText();
            
            str = str + "\n" + txtHi.getText();
            TXarea.setText(str);
            txtHi.setText("");
        }
         
    }
    private class Resend implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           txtHi.setText("");
            TXarea.setText("");
            
        }
    }
    private class Exit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
    ChatRoom cr = new ChatRoom();  
    cr.createGUI();
    
   }
}
