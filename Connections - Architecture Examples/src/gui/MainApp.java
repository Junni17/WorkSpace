package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import service.Service;

public class MainApp extends Application
{
    private PrintStage printStage;

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void init()
    {
        Service.initStorage();
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Arcitecture Demo");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        printStage = new PrintStage(stage);
    }

//    @Override
//    public void stop() throws Exception
//    {
//        System.out.println("Saving data (but not in this version of the program)");
//    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane)
    {
        MenuBar menubar = new MenuBar();
        this.initMenus(menubar);
        pane.setTop(menubar);

        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initMenus(MenuBar menubar)
    {
        Menu menuPrint = new Menu("Print");
        menubar.getMenus().add(menuPrint);

        MenuItem companies = new MenuItem("Companies");
        menuPrint.getItems().add(companies);
        companies.setOnAction(event -> ctrl.companiesAction());

        MenuItem employees = new MenuItem("Employees");
        menuPrint.getItems().add(employees);
        employees.setOnAction(event -> ctrl.employeesAction());

        menuPrint.getItems().add(new SeparatorMenuItem());

        MenuItem exit = new MenuItem("Exit");
        menuPrint.getItems().add(exit);
        exit.setOnAction(event -> ctrl.exitAction());
    }

    private void initTabPane(TabPane tabPane)
    {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabCompanies = new Tab("Companies");
        tabPane.getTabs().add(tabCompanies);

        CompanyPane companyPane = new CompanyPane();
        tabCompanies.setContent(companyPane);
        tabCompanies.setOnSelectionChanged(event -> companyPane.updateControls());

        Tab tabEmployees = new Tab("Employees");
        tabPane.getTabs().add(tabEmployees);

        EmployeePane employeePane = new EmployeePane();
        tabEmployees.setContent(employeePane);
        tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());
    }

    // -------------------------------------------------------------------------

    private Controller ctrl = new Controller();

    private class Controller
    {
        public void employeesAction()
        {
            printStage.showEmployees();
            printStage.show();
        }

        public void companiesAction()
        {
            printStage.showCompanies();
            printStage.show();
        }

        public void exitAction()
        {
            Platform.exit();
        }
    }

}
