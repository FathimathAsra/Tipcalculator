
package tipcal;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.NumberFormat;


public class FXMLDocumentController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tippercentage = new BigDecimal(0.15);

    @FXML
    private Label label;

    @FXML
    private Label AmountLable;

    @FXML
    private Label PercentageLable;

    @FXML
    private Label TipLable;

    @FXML
    private Label TotalLable;

    @FXML
    private Button calculatebutton;

    @FXML
    private TextField Amount;

    @FXML
    private TextField Tippercentage;

    @FXML
    private TextField Total;

    @FXML
    private Slider Sliderpercentage;

    @FXML
    void handleButtonAction(ActionEvent event) {
        try {
            BigDecimal amount= new BigDecimal (Amount.getText());
            BigDecimal tip = amount.multiply (tippercentage);
            BigDecimal total= amount.add(tip);
            Tippercentage.setText(currency.format(tip));
            Total.setText(currency.format(total));  
        }
        
        catch (NumberFormatException ex) {
            Amount.setText("Enter the price");
            Amount.selectAll();
            Amount.requestFocus();
            
        }
    
    }
    
    
    
}
