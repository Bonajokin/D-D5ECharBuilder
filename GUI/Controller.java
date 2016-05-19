/*
 * Copyright (C) 2016 Bonajokin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package GUI;

import DnD.CharacterSheet;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Bonajokin
 */
public class Controller implements Initializable {
    
    @FXML
    private Label label,hpMax,hpConstBonus,hpRacialBonus;
    
    @FXML
    private TextField charName;
    
    @FXML
    private ChoiceBox pClass;
    
    private CharacterSheet character;
 
    
    
    
    
    @FXML
    private void handleCharacterNameSubmit(MouseEvent event) {
        
 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        
    }    
    
}
