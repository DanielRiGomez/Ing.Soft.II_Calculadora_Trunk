package controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.MyFrame;

public class Controller implements ActionListener{

    private MyFrame view;

    public Controller(){
        super();
        view = new MyFrame();
        view.setVisible(true);
        view.addListener(this);
    }    

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "result":
                view.getMainPanel().addResult("Resultado Agui..");
                view.revalidate();
                break;
        }
    }

}
