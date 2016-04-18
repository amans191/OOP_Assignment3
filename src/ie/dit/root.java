package ie.dit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP-PC on 4/18/2016.
 */
public class root {


    public static void main(String[] args) {
        JFrame frame = new JFrame("root");
        frame.setContentPane(new root().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel panel1;
    private JButton choosefile = new JButton();

    public void btnpresed(ActionEvent e)
    {
        choosefile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {


        // TODO: place custom component creation code here

    }
}
