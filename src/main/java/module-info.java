module br.com.ufersa {
    requires javafx.controls;
    requires javafx.web;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jakarta.persistence;
    requires java.desktop;

    requires org.hibernate.orm.core;
    requires mysql.connector.j;
    opens br.com.ufersa.model.entities to org.hibernate.orm.core,  javafx.fxml, javafx.base;

    opens br.com.ufersa.presenter to javafx.fxml;
    exports br.com.ufersa.view;
    opens br.com.ufersa.view to javafx.fxml;
    opens br.com.ufersa.presenter.locais to javafx.fxml;
    opens br.com.ufersa.presenter.equipamentos to javafx.fxml;
    opens br.com.ufersa.presenter.clientes to javafx.fxml;
    opens br.com.ufersa.presenter.vendas to javafx.fxml;
    opens br.com.ufersa.presenter.util to javafx.fxml;


}