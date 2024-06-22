package controllers;

import models.GrammarManager;
import views.GuiManager;
import views.components.MyProductiongJDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private GrammarManager manager;
    private GuiManager guiManager;
    private MyProductiongJDialog productionsDialog;

    public Controller() {
        manager = new GrammarManager();
        guiManager = new GuiManager(this);
        productionsDialog = new MyProductiongJDialog(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) throws NullPointerException {
        switch (Commands.valueOf(e.getActionCommand())) {
            case ADD_PRODUCTIONS:
                productionsDialog.openDialog(guiManager);
                break;
            case ADD_GRAMMAR:
                createAndAddGrammar();
                break;
            case ACCEPT_PRODUCTION:
                productionsDialog.setVisible(false);
                break;
            case DELETE_GRAMMAR:
                deleteParameters();
                break;
            case EDIT_GRAMMAR:
                editParameters();
                break;
            case ADD_PRODUCTION:
                productionsDialog.addProductionField();
                break;
            case DELETE_PRODUCTION:
                productionsDialog.deleteProductionField();
                break;
            case VALIDATE_WORD:
                validateWordOnGrammar();
                break;
        }
    }

    private void createAndAddGrammar() {
        manager.createGrammar(guiManager.getGrammarName(), guiManager.getNoTerminalSymbols(), guiManager.getSigma(),
                guiManager.getAxiom(), productionsDialog.getProductions());

        guiManager.showGeneralTree(manager.getGeneralRoot(), manager.getGrammarName());
    }

    private void editParameters() {
        guiManager.enableFields();
        productionsDialog.enableProductions();
    }

    private void deleteParameters() {
        guiManager.deleteContentFields();
        productionsDialog.deleteProductions();
    }

    private void validateWordOnGrammar() throws NullPointerException {
        String word = guiManager.getWord();
        guiManager.showTree(manager.getParticularRoot(word));
    }


}
