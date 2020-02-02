package application;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProdAusController {

	

    @FXML
    private ImageView imgZigaretten;

    @FXML
    private Button btnLottoSpielen;

    @FXML
    private Button btnZigarettenKaufen;

    @FXML
    private Button btnLebensmittelKaufen;

    @FXML
    private Label lblInfoProdAus;
    
    @FXML
    private Label lblKundenummer;
   
	   @FXML
	    private Label  lblKundenummerAnzeigen;
	 
	    //Kunden Detail Daten Anzeigen 
	    public static void KundeDetailAnzeigen(Integer iKundenummer)
	    
	    { 
	    	  
	    		//Muss so oder so nochmals ein SQL gwemacht werden der Kudne gibt nur die ID ein der Rest wird mit SQL gemacht 
	    	try {
				    	 SQLDBReadWrite.SELECTTKundenDaten(iKundenummer);
				    	 
				 //LM so kann Warenkorb ID gehot werden  Integer iWarenkorbID =  LoginController.iWarenkorbID;
				    	 
				   
				   //	lblKundenummerAnzeigen.getText()
	    	
			} 
			 
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    @FXML
	    void btnLottoSpielen_clicked (ActionEvent event) {
try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("LottoSpielen.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
				
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void btnZigarettenKaufen_clicked(ActionEvent event) {
try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("ZigarettenKaufen.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
				
				// TODO Alterscheck
				
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void btnLebensmittelKaufen_clicked(ActionEvent event) {
try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("ZigarettenKaufen.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void btnZurueckZUAnmelden_clicked(ActionEvent event) {

	    	try {
				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
			} 
			
			catch(Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    
	}
	
	

