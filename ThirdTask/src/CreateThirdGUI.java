import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class CreateThirdGUI extends JFrame{
    private JLabel inputLabel = new JLabel("Ваш массив:");
    private JTextField inputTextField = new JTextField(10);
    private JLabel outputLabel = new JLabel("Результат:");
    private JTextField outputTextField = new JTextField(10);
    private JButton findButton = new JButton("Найти");
    private JButton createButton = new JButton("Массив");
    private int[] array = new int[10];

    public CreateThirdGUI() {
        super("Задание №3");
        this.setBounds(5, 5, 495, 205);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputLabel.setBounds(10,10, 80, 20);
        inputTextField.setBounds(90,10, 265,20);
        inputTextField.setEditable(false);

        outputLabel.setBounds(10,60, 70, 20);
        outputTextField.setBounds(10,85, 343,70);
        outputTextField.setEditable(false);

        this.add(inputLabel);
        this.add(inputTextField);
        this.add(outputLabel);
        this.add(outputTextField);

        createButton.addActionListener(new ButtonEventListener());
        createButton.setBounds(365, 10, 100, 30);
        this.add(createButton);

        findButton.addActionListener(new ButtonEventListener());
        findButton.setBounds(365, 125, 100, 30);
        this.add(findButton);
    }

    public class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == findButton) {
                if (!inputTextField.getText().isEmpty()) {
                    int[] newArray = findDivisibleNumbers(array);
                    outputTextField.setText(Arrays.toString(newArray));
                }
                else outputTextField.setText ("Вы не сгенерировали массив");
            }
            else if (e.getSource() == createButton) {
                inputTextField.setText(null);
                inputTextField.setText(Arrays.toString(createRandomArray()));
                outputTextField.setText(null);
            }
        }
    }

    private int[] createRandomArray() {
        Random random = new Random();
        IntStream.range(0, array.length).forEach(i -> array[i] = random.nextInt(-99, 99));
        return array;
    }

    public int[] findDivisibleNumbers(int[] array) {
        return Arrays.stream(array).filter(x -> x % 3 == 0).toArray();
    }
}