/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TechNova;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eider
 */
public class CatalogoView {
    private static final String OSCURO = "#10192D";
    private static final String FONDO = "#F5F7FA";
    private static final String TURQUESA = "#18B6E8";

    private static final List<Producto> productos =
            new ArrayList<>();

    private static GridPane grid;

    private static void cargarProductos() {

        productos.clear();

        productos.add(new Producto(
            "Laptop Lenovo",
            "Portátiles",
            "Equipo ideal para trabajo y estudio",
            "$2.500.000",
            "/TechNova/ImagenesCatalogo/laptop.jpg"
        ));

        productos.add(new Producto(
            "MacBook Air",
            "Portátiles",
            "Portátil Apple de alto rendimiento",
            "$4.500.000",
            "/TechNova/ImagenesCatalogo/macbook.jpg"
        ));

        productos.add(new Producto(
            "Samsung Galaxy",
            "Celulares",
            "Smartphone de última generación",
            "$1.800.000",
            "/TechNova/ImagenesCatalogo/samsung.jpg"
        ));

        productos.add(new Producto(
            "iPhone",
            "Celulares",
            "Smartphone Apple",
            "$3.800.000",
            "/TechNova/ImagenesCatalogo/iphone.jpg"
        ));

        productos.add(new Producto(
            "Audífonos Bluetooth",
            "Audio",
            "Sonido inalámbrico de alta calidad",
            "$150.000",
            "/TechNova/ImagenesCatalogo/audífonos.jpg"
        ));

        productos.add(new Producto(
            "Parlante Bluetooth",
            "Audio",
            "Parlante portátil",
            "$220.000",
            "/TechNova/ImagenesCatalogo/parlante.jpg"
        ));

        productos.add(new Producto(
            "Teclado Gamer",
            "Accesorios",
            "Teclado para videojuegos",
            "$120.000",
            "/TechNova/ImagenesCatalogo/teclado.jpg"
        ));

        productos.add(new Producto(
            "Mouse Gamer",
            "Accesorios",
            "Mouse óptico de precisión",
            "$85.000",
            "/TechNova/ImagenesCatalogo/mause.jpg"
        ));

        productos.add(new Producto(
            "Monitor LG",
            "Accesorios",
            "Monitor para computador",
            "$950.000",
            "/TechNova/ImagenesCatalogo/monitor.jpg"
        ));
    }

