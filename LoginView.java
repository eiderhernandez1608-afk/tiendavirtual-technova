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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Eider
 */
public class LoginView {
      private static final String OSCURO = "#10192D";
    private static final String FONDO = "#F5F7FA";
    private static final String TURQUESA = "#18B6E8";

    // Usuarios registrados durante la ejecución
    private static final Map<String, String> usuarios =
            new HashMap<>();

    // Usuario administrador de prueba
    static {
        usuarios.put("admin", "admin123");
    }

    public static void mostrar(Stage stage) {

        // ICONO
        Label icono = new Label("▦");
        icono.setFont(Font.font("Arial", 34));
        icono.setTextFill(Color.web(TURQUESA));

        StackPane iconoCaja = new StackPane(icono);
        iconoCaja.setPrefSize(58, 58);
        iconoCaja.setMaxSize(58, 58);

        iconoCaja.setStyle(
            "-fx-background-color: " + OSCURO + ";" +
            "-fx-background-radius: 17;"
        );

        // TITULO
        Label titulo = new Label("TechNova");
        titulo.setFont(Font.font(
            "Arial", FontWeight.BOLD, 34
        ));
        titulo.setTextFill(Color.web(OSCURO));

        Label subtitulo = new Label(
            "La tecnología del futuro a tu alcance"
        );
        subtitulo.setFont(Font.font("Arial", 16));
        subtitulo.setTextFill(Color.web("#8291A8"));

        // USUARIO
        Label textoUsuario = new Label("Usuario");

        textoUsuario.setFont(Font.font(
            "Arial", FontWeight.BOLD, 14
        ));

        textoUsuario.setTextFill(Color.web(OSCURO));

        TextField usuario = new TextField();

        usuario.setPromptText(
            "Ingresa tu correo o usuario"
        );

        usuario.setPrefHeight(48);
        usuario.setStyle(estiloCampo());

        HBox cajaUsuario = new HBox(
            10, new Label("♙"), usuario
        );

        cajaUsuario.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(usuario, Priority.ALWAYS);
        cajaUsuario.setStyle(estiloContenedor());

        // CONTRASEÑA
        Label textoPassword = new Label("Contraseña");

        textoPassword.setFont(Font.font(
            "Arial", FontWeight.BOLD, 14
        ));

        textoPassword.setTextFill(Color.web(OSCURO));

        PasswordField password = new PasswordField();

        password.setPromptText(
            "Ingresa tu contraseña"
        );

        password.setPrefHeight(48);
        password.setStyle(estiloCampo());

        HBox cajaPassword = new HBox(
            10, new Label("▢"), password
        );

        cajaPassword.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(password, Priority.ALWAYS);
        cajaPassword.setStyle(estiloContenedor());

        // MENSAJE
        Label mensaje = new Label();
        mensaje.setTextFill(Color.web("#DC2626"));
        mensaje.setWrapText(true);

        // BOTON INICIAR SESION
        Button ingresar = new Button("Iniciar Sesión");

        ingresar.setPrefHeight(53);
        ingresar.setMaxWidth(Double.MAX_VALUE);

        ingresar.setStyle(
            "-fx-background-color: " + OSCURO + ";" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12;" +
            "-fx-cursor: hand;"
        );

        ingresar.setOnAction(e -> {

            String user = usuario.getText().trim();
            String pass = password.getText();

            if (user.isEmpty() || pass.isEmpty()) {

                mensaje.setText(
                    "información incompleta."
                );

                return;
            }

            if (usuarios.containsKey(user)
                    && usuarios.get(user).equals(pass)) {

                String tipo = user.equals("admin")
                    ? "Administrador" : "Cliente";

                CatalogoView.mostrar(stage, tipo);

            } else {

                mensaje.setText(
                    "Usuario o contraseña incorrectos."
                );
            }
        });

        // BOTON REGISTRARSE
        Button registrarse = new Button("Registrarse");

        registrarse.setPrefHeight(53);
        registrarse.setMaxWidth(Double.MAX_VALUE);

        registrarse.setStyle(
            "-fx-background-color: white;" +
            "-fx-text-fill: " + OSCURO + ";" +
            "-fx-font-size: 15;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: #7E8490;" +
            "-fx-border-width: 1.5;" +
            "-fx-border-radius: 12;" +
            "-fx-background-radius: 12;" +
            "-fx-cursor: hand;"
        );

        registrarse.setOnAction(e ->
            mostrarRegistro(stage)
        );

        // TARJETA PRINCIPAL
        VBox tarjeta = new VBox(16);

        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setPadding(new Insets(40));
        tarjeta.setMaxWidth(486);
        tarjeta.setPrefWidth(486);

        Region espacio = new Region();
        espacio.setMinHeight(5);

        tarjeta.getChildren().addAll(
            iconoCaja,
            titulo,
            subtitulo,
            espacio,
            textoUsuario,
            cajaUsuario,
            textoPassword,
            cajaPassword,
            ingresar,
            registrarse,
            mensaje
        );

        tarjeta.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 26;"
        );

