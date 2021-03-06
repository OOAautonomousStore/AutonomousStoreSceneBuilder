package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LottoController {
	
	@FXML
    public TextField txtTippZahlen;
    @FXML
    public TextField txtAnzahlSpiele;
    @FXML
    private Button btnZurueckZUProdAusVONLotto;
    @FXML
    private Label lblInfo;
    @FXML
    private AnchorPane pnlZahlentippErfassung;
    @FXML
    private Button btnZahlenAngeben;       
    @FXML
    private CheckBox cbxZusatzSpiel;        
    @FXML
    private Button btnTippAbgeben;
    
    Integer iWarenkorbID;
    Integer iVerbleibendeSpiele = 0;
 	Integer iGespielteSpiele = 0;   
    Integer iAnzahlSpiele =0;
    
    @FXML
    void btnZahlenAngeben_clicked(ActionEvent event) {
    	
    	try {
    		String tAnzahlSpiele = txtAnzahlSpiele.getText();
    		// Abfangen von leerem Input
    	if (tAnzahlSpiele.equals(""))
    	{
    	lblInfo.setText("Bitte erfassen Sie die Anzahl Spiele.");
    	lblInfo.setTextFill(javafx.scene.paint.Color.RED);
    	return;
    	}
    	
    	iAnzahlSpiele = Integer.parseInt(txtAnzahlSpiele.getText());
    	pnlZahlentippErfassung.setVisible(true);    	
    		}
    	
    	catch (Exception e) 
    	{
		lblInfo.setText("Es ist ein Fehler aufgetreten: "+e.getMessage());
		}
    }
    
    @FXML
    void btnTippAbgeben_clicked(ActionEvent event) {	  	
	 	//WarenkorPosition Daten
    	Integer iref_Warenkorb = 0;
    	Integer iArtikelnummer = 0;
    	String tArtikelbezeichnung = ("Lotozahlentipp: " + txtTippZahlen.getText());
    	float fPreisProStueck = 0;
    	Integer iAnzahl = 0;
    	float fPreisPositionTotal = 0.00f;       	            		
         		    try {		
	         		iref_Warenkorb = LoginController.iWarenkorbID;
	             	iArtikelnummer = 10101010;	             	
	             	fPreisProStueck = 5.5f;
	             	iAnzahl = 1;
	             	fPreisPositionTotal = 5.5f;
	             	
	             	txtTippZahlen.getText();
         		
	             	if(txtTippZahlen.getLength()!=6) {
	             		lblInfo.setText("Es sind nur 6-stellige Zahlen g�ltig. Bitte Eingabe pr�fen.");   
	             		lblInfo.setTextFill(javafx.scene.paint.Color.RED);
	             		return;}
	             	
	             	// Check ob eingabe nummerisch ist wenn nicht wird Exception Nex geworfen
	             		Integer.parseInt(txtTippZahlen.getText());
					 
             	SQLDBReadWrite.INSERTWarenkorbPosition( iref_Warenkorb,  iArtikelnummer,  tArtikelbezeichnung, fPreisProStueck,  iAnzahl, fPreisPositionTotal) ;
             	
	             		iGespielteSpiele += 1;
	             		
	             		iVerbleibendeSpiele = iAnzahlSpiele-iGespielteSpiele;
	             		lblInfo.setText("Sie haben noch "+iVerbleibendeSpiele+". Tipps.");             		
	             		lblInfo.setFont(new Font("Arial", 14));
	             		lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
	             		
	             		txtTippZahlen.setText("");	             		
        	if (iAnzahlSpiele==iGespielteSpiele)
        	{
        	lblInfo.setText(iAnzahlSpiele+". Tipps wurden dem Warenkorb hinzugef�gt, Viel Gl�ck!");
        	lblInfo.setFont(new Font("Arial", 16));
        	lblInfo.setTextFill(javafx.scene.paint.Color.GREEN);
        	btnTippAbgeben.setDisable(true);
        	txtTippZahlen.setDisable(true);
        	txtAnzahlSpiele.setDisable(true);
        	btnZahlenAngeben.setDisable(true);
        	}	       	
         		    }
         		   catch (NumberFormatException Nex)
         		    {
         			   lblInfo.setText("Bitte nur Zahlen 0-9 verwenden, keine Sonderzeichen.");
         			   lblInfo.setTextFill(javafx.scene.paint.Color.RED);
         		    }
         		    
         		    catch(Exception e)
         		    {       		    	
         		    	lblInfo.setText("Es ist ein Fehler aufgetreten: "+e.getMessage());
         		    	lblInfo.setTextFill(javafx.scene.paint.Color.RED);
         		    }
         		  
    }
    
	    @FXML
	void btnZurueckZUProdAusVONLotto_clicked(ActionEvent event) {
	    		
	    	try {				
	    		Stage StageRegist = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("ProdukteAuswahl.fxml"));
				Scene scene = new Scene(root);
				StageRegist.setScene(scene);
				StageRegist.show();
	    		} 
			
			catch(Exception e) {
				e.printStackTrace();
								}	
	    	
	    		}
												
}
