import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame{
    JTextField textField;

    MyFrame(){
        addButtons(2, 0, 60, 60, 3, 3);

        addField(2, 2, 250, 50, 20);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(260, 500);
        this.setVisible(true);
    }

    private void addField(int fieldStartX,
                          int fieldStartY,
                          int fieldSizeX,
                          int fieldSizeY,
                          int columns) {

        textField = new JTextField(columns);
        textField.setBounds(fieldStartX, fieldStartY, fieldSizeX, fieldSizeY);
        this.add(textField);
    }

    private void addButtons(int buttonStartX,
                            int buttonStartY,
                            int buttonSizeX,
                            int buttonSizeY,
                            int rows,
                            int columns){

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
