
module proyectof1 {
	requires java.sql;
	requires javafx.graphics;
	requires javafx.controls;
    opens demo to javafx.graphics;
    exports demo;
    opens modelos;
}