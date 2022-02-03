import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame{
    JTextField textField;

    MyFrame(){
        addButtons();

        addField();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(260, 500);
        this.setVisible(true);
    }

    private void addField() {
        textField = new JTextField(20);
        textField.setBounds(2, 2, 240, 50);
        this.add(textField);
    }

    private void addButtons(){
        int buttonStartX = 2;
        int buttonStartY = 0;
        int buttonSizeX = 60;
        int buttonSizeY = 60;
        int rows = 3;
        int columns = 3;

        List<ButtonData> buttons = new ArrayList<>();
        for (int y=0; y < rows; y++){
            for (int x=0; x < columns; x++){
                int num = y * columns + x + 1;
                buttons.add(new ButtonData(x,
                        rows - y,
                        Integer.toString(num),
                        n -> addToField(Integer.toString(num))));
            }
        }

        buttons.add(new ButtonData(0, 4, ".", n -> addToField(".")));
        buttons.add(new ButtonData(1, 4, "0", n -> addToField("0")));
        buttons.add(new ButtonData(2, 4, "=", n -> compute()));
        buttons.add(new ButtonData(3, 1, "*", n -> addToFieldSeparated("*")));
        buttons.add(new ButtonData(3, 2, "/", n -> addToFieldSeparated("/")));
        buttons.add(new ButtonData(3, 3, "+", n -> addToFieldSeparated("+")));
        buttons.add(new ButtonData(3, 4, "-", n -> addToFieldSeparated("-")));

        for(ButtonData b: buttons){
            JButton button = new JButton(b.sign);
            button.setBounds(buttonStartX + buttonSizeX * b.x,
                    buttonStartY + buttonSizeY * b.y,
                    buttonSizeX,
                    buttonSizeY);
            button.addActionListener(b.method);
            this.add(button);
        }
    }

    private void compute() {
        System.out.println("equals");
    }

    private void addToField(String s){
        textField.setText(textField.getText() + s);
    }

    private void addToFieldSeparated(String s){
        textField.setText(textField.getText() + " " + s + " ");
    }
}
