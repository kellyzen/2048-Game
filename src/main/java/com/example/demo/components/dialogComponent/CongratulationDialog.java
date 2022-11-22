package com.example.demo.components.dialogComponent;

public class CongratulationDialog extends InformationDialog {

    public CongratulationDialog() {
        String title = "Information DialogComponent";
        String header = "You Win!";
        String context = "Congratulations, you've reached 2048!";
        ConfirmationDialog continueButton = new ConfirmationDialog();
        continueButton.createButton(title, header, context);
    }
}