        StackPane principal = new StackPane(tarjeta);

        principal.setPadding(new Insets(25));

        principal.setStyle(
            "-fx-background-color: " + FONDO + ";"
        );

        Scene scene = new Scene(principal, 900, 760);

        stage.setTitle("TechNova | Iniciar Sesión");
        stage.setScene(scene);
        stage.setMinWidth(550);
        stage.setMinHeight(650);
        stage.show();
    }

    // FORMULARIO DE REGISTRO
    private static void mostrarRegistro(Stage stage) {

        Label titulo = new Label("Crear cuenta");

        titulo.setFont(Font.font(
            "Arial", FontWeight.BOLD, 30
        ));

        titulo.setTextFill(Color.web(OSCURO));

        Label subtitulo = new Label(
            "Únete a la experiencia TechNova"
        );

        subtitulo.setTextFill(Color.web("#8291A8"));

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre completo");

        TextField usuario = new TextField();
        usuario.setPromptText("Crea tu nombre de usuario");

        PasswordField password = new PasswordField();
        password.setPromptText("Crea una contraseña");

        PasswordField confirmar = new PasswordField();
        confirmar.setPromptText("Confirma tu contraseña");

        Label mensaje = new Label();
        mensaje.setWrapText(true);

        Button registrar = new Button("Crear mi cuenta");

        registrar.setMaxWidth(Double.MAX_VALUE);
        registrar.setPrefHeight(50);

        registrar.setStyle(
            "-fx-background-color: " + OSCURO + ";" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12;"
        );

        Button volver = new Button(
            "Volver al inicio de sesión"
        );

        volver.setMaxWidth(Double.MAX_VALUE);

        volver.setStyle(
            "-fx-background-color: white;" +
            "-fx-text-fill: " + OSCURO + ";" +
            "-fx-border-color: #7E8490;" +
            "-fx-border-radius: 12;" +
            "-fx-background-radius: 12;"
        );

        registrar.setOnAction(e -> {

            String nom = nombre.getText().trim();
            String user = usuario.getText().trim();
            String pass = password.getText();
            String conf = confirmar.getText();

            if (nom.isEmpty() || user.isEmpty()
                    || pass.isEmpty() || conf.isEmpty()) {

                mensaje.setText(
                    "Completa todos los campos."
                );

                mensaje.setTextFill(Color.RED);
                return;
            }

            if (user.equalsIgnoreCase("admin")
                    || usuarios.containsKey(user)) {

                mensaje.setText(
                    "Este usuario ya está registrado."
                );

                mensaje.setTextFill(Color.RED);
                return;
            }

            if (pass.length() < 4) {

                mensaje.setText(
                    "La contraseña debe tener mínimo 4 caracteres."
                );

                mensaje.setTextFill(Color.RED);
                return;
            }

            if (!pass.equals(conf)) {

                mensaje.setText(
                    "Las contraseñas no coinciden."
                );

                mensaje.setTextFill(Color.RED);
                return;
            }

            usuarios.put(user, pass);

            mensaje.setText(
                "¡Cuenta creada correctamente! Ya puedes ingresar."
            );

            mensaje.setTextFill(Color.web("#15803D"));

            nombre.clear();
            usuario.clear();
            password.clear();
            confirmar.clear();
        });

        volver.setOnAction(e -> mostrar(stage));

        VBox tarjeta = new VBox(13);

        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setPadding(new Insets(40));
        tarjeta.setMaxWidth(486);

        tarjeta.getChildren().addAll(
            titulo,
            subtitulo,
            new Label("Nombre completo"),
            nombre,
            new Label("Usuario"),
            usuario,
            new Label("Contraseña"),
            password,
            new Label("Confirmar contraseña"),
            confirmar,
            registrar,
            volver,
            mensaje
        );

        tarjeta.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 26;"
        );

        StackPane root = new StackPane(tarjeta);

        root.setPadding(new Insets(25));

        root.setStyle(
            "-fx-background-color: " + FONDO + ";"
        );

        Scene scene = new Scene(root, 900, 760);

        stage.setTitle("TechNova | Crear cuenta");
        stage.setScene(scene);
        stage.show();
    }

    private static String estiloCampo() {

        return "-fx-background-color: transparent;" +
               "-fx-border-color: transparent;" +
               "-fx-font-size: 14;" +
               "-fx-text-fill: " + OSCURO + ";";
    }

    private static String estiloContenedor() {

        return "-fx-background-color: white;" +
               "-fx-border-color: #E5EAF1;" +
               "-fx-border-radius: 12;" +
               "-fx-background-radius: 12;" +
               "-fx-padding: 0 12 0 12;";
    }
}
