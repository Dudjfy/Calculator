import javax.swing.*;

public class MyFrame extends JFrame{
    JTextField textField;

    MyFrame(){
        int buttonStartX = 2;
        int buttonStartY = 0;
        int buttonSizeX = 60;
        int buttonSizeY = 60;
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
                button.addActionListener(e -> addToField(Integer.toString(num)));
                this.add(button);
            }
        }

        ButtonData[] extraButtons = new ButtonData[2];
        extraButtons[0] = new ButtonData(0, 4, ".");
        extraButtons[1] = new ButtonData(1, 4, "0");

        for(ButtonData b: extraButtons){
            JButton button = new JButton(b.sign);
            button.setBounds(buttonStartX + buttonSizeX * b.x,
                    buttonStartY + buttonSizeY * b.y,
                    buttonSizeX,
                    buttonSizeY);
            button.addActionListener(e -> addToField(b.sign));
            this.add(button);
        }

        ButtonData equalsData = new ButtonData(2, 4, "=");
        JButton equals = new JButton(equalsData.sign);
        equals.setBounds(buttonStartX + buttonSizeX * equalsData.x,
                buttonStartY + buttonSizeY * equalsData.y,
                buttonSizeX,
                buttonSizeY);
        equals.addActionListener(e -> compute());
        this.add(equals);


        ButtonData[] signButtons = new ButtonData[4];
        signButtons[0] = new ButtonData(3, 1, "*");
        signButtons[1] = new ButtonData(3, 2, "/");
        signButtons[2] = new ButtonData(3, 3, "+");
        signButtons[3] = new ButtonData(3, 4, "-");

        for(ButtonData b: signButtons){
            JButton button = new JButton(b.sign);
            button.setBounds(buttonStartX + buttonSizeX * b.x,
                    buttonStartY + buttonSizeY * b.y,
                    buttonSizeX,
                    buttonSizeY);
            button.addActionListener(e -> addToFieldSeparated(b.sign));
            this.add(button);
        }

        textField = new JTextField(20);
        textField.setBounds(2, 2, 240, 50);
        this.add(textField);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(260, 500);
        this.setVisible(true);
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
