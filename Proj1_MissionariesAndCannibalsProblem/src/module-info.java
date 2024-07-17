module Proj1_MissionariesAndCannibalsProblem {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	
	opens A_RunApplication to javafx.graphics, javafx.fxml;
}
