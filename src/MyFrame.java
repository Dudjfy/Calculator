import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    JTextField textField;

    MyFrame(){
        int buttonStartX = 2;
        int buttonStartY = 0;
        int buttonSizeX = 60;
        int buttonSizeY = 60;
        int rows = 3;
        int columns = 4;

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
        JButton zero = new JButton(Integer.toString(0));
        zero.setBounds(buttonStartX + buttonSizeX,
                buttonStartY + buttonSizeY * (rows + 1),
                buttonSizeX,
                buttonSizeY);
        zero.addActionListener(e -> addToField(0));
        this.add(zero);

        textField = new JTextField(20);
        textField.setBounds(2, 2, 240, 50);
        this.add(textField);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(260, 500);
        this.setVisible(true);
    }

    void addToField(int n){
        textField.setText(textField.getText() + n);
    }
}
