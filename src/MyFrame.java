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
        int rows = 3;
        int columns = 3;

        for (int y=0; y < rows; y++){
            for (int x=0; x < columns; x++){
                int num = y * columns + x + 1;
                JButton button = new JButton(Integer.toString(num));
                button.setBounds(buttonStartX + buttonSizeX * x,
                        buttonStartY + buttonSizeY * rows - buttonSizeY * y,
                        buttonSizeX,
                        buttonSizeY);
                button.addActionListener(e -> addToField(num));
                this.add(button);
            }
        }


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(300, 500);
        this.setVisible(true);
    }

    static void addToField(int n){
        System.out.println("Button " + n);
    }
}
