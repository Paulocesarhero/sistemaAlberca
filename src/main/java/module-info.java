module uv.daduv.alberca {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens uv.daduv.alberca to javafx.fxml;
    exports uv.daduv.alberca;
}