    public static void mostrar(Stage stage, String tipoCuenta) {

        cargarProductos();

        // ENCABEZADO
        Label logo = new Label("TechNova");

        logo.setFont(Font.font(
            "Arial", FontWeight.BOLD, 27
        ));

        logo.setTextFill(Color.web(TURQUESA));

        Label usuario = new Label(
            "Bienvenido | " + tipoCuenta
        );

        usuario.setTextFill(Color.WHITE);

        Button cerrarSesion = new Button("Cerrar sesión");

        cerrarSesion.setStyle(
            "-fx-background-color: white;" +
            "-fx-text-fill: " + OSCURO + ";" +
            "-fx-background-radius: 8;" +
            "-fx-font-weight: bold;"
        );

        cerrarSesion.setOnAction(e ->
            LoginView.mostrar(stage)
        );

        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        HBox encabezado = new HBox(
            20, logo, espacio, usuario, cerrarSesion
        );

        encabezado.setAlignment(Pos.CENTER);
        encabezado.setPadding(new Insets(18, 30, 18, 30));

        encabezado.setStyle(
            "-fx-background-color: " + OSCURO + ";"
        );

        // TITULO
        Label titulo = new Label(
            "Catálogo de productos"
        );

        titulo.setFont(Font.font(
            "Arial", FontWeight.BOLD, 28
        ));

        titulo.setTextFill(Color.web(OSCURO));

        Label descripcion = new Label(
            "Descubre nuestra selección de tecnología"
        );

        descripcion.setFont(Font.font(15));
        descripcion.setTextFill(Color.web("#8291A8"));

        // BUSCADOR
        TextField buscador = new TextField();

        buscador.setPromptText(
            "Buscar productos tecnológicos..."
        );

        buscador.setPrefWidth(350);
        buscador.setPrefHeight(43);

        ComboBox<String> categoria = new ComboBox<>();

        categoria.getItems().addAll(
            "Todas",
            "Portátiles",
            "Celulares",
            "Audio",
            "Accesorios"
        );

        categoria.setValue("Todas");
        categoria.setPrefHeight(43);

        HBox filtros = new HBox(
            12, buscador, categoria
        );

        filtros.setAlignment(Pos.CENTER);

        // GRID
        grid = new GridPane();

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(22);
        grid.setVgap(22);
        grid.setPadding(new Insets(20));

        // FILTRADO
        Runnable actualizar = () -> {

            grid.getChildren().clear();

            String texto = buscador.getText()
                .toLowerCase().trim();

            String seleccion = categoria.getValue();

            int columna = 0;
            int fila = 0;

            for (Producto p : productos) {

                boolean coincideNombre =
                    p.getNombre().toLowerCase()
                    .contains(texto);

                boolean coincideCategoria =
                    seleccion.equals("Todas")
                    || p.getCategoria().equals(seleccion);

                if (coincideNombre && coincideCategoria) {

                    VBox tarjeta = crearTarjeta(p);

                    grid.add(tarjeta, columna, fila);

                    columna++;

                    if (columna == 3) {
                        columna = 0;
                        fila++;
                    }
                }
            }
        };

        buscador.textProperty().addListener(
            (observable, anterior, nuevo) ->
                actualizar.run()
        );

        categoria.setOnAction(
            e -> actualizar.run()
        );

        // CONTENIDO
        VBox contenido = new VBox(
            16, titulo, descripcion, filtros, grid
        );

        contenido.setAlignment(Pos.TOP_CENTER);
        contenido.setPadding(new Insets(30));

        ScrollPane scroll = new ScrollPane(contenido);

        scroll.setFitToWidth(true);

        scroll.setStyle(
            "-fx-background: " + FONDO + ";" +
            "-fx-background-color: " + FONDO + ";"
        );

        BorderPane principal = new BorderPane();

        principal.setTop(encabezado);
        principal.setCenter(scroll);

        principal.setStyle(
            "-fx-background-color: " + FONDO + ";"
        );

        Scene scene = new Scene(principal, 1100, 720);

        stage.setTitle("TechNova | Catálogo");
        stage.setScene(scene);
        stage.show();

        actualizar.run();
    }

    private static VBox crearTarjeta(Producto producto) {

        VBox tarjeta = new VBox(12);

        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setPadding(new Insets(20));
        tarjeta.setPrefWidth(245);
        tarjeta.setMinHeight(275);

        tarjeta.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 18;" +
            "-fx-border-color: #E5EAF1;" +
            "-fx-border-radius: 18;"
        );
        
ImageView imagen = new ImageView();

try {

    URL recurso = CatalogoView.class.getResource(
        producto.getImagen()
    );

    if (recurso != null) {

        Image img = new Image(recurso.toExternalForm());

        imagen.setImage(img);

    } else {

        System.out.println(
            "No se encontro la imagen: "
            + producto.getImagen()
        );
    }

} catch (Exception e) {

    System.out.println("Error al cargar imagen: "
            + producto.getImagen());

    e.printStackTrace();
}

imagen.setFitWidth(150);
imagen.setFitHeight(140);
imagen.setPreserveRatio(true);
imagen.setSmooth(true);

        
        Label nombre = new Label(
            producto.getNombre()
        );

        nombre.setFont(Font.font(
            "Arial", FontWeight.BOLD, 17
        ));

        nombre.setTextFill(Color.web(OSCURO));

        Label descripcion = new Label(
            producto.getDescripcion()
        );

        descripcion.setFont(Font.font(12));
        descripcion.setTextFill(Color.web("#8291A8"));
        descripcion.setWrapText(true);
        descripcion.setMaxWidth(210);
        descripcion.setAlignment(Pos.CENTER);

        Label precio = new Label(
            producto.getPrecio()
        );

        precio.setFont(Font.font(
            "Arial", FontWeight.BOLD, 20
        ));

        precio.setTextFill(Color.web("#008FAF"));

        tarjeta.getChildren().addAll(
            imagen,
            nombre,
            descripcion,
            precio
        );

        return tarjeta;
    }
}
