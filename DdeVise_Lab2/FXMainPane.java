


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button helloBtn;
	Button howdyBtn;
	Button chineseBtn;
	Button clearBtn;
	Button exitBtn;
	Button frenchBtn;
	Label feedbackLbl;
	TextField text;
	//  declare two HBoxes
	HBox box1;
	HBox box2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager datamngr;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		helloBtn = new Button("Hello");
		helloBtn.setOnAction(new ButtonHandler());
		
		howdyBtn = new Button("Howdy");
		howdyBtn.setOnAction(new ButtonHandler());
		
		chineseBtn = new Button("Chinese");
		chineseBtn.setOnAction(new ButtonHandler());
		
		frenchBtn = new Button("French");
		frenchBtn.setOnAction(new ButtonHandler());
		
		clearBtn = new Button("Clear");
		clearBtn.setOnAction(new ButtonHandler());
		
		exitBtn = new Button("Exit");
		exitBtn.setOnAction(new ButtonHandler());
		
		feedbackLbl = new Label("Feedback:");
		text = new TextField();
		//  instantiate the HBoxes
		box1 = new HBox();
		box2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		datamngr = new DataManager();
		//  set margins and set alignment of the components
		box1.setMargin(feedbackLbl, new Insets(20));
		box1.setMargin(text, new Insets(10));
		box1.setAlignment(Pos.CENTER);
		box2.setMargin(helloBtn, new Insets(20));
		box2.setMargin(howdyBtn, new Insets(20));
		box2.setMargin(chineseBtn, new Insets(20));
		box2.setMargin(frenchBtn, new Insets(20));
		box2.setMargin(clearBtn, new Insets(20));
		box2.setMargin(exitBtn, new Insets(20));
		box2.setAlignment(Pos.CENTER);
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		box1.getChildren().addAll(feedbackLbl, text);
		//  add the buttons to the other HBox
		box2.getChildren().addAll(helloBtn, howdyBtn, chineseBtn, frenchBtn, clearBtn, exitBtn);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(box1, box2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			if (event.getTarget() == helloBtn)
				text.setText(datamngr.getHello());
			else if (event.getTarget() == howdyBtn)
				text.setText(datamngr.getHowdy());
			else if (event.getTarget() == chineseBtn)
				text.setText(datamngr.getChinese());
			else if (event.getTarget() == frenchBtn)
				text.setText(datamngr.getFrench());
			else if (event.getTarget() == clearBtn)
				text.setText("");
			else if (event.getTarget() == exitBtn)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
	
}
	
