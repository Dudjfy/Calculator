import java.awt.event.ActionListener;

public class ButtonData {
    String sign;
    int x;
    int y;
    ActionListener method;

    ButtonData(int x, int y, String sign, ActionListener method){
        this.x = x;
        this.y = y;
        this.sign = sign;
        this.method = method;
    }
}
