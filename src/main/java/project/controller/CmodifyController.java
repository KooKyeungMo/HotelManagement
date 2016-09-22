package project.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import project.DAO.CustomDAO;
import project.model.rhror;

/**
 * Created by java on 2016-09-20.
 */
public class CmodifyController {

    @FXML private TextField no, name, birthday, email, phoneno;
    @FXML private GridPane mod;
    @FXML private Button cancelbtn;

    private ObservableList<rhror> clist;
    private int num;

    public void saveCustom(ActionEvent event) {
        rhror cs = new rhror("",name.getText(),"",birthday.getText(),phoneno.getText(),email.getText(),"");
       if(num==-1){
           CustomDAO.newCustom(cs);

       }else{
            String cno = clist.get(num).getNo();
            cs.setNo(cno);
            CustomDAO.updateCustom(cs);
       }

        clist.clear();

        for(rhror m : CustomDAO.listCustom()){
            clist.add(m);
        }

    }

    public void sendData(ObservableList<rhror> clist, int num) {

       this.clist = clist;
       this.num = num;

        if(num>-1) {//수정하기 클릭시
            //수정하기 대화상자에 이미 저장된 데이터 표시

            String cno = clist.get(num).getNo();
            rhror cs = CustomDAO.viewCustom(cno);

            no.setText(cs.getNo());
            name.setText(cs.getName());
            birthday.setText(cs.getBirthday());
            phoneno.setText((cs.getPhoneno()));
            email.setText((cs.getEmail()));
        }
    }


    public void cancel(ActionEvent event) {



       // Platform.exit();

    }
}
