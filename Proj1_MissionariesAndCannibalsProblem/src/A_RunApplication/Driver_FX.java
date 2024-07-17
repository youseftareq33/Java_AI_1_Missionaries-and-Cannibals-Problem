// yousef sharbi 1202057
// anas karakra 1200467
package A_RunApplication;
	
import java.util.ArrayList;

import B_Classes.BFS;
import B_Classes.Boat;
import B_Classes.DFS;
import B_Classes.State;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Driver_FX extends Application {
	//for data
	BFS sol_bfs=new BFS();
	DFS sol_dfs=new DFS();
	State init_state=new State(3, 3, new Boat("Empty", "Empty", "Left"), 0, 0);
	int stepNumber=1;
	ArrayList<State> al_data=new ArrayList<>();
	
	// to calc ex
	long endTime;
	long startTime;
	
	//for UI
	Stage stage = new Stage();
	DropShadow shadow = new DropShadow();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// scenes
			Scene scene = new Scene(startPage());
			
			stage.setMaximized(true);
			stage.setScene(scene);
			stage.setTitle("Missionaries_And_Cannibals Problem");
			stage.setIconified(true);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/D2_Graphic_icons/app_icon.png")));
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	// Pages:
	
	// start page
	public BorderPane startPage() {
		BorderPane bp_startPage = new BorderPane();
		
		VBox vb=new VBox();
		// top
		HBox hb_top=new HBox();
		Image image_D3_Missionaries_And_Cannibals = new Image(getClass().getResource("/D3_Graphic_images/Missionaries_And_Cannibals.png").toExternalForm()); 
		ImageView imageView_D3_Missionaries_And_Cannibals = new ImageView(image_D3_Missionaries_And_Cannibals);
		hb_top.getChildren().add(imageView_D3_Missionaries_And_Cannibals);
		hb_top.setPadding(new Insets(20,0,0,255)); // top, right, bottom, left
		
		
		// bottom
		HBox hb_bottom=new HBox();
		Button b_start=new Button("Let's GO");
		b_start.setPrefSize(250, 80);
		b_start.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
				+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:2;-fx-font-weight:bold;");
		
		b_start.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  b_start.setEffect(shadow);
	        	  b_start.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:20;"
	        			  + "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white;-fx-background-radius: 14;-fx-Border-radius: 12");
	          }
	    });
		
		b_start.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  b_start.setEffect(null);
	        	  b_start.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
	    			   	  + "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:2;-fx-font-weight:bold;");
	          }
	    });
		
		b_start.setOnAction(e->{
			stage.getScene().setRoot(typeOfSearchPage());
		});
		
		hb_bottom.getChildren().add(b_start);
		hb_bottom.setPadding(new Insets(40,0,0,625)); // top, right, bottom, left
		
		vb.getChildren().addAll(hb_top,hb_bottom);
		bp_startPage.setCenter(vb);
		bp_startPage.setStyle("-fx-background-color:#457822;");
		return bp_startPage;
	}

	
	// type of search page
	public BorderPane typeOfSearchPage() {
		BorderPane bp_typeOfSearchPage = new BorderPane();
		
		VBox vb=new VBox();
		// top
		HBox hb_top=new HBox();
		Text t=new Text("Please choose the type of search:");
		t.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
		hb_top.getChildren().add(t);
		hb_top.setPadding(new Insets(50,0,0,25)); // top, right, bottom, left
		
		// center
		HBox hb_center=new HBox();
		Button b_BFS=new Button("BFS");
		b_BFS.setPrefSize(250, 200);
		b_BFS.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
				+ "-fx-Border-radius: 10;-fx-font-size:30;-fx-Border-width:2;-fx-font-weight:bold;");
		
		b_BFS.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  b_BFS.setEffect(shadow);
	        	  b_BFS.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:30;"
	        			  + "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white;-fx-background-radius: 14;-fx-Border-radius: 12");
	          }
	    });
		
		b_BFS.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  b_BFS.setEffect(null);
	        	  b_BFS.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
	    			   	  + "-fx-Border-radius: 10;-fx-font-size:30;-fx-Border-width:2;-fx-font-weight:bold;");
	          }
	    });
		
		
		
		Button b_DFS=new Button("DFS");
		b_DFS.setPrefSize(250, 200);
		b_DFS.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
				+ "-fx-Border-radius: 10;-fx-font-size:30;-fx-Border-width:2;-fx-font-weight:bold;");
		
		b_DFS.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  b_DFS.setEffect(shadow);
	        	  b_DFS.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:30;"
	        			  + "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white;-fx-background-radius: 14;-fx-Border-radius: 12");
	          }
	    });
		
		b_DFS.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  b_DFS.setEffect(null);
	        	  b_DFS.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
	    			   	  + "-fx-Border-radius: 10;-fx-font-size:30;-fx-Border-width:2;-fx-font-weight:bold;");
	          }
	    });
		
		// set on Action
		b_BFS.setOnAction(e->{
			stage.getScene().setRoot(mainPage("BFS"));
		});
		
		b_DFS.setOnAction(e->{
			stage.getScene().setRoot(mainPage("DFS"));
		});
		
		hb_center.getChildren().addAll(b_BFS,b_DFS);
		hb_center.setSpacing(100);
		hb_center.setPadding(new Insets(190,0,0,450)); // top, right, bottom, left
		
		vb.getChildren().addAll(hb_top,hb_center);
		
		bp_typeOfSearchPage.setCenter(vb);
		bp_typeOfSearchPage.setStyle("-fx-background-color:#457822;");
		return bp_typeOfSearchPage;
	}

	
	// main page
	public BorderPane mainPage(String searchType) {
		BorderPane bp_mainPage = new BorderPane();
		stepNumber=1;
		State sol=null;
		if(searchType.equals("BFS")) {
			
			startTime = System.nanoTime();
			sol=sol_bfs.BFS_MandC(init_state);
			endTime = System.nanoTime();
			
			al_data=sol_bfs.BFS_Data(sol);
		}
		else if(searchType.equals("DFS")) {
			
			startTime = System.nanoTime();
			sol=sol_dfs.DFS_MandC(init_state);
			endTime = System.nanoTime();
			
			al_data=sol_dfs.DFS_Data(sol);
		}
		
			//################################################################################# 
			// top
			ScrollPane sp=new ScrollPane();
			
			
				// top_center
				BorderPane bp_top_center=new BorderPane();
				bp_top_center.setStyle("-fx-background-color:#7ac943;");
					//-------------------------------------------------------------------------
					// top_center_left
					BorderPane bp_top_center_left=new BorderPane();
					bp_top_center_left.setPrefSize(568, 688.8);
					bp_top_center_left.setStyle("-fx-background-color:#7ac943;-fx-Border-color:black;-fx-Border-width:0;");
						//---------------------------------------------------------------------
						// top_center_left_top
						HBox hb_top_center_left_top_t=new HBox();
						Text t_start=new Text("START");
						t_start.setStyle("-fx-font-size: 15;-fx-font-family:Toledo;");
						hb_top_center_left_top_t.getChildren().add(t_start);
						hb_top_center_left_top_t.setPadding(new Insets(0,0,0,255)); // top, right, bottom, left
						//---------------------------------------------------------------------
						// top_center_left_bottom
						VBox vb_top_center_left_bottom=new VBox();
							//-----------------------------------------------------------------
							// top_center_left_bottom_h
							HBox hb_left=new HBox();
								//-----------------------------------------------------------------
								// top_center_left_bottom_h_cannibals
								HBox hb_left_cannibals=new HBox();
								Image image_D2_cannibal = new Image(getClass().getResource("/D2_Graphic_icons/cannibal.png").toExternalForm()); 
								ImageView imageView_D2_cannibal1 = new ImageView(image_D2_cannibal);
								ImageView imageView_D2_cannibal2 = new ImageView(image_D2_cannibal);
								ImageView imageView_D2_cannibal3 = new ImageView(image_D2_cannibal);
								hb_left_cannibals.getChildren().addAll(imageView_D2_cannibal1,imageView_D2_cannibal2,imageView_D2_cannibal3);
								//hb_left_cannibals.setPadding(new Insets(45,0,0,0)); // top, right, bottom, left
								//-----------------------------------------------------------------
								// top_center_left_bottom_h_missionaries
								HBox hb_left_missionaries=new HBox();
								Image image_D2_missionary = new Image(getClass().getResource("/D2_Graphic_icons/missionary.png").toExternalForm()); 
								ImageView imageView_D2_missionary1 = new ImageView(image_D2_missionary);
								ImageView imageView_D2_missionary2 = new ImageView(image_D2_missionary);
								ImageView imageView_D2_missionary3 = new ImageView(image_D2_missionary);
								hb_left_missionaries.getChildren().addAll(imageView_D2_missionary1,imageView_D2_missionary2,imageView_D2_missionary3);
								hb_left_missionaries.setPadding(new Insets(0,50,0,0)); // top, right, bottom, left
								//-----------------------------------------------------------------
								// top_center_left_bottom_h_boat
								HBox hb_left_boat=new HBox();
								Image image_D2_boat = new Image(getClass().getResource("/D2_Graphic_icons/boat_right.png").toExternalForm()); 
								ImageView imageView_D2_boat = new ImageView(image_D2_boat);
								hb_left_boat.getChildren().add(imageView_D2_boat);
								
							hb_left.getChildren().addAll(hb_left_cannibals,hb_left_missionaries,hb_left_boat);
							hb_left.setSpacing(30);
							hb_left.setPadding(new Insets(127,0,0,127)); // top, right, bottom, left
							hb_left.setAlignment(Pos.CENTER);
						vb_top_center_left_bottom.getChildren().add(hb_left);	
						//vb_top_center_left_bottom.getChildren().add(left(1, 2, 3));
					bp_top_center_left.setTop(hb_top_center_left_top_t);
					bp_top_center_left.setCenter(vb_top_center_left_bottom);
					
					
					
					
					//-------------------------------------------------------------------------
					// top_center_center
					BorderPane bp_top_center_center=new BorderPane();
					bp_top_center_center.setPrefSize(380, 688.8);
					bp_top_center_center.setStyle("-fx-background-color:#3fa9f5;-fx-Border-color:black;-fx-Border-width:1;");
						//---------------------------------------------------------------------
						// top_center_center_center
						VBox vb_top_center_center_center=new VBox();
						vb_top_center_center_center.setStyle("-fx-Border-color:black;-fx-Border-width:1;");
							//---------------------------------------------------------------------
							// top_center_center_center_v
							BorderPane bp_center=new BorderPane();
								
								// center
								VBox vb_center_center_center_center=new VBox();
									// top
									HBox hb_center_center_center_center_top=new HBox();
									Image image_D2_cannibal_center = new Image(getClass().getResource("/D2_Graphic_icons/cannibal.png").toExternalForm()); 
									ImageView imageView_D2_cannibal1_center = new ImageView(image_D2_cannibal_center);
									Image image_D2_missionary_center = new Image(getClass().getResource("/D2_Graphic_icons/missionary.png").toExternalForm()); 
									ImageView imageView_D2_missionary1_center = new ImageView(image_D2_missionary_center);
									hb_center_center_center_center_top.getChildren().addAll(imageView_D2_cannibal1_center,imageView_D2_missionary1_center);
									hb_center_center_center_center_top.setSpacing(6);
									hb_center_center_center_center_top.setAlignment(Pos.BOTTOM_CENTER);
									hb_center_center_center_center_top.setPadding(new Insets(0,0,0,0)); // top, right, bottom, left
									// bottom
									HBox hb_center_center_center_center_bottom=new HBox();
									Image image_D2_boat_center = new Image(getClass().getResource("/D2_Graphic_icons/boat_right.png").toExternalForm()); 
									ImageView imageView_D2_boat_center = new ImageView(image_D2_boat_center);
									hb_center_center_center_center_bottom.getChildren().add(imageView_D2_boat_center);
									hb_center_center_center_center_bottom.setAlignment(Pos.TOP_CENTER);
									vb_center_center_center_center.getChildren().addAll(hb_center_center_center_center_top,hb_center_center_center_center_bottom);	
									
								// left
								HBox hb_center_center_center_left=new HBox();
								Image image_D2_leftArrow_center = new Image(getClass().getResource("/D2_Graphic_icons/arrow_left.png").toExternalForm()); 
								ImageView imageView_D2_leftArrow_center = new ImageView(image_D2_leftArrow_center);
								hb_center_center_center_left.getChildren().add(imageView_D2_leftArrow_center);
								hb_center_center_center_left.setPadding(new Insets(30,0,0,10)); // top, right, bottom, left

								// right
								HBox hb_center_center_center_right=new HBox();
								Image image_D2_rightArrow_center = new Image(getClass().getResource("/D2_Graphic_icons/arrow_right.png").toExternalForm()); 
								ImageView imageView_D2_rightArrow_center = new ImageView(image_D2_rightArrow_center);
								hb_center_center_center_right.getChildren().add(imageView_D2_rightArrow_center);
								hb_center_center_center_right.setPadding(new Insets(30,10,0,0)); // top, right, bottom, left
								
							bp_center.setCenter(vb_center_center_center_center);
							bp_center.setLeft(hb_center_center_center_left);
							bp_center.setRight(hb_center_center_center_right);
							bp_center.setPadding(new Insets(114,0,0,0)); // top, right, bottom, left
							bp_center.setVisible(false);
						vb_top_center_center_center.getChildren().add(bp_center);	
						//vb_top_center_center_center.getChildren().add(center("Missionary", "Empty", "Left"));
						
					bp_top_center_center.setCenter(vb_top_center_center_center);
					
					
					
					
					//-------------------------------------------------------------------------
					// top_center_right
					BorderPane bp_top_center_right=new BorderPane();
					bp_top_center_right.setPrefSize(585, 688.8);
					bp_top_center_right.setStyle("-fx-background-color:#7ac943;-fx-Border-color:black;-fx-Border-width:0;");
						//-------------------------------------------------------------------------
						// top_center_right_top
						HBox hb_top_center_right_top=new HBox();
						hb_top_center_right_top.setMinHeight(140);
							//-------------------------------------------------------------------------
							// top_center_right_top_left
							HBox hb_top_center_right_top_left=new HBox();
							Text t_finish=new Text("FINISH");
							t_finish.setStyle("-fx-font-size: 15;-fx-font-family:Toledo;");
							hb_top_center_right_top_left.getChildren().add(t_finish);
							hb_top_center_right_top_left.setPadding(new Insets(0,180,0,0)); // top, right, bottom, left
							
							//-------------------------------------------------------------------------
							// top_center_right_top_right
							VBox vb_top_center_right_top_right=new VBox();
							vb_top_center_right_top_right.setPrefSize(170, 10);
							vb_top_center_right_top_right.setStyle("-fx-background-color:#e6e6e6;-fx-Border-color:black;-fx-Border-width:0;");
							vb_top_center_right_top_right.setSpacing(5);	
								// 1
								HBox hb_c_descrption=new HBox();
								Image image_D2_cannibal_des = new Image(getClass().getResource("/D2_Graphic_icons/cannibal_description.png").toExternalForm()); 
								ImageView imageView_D2_cannibal_des = new ImageView(image_D2_cannibal_des);
								Text t_c_descrption=new Text("Cannibal");
								t_c_descrption.setStyle("-fx-font-size: 15;-fx-font-weight: bold;");
								hb_c_descrption.getChildren().addAll(imageView_D2_cannibal_des,t_c_descrption);
								hb_c_descrption.setSpacing(10);
								hb_c_descrption.setPadding(new Insets(5,0,0,7)); // top, right, bottom, left
								// 2
								HBox hb_m_descrption=new HBox();
								Image image_D2_missionary_des = new Image(getClass().getResource("/D2_Graphic_icons/missionary_description.png").toExternalForm()); 
								ImageView imageView_D2_missionary_des = new ImageView(image_D2_missionary_des);
								Text t_m_descrption=new Text("Missionary");
								t_m_descrption.setStyle("-fx-font-size: 15;-fx-font-weight: bold;");
								hb_m_descrption.getChildren().addAll(imageView_D2_missionary_des,t_m_descrption);
								hb_m_descrption.setSpacing(10);
								hb_m_descrption.setPadding(new Insets(7,0,0,7)); // top, right, bottom, left
								// 3
								HBox hb_snum_descrption=new HBox();
								Image image_D2_snum_des = new Image(getClass().getResource("/D2_Graphic_icons/square_description.png").toExternalForm()); 
								ImageView imageView_D2_snum_des = new ImageView(image_D2_snum_des);
								Text t_snum_descrption=new Text("Step numbers");
								t_snum_descrption.setStyle("-fx-font-size: 15;-fx-font-weight: bold;");
								hb_snum_descrption.getChildren().addAll(imageView_D2_snum_des,t_snum_descrption);
								hb_snum_descrption.setSpacing(10);
								hb_snum_descrption.setPadding(new Insets(7,0,0,7)); // top, right, bottom, left
								// 4
								HBox hb_boat_descrption=new HBox();
								Image image_D2_boat_des = new Image(getClass().getResource("/D2_Graphic_icons/boat_description.png").toExternalForm()); 
								ImageView imageView_D2_boat_des = new ImageView(image_D2_boat_des);
								Text t_boat_descrption=new Text("Boat");
								t_boat_descrption.setStyle("-fx-font-size: 15;-fx-font-weight: bold;");
								hb_boat_descrption.getChildren().addAll(imageView_D2_boat_des,t_boat_descrption);
								hb_boat_descrption.setSpacing(6);
								hb_boat_descrption.setPadding(new Insets(5,0,0,5)); // top, right, bottom, left
								
							vb_top_center_right_top_right.getChildren().addAll(hb_c_descrption,hb_m_descrption,hb_snum_descrption,hb_boat_descrption);	
							
						hb_top_center_right_top.getChildren().addAll(hb_top_center_right_top_left,vb_top_center_right_top_right);
						hb_top_center_right_top.setPadding(new Insets(0,0,0,190)); // top, right, bottom, left
						//-------------------------------------------------------------------------
						// top_center_right_bottom
						VBox vb_top_center_right_bottom=new VBox();
							//-------------------------------------------------------------------------
							// top_center_right_bottom_h
							HBox hb_right=new HBox();
								//-------------------------------------------------------------------------
								// top_center_right_bottom_h_boat
								HBox hb_right_boat=new HBox();
								Image image_D2_boat_right = new Image(getClass().getResource("/D2_Graphic_icons/boat_right.png").toExternalForm()); 
								ImageView imageView_D2_boat_right = new ImageView(image_D2_boat_right);
								hb_right_boat.getChildren().add(imageView_D2_boat_right);
								hb_right_boat.setPadding(new Insets(0,0,0,17)); // top, right, bottom, left
								//-------------------------------------------------------------------------
								// top_center_right_bottom_h_cannibals
								HBox hb_right_cannibals=new HBox();
								Image image_D2_cannibal_right = new Image(getClass().getResource("/D2_Graphic_icons/cannibal.png").toExternalForm()); 
								ImageView imageView_D2_cannibal1_right = new ImageView(image_D2_cannibal_right);
								ImageView imageView_D2_cannibal2_right = new ImageView(image_D2_cannibal_right);
								ImageView imageView_D2_cannibal3_right = new ImageView(image_D2_cannibal_right);
								hb_right_cannibals.getChildren().addAll(imageView_D2_cannibal1_right,imageView_D2_cannibal2_right,imageView_D2_cannibal3_right);
								hb_right_cannibals.setPadding(new Insets(0,0,0,50)); // top, right, bottom, left
								//-----------------------------------------------------------------
								// top_center_right_bottom_h_missionaries
								HBox hb_right_missionaries=new HBox();
								Image image_D2_missionary_right = new Image(getClass().getResource("/D2_Graphic_icons/missionary.png").toExternalForm()); 
								ImageView imageView_D2_missionary1_right = new ImageView(image_D2_missionary_right);
								ImageView imageView_D2_missionary2_right = new ImageView(image_D2_missionary_right);
								ImageView imageView_D2_missionary3_right = new ImageView(image_D2_missionary_right);
								hb_right_missionaries.getChildren().addAll(imageView_D2_missionary1_right,imageView_D2_missionary2_right,imageView_D2_missionary3_right);
								hb_right_missionaries.setPadding(new Insets(0,0,0,30)); // top, right, bottom, left
								
							hb_right.getChildren().addAll(hb_right_boat,hb_right_cannibals,hb_right_missionaries);
							hb_right.setVisible(false);
						vb_top_center_right_bottom.getChildren().add(hb_right);	
//						vb_top_center_right_bottom.getChildren().add(right(2, 3));
//						vb_top_center_right_bottom.getChildren().add(right(3, 3));
					bp_top_center_right.setTop(hb_top_center_right_top);
					bp_top_center_right.setCenter(vb_top_center_right_bottom);	
						
						
					
				bp_top_center.setLeft(bp_top_center_left);
				bp_top_center.setCenter(bp_top_center_center);
				bp_top_center.setRight(bp_top_center_right);
				//-----------------------------------------------------------------------------
				
				vb_top_center_left_bottom.setSpacing(40);
				vb_top_center_center_center.setSpacing(23);
				vb_top_center_right_bottom.setSpacing(18);
				
			sp=new ScrollPane(bp_top_center);
			
			//#################################################################################
			// bottom
			BorderPane bp_bottom=new BorderPane();
			bp_bottom.setPrefHeight(110);
			
				VBox vb_bottom=new VBox();
					
					// top
					HBox hb_bottom_top=new HBox();
					Button b_start=new Button("Start");
					b_start.setPrefSize(200, 40);
					b_start.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
							+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:2;-fx-font-weight:bold;");
					
					b_start.addEventHandler(MouseEvent.MOUSE_ENTERED,
					        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				        	  b_start.setEffect(shadow);
				        	  b_start.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:20;"
				        			  + "-fx-Border-width:2;-fx-font-weight:bold;-fx-text-fill: white;-fx-background-radius: 10;-fx-Border-radius: 8");
				          }
				    });
					
					b_start.addEventHandler(MouseEvent.MOUSE_EXITED,
					        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				        	  b_start.setEffect(null);
				        	  b_start.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
				    			   	  + "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:2;-fx-font-weight:bold;");
				          }
				    });
					
						// inside it:
						
						//
						Button b_restAllStep=new Button();
						Button b_prevStep=new Button();
						Button b_showResult=new Button();
						Button b_nextStep=new Button();
						Button b_nextAllStep=new Button();						
						//
						
						
						// restAllStep
						VBox vb_restAllStep=new VBox();
						b_restAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/restAllStep_notwork.png").toExternalForm())));
						b_restAllStep.setDisable(true);
						b_restAllStep.setPrefSize(67, 10);
						Text t_restAllStep=new Text("Rest All Step");
						t_restAllStep.setStyle("-fx-font-weight:bold;");
						t_restAllStep.setVisible(false);
						b_restAllStep.addEventHandler(MouseEvent.MOUSE_ENTERED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_restAllStep.setEffect(shadow);
					        	  t_restAllStep.setVisible(true);
					          }
					    });
						
						b_restAllStep.addEventHandler(MouseEvent.MOUSE_EXITED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_restAllStep.setEffect(null);
					        	  t_restAllStep.setVisible(false);
					          }
					    });
						
						b_restAllStep.setOnAction(e->{
							
							b_restAllStep.setDisable(true);
							b_restAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/restAllStep_notwork.png").toExternalForm())));
							b_prevStep.setDisable(true);
							b_prevStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/previousStep_notwork.png").toExternalForm())));
							
							b_nextStep.setDisable(false);
							b_nextStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextStep_work.png").toExternalForm())));
							b_nextAllStep.setDisable(false);
							b_nextAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextAllStep_work.png").toExternalForm())));
							
							b_showResult.setDisable(true);
							b_showResult.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/showResult_notwork.png").toExternalForm())));

								
							vb_top_center_left_bottom.getChildren().clear();
							vb_top_center_center_center.getChildren().clear();
							vb_top_center_right_bottom.getChildren().clear();
							
							vb_top_center_left_bottom.getChildren().add(hb_left);	
							vb_top_center_center_center.getChildren().add(bp_center);	
							vb_top_center_right_bottom.getChildren().add(hb_right);	
							
							stepNumber=1;
							
						});
						
						vb_restAllStep.getChildren().addAll(b_restAllStep,t_restAllStep);	
						
						// previous step
						VBox vb_prevStep=new VBox();
						b_prevStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/previousStep_notwork.png").toExternalForm())));
						b_prevStep.setDisable(true);
						b_prevStep.setPrefSize(70, 10);
						Text t_prevStep=new Text("Previous Step");
						t_prevStep.setStyle("-fx-font-weight:bold;");
						t_prevStep.setVisible(false);
						
						b_prevStep.addEventHandler(MouseEvent.MOUSE_ENTERED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	 b_prevStep.setEffect(shadow);
					        	 t_prevStep.setVisible(true);
					          }
					    });
						
						b_prevStep.addEventHandler(MouseEvent.MOUSE_EXITED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_prevStep.setEffect(null);
					        	  t_prevStep.setVisible(false);
					          }
					    });
						
						b_prevStep.setOnAction(e->{
							
							if(stepNumber==2) {
								vb_top_center_left_bottom.getChildren().remove(vb_top_center_left_bottom.getChildren().size()-1);
								vb_top_center_center_center.getChildren().remove(vb_top_center_center_center.getChildren().size()-1);
								vb_top_center_right_bottom.getChildren().remove(vb_top_center_right_bottom.getChildren().size()-1);
								
								b_restAllStep.setDisable(true);
								b_restAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/restAllStep_notwork.png").toExternalForm())));
								b_prevStep.setDisable(true);
								b_prevStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/previousStep_notwork.png").toExternalForm())));
								
								stepNumber--;
							}
							else if(stepNumber>2) {
								vb_top_center_left_bottom.getChildren().remove(vb_top_center_left_bottom.getChildren().size()-1);
								vb_top_center_center_center.getChildren().remove(vb_top_center_center_center.getChildren().size()-1);
								vb_top_center_right_bottom.getChildren().remove(vb_top_center_right_bottom.getChildren().size()-1);
								
								
								b_nextStep.setDisable(false);
								b_nextStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextStep_work.png").toExternalForm())));
								b_nextAllStep.setDisable(false);
								b_nextAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextAllStep_work.png").toExternalForm())));
								
								b_showResult.setDisable(true);
								b_showResult.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/showResult_notwork.png").toExternalForm())));
								
								stepNumber--;
							}
							
						});
						
						vb_prevStep.getChildren().addAll(b_prevStep,t_prevStep);
						
						// show result
						VBox vb_showResult=new VBox();
						
						b_showResult.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/showResult_notwork.png").toExternalForm())));
						b_showResult.setDisable(true);
						b_showResult.setPrefSize(63.5, 10);
						Text t_showResult=new Text("Show Result");
						t_showResult.setStyle("-fx-font-weight:bold;");
						t_showResult.setVisible(false);
						
						b_showResult.addEventHandler(MouseEvent.MOUSE_ENTERED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_showResult.setEffect(shadow);
					        	  t_showResult.setVisible(true);
					          }
					    });
						
						b_showResult.addEventHandler(MouseEvent.MOUSE_EXITED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_showResult.setEffect(null);
					        	  t_showResult.setVisible(false);
					          }
					    });
						
						b_showResult.setOnAction(e->{
							Stage stage_showRes=new Stage();
							stage_showRes.setTitle("Show Result");
							stage_showRes.getIcons().add(new Image(getClass().getResourceAsStream("/D2_Graphic_icons/showResult_work.png")));
							TextArea ta_res=new TextArea();
							ta_res.setEditable(false);
							ta_res.setText(printData(searchType));
							Scene scene_showRes=new Scene(ta_res, 600, 500);
							stage_showRes.setScene(scene_showRes);
							stage_showRes.show();
						});
						
						vb_showResult.getChildren().addAll(b_showResult,t_showResult);
						
						
												
						// next step
						VBox vb_nextStep=new VBox();
						b_nextStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextStep_work.png").toExternalForm())));
						b_nextStep.setPrefSize(52, 10);
						Text t_nextStep=new Text("Next Step");
						t_nextStep.setStyle("-fx-font-weight:bold;");
						t_nextStep.setVisible(false);
						
						b_nextStep.addEventHandler(MouseEvent.MOUSE_ENTERED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_nextStep.setEffect(shadow);
					        	  t_nextStep.setVisible(true);
					          }
					    });
						
						b_nextStep.addEventHandler(MouseEvent.MOUSE_EXITED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_nextStep.setEffect(null);
					        	  t_nextStep.setVisible(false);
					          }
					    });
						
						b_nextStep.setOnAction(e->{
							
							if(stepNumber==al_data.size()-1) {
								vb_top_center_left_bottom.getChildren().add(left(stepNumber, al_data.get(stepNumber).getLeft_cannibal(), al_data.get(stepNumber).getLeft_missionary()));
								vb_top_center_center_center.getChildren().add(center(al_data.get(stepNumber).getBoat().getPassenger1(), al_data.get(stepNumber).getBoat().getPassenger2(), al_data.get(stepNumber).getBoat().getPosition()));
								vb_top_center_right_bottom.getChildren().add(right(al_data.get(stepNumber).getRight_cannibal(), al_data.get(stepNumber).getRight_missionary()));
								
								b_nextStep.setDisable(true);
								b_nextStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextStep_notwork.png").toExternalForm())));
								b_nextAllStep.setDisable(true);
								b_nextAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextAllStep_notwork.png").toExternalForm())));
								
								b_showResult.setDisable(false);
								b_showResult.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/showResult_work.png").toExternalForm())));
							}
							else if(stepNumber<al_data.size()-1) {
								vb_top_center_left_bottom.getChildren().add(left(stepNumber, al_data.get(stepNumber).getLeft_cannibal(), al_data.get(stepNumber).getLeft_missionary()));
								vb_top_center_center_center.getChildren().add(center(al_data.get(stepNumber).getBoat().getPassenger1(), al_data.get(stepNumber).getBoat().getPassenger2(), al_data.get(stepNumber).getBoat().getPosition()));
								vb_top_center_right_bottom.getChildren().add(right(al_data.get(stepNumber).getRight_cannibal(), al_data.get(stepNumber).getRight_missionary()));
								
								
								
								b_restAllStep.setDisable(false);
								b_restAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/restAllStep_work.png").toExternalForm())));
								b_prevStep.setDisable(false);
								b_prevStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/previousStep_work.png").toExternalForm())));
								stepNumber++;
							}
							
							
						});
						vb_nextStep.getChildren().addAll(b_nextStep,t_nextStep);
						
						// next all step
						VBox vb_nextAllStep=new VBox();
						b_nextAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextAllStep_work.png").toExternalForm())));
						b_nextAllStep.setPrefSize(67, 10);
						Text t_nextAllStep=new Text("Next All Step");
						t_nextAllStep.setStyle("-fx-font-weight:bold;");
						t_nextAllStep.setVisible(false);
						
						b_nextAllStep.addEventHandler(MouseEvent.MOUSE_ENTERED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_nextAllStep.setEffect(shadow);
					        	  t_nextAllStep.setVisible(true);
					          }
					    });
						
						b_nextAllStep.addEventHandler(MouseEvent.MOUSE_EXITED,
						        new EventHandler<MouseEvent>() {
					          @Override
					          public void handle(MouseEvent e) {
					        	  b_nextAllStep.setEffect(null);
					        	  t_nextAllStep.setVisible(false);
					          }
					    });
						
						
						b_nextAllStep.setOnAction(e->{
							
							for(int i=stepNumber;i<=al_data.size()-1;i++) {
								if(stepNumber==al_data.size()-1) {
									vb_top_center_left_bottom.getChildren().add(left(stepNumber, al_data.get(stepNumber).getLeft_cannibal(), al_data.get(stepNumber).getLeft_missionary()));
									vb_top_center_center_center.getChildren().add(center(al_data.get(stepNumber).getBoat().getPassenger1(), al_data.get(stepNumber).getBoat().getPassenger2(), al_data.get(stepNumber).getBoat().getPosition()));
									vb_top_center_right_bottom.getChildren().add(right(al_data.get(stepNumber).getRight_cannibal(), al_data.get(stepNumber).getRight_missionary()));
									
									b_nextStep.setDisable(true);
									b_nextStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextStep_notwork.png").toExternalForm())));
									b_nextAllStep.setDisable(true);
									b_nextAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/nextAllStep_notwork.png").toExternalForm())));
									
									b_showResult.setDisable(false);
									b_showResult.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/showResult_work.png").toExternalForm())));
								}
								else if(stepNumber<al_data.size()-1) {
									vb_top_center_left_bottom.getChildren().add(left(stepNumber, al_data.get(stepNumber).getLeft_cannibal(), al_data.get(stepNumber).getLeft_missionary()));
									vb_top_center_center_center.getChildren().add(center(al_data.get(stepNumber).getBoat().getPassenger1(), al_data.get(stepNumber).getBoat().getPassenger2(), al_data.get(stepNumber).getBoat().getPosition()));
									vb_top_center_right_bottom.getChildren().add(right(al_data.get(stepNumber).getRight_cannibal(), al_data.get(stepNumber).getRight_missionary()));
									
									vb_top_center_left_bottom.setSpacing(40);
									vb_top_center_center_center.setSpacing(23);
									vb_top_center_right_bottom.setSpacing(18);
									
									b_restAllStep.setDisable(false);
									b_restAllStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/restAllStep_work.png").toExternalForm())));
									b_prevStep.setDisable(false);
									b_prevStep.setGraphic(new ImageView(new Image(getClass().getResource("/D2_Graphic_icons/previousStep_work.png").toExternalForm())));
									stepNumber++;
								}
							}
							
							stepNumber++;
						});
						
						vb_nextAllStep.getChildren().addAll(b_nextAllStep,t_nextAllStep);
						
					hb_bottom_top.getChildren().add(b_start);
					hb_bottom_top.setAlignment(Pos.CENTER);
						
						
				
					// bottom
					HBox hb_bottom_bottom=new HBox();
					Button b_prevPage=new Button("<- Previous Page");
					b_prevPage.setPrefSize(170, 30);
					b_prevPage.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
							+ "-fx-Border-radius: 10;-fx-font-size:16;-fx-Border-width:2;-fx-font-weight:bold;");
					
					b_prevPage.addEventHandler(MouseEvent.MOUSE_ENTERED,
					        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				        	  b_prevPage.setEffect(shadow);
				        	  b_prevPage.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:16;"
				        			  + "-fx-Border-width:2;-fx-font-weight:bold;-fx-text-fill: white;-fx-background-radius: 10;-fx-Border-radius: 8");
				          }
				    });
					
					b_prevPage.addEventHandler(MouseEvent.MOUSE_EXITED,
					        new EventHandler<MouseEvent>() {
				          @Override
				          public void handle(MouseEvent e) {
				        	  b_prevPage.setEffect(null);
				        	  b_prevPage.setStyle("-fx-background-color: LAWNGREEN; -fx-background-radius: 12; -fx-Border-color: OLIVEDRAB;"
				    			   	  + "-fx-Border-radius: 10;-fx-font-size:16;-fx-Border-width:2;-fx-font-weight:bold;");
				          }
				    });
					
					
					hb_bottom_bottom.getChildren().add(b_prevPage);
					hb_bottom_bottom.setAlignment(Pos.BOTTOM_RIGHT);
					hb_bottom_bottom.setPadding(new Insets(0,10,0,0)); // top, right, bottom, left
					
				vb_bottom.getChildren().addAll(hb_bottom_top,hb_bottom_bottom);
				vb_bottom.setAlignment(Pos.CENTER);
				vb_bottom.setPadding(new Insets(5,0,0,0)); // top, right, bottom, left
			
			// set on action
				b_prevPage.setOnAction(e->{
					stage.getScene().setRoot(typeOfSearchPage());
				});
				
				b_start.setOnAction(e->{
					hb_bottom_top.getChildren().clear();
					hb_bottom_top.getChildren().addAll(vb_restAllStep,vb_prevStep,vb_showResult,vb_nextStep,vb_nextAllStep);
					hb_bottom_top.setSpacing(25);
					hb_bottom_bottom.setPadding(new Insets(0,10,5.8,0)); // top, right, bottom, left
				});
				
				
			bp_bottom.setCenter(vb_bottom);				
			bp_bottom.setStyle("-fx-background-color:#457822;-fx-Border-color:black;-fx-Border-width:2;");
			
			
		
		bp_mainPage.setCenter(sp);
		bp_mainPage.setBottom(bp_bottom);
		
		bp_mainPage.setStyle("-fx-background-color:#7ac943;");
		return bp_mainPage;
	}


	//////////////////////////////////////////////////////////////////////////////////
	// Methods:
	
	public HBox left(int stepNum,int leftCannibalsNum,int leftMissionariesNum) {
		HBox hb_left=new HBox();
			
			// step number
			HBox hb_stepNum=new HBox();
			Text t_sn=new Text(stepNum+"");
			t_sn.setStyle("-fx-font-family: 'Montserrat';-fx-font-size: 17;-fx-fill: white;-fx-font-weight: bold;");
			hb_stepNum.getChildren().add(t_sn);
			hb_stepNum.setAlignment(Pos.CENTER);
			hb_stepNum.setMaxHeight(32);
			hb_stepNum.setMinWidth(32);
			hb_stepNum.setStyle("-fx-background-image: url('" + getClass().getResource("/D2_Graphic_icons/square.png") + "');");
			hb_left.getChildren().add(hb_stepNum);
			//-----------------------------------------------------------------
			// left cannibals
			HBox hb_left_cannibals=new HBox();
			Image image_D2_cannibal = new Image(getClass().getResource("/D2_Graphic_icons/cannibal.png").toExternalForm()); 
			for(int i=0;i<leftCannibalsNum;i++) {
				hb_left_cannibals.getChildren().add(new ImageView(image_D2_cannibal));
			}
			hb_left_cannibals.setPadding(new Insets(0,0,0,95)); // top, right, bottom, left
			hb_left.getChildren().add(hb_left_cannibals);
			//-----------------------------------------------------------------
			// top_center_left_bottom_h_missionaries
			HBox hb_left_missionaries=new HBox();
			Image image_D2_missionary = new Image(getClass().getResource("/D2_Graphic_icons/missionary.png").toExternalForm()); 
			for(int i=0;i<leftMissionariesNum;i++) {
				hb_left_missionaries.getChildren().add(new ImageView(image_D2_missionary));
			}
			if(leftCannibalsNum==0) {
				hb_left_missionaries.setPadding(new Insets(0,50,0,128)); // top, right, bottom, left
			}
			else if(leftCannibalsNum==1) {
				hb_left_missionaries.setPadding(new Insets(0,50,0,97)); // top, right, bottom, left
			}
			else if(leftCannibalsNum==2) {
				hb_left_missionaries.setPadding(new Insets(0,50,0,64.5)); // top, right, bottom, left
			}
			else if(leftCannibalsNum==3) {
				hb_left_missionaries.setPadding(new Insets(0,50,0,33)); // top, right, bottom, left
			}
			
			hb_left.getChildren().add(hb_left_missionaries);
			
			hb_left.setPadding(new Insets(60,0,0,15)); // top, right, bottom, left
		
		return hb_left;
	}

	public BorderPane center(String passenger1,String passenger2,String position) {
		BorderPane bp_center=new BorderPane();
			
		// center top
			VBox vb_center_top=new VBox();
				// top
				HBox hb_center_center_top=new HBox();
				Image image_D2_cannibal = new Image(getClass().getResource("/D2_Graphic_icons/cannibal.png").toExternalForm()); 
				Image image_D2_missionary = new Image(getClass().getResource("/D2_Graphic_icons/missionary.png").toExternalForm()); 
				
				ImageView imageView_passenger1=null;
				ImageView imageView_passenger2=null;
				
				if(passenger1.equals("Cannibal")) {
					imageView_passenger1 = new ImageView(image_D2_cannibal);
				}
				else if(passenger1.equals("Missionary")) {
					imageView_passenger1 = new ImageView(image_D2_missionary);
				}
				
				
				if(passenger2.equals("Cannibal")) {
					imageView_passenger2 = new ImageView(image_D2_cannibal);
				}
				else if(passenger2.equals("Missionary")) {
					imageView_passenger2 = new ImageView(image_D2_missionary);
				}
				
				
				if(passenger1.equals("Empty")) {
					hb_center_center_top.getChildren().add(imageView_passenger2);
				}
				else if(passenger2.equals("Empty")) {
					hb_center_center_top.getChildren().add(imageView_passenger1);
				}
				else {
					hb_center_center_top.getChildren().addAll(imageView_passenger1,imageView_passenger2);
				}
				
				hb_center_center_top.setSpacing(6);
				hb_center_center_top.setAlignment(Pos.BOTTOM_CENTER);
				hb_center_center_top.setPadding(new Insets(0,0,0,0)); // top, right, bottom, left
				
				// bottom
				HBox hb_center_center_bottom=new HBox();
				Image image_D2_boat_center = new Image(getClass().getResource("/D2_Graphic_icons/boat_right.png").toExternalForm()); 
				ImageView imageView_D2_boat_center = new ImageView(image_D2_boat_center);
				hb_center_center_bottom.getChildren().add(imageView_D2_boat_center);
				hb_center_center_bottom.setAlignment(Pos.TOP_CENTER);
			vb_center_top.getChildren().addAll(hb_center_center_top,hb_center_center_bottom);	
				
			// right
			HBox hb_center_right=new HBox();
			Image image_D2_rightArrow_center = new Image(getClass().getResource("/D2_Graphic_icons/arrow_right.png").toExternalForm()); 
			ImageView imageView_D2_rightArrow_center = new ImageView(image_D2_rightArrow_center);
			hb_center_right.getChildren().add(imageView_D2_rightArrow_center);
			hb_center_right.setPadding(new Insets(30,10,0,0)); // top, right, bottom, left
				
			// left
			HBox hb_center_left=new HBox();
			Image image_D2_leftArrow_center = new Image(getClass().getResource("/D2_Graphic_icons/arrow_left.png").toExternalForm()); 
			ImageView imageView_D2_leftArrow_center = new ImageView(image_D2_leftArrow_center);
			hb_center_left.getChildren().add(imageView_D2_leftArrow_center);
			hb_center_left.setPadding(new Insets(30,0,0,10)); // top, right, bottom, left
	
			
		bp_center.setCenter(vb_center_top);
		if(position.equals("Right")) {
			bp_center.setRight(hb_center_right);
			vb_center_top.setPadding(new Insets(0,0,0,41.5)); // top, right, bottom, left
		}
		else if(position.equals("Left")) {
			bp_center.setLeft(hb_center_left);
			vb_center_top.setPadding(new Insets(0,41.5,0,0)); // top, right, bottom, left
		}
		
		bp_center.setPadding(new Insets(30,0,0,0)); // top, right, bottom, left
		
		return bp_center;
	}

	public HBox right(int rightCannibalsNum,int rightMissionariesNum) {
		HBox hb_right=new HBox();
			
			
			// right_left_boat
			HBox hb_right_left_boat=new HBox();
			Image image_D2_boat_right = new Image(getClass().getResource("/D2_Graphic_icons/boat_right.png").toExternalForm()); 
			ImageView imageView_D2_boat_right = new ImageView(image_D2_boat_right);
			hb_right_left_boat.getChildren().add(imageView_D2_boat_right);
			hb_right_left_boat.setPadding(new Insets(0,0,0,17)); // top, right, bottom, left
			hb_right_left_boat.setVisible(false);
			//-------------------------------------------------------------------------
			// right_center_cannibal
			HBox hb_right_center_cannibal=new HBox();
			Image image_D2_cannibal = new Image(getClass().getResource("/D2_Graphic_icons/cannibal.png").toExternalForm()); 
			for(int i=0;i<rightCannibalsNum;i++) {
				hb_right_center_cannibal.getChildren().add(new ImageView(image_D2_cannibal));
			}

			hb_right_center_cannibal.setPadding(new Insets(0,0,0,52)); // top, right, bottom, left
			//-----------------------------------------------------------------
			// right_right_missionaries
			HBox hb_right_right_missionaries=new HBox();
			Image image_D2_missionary = new Image(getClass().getResource("/D2_Graphic_icons/missionary.png").toExternalForm()); 
			for(int i=0;i<rightMissionariesNum;i++) {
				hb_right_right_missionaries.getChildren().add(new ImageView(image_D2_missionary));
			}
			
			
		
			
	
	
	if(rightCannibalsNum==0) {
		hb_right_right_missionaries.setPadding(new Insets(0,0,0,126.5)); // top, right, bottom, left
	}
	else if(rightCannibalsNum==1) {
		hb_right_right_missionaries.setPadding(new Insets(0,0,0,93)); // top, right, bottom, left
	}
	else if(rightCannibalsNum==2) {
		hb_right_right_missionaries.setPadding(new Insets(0,0,0,61.5)); // top, right, bottom, left
	}
	else if(rightMissionariesNum==3) {
		hb_right_right_missionaries.setPadding(new Insets(0,0,0,29.5)); // top, right, bottom, left
	}
	
	if(rightCannibalsNum==3 && rightMissionariesNum==3) {
		hb_right_left_boat.setVisible(true);
	}
	hb_right.getChildren().addAll(hb_right_left_boat,hb_right_center_cannibal,hb_right_right_missionaries);	
	hb_right.setPadding(new Insets(67, 0, 0, 0)); // top, right, bottom, left
		
		return hb_right;
	}
	
	public String printData(String searchType) {
		String s="";
		
		for(int i=0;i<al_data.size();i++) {
			if(i==0) {
				s+="Initial State        : "+al_data.get(i).toString()+"\n";
				s+="                            "+"|"+"\n";
				s+="                           "+"V"+"\n";
			}
			else {
				if(i==al_data.size()-1) {
					s+="Step number ("+i+"): "+al_data.get(i).toString()+"\n";
				}
				else {
					s+="Step number ("+i+"): "+al_data.get(i).toString()+"\n";
					s+="                           "+"|"+"\n";
					s+="                          "+"V"+"\n";
				}
			}
			
			
		}
		
		s+=searchType+" Execution time: "+(endTime - startTime);
		
		return s;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
