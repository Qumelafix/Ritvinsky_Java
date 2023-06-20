import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSecondGUI extends JFrame {
    private JLabel inputLabel = new JLabel("Введите имя:");
    private JTextField inputTextField = new JTextField(10);
    private JLabel outputLabel = new JLabel("Результат:");
    private JTextField outputTextField = new JTextField(10);
    private JButton sendButton = new JButton("Ввод");
    private JButton clearButton = new JButton("Очистка");

    public CreateSecondGUI() {
        super("Задание №2");
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
                    outputTextField.setText(compareName(inputTextField.getText()));
                } catch (Exception ex) {
                    outputTextField.setText ("Вы ничего не ввели");
                }
            }
            else if (e.getSource() == clearButton) {
                inputTextField.setText("");
                outputTextField.setText("");
            }
        }
    }

    public String compareName(String s) {
        return (s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .compareTo("Вячеслав") == 0 ? "Привет, Вячеслав" : "Нет такого имени";
    }
}