import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFirstGUI extends JFrame{
    private JLabel inputLabel = new JLabel("Введите число:");
    private JTextField inputTextField = new JTextField(10);
    private JLabel outputLabel = new JLabel("Результат:");
    private JTextField outputTextField = new JTextField(10);
    private JButton sendButton = new JButton("Ввод");
    private JButton clearButton = new JButton("Очистка");

    public CreateFirstGUI() {
        super("Задание №1");
        this.setBounds(5, 5, 460, 210);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputLabel.setBounds(10,10, 100, 20);
        inputTextField.setBounds(115,10, 195,20);

        outputLabel.setBounds(10,60, 70, 20);
        outputTextField.setBounds(10,85, 300,70);
        outputTextField.setEditable(false);

        this.add(inputLabel);
        this.add(inputTextField);
        this.add(outputLabel);
        this.add(outputTextField);

        sendButton.addActionListener(new ButtonEventListener());
        sendButton.setBounds(330, 10, 100, 30);
        this.add(sendButton);

        clearButton.addActionListener(new ButtonEventListener());
        clearButton.setBounds(330, 60, 100, 30);
        this.add(clearButton);
    }

    public class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sendButton) {
                try {
                    outputTextField.setText(inputNumber(Integer.parseInt(inputTextField.getText())));
                } catch (Exception ex) {
                    outputTextField.setText ("Вы ошиблись");
                }
            }
            else if (e.getSource() == clearButton) {
                inputTextField.setText("");
                outputTextField.setText("");
            }
        }
    }
    public String inputNumber(double val) {

        return val > 7.0 ? "Привет" : "Попробуйте ввести число больше 7";
    }
}