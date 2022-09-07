package controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import utils.Expression;
import utils.Logic;

import view.MyFrame;

public class Controller implements ActionListener{

    private MyFrame view;
    Logic logic;
    public Controller(){
        super();
        logic = new Logic();
        view = new MyFrame();
        view.setVisible(true);
        view.addListener(this);
    }    

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "result":
                String result = doOperation(view.getMainPanel().getData());
                view.getMainPanel().addResult(result);
                view.revalidate();
                break;
        }
    }

    private String doOperation(String opString){
        String result = "";
        String[] expressionStrings = opString.split("m|s|r|d");
        Expression e1 = logic.parseStringToExp(expressionStrings[0]);
        Expression e2 = logic.parseStringToExp(expressionStrings[1]);
        if(opString.contains("s")){
            result = logic.summ(e1, e2).toString();
        }else if(opString.contains("r")){
            result = logic.substract(e1, e2).toString();
        }else if(opString.contains("m")){
            result = logic.multiply(e1, e2).toString();
        }else if(opString.contains("d")){
            result = logic.divide(e1, e2).toString();
        }
        return result;
    }
}
