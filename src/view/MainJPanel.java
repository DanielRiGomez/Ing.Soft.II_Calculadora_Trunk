package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainJPanel extends JPanel {

    private JTextField num1_1;
    private JLabel i1;
    private JTextField num1_2;
    private JComboBox operations;
    private JTextField num2_1;
    private JLabel i2;
    private JTextField num2_2;
    private JButton result;
    private JLabel value;

    public MainJPanel(){
        super();
        num1_1 = new JTextField(3);
        num1_2 = new JTextField(3);
        num2_1 = new JTextField(3);
        num2_2 = new JTextField(3);
        i1 = new JLabel("i^");
        i2 = new JLabel("i^");
        result = new JButton("=");
        operations = new JComboBox<>();
        value = new JLabel("");
        init();
    }

    private void init(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0, 30));
        num1_1.setFont(new Font("Arial", Font.ITALIC, 20));
        this.add(num1_1);
        i1.setFont(new Font("Arial", Font.ITALIC, 40));
        i1.setPreferredSize(new Dimension(30,40));
        i2.setFont(new Font("Arial", Font.ITALIC, 40));
        i2.setPreferredSize(new Dimension(30,40));
        this.add(i1);
        this.add(num1_2);
        this.add(new JLabel("        "));
        operations.addItem("+");
        operations.addItem("-");
        operations.addItem("*");
        operations.addItem("/");
        this.add(operations); 
        this.add(new JLabel("        "));
        num2_1.setFont(new Font("Arial", Font.ITALIC, 20));
        this.add(num2_1);
        this.add(i2);
        this.add(num2_2);
        this.add(new JLabel("        "));
        this.add(result);
        this.add(new JLabel("        "));
        value.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        value.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(value);
    }

    /**
     * Metodo que retorna un texto con la operacion
     * @return texto de la operacion
     */
    public String getData(){
        
        String text = ""+num1_1.getText() + i1.getText() + num1_2.getText() 
            + operations.getSelectedItem() + num2_1.getText() + i2.getText() +  num2_2.getText();
        System.out.println(text);
        return text;
    }

    /**
     * Metodo para agregar el resultado de la operacion
     * @param result resultado de la operacion
     */
    public void addResult(String result){
        value.setText(result);
    }

    /**
     * Metodo para agregar el listener
     * @param listener componente a la escucha
     */
    public void addListener(ActionListener listener){
        result.setActionCommand("result");
        result.addActionListener(listener);
    }

}
