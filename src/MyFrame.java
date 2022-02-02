import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    MyFrame(){
        int buttonStartX = 100;
        int buttonStartY = 100;
        int buttonSizeX = 50;
        int buttonSizeY = 50;
        int rows = 4;
        int columns = 3;

        for (int y=0; y < columns; y++){
            for (int x=0; x < rows; x++){
                int num = y * rows + x + 1;
                JButton button = new JButton();
                button.setBounds(buttonStartX + buttonSizeX * x,
                        buttonStartY + buttonSizeY * y,
                        buttonSizeX,
                        buttonSizeY);
                button.addActionListener(e -> System.out.println("Button " + num));
                button.setText(Integer.toString(num));
                this.add(button);
            }
        }


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(300, 500);
        this.setVisible(true);


    }
}
