package br.com.rhmanager;

import br.com.rhmanager.view.PrincipalView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        new PrincipalView().start(null);
    }
    
    public static void main(String[] args) throws Exception {
        //HibernateUtil.getSession();
        launch(args);
        
    }
    
}
