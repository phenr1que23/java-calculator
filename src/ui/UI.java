package ui;

import service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class UI {
    private JLabel display;
    private Service service = new Service();

    public void initialize_ui(){
        JFrame window = create_window();
        create_visor(window);
        create_button(window);
        window.setVisible(true);
    }

    private JFrame create_window(){
        JFrame window = new JFrame("calculator");
        GridBagLayout layout = new GridBagLayout();
        layout.columnWeights = new double[]{1, 1, 1, 1};
        layout.rowWeights = new double[]{1, 1, 1, 1, 1, 1};
        window.setLayout(layout);
        window.setSize(500, 700);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color(0, 0, 0));
        return window;
    }

    private void create_visor(JFrame window){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.BOTH;
        display = new JLabel("0",  JLabel.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setForeground(new Color(255, 255, 255));
        window.add(display, c);
    }

    private void create_button(JFrame window){
        int rows = 5, columns = 4, indexButton = 0;
        String [] buttonsText = {
                "AC", "+/-", "%", "/",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "SQRT", "="
        };
        HashMap<String, String> buttonsMap = getStringStringHashMap();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                c.gridx = j;
                c.gridy = i + 1;
                JButton button = new JButton(buttonsText[indexButton]);
                button.setBackground(fill_button(button, buttonsMap));
                button.setForeground(fill_foreground_button(button, buttonsMap));
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setPreferredSize(new Dimension(0, 0));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(button.getText().equals("AC")){
                            clear_all(display);
                        }
                        else if(buttonsMap.get(button.getText()).equals("numbers")){
                            write_number(display, button);
                        }
                        else if(button.getText().equals(".")){
                            write_dot(display, button);
                        }
                        else if(button.getText().equals("+/-")){
                            reverse(display);
                        }
                        else if(buttonsMap.get(button.getText()).equals("opers")){
                            set_oper(display, button);
                        }
                        else if(button.getText().equals("=")){
                            set_b(display);
                            display.setText(String.valueOf(service.calculate()));
                        }
                        else if(button.getText().equals("SQRT")){
                            service.a = Double.parseDouble(display.getText());
                            display.setText(String.valueOf(service.sqrt()));
                        }
                        else if(button.getText().equals("%")){
                            service.a = Double.parseDouble(display.getText());
                            display.setText(String.valueOf(service.percentage()));
                        }
                    }
                });
                window.add(button, c);
                indexButton++;
            }
        }
    }

    private HashMap<String, String> getStringStringHashMap() {
        HashMap<String, String> buttonsMap = new HashMap<>();
        buttonsMap.put("+", "opers");
        buttonsMap.put("-", "opers");
        buttonsMap.put("x", "opers");
        buttonsMap.put("/", "opers");
        buttonsMap.put("=", "equal");
        buttonsMap.put("0", "numbers");
        buttonsMap.put("1", "numbers");
        buttonsMap.put("2", "numbers");
        buttonsMap.put("3", "numbers");
        buttonsMap.put("4", "numbers");
        buttonsMap.put("5", "numbers");
        buttonsMap.put("6", "numbers");
        buttonsMap.put("7", "numbers");
        buttonsMap.put("8", "numbers");
        buttonsMap.put("9", "numbers");
        buttonsMap.put("AC", "others");
        buttonsMap.put(".", "others");
        buttonsMap.put("SQRT", "others");
        buttonsMap.put("%", "others");
        buttonsMap.put("+/-", "others");
        return buttonsMap;
    }

    private Color fill_button(JButton button, HashMap<String, String> buttonsMap){
        if(buttonsMap.get(button.getText()).equals("opers") || buttonsMap.get(button.getText()).equals("equal") ){
            return new Color(255,165,0);
        }
        else if(buttonsMap.get(button.getText()).equals("numbers")){
            return new Color(86,86,86);
        }
            return new Color(211,211,211);
    }

    private Color fill_foreground_button(JButton button, HashMap<String, String> buttonsMap){
        if(buttonsMap.get(button.getText()).equals("numbers") || buttonsMap.get(button.getText()).equals("opers") || buttonsMap.get(button.getText()).equals("equal")  ){
            return new Color(255,255,255);
        }
        return new Color(0, 0, 0);
    }

    public void clear_all(JLabel display){
        display.setText("0");
    }

    public void write_number(JLabel display, JButton button){
        if(display.getText().equals("0") || display.getText().equals("Infinity") || display.getText().equals("NaN")){
            display.setText(button.getText());
            return;
        }
        display.setText(display.getText() + button.getText());
    }

    public void write_dot(JLabel display, JButton button){
        if(!display.getText().contains(".")) {
            if(display.getText().equals("Infinity") || display.getText().equals("NaN")){
                display.setText("0");
            }
            display.setText(display.getText() + button.getText());
        }
    }

    public void reverse(JLabel display){
        if(!display.getText().equals("0")){
            double number = Double.parseDouble(display.getText()) * -1;
            if(number == (int) number){
                display.setText(String.valueOf((int) number));
                return;
            }
            display.setText(String.valueOf(number));
        }
    }

    public void set_oper(JLabel display, JButton button){
        service.oper = button.getText();
        set_a(display);
    }
    public void set_a(JLabel display) {
        service.a = Double.parseDouble(display.getText());
        display.setText("0");
    }

    public void set_b(JLabel display) {
        service.b = Double.parseDouble(display.getText());
    }
}
