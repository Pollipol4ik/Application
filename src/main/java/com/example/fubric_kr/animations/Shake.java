package com.example.fubric_kr.animations;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;
    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(60), node);
        tt.setFromX(0f);
        tt.setByX(8f);
        tt.setCycleCount(4);
        tt.setAutoReverse(true);

    }
    public void playanimation(){
        tt.playFromStart();
    }


}
