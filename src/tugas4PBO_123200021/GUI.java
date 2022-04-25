package tugas4pbo_123200025;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{
    JLabel judul = new JLabel ("LOGIN");
    JLabel luser = new JLabel("Username : ");
    JTextField fuser = new JTextField (20);
    JLabel lpass = new JLabel ("Password : ");
    JPasswordField fpass = new JPasswordField(10);
    JButton blogin = new JButton("Login");
    JButton bcancel = new JButton ("Cancel");
    JLabel lreguser = new JLabel ("Username : ");
    JTextField freguser = new JTextField (20);
    JLabel lregpass = new JLabel ("Password : ");
    JPasswordField fregpass = new JPasswordField (10);
    JButton bregister = new JButton ("Register");
    
    public GUI(){
        setVisible(true);
        setTitle("");
        setSize(500,200);
        setLayout(null);
        add(judul);
        
        //LOGIN
        add(luser);
        add(fuser);
        add(lpass);
        add(fpass);
        add(blogin);
        
        //REGISTER
        add(lreguser);
        add(freguser);
        add(lregpass);
        add(fregpass);
        add(bregister);
        
        //SET SIZE LOGIN
        judul.setBounds(200,10,80,20);
        luser.setBounds(10, 40, 100,30);
        fuser.setBounds(80,40,100,30);
        lpass.setBounds(10,80,100,30);
        fpass.setBounds(80,80,100,30);
        blogin.setBounds(40,120,90,20);
        
        //SET SIZE REGISTER
        lreguser.setBounds(250,40,100,30);
        freguser.setBounds(320,40,100,30);
        lregpass.setBounds(250,80,100,30);
        fregpass.setBounds(320,80,100,30);
        bregister.setBounds(290,120,90,20);
        
        blogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                connector conn = new connector();
                String user = fuser.getText();
                System.out.println(user);
                if (conn.checkUsername(user) && user != "" && conn.checkLogin(user, String.valueOf(fpass.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Success!");
                }
                else if (user.isEmpty() || String.valueOf(fpass.getPassword()).isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Jangan Kosong!");
                }
                else if (!conn.checkUsername(user)) {
                    JOptionPane.showMessageDialog(null, "Username Salah!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password Salah!");
                }
                
            }
            
        });
        bregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                connector conn = new connector();
                String reguser = freguser.getText();
                String regpass = String.valueOf(fregpass.getPassword());
                if (!reguser.isEmpty() && !regpass.isEmpty()) {
                    conn.masukData(reguser,regpass);
                }
                else if (reguser.isEmpty() || regpass.isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Jangan Kosong!");
                }
            }
        });
    }
    
}
