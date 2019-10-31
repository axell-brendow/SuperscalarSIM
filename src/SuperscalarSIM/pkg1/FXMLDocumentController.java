/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperscalarSIM.pkg1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author roberto
 */
public class FXMLDocumentController implements Initializable {

    // Desenho de Fundo
    
    @FXML
    private ImageView fundo;
	
    // Menus
    
    @FXML
    private MenuItem menuOpenFile;
    @FXML
    private MenuItem menuClose;
    @FXML
    private CheckMenuItem menuSecondALU;
    @FXML
    private CheckMenuItem menuSecondMEM;
    @FXML
    private CheckMenuItem menuSecondFP;
    @FXML
    private RadioMenuItem menu2LineRS;
    @FXML
    private RadioMenuItem menu3LineRS;
    @FXML
    private RadioMenuItem menu1WayPipeline;
    @FXML
    private RadioMenuItem menu2WayPipeline;
    @FXML
    private RadioMenuItem menu4WayPipeline;
    
    // Functional Units Animation

    @FXML
    private Label labelCycles;
    @FXML
    private Label labelALU1;
    @FXML
    private Label labelALU2;
    @FXML
    private Label labelFP1;
    @FXML
    private Label labelFP2;
    @FXML
    private Label labelMEM1;
    @FXML
    private Label labelMEM2;
    @FXML
    private Label labelEstagioALU1;
    @FXML
    private Label labelEstagioALU2;
    @FXML
    private Label labelEstagioFP11;
    @FXML
    private Label labelEstagioFP12;
    @FXML
    private Label labelEstagioFP13;
    @FXML
    private Label labelEstagioFP21;
    @FXML
    private Label labelEstagioFP22;
    @FXML
    private Label labelEstagioFP23;
    @FXML
    private Label labelEstagioMEM1;
    @FXML
    private Label labelEstagioMEM2;

    // Bind 
    private final StringProperty valorALU1 = new SimpleStringProperty("");
    private final StringProperty valorALU2 = new SimpleStringProperty("");
    private final StringProperty valorFP11 = new SimpleStringProperty("");
    private final StringProperty valorFP12 = new SimpleStringProperty("");
    private final StringProperty valorFP13 = new SimpleStringProperty("");
    private final StringProperty valorFP21 = new SimpleStringProperty("");
    private final StringProperty valorFP22 = new SimpleStringProperty("");
    private final StringProperty valorFP23 = new SimpleStringProperty("");
    private final StringProperty valorMEM1 = new SimpleStringProperty("");
    private final StringProperty valorMEM2 = new SimpleStringProperty("");
     
    // Tables
    
    @FXML
    private TableView<EntryMEM> instructionMemory;
    @FXML
    private TableColumn<EntryMEM, String> instructionMemoryInst;
    @FXML
    private TableColumn<EntryMEM, String> instructionMemoryProgLine;

    @FXML
    private TableView<EntryIQ> instructionQueue;
    @FXML
    private TableColumn<EntryIQ, String> instructionQueueInst;
    @FXML
    private TableColumn<EntryIQ, String> instructionQueueOp;
    @FXML
    private TableColumn<EntryIQ, String> instructionQueueRd;
    @FXML
    private TableColumn<EntryIQ, String> instructionQueueRs;
    @FXML
    private TableColumn<EntryIQ, String> instructionQueueRt;
    @FXML
    private TableColumn<EntryIQ, Integer> instructionQueueIm;

    
    
            
    @FXML
    private TableView<EntryREG> registerFile;
    @FXML
    private TableColumn<EntryREG, String> registerFileReg;
    @FXML
    private TableColumn<EntryREG, String> registerFileV;
    @FXML
    private TableColumn<EntryREG, String> registerFileQi;
    @FXML
    private TableColumn<EntryREG, String> registerFileValid;

    @FXML
    private TableView<EntryRS> reservStation1;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation1Id;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation1Inst;
    @FXML
    private TableColumn<EntryRS, String> reservStation1Op;
    @FXML
    private TableColumn<EntryRS, String> reservStation1Vj;
    @FXML
    private TableColumn<EntryRS, String> reservStation1Vk;
    @FXML
    private TableColumn<EntryRS, String> reservStation1Qj;
    @FXML
    private TableColumn<EntryRS, String> reservStation1Qk;
    @FXML
    private TableColumn<EntryRS, String> reservStation1A;
    @FXML
    private TableColumn<EntryRS, String> reservStation1Busy;


    @FXML
    private TableView<EntryRS> reservStation2;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation2Id;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation2Inst;
    @FXML
    private TableColumn<EntryRS, String> reservStation2Op;
    @FXML
    private TableColumn<EntryRS, String> reservStation2Vj;
    @FXML
    private TableColumn<EntryRS, String> reservStation2Vk;
    @FXML
    private TableColumn<EntryRS, String> reservStation2Qj;
    @FXML
    private TableColumn<EntryRS, String> reservStation2Qk;
    @FXML
    private TableColumn<EntryRS, String> reservStation2A;
    @FXML
    private TableColumn<EntryRS, String> reservStation2Busy;


    @FXML
    private TableView<EntryRS> reservStation3;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation3Id;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation3Inst;
    @FXML
    private TableColumn<EntryRS, String> reservStation3Op;
    @FXML
    private TableColumn<EntryRS, String> reservStation3Vj;
    @FXML
    private TableColumn<EntryRS, String> reservStation3Vk;
    @FXML
    private TableColumn<EntryRS, String> reservStation3Qj;
    @FXML
    private TableColumn<EntryRS, String> reservStation3Qk;
    @FXML
    private TableColumn<EntryRS, String> reservStation3A;
    @FXML
    private TableColumn<EntryRS, String> reservStation3Busy;


    @FXML
    private TableView<EntryRS> reservStation4;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation4Id;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation4Inst;
    @FXML
    private TableColumn<EntryRS, String> reservStation4Op;
    @FXML
    private TableColumn<EntryRS, String> reservStation4Vj;
    @FXML
    private TableColumn<EntryRS, String> reservStation4Vk;
    @FXML
    private TableColumn<EntryRS, String> reservStation4Qj;
    @FXML
    private TableColumn<EntryRS, String> reservStation4Qk;
    @FXML
    private TableColumn<EntryRS, String> reservStation4A;
    @FXML
    private TableColumn<EntryRS, String> reservStation4Busy;


    @FXML
    private TableView<EntryRS> reservStation5;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation5Id;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation5Inst;
    @FXML
    private TableColumn<EntryRS, String> reservStation5Op;
    @FXML
    private TableColumn<EntryRS, String> reservStation5Vj;
    @FXML
    private TableColumn<EntryRS, String> reservStation5Vk;
    @FXML
    private TableColumn<EntryRS, String> reservStation5Qj;
    @FXML
    private TableColumn<EntryRS, String> reservStation5Qk;
    @FXML
    private TableColumn<EntryRS, String> reservStation5A;
    @FXML
    private TableColumn<EntryRS, String> reservStation5Busy;


    @FXML
    private TableView<EntryRS> reservStation6;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation6Id;
    @FXML
    private TableColumn<EntryRS, Integer> reservStation6Inst;
    @FXML
    private TableColumn<EntryRS, String> reservStation6Op;
    @FXML
    private TableColumn<EntryRS, String> reservStation6Vj;
    @FXML
    private TableColumn<EntryRS, String> reservStation6Vk;
    @FXML
    private TableColumn<EntryRS, String> reservStation6Qj;
    @FXML
    private TableColumn<EntryRS, String> reservStation6Qk;
    @FXML
    private TableColumn<EntryRS, String> reservStation6A;
    @FXML
    private TableColumn<EntryRS, String> reservStation6Busy;

    
    @FXML
    private TableView<EntryROB> reorderBuffer;
    @FXML
    private TableColumn<EntryROB, Integer> reorderBufferId;
    @FXML
    private TableColumn<EntryROB, Integer> reorderBufferInst;
    @FXML
    private TableColumn<EntryROB, String> reorderBufferType;
    @FXML
    private TableColumn<EntryROB, String> reorderBufferD;
    @FXML
    private TableColumn<EntryROB, String> reorderBufferV;
    @FXML
    private TableColumn<EntryROB, String> reorderBufferReady;
    

    // Cada tabela é associada a uma lista
    
//    private final List<EntryIQ> InstructionQueue = new ArrayList();
    private ObservableList<EntryIQ> observableListentryIQ;

    private ObservableList<EntryMEM> observableListentryMEM;

//    private final List<EntryREG> listentryREG = new ArrayList();
    private ObservableList<EntryREG> observableListentryREG;

//    private final List<EntryRS> listentryRS1 = new ArrayList();
    private ObservableList<EntryRS> observableListentryRS1;

//    private final List<EntryRS> listentryRS2 = new ArrayList();
    private ObservableList<EntryRS> observableListentryRS2;
   
//    private final List<EntryRS> listentryRS3 = new ArrayList();
    private ObservableList<EntryRS> observableListentryRS3;
   
//    private final List<EntryRS> listentryRS4 = new ArrayList();
    private ObservableList<EntryRS> observableListentryRS4;
   
//    private final List<EntryRS> listentryRS5 = new ArrayList();
    private ObservableList<EntryRS> observableListentryRS5;
   
//    private final List<EntryRS> listentryRS6 = new ArrayList();
    private ObservableList<EntryRS> observableListentryRS6;
   
//    private final List<EntryROB> listentryROB = new ArrayList();
    private ObservableList<EntryROB> observableListentryROB;
   
    

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

    // Declaração de Variáveis
    
    boolean verbose = true;
    
    int currentCycle  = 0;
    
    int wayNumber = 1;

    boolean secondAluISselected = true;
    boolean secondMemISselected = true;
    boolean secondFpISselected = true;
    
    int functionalUnitCount = 6;
    
    boolean nextCommandStated = false;

    int listMEMcurrentPos = 0;
    int listIQcurrentPos = 0;
    int listROBcurrentPos = 0;

    boolean isListRS1ALUturn = true;
    boolean isListRS1FPturn = true;
    boolean isListRS1MEMturn = true;
    
    EntryOU OperationUnit1ALU = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit2ALU = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit1FPstage1 = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit1FPstage2 = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit1FPstage3 = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit2FPstage1 = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit2FPstage2 = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit2FPstage3 = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit1MEM = new EntryOU(0, "", "", "", 0);
    EntryOU OperationUnit2MEM = new EntryOU(0, "", "", "", 0);


    List<EntryMEM> listMEM = new ArrayList<>();
    List<EntryMEM> listentryMEM = new ArrayList<>();

    List<EntryIQ> listIQ = new ArrayList<>();
    int listIQMaxSize = 12;

    List<EntryIQ> listFetch = new ArrayList<>();
    
    List<Decoder> listDecoder = new ArrayList<>();

    List<EntryREG> listREG = new ArrayList<>();
    int listREGMaxSize = 128;
    
    List<EntryROB> listROB = new ArrayList<>();
    int listROBMaxSize = 24;
    
    List<EntryRS> listRS1ALU = new ArrayList<>();
    List<EntryRS> listRS2ALU = new ArrayList<>();
    List<EntryRS> listRS1FP = new ArrayList<>();
    List<EntryRS> listRS2FP = new ArrayList<>();
    List<EntryRS> listRS1MEM = new ArrayList<>();
    List<EntryRS> listRS2MEM = new ArrayList<>();
    int listRSMaxSize = 3;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Desenho de Fundo
        Image imagem = new Image("resources/FUNDO4.png");
        fundo.setImage(imagem);

        // Labels
        labelCycles.setText("Cycles: " + currentCycle);
        labelEstagioALU1.setText("");
        labelEstagioALU2.setText("");
        labelEstagioFP11.setText("");
        labelEstagioFP12.setText("");
        labelEstagioFP13.setText("");
        labelEstagioFP21.setText("");
        labelEstagioFP22.setText("");
        labelEstagioFP23.setText("");
        labelEstagioMEM1.setText("");
        labelEstagioMEM2.setText("");
        
        // Binding Properties
        labelEstagioALU1.textProperty().bind(valorALU1);
        labelEstagioALU2.textProperty().bind(valorALU2);
        labelEstagioFP11.textProperty().bind(valorFP11);
        labelEstagioFP12.textProperty().bind(valorFP12);
        labelEstagioFP13.textProperty().bind(valorFP13);
        labelEstagioFP21.textProperty().bind(valorFP21);
        labelEstagioFP22.textProperty().bind(valorFP22);
        labelEstagioFP23.textProperty().bind(valorFP23);
        labelEstagioMEM1.textProperty().bind(valorMEM1);
        labelEstagioMEM2.textProperty().bind(valorMEM2);
        
        //Memoria
        
        instructionMemoryInst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        instructionMemoryProgLine.setCellValueFactory(new PropertyValueFactory<>("ProgLine"));

        //Instruction Queue
        
        instructionQueueInst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        instructionQueueOp.setCellValueFactory(new PropertyValueFactory<>("Op"));
        instructionQueueRd.setCellValueFactory(new PropertyValueFactory<>("Rd"));
        instructionQueueRs.setCellValueFactory(new PropertyValueFactory<>("Rs"));
        instructionQueueRt.setCellValueFactory(new PropertyValueFactory<>("Rt"));
        instructionQueueIm.setCellValueFactory(new PropertyValueFactory<>("Im"));

        //Reservation Station 1

        reservStation1Inst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        reservStation1Op.setCellValueFactory(new PropertyValueFactory<>("Op"));
        reservStation1Vj.setCellValueFactory(new PropertyValueFactory<>("Vj"));
        reservStation1Vk.setCellValueFactory(new PropertyValueFactory<>("Vk"));
        reservStation1Qj.setCellValueFactory(new PropertyValueFactory<>("Qj"));
        reservStation1Qk.setCellValueFactory(new PropertyValueFactory<>("Qk"));
        reservStation1A.setCellValueFactory(new PropertyValueFactory<>("A"));
        reservStation1Busy.setCellValueFactory(new PropertyValueFactory<>("Busy"));

        //Reservation Station 2

        reservStation2Inst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        reservStation2Op.setCellValueFactory(new PropertyValueFactory<>("Op"));
        reservStation2Vj.setCellValueFactory(new PropertyValueFactory<>("Vj"));
        reservStation2Vk.setCellValueFactory(new PropertyValueFactory<>("Vk"));
        reservStation2Qj.setCellValueFactory(new PropertyValueFactory<>("Qj"));
        reservStation2Qk.setCellValueFactory(new PropertyValueFactory<>("Qk"));
        reservStation2A.setCellValueFactory(new PropertyValueFactory<>("A"));
        reservStation2Busy.setCellValueFactory(new PropertyValueFactory<>("Busy"));
        
        //Reservation Station 3

        reservStation3Inst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        reservStation3Op.setCellValueFactory(new PropertyValueFactory<>("Op"));
        reservStation3Vj.setCellValueFactory(new PropertyValueFactory<>("Vj"));
        reservStation3Vk.setCellValueFactory(new PropertyValueFactory<>("Vk"));
        reservStation3Qj.setCellValueFactory(new PropertyValueFactory<>("Qj"));
        reservStation3Qk.setCellValueFactory(new PropertyValueFactory<>("Qk"));
        reservStation3A.setCellValueFactory(new PropertyValueFactory<>("A"));
        reservStation3Busy.setCellValueFactory(new PropertyValueFactory<>("Busy"));
        
        //Reservation Station 4

        reservStation4Inst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        reservStation4Op.setCellValueFactory(new PropertyValueFactory<>("Op"));
        reservStation4Vj.setCellValueFactory(new PropertyValueFactory<>("Vj"));
        reservStation4Vk.setCellValueFactory(new PropertyValueFactory<>("Vk"));
        reservStation4Qj.setCellValueFactory(new PropertyValueFactory<>("Qj"));
        reservStation4Qk.setCellValueFactory(new PropertyValueFactory<>("Qk"));
        reservStation4A.setCellValueFactory(new PropertyValueFactory<>("A"));
        reservStation4Busy.setCellValueFactory(new PropertyValueFactory<>("Busy"));

        //Reservation Station 5

        reservStation5Inst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        reservStation5Op.setCellValueFactory(new PropertyValueFactory<>("Op"));
        reservStation5Vj.setCellValueFactory(new PropertyValueFactory<>("Vj"));
        reservStation5Vk.setCellValueFactory(new PropertyValueFactory<>("Vk"));
        reservStation5Qj.setCellValueFactory(new PropertyValueFactory<>("Qj"));
        reservStation5Qk.setCellValueFactory(new PropertyValueFactory<>("Qk"));
        reservStation5A.setCellValueFactory(new PropertyValueFactory<>("A"));
        reservStation5Busy.setCellValueFactory(new PropertyValueFactory<>("Busy"));

        //Reservation Station 6

        reservStation6Inst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        reservStation6Op.setCellValueFactory(new PropertyValueFactory<>("Op"));
        reservStation6Vj.setCellValueFactory(new PropertyValueFactory<>("Vj"));
        reservStation6Vk.setCellValueFactory(new PropertyValueFactory<>("Vk"));
        reservStation6Qj.setCellValueFactory(new PropertyValueFactory<>("Qj"));
        reservStation6Qk.setCellValueFactory(new PropertyValueFactory<>("Qk"));
        reservStation6A.setCellValueFactory(new PropertyValueFactory<>("A"));
        reservStation6Busy.setCellValueFactory(new PropertyValueFactory<>("Busy"));

        //Cria estrutura do Reorder Buffer
        
        reorderBufferId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        reorderBufferInst.setCellValueFactory(new PropertyValueFactory<>("Inst"));
        reorderBufferType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        reorderBufferD.setCellValueFactory(new PropertyValueFactory<>("D"));
        reorderBufferV.setCellValueFactory(new PropertyValueFactory<>("V"));
        reorderBufferReady.setCellValueFactory(new PropertyValueFactory<>("Ready"));

        //Banco de Registradores

        registerFileReg.setCellValueFactory(new PropertyValueFactory<>("Reg"));
        registerFileV.setCellValueFactory(new PropertyValueFactory<>("V"));
        registerFileQi.setCellValueFactory(new PropertyValueFactory<>("Qi"));
        registerFileValid.setCellValueFactory(new PropertyValueFactory<>("Valid"));

        //Cria o Banco de Registradores

        for(int i=0; i<(listREGMaxSize/2); i++){
            listREG.add(new EntryREG(i, "F"+i, "V",  "", "Y"));
        }
        for(int i=0; i<(listREGMaxSize/2); i++){
            listREG.add(new EntryREG(i, "R"+i, "V",  "", "Y"));
        }
                
        observableListentryREG = FXCollections.observableArrayList(listREG);
        registerFile.setItems(observableListentryREG);

    }
    

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
       
    
    @FXML
    public void oneWayNumCheck(Event event){
        if (menu1WayPipeline.isSelected()){
            wayNumber = 1;
        }
    }
        
    @FXML
    public void twoWayNumCheck(Event event){
        if (menu2WayPipeline.isSelected()){
            wayNumber = 2;
        }
    }
    
    @FXML
    public void fourWayNumCheck(Event event){
        if (menu4WayPipeline.isSelected()){
            wayNumber = 4;
        }
    }

    @FXML
    public void rS2lineNumCheck(Event event){
        if (menu2LineRS.isSelected()){
            listRSMaxSize = 2;

        }
    }
    
    @FXML
    public void rS3lineNumCheck(Event event){
        if (menu3LineRS.isSelected()){
            listRSMaxSize = 3;
        }
    }
 
    @FXML
    public void secondALUCheck(Event event){
        if (menuSecondALU.isSelected()){
            secondAluISselected = true;
            labelALU2.setVisible(true);
            labelEstagioALU2.setVisible(true);
            functionalUnitCount+=1;
        }
            else {
            secondAluISselected = false;
            labelALU2.setVisible(false);
            labelEstagioALU2.setVisible(false);
            functionalUnitCount-=1;
        }
    }

    @FXML
    public void secondMEMCheck(Event event){
        if (menuSecondMEM.isSelected()){
            secondMemISselected = true;
            labelMEM2.setVisible(true);
            labelEstagioMEM2.setVisible(true);
            functionalUnitCount+=1;
        }
        else {
            secondMemISselected = false;
            labelMEM2.setVisible(false);
            labelEstagioMEM2.setVisible(false);
            functionalUnitCount-=1;
        }
    }

   @FXML
    public void secondFPCheck(Event event){
        if (menuSecondFP.isSelected()){
            secondFpISselected = true;
            labelFP2.setVisible(true);
            labelEstagioFP21.setVisible(true);
            labelEstagioFP22.setVisible(true);
            labelEstagioFP23.setVisible(true);
            functionalUnitCount+=1;
        }
        else{
            secondFpISselected = false;
            labelFP2.setVisible(false);
            labelEstagioFP21.setVisible(false);
            labelEstagioFP22.setVisible(false);
            labelEstagioFP23.setVisible(false);
            functionalUnitCount-=1;
        }
    }

    @FXML
    public void nextCommandCheckMenu(ActionEvent event){
        if (nextCommandStated != true){
            nextCommandStated = true;
            nextCommandFunc();    
            nextCommandStated = false;
        }
    }
    
    @FXML
    public void nextCommandCheckButton(ActionEvent event){
        if (nextCommandStated != true){
            nextCommandStated = true;
            nextCommandFunc();    
            nextCommandStated = false;
        }
    }

    public boolean simulationEnded()
    {
        for(int i = 0; i < listIQ.size(); i++)
            if (listIQ.get(i) != null) return false;


        for(int i = 0; i < listROB.size(); i++)
            if (listROB.get(i) != null) return false;

        return currentCycle > 0;
    }

    public void resetSimulation()
    {
        listIQcurrentPos = 0;
        listMEMcurrentPos = 0;
        currentCycle = 0;

        // Re-enable architecture configuration menu
        menuSecondALU.setDisable(false);
        menuSecondMEM.setDisable(false);
        menuSecondFP.setDisable(false);
        menu2LineRS.setDisable(false);
        menu3LineRS.setDisable(false);
        menu1WayPipeline.setDisable(false);
        menu2WayPipeline.setDisable(false);
        menu4WayPipeline.setDisable(false);
    }
    
    public void nextCommandFunc(){

        if (!listMEM.isEmpty()){
            // Inibe selecoes
            menuSecondALU.setDisable(true);
            menuSecondMEM.setDisable(true);
            menuSecondFP.setDisable(true);
            menu2LineRS.setDisable(true);
            menu3LineRS.setDisable(true);
            menu1WayPipeline.setDisable(true);
            menu2WayPipeline.setDisable(true);
            menu4WayPipeline.setDisable(true);

            // Checa se a simulação terminou
            if (!simulationEnded())
            {
                currentCycle++;
                
                //Etapas Executadas na Primeira Metade do Ciclo (Rizing Edge)

                if(currentCycle >= 5) commitStage();
                if(currentCycle >= 4) executeStage();
                if(currentCycle >= 2) decodeStage();

                fetchStage();

                //Etapas Executadas na Segunda Metade do Ciclo (Falling Edge)

                if(currentCycle >= 3) issueStage();
                if(currentCycle >= 2) decodeDispatchStage();

                fetchIQStage();
            }
            else
            {
                resetSimulation();
            }

            labelCycles.setText("Cycles: " + currentCycle);

        }
    }
    
    @FXML
    public void menuExit(ActionEvent event) {
        System.exit(0);
    }

    void animationUpdade(){
            
        observableListentryMEM = FXCollections.observableArrayList(listMEM);
        instructionMemory.setItems(observableListentryMEM);
        instructionMemory.refresh();

        observableListentryIQ = FXCollections.observableArrayList(listIQ);
        instructionQueue.setItems(observableListentryIQ);
        instructionQueue.refresh();

        observableListentryREG = FXCollections.observableArrayList(listREG);
        registerFile.setItems(observableListentryREG);
        registerFile.refresh();

        observableListentryRS1 = FXCollections.observableArrayList(listRS1ALU);
        reservStation1.setItems(observableListentryRS1);
        reservStation1.refresh();

        observableListentryRS2 = FXCollections.observableArrayList(listRS2ALU);
        reservStation2.setItems(observableListentryRS2);
        reservStation2.refresh();

        observableListentryRS3 = FXCollections.observableArrayList(listRS1FP);
        reservStation3.setItems(observableListentryRS3);
        reservStation3.refresh();

        observableListentryRS4 = FXCollections.observableArrayList(listRS2FP);
        reservStation4.setItems(observableListentryRS4);
        reservStation4.refresh();

        observableListentryRS5 = FXCollections.observableArrayList(listRS1MEM);
        reservStation5.setItems(observableListentryRS5);
        reservStation5.refresh();

        observableListentryRS6 = FXCollections.observableArrayList(listRS2MEM);
        reservStation6.setItems(observableListentryRS6);
        reservStation6.refresh();

        observableListentryROB = FXCollections.observableArrayList(listROB);
        reorderBuffer.setItems(observableListentryROB);
        reorderBuffer.refresh();

        labelCycles.setText("Cycles: " + currentCycle);

    }

    
    
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

    

    @FXML
    private void menuFileOpenButtonAction(ActionEvent event){

        int contInstrucoes = 0;

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {

            String linhaPrograma;
            
            try{

                File fin = new File(selectedFile.getAbsolutePath());
                FileReader fr = new FileReader(fin);
                BufferedReader br = new BufferedReader(fr);
                listMEM.clear();
                
                // enquanto não for fim de arquivo le 
                while(br.ready()){
                    // le a linha
                    linhaPrograma = br.readLine();
                    // numera a instrução
                    contInstrucoes ++;

                    // adiciona para a lista
                    listMEM.add(new EntryMEM(contInstrucoes ,linhaPrograma));
                    
                }

                br.close();

                resetSimulation();
                animationUpdade();

            }catch(IOException ioe){
                ioe.printStackTrace();
            }
            
            // menuOpenFile.setDisable(true);
        }
        else {
            System.out.println("Nenhum arquivo foi selecionado");
        }
        
    }

    void fetchStage(){
          
        if (listMEMcurrentPos < listMEM.size()) {
            
            int currentPos = listMEMcurrentPos;

            for (int way=0; way< wayNumber; way++) {

                String op;
                String Rd="";
                String Rs="";
                String Rt;
                String imed="0";

                // o metodo split separa a string em uma linha cada vez que aparace a condicao desejada
                String[] valorComSplit = listMEM.get(currentPos).getProgLine().split(" ");

                op=valorComSplit[0];

                if(op.equals("ADD") || op.equals("ADD.D") || op.equals("SUB") || op.equals("SUB.D") 
                        || op.equals("MUL.D") || op.equals("DIV.D")) {

                    String[] reg = valorComSplit[1].split(",");

                    Rd=reg[0];
                    Rs=reg[1];
                    Rt=reg[2];


                    if(op.equals("ADD") || op.equals("SUB")) {
                            if(Rd.charAt(0)=='F'||Rs.charAt(0)=='F'||Rt.charAt(0)=='F') {
                                    if (verbose == true) System.out.println("Registrador invalido");	
                                    System.exit(0);
                            }
                    }

                    if(op.equals("ADD.D") || op.equals("SUB.D")) {
                            if(Rd.charAt(0)=='R'||Rs.charAt(0)=='R'||Rt.charAt(0)=='R') {
                                    if (verbose == true) System.out.println("Registrador invalido");	
                                    System.exit(0);
                            }
                    }

                }

                else if(op.equals("ADDi") || op.equals("SUBi")) {

                    String[] reg = valorComSplit[1].split(",");

                    Rs=reg[0];
                    Rt=reg[1];
                    imed=reg[2];

                            if(Rt.charAt(0)=='F'||Rs.charAt(0)=='F'||!imed.matches("^[0-9]*$")) {
                                    if (verbose == true) System.out.println("Registrador invalido");	
                                    System.exit(0);
                            }

                }

                else if(op.equals("BNE") || op.equals("BNQ")) {

                    String[] reg = valorComSplit[1].split(",");

                    Rs=reg[0];
                    Rt=reg[1];
                    imed=reg[2];

                            if(Rs.charAt(0)=='F'||Rt.charAt(0)=='F'||!imed.matches("^[0-9]*$")) {
                                    if (verbose == true) System.out.println("Registrador invalido");	
                                    System.exit(0);
                            }

                }

                else { // "LW" || "L.D" || "SW" || "S.D"

                    String[] reg = valorComSplit[1].split(",");

                    Rt=reg[0];
                    imed="";

                    for(int j=0;j<reg[1].length();j++) {
                        char c = reg[1].charAt(j);
                        if(c!='(') {
                        imed=imed+=c;
                        }
                        else{
                            for(int k=j+1;k<reg[1].length();k++) {
                                c = reg[1].charAt(k);
                                if(c!=')') {
                                    Rs=Rs+=c;
                                }
                                else {
                                    break;
                                }
                            }
                            break;
                        }
                    }


                    if(op.equals("LW") || op.equals("SW")) {
                            if(Rs.charAt(0)=='F'||Rt.charAt(0)=='F'||!imed.matches("^[0-9]*$")) {
                                    if (verbose == true) System.out.println("Registrador invalido");	
                                    System.exit(0);
                            }
                    }

                    if(op.equals("L.D") || op.equals("S.D")) {
                            if(Rs.charAt(0)=='F'||Rt.charAt(0)=='R'||!imed.matches("^[0-9]*$")) {
                                    if (verbose == true) System.out.println("Registrador invalido");	
                                    System.exit(0);
                            }
                    }

                }

                EntryIQ instruction = new EntryIQ(listMEM.get(currentPos).getInst(),op,Rd,Rs,Rt,Integer.parseInt(imed));
                listFetch.add(instruction);	

                currentPos++;
                
                if (currentPos >= listMEM.size())
                    break;
                
            }
    
        }
    
    }
    
    void fetchIQStage(){

        for (EntryIQ i : listFetch) {
            if (listIQcurrentPos < listIQMaxSize){
                listIQ.add(i);
                listIQcurrentPos++;
                listMEMcurrentPos++;
            }
            else{
                System.out.println("Fila de instruções cheia.");
                break;
            }
        }
        listFetch.clear();

        animationUpdade();

    }

    
    void decodeStage(){
        
        int currentlistRS1ALUsize = listRS1ALU.size();
        int currentlistRS2ALUsize = listRS2ALU.size();
        int currentlistRS1FPsize = listRS1FP.size();
        int currentlistRS2FPsize = listRS2FP.size();
        int currentlistRS1MEMsize = listRS1MEM.size();
        int currentlistRS2MEMsize = listRS2MEM.size();

        boolean isListRS1ALUturnLocal = isListRS1ALUturn;
        boolean isListMEM1ALUturnLocal = isListRS1MEMturn;
        boolean isListFP1ALUturnLocal = isListRS1FPturn;
        
        for (int i=0; i<functionalUnitCount; i++) {
            
            if (listIQ.isEmpty()) break;
                
            if(listROBcurrentPos < listROBMaxSize) {

                int instrDecoder = listIQ.get(0).getInst();
		String opDecoder = listIQ.get(0).getOp();
		String rdDecoder = listIQ.get(0).getRd();
		String rsDecoder = listIQ.get(0).getRs();
		String rtDecoder = listIQ.get(0).getRt();
		int imDecoder = listIQ.get(0).getIm();
                String type;

                if(opDecoder.equals("ADD") || opDecoder.equals("ADDi") || opDecoder.equals("SUB") || opDecoder.equals("SUBi")) {
                    type="ALU";
                    if (isListRS1ALUturnLocal == true && currentlistRS1ALUsize < listRSMaxSize){
                        currentlistRS1ALUsize++;
                        isListRS1ALUturnLocal = false;
                    }
                    else if (currentlistRS2ALUsize < listRSMaxSize && secondAluISselected){
                        currentlistRS2ALUsize++;
                        isListRS1ALUturnLocal = true;
                    }
                    else {
                        if (verbose == true) System.out.println("Estação de Reserva (ALU) cheia.");
                        break;
                    }
                }
                else if(opDecoder.equals("BNE") || opDecoder.equals("BNQ")) {
                    type="BRA";
                    if (isListRS1ALUturnLocal == true && currentlistRS1ALUsize < listRSMaxSize){
                        currentlistRS1ALUsize++;
                        isListRS1ALUturnLocal = false;
                    }
                    else if (currentlistRS2ALUsize < listRSMaxSize && secondAluISselected){
                        currentlistRS2ALUsize++;
                        isListRS1ALUturnLocal = true;
                    }
                    else {
                        if (verbose == true) System.out.println("Estação de Reserva (ALU) cheia.");
                        break;
                    }
                }
                else if(opDecoder.equals("LW")|| opDecoder.equals("L.D")) {
                    type="LOAD";
                    if (isListMEM1ALUturnLocal == true && currentlistRS1MEMsize < listRSMaxSize){
                        currentlistRS1MEMsize++;
                        isListMEM1ALUturnLocal = false;
                    }
                    else if (currentlistRS2MEMsize < listRSMaxSize && secondMemISselected){
                        currentlistRS2MEMsize++;
                        isListMEM1ALUturnLocal = true;
                    }
                    else {
                        if (verbose == true) System.out.println("Estação de Reserva (Mémória) cheia.");
                        break;
                    }
                }
                else if(opDecoder.equals("SW")|| opDecoder.equals("S.D")) {
                    type="STORE";
                    if (isListMEM1ALUturnLocal == true && currentlistRS1MEMsize < listRSMaxSize){
                        currentlistRS1MEMsize++;
                        isListMEM1ALUturnLocal = false;
                    }
                    else if (currentlistRS2MEMsize < listRSMaxSize && secondMemISselected){
                        currentlistRS2MEMsize++;
                        isListMEM1ALUturnLocal = true;
                    }
                    else {
                        if (verbose == true) System.out.println("Estação de Reserva (Mémória) cheia.");
                        break;
                    }
                }
                else {
                    type="FP";
                    if (isListFP1ALUturnLocal == true && currentlistRS1FPsize < listRSMaxSize){
                        currentlistRS1FPsize++;
                        isListFP1ALUturnLocal = false;
                    }
                    else if (currentlistRS2FPsize < listRSMaxSize && secondFpISselected){
                        currentlistRS2FPsize++;
                        isListFP1ALUturnLocal = true;
                    }
                    else {
                        if (verbose == true) System.out.println("Estação de Reserva (Ponto Flutuante) cheia.");
                        break;
                    }

                }

                Decoder decoder = new Decoder(instrDecoder, opDecoder, rdDecoder, rsDecoder, rtDecoder, imDecoder, type);
                listDecoder.add(decoder);

                listIQ.remove(0);
                
                listIQcurrentPos--;

            }

        }
        
    }

    void decodeDispatchStage(){

        int instToBeDispatched = listDecoder.size();
        
        for (int i=0; i< instToBeDispatched; i++) {
            
            if (listROB.size()<listROBMaxSize) {
                
                String Vj = "";
                String Vk = "";
                String Qj = "";
                String Qk = "";
                int A = listDecoder.get(0).getIm();

                //Extrai o tipo de cada registrador e seu indice no Banco de Registradores         

                String RsType = listDecoder.get(0).getRs().substring(0, 1);
                int RsIndex;
                if (RsType.equals("F")){ //Indice do Registrador de Ponto Flutuante
                    RsIndex = Integer.parseInt(listDecoder.get(0).getRs().substring(1));
                }
                else{ //Indice do Registrador de Inteiro
                    RsIndex = Integer.parseInt(listDecoder.get(0).getRs().substring(1))+(listREGMaxSize/2);
                }

                String RtType = listDecoder.get(0).getRt().substring(0, 1);
                int RtIndex;
                if (RtType.equals("F")){ //Indice do Registrador de Ponto Flutuante
                    RtIndex = Integer.parseInt(listDecoder.get(0).getRt().substring(1));
                }
                else{ //Indice do Registrador de Inteiro
                    RtIndex = Integer.parseInt(listDecoder.get(0).getRt().substring(1))+(listREGMaxSize/2);
                }

                int RdIndex = 0;
                if ((!listDecoder.get(0).getOp().equals("ADDi") && !listDecoder.get(0).getOp().equals("SUBi"))
                        && ((listDecoder.get(0).getType().equals("ALU")) || listDecoder.get(0).getType().equals("FP"))){
                    String RdType = listDecoder.get(0).getRd().substring(0, 1);
                    if (RdType.equals("F")){ //Indice do Registrador de Ponto Flutuante
                        RdIndex = Integer.parseInt(listDecoder.get(0).getRd().substring(1));
                    }
                    else{ //Indice do Registrador de Inteiro
                        RdIndex = Integer.parseInt(listDecoder.get(0).getRd().substring(1))+(listREGMaxSize/2);
                    }
                }
                
                //Verifica a disponibilidade de Operandos
                
                if (listDecoder.get(0).getOp().equals("ADDi") || listDecoder.get(0).getOp().equals("SUBi")){ 
                    if (listREG.get(RtIndex).getValid().equals("Y")){
                        Vj = "Reg["+ listREG.get(RtIndex).getReg() +"]";
                        Qj = "";
                    }
                    else{
                        Vj = "";
                        Qj = listREG.get(RtIndex).getQi();
                    }
                }
                
                else if (listDecoder.get(0).getType().equals("ALU") || listDecoder.get(0).getType().equals("BRA")  
                        || listDecoder.get(0).getType().equals("FP") || listDecoder.get(0).getOp().equals("SW") 
                        || listDecoder.get(0).getOp().equals("S.D")){ 
                    if (listREG.get(RsIndex).getValid().equals("Y")){
                        Vj = "Reg["+ listREG.get(RsIndex).getReg() +"]";
                        Qj = "";
                    }
                    else{
                        Vj = "";
                        Qj = listREG.get(RsIndex).getQi();
                    }
                    if (listREG.get(RtIndex).getValid().equals("Y")){
                        Vk = "Reg["+ listREG.get(RtIndex).getReg() +"]";
                        Qk = "";
                    }
                    else{
                        Vk = "";
                        Qk = listREG.get(RtIndex).getQi();
                    }
                }
                
                else { // Instruções de 
                    if (listREG.get(RsIndex).getValid().equals("Y")){
                        Vj = "Reg["+ listREG.get(RsIndex).getReg() +"]";
                        Qj = "";
                    }
                    else{
                        Vj = "";
                        Qj = listREG.get(RsIndex).getQi();
                    }
                }
                
                
                // Despacha a instrução
                
                if(listDecoder.get(0).getOp().equals("ADDi") || listDecoder.get(0).getOp().equals("SUBi")) {

                    // Invalida o Registrador de Destino
                    
                    listREG.get(RsIndex).setValid("N");
                    
                    // Indica qual posição do ROB será escrita
                    
                    listREG.get(RsIndex).setQi("ROB."+listROBcurrentPos);
                    
                    // Inclui a instrução na Estação de Reserva
                    if (listRS1ALU.size()<listRSMaxSize && isListRS1ALUturn == true){
                        listRS1ALU.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, "", Qj, "", Integer.toString(A), "Y", listROBcurrentPos, false));
                        if (secondAluISselected) isListRS1ALUturn = false;
                    }
                     else{
                        listRS2ALU.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, "", Qj, "", Integer.toString(A), "Y", listROBcurrentPos, false));
                        isListRS1ALUturn = true;
                    }
                           
                }
                else if(listDecoder.get(0).getOp().equals("ADD") || listDecoder.get(0).getOp().equals("SUB")) {

                    // Invalida o Registrador de Destino
                    
                    listREG.get(RdIndex).setValid("N");
                    
                    // Indica qual posição do ROB será escrita
                    
                    listREG.get(RdIndex).setQi("ROB."+listROBcurrentPos);
                    
                    // Inclui a instrução na Estação de Reserva
                    if (listRS1ALU.size()<listRSMaxSize && isListRS1ALUturn == true){
                        listRS1ALU.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, "", "Y", listROBcurrentPos, false));
                        if (secondAluISselected) isListRS1ALUturn = false;
                    }
                     else{
                        listRS2ALU.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, "", "Y", listROBcurrentPos, false));
                        isListRS1ALUturn = true;
                    }
                           
                }
                else if(listDecoder.get(0).getType().equals("FP")) {

                    // Invalida o Registrador de Destino
                    
                    listREG.get(RdIndex).setValid("N");
                    
                    // Indica qual posição do ROB será escrita
                    
                    listREG.get(RdIndex).setQi("ROB."+listROBcurrentPos);
                    
                    // Inclui a instrução na Estação de Reserva
                    if (listRS1FP.size()<listRSMaxSize && isListRS1FPturn == true){
                        listRS1FP.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, "", "Y", listROBcurrentPos, false));
                        if (secondFpISselected) isListRS1FPturn = false;
                    }
                     else{
                        listRS2FP.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, "", "Y", listROBcurrentPos, false));
                        isListRS1FPturn = true;
                    }
                           
                }
                else if(listDecoder.get(0).getOp().equals("BNE") || listDecoder.get(0).getOp().equals("BNQ")) {

                    // Inclui a instrução na Estação de Reserva
                    if (listRS1ALU.size()<listRSMaxSize && isListRS1ALUturn == true){
                        listRS1ALU.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, Integer.toString(A), "Y", listROBcurrentPos, false));
                        if (secondAluISselected) isListRS1ALUturn = false;
                    }
                     else{
                        listRS2ALU.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, Integer.toString(A), "Y", listROBcurrentPos, false));
                        isListRS1ALUturn = true;
                    }
                           
                }
                else if(listDecoder.get(0).getOp().equals("LW") || listDecoder.get(0).getOp().equals("L.D")) {

                    // Invalida o Registrador de Destino
                    
                    listREG.get(RtIndex).setValid("N");
                    
                    // Indica qual posição do ROB será escrita
                    
                    listREG.get(RtIndex).setQi("ROB."+listROBcurrentPos);
                    
                    // Inclui a instrução na Estação de Reserva
                    if (listRS1MEM.size()<listRSMaxSize && isListRS1MEMturn == true){
                        listRS1MEM.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, "", Qj, "", Integer.toString(A), "Y", listROBcurrentPos, false));
                        if (secondMemISselected) isListRS1MEMturn = false;
                    }
                     else{
                        listRS2MEM.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, "", Qj, "", Integer.toString(A), "Y", listROBcurrentPos, false));
                        isListRS1MEMturn = true;
                    }
                           
                }
                else { // Instrução de Escrita em Memória

                    // Inclui a instrução na Estação de Reserva
                    if (listRS1MEM.size()<listRSMaxSize && isListRS1MEMturn == true){
                        listRS1MEM.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, Integer.toString(A), "Y", listROBcurrentPos, false));
                        if (secondMemISselected) isListRS1MEMturn = false;
                    }
                     else{
                        listRS2MEM.add(new EntryRS(listDecoder.get(0).getInst(), listDecoder.get(0).getOp(), Vj, Vk, Qj, Qk, Integer.toString(A), "Y", listROBcurrentPos, false));
                        isListRS1MEMturn = true;
                    }
                           
                }


                // Inclui instrução no ROB
                switch (listDecoder.get(0).getType()) {
                    case "BRA":
                        listROB.add(new EntryROB(listROBcurrentPos, listDecoder.get(0).getInst(), listDecoder.get(0).getType(),  Integer.toString(listDecoder.get(0).getIm()), "", "N"));
                        break;
                    case "LOAD":
                        listROB.add(new EntryROB(listROBcurrentPos, listDecoder.get(0).getInst(), listDecoder.get(0).getType(),  listDecoder.get(0).getRt(), "", "N"));
                        break;
                    case "STORE":
                        listROB.add(new EntryROB(listROBcurrentPos, listDecoder.get(0).getInst(), listDecoder.get(0).getType(),  "", "Reg["+listDecoder.get(0).getRt()+"]", "N"));
                        break;
                    default:
                        switch (listDecoder.get(0).getOp()){
                            case "ADDi":
                            case "SUBi":
                                listROB.add(new EntryROB(listROBcurrentPos, listDecoder.get(0).getInst(), listDecoder.get(0).getType(),  listDecoder.get(0).getRs(), "", "N"));
                                break;
                            default:
                                listROB.add(new EntryROB(listROBcurrentPos, listDecoder.get(0).getInst(), listDecoder.get(0).getType(),  listDecoder.get(0).getRd(), "", "N"));
                                break;
                        }
                        break;
                }


                listROBcurrentPos++;

                // Retira registro da fila

                listDecoder.remove(0);

                animationUpdade();

            }
            else {
                if (verbose == true) System.out.println("Buffer de Reordenação cheio.");
            }

        }
        
    }

    void issueStage(){
        
        int indexOldest = -1;
        boolean instAlreadySelected = false;
        
        //Emite Instrução para ALU1
        
        for(int i=0;i<listRS1ALU.size();i++) {
            if((listRS1ALU.get(i).getOp().equals("ADDi") || listRS1ALU.get(i).getOp().equals("SUBi")
                || listRS1ALU.get(i).getOp().equals("BNE") || listRS1ALU.get(i).getOp().equals("BEQ"))){
                    if(!listRS1ALU.get(i).getVj().equals("") && !listRS1ALU.get(i).isInExecution()){
                        if (instAlreadySelected){
                            if (i<=indexOldest){
                                indexOldest = i;
                            }
                        }
                        else{ 
                            indexOldest = i;
                            instAlreadySelected = true;
                        }
                    }
                }
            else{
                if(!listRS1ALU.get(i).getVj().equals("") && !listRS1ALU.get(i).getVk().equals("") && !listRS1ALU.get(i).isInExecution()){
                    if (instAlreadySelected){
                        if (i<=indexOldest){
                            indexOldest = i;
                        }
                    }
                    else{ 
                        indexOldest = i;
                        instAlreadySelected = true;
                    }
                }
            }
        }
        
        if (indexOldest!=-1){
            if(listRS1ALU.get(indexOldest).getOp().equals("ADDi") || listRS1ALU.get(indexOldest).getOp().equals("SUBi")){
                OperationUnit1ALU = new EntryOU(listRS1ALU.get(indexOldest).getInst(), listRS1ALU.get(indexOldest).getOp(), listRS1ALU.get(indexOldest).getVj(), "", listRS1ALU.get(indexOldest).getRob());
            }
            else{
                OperationUnit1ALU = new EntryOU(listRS1ALU.get(indexOldest).getInst(), listRS1ALU.get(indexOldest).getOp(), listRS1ALU.get(indexOldest).getVj(), listRS1ALU.get(indexOldest).getVk(), listRS1ALU.get(indexOldest).getRob());
            }
            valorALU1.setValue("I-"+OperationUnit1ALU.getInst());
            listRS1ALU.get(indexOldest).setInExecution(true);
        }   

        //Emite Instrução para ALU2
        
        indexOldest = -1;
        instAlreadySelected = false;

        for(int i=0;i<listRS2ALU.size();i++) {
            if((listRS2ALU.get(i).getOp().equals("ADDi") || listRS2ALU.get(i).getOp().equals("SUBi")
                || listRS2ALU.get(i).getOp().equals("BNE") || listRS2ALU.get(i).getOp().equals("BEQ"))){
                    if (!listRS2ALU.get(i).getVj().equals("") && !listRS2ALU.get(i).isInExecution()){
                        if (instAlreadySelected){
                            if (i<=indexOldest){
                                indexOldest = i;
                            }
                        }
                        else{ 
                            indexOldest = i;
                            instAlreadySelected = true;
                        }
                    }
                }
            else{
                if(!listRS2ALU.get(i).getVj().equals("") && !listRS2ALU.get(i).getVk().equals("") && !listRS2ALU.get(i).isInExecution()){
                    if (instAlreadySelected){
                        if (i<=indexOldest){
                            indexOldest = i;
                        }
                    }
                    else{ 
                        indexOldest = i;
                        instAlreadySelected = true;
                    }
                }
            }
        }
        
        if (indexOldest!=-1){
            if(listRS2ALU.get(indexOldest).getOp().equals("ADDi") || listRS2ALU.get(indexOldest).getOp().equals("SUBi")
                    || listRS2ALU.get(indexOldest).getOp().equals("BNE") || listRS2ALU.get(indexOldest).getOp().equals("BEQ")){
                OperationUnit2ALU = new EntryOU(listRS2ALU.get(indexOldest).getInst(), listRS2ALU.get(indexOldest).getOp(), listRS2ALU.get(indexOldest).getVj(), listRS2ALU.get(indexOldest).getA(), listRS2ALU.get(indexOldest).getRob());
            }
            else{
                OperationUnit2ALU = new EntryOU(listRS2ALU.get(indexOldest).getInst(), listRS2ALU.get(indexOldest).getOp(), listRS2ALU.get(indexOldest).getVj(), listRS2ALU.get(indexOldest).getVk(), listRS2ALU.get(indexOldest).getRob());
            }
            valorALU2.setValue("I-"+OperationUnit2ALU.getInst());
            listRS2ALU.get(indexOldest).setInExecution(true);
        }   
       
        //Emite Instrução para FP1
        
        indexOldest = -1;
        instAlreadySelected = false;

        for(int i=0;i<listRS1FP.size();i++) {
            if(!listRS1FP.get(i).getVj().equals("") && !listRS1FP.get(i).getVk().equals("") && !listRS1FP.get(i).isInExecution()){
                if (instAlreadySelected){
                    if (i<=indexOldest){
                        indexOldest = i;
                    }
                }
                else{ 
                    indexOldest = i;
                    instAlreadySelected = true;
                }
            }
        }
        
        if (indexOldest!=-1){
            OperationUnit1FPstage1 = new EntryOU(listRS1FP.get(indexOldest).getInst(), listRS1FP.get(indexOldest).getOp(), listRS1FP.get(indexOldest).getVj(), listRS1FP.get(indexOldest).getVk(), listRS1FP.get(indexOldest).getRob());
            valorFP11.setValue("I-"+OperationUnit1FPstage1.getInst());
            listRS1FP.get(indexOldest).setInExecution(true);
        }   

        //Emite Instrução para FP2
        
        indexOldest = -1;
        instAlreadySelected = false;

        for(int i=0;i<listRS2FP.size();i++) {
            if(!listRS2FP.get(i).getVj().equals("") && !listRS2FP.get(i).getVk().equals("") && !listRS2FP.get(i).isInExecution()){
                if (instAlreadySelected){
                    if (i<=indexOldest){
                        indexOldest = i;
                    }
                }
                else{ 
                    indexOldest = i;
                    instAlreadySelected = true;
                }
            }
        }
        
        if (indexOldest!=-1){
            OperationUnit2FPstage1 = new EntryOU(listRS2FP.get(indexOldest).getInst(), listRS2FP.get(indexOldest).getOp(), listRS2FP.get(indexOldest).getVj(), listRS2FP.get(indexOldest).getVk(), listRS2FP.get(indexOldest).getRob());
            valorFP21.setValue("I-"+OperationUnit2FPstage1.getInst());
            listRS2FP.get(indexOldest).setInExecution(true);
        }   

        //Emite Instrução para MEM1
        
        indexOldest = -1;
        instAlreadySelected = false;

        for(int i=0;i<listRS1MEM.size();i++) {
            if(listRS1MEM.get(i).getOp().equals("LW") || listRS1MEM.get(i).getOp().equals("L.D")){
                    if (!listRS1MEM.get(i).getVj().equals("") && !listRS1MEM.get(i).isInExecution()){
                        if (instAlreadySelected){
                            if (i<=indexOldest){
                                indexOldest = i;
                            }
                        }
                        else{ 
                            indexOldest = i;
                            instAlreadySelected = true;
                        }
                    }
                }
            else{
                if(!listRS1MEM.get(i).getVj().equals("") && !listRS1MEM.get(i).getVk().equals("") && !listRS1MEM.get(i).isInExecution()){
                    if (instAlreadySelected){
                        if (i<=indexOldest){
                            indexOldest = i;
                        }
                    }
                    else{ 
                        indexOldest = i;
                        instAlreadySelected = true;
                    }
                }
            }
        }
        
        if (indexOldest!=-1){
            OperationUnit1MEM = new EntryOU(listRS1MEM.get(indexOldest).getInst(), listRS1MEM.get(indexOldest).getOp(), listRS1MEM.get(indexOldest).getVj(), listRS1MEM.get(indexOldest).getA(), listRS1MEM.get(indexOldest).getRob());
            valorMEM1.setValue("I-"+OperationUnit1MEM.getInst());
            listRS1MEM.get(indexOldest).setInExecution(true);
       }   
        
        //Emite Instrução para MEM2
        
        indexOldest = -1;
        instAlreadySelected = false;

        for(int i=0;i<listRS2MEM.size();i++) {
            if(listRS2MEM.get(i).getOp().equals("LW") || listRS2MEM.get(i).getOp().equals("L.D")){
                    if (!listRS2MEM.get(i).getVj().equals("") && !listRS2MEM.get(i).isInExecution()){
                        if (instAlreadySelected){
                            if (i<=indexOldest){
                                indexOldest = i;
                            }
                        }
                        else{ 
                            indexOldest = i;
                            instAlreadySelected = true;
                        }
                    }
                }
            else{
                if(!listRS2MEM.get(i).getVj().equals("") && !listRS2MEM.get(i).getVk().equals("") && !listRS2MEM.get(i).isInExecution()){
                    if (instAlreadySelected){
                        if (i<=indexOldest){
                            indexOldest = i;
                        }
                    }
                    else{ 
                        indexOldest = i;
                        instAlreadySelected = true;
                    }
                }
            }
        }
        
        if (indexOldest!=-1){
            OperationUnit2MEM = new EntryOU(listRS2MEM.get(indexOldest).getInst(), listRS2MEM.get(indexOldest).getOp(), listRS2MEM.get(indexOldest).getVj(), listRS2MEM.get(indexOldest).getA(), listRS2MEM.get(indexOldest).getRob());
            valorMEM2.setValue("I-"+OperationUnit2MEM.getInst());
            listRS2MEM.get(indexOldest).setInExecution(true);
        }   

        animationUpdade();
    }

    void executeStage(){
        
        //Executa ALU1 e Escrever o Resultado
        
        if (OperationUnit1ALU.getInst()!=0){
            
            listROB.get(OperationUnit1ALU.getRobIndex()).setV("Result"); 

            Predicate<EntryRS> removePredicate = p-> p.getInst() == OperationUnit1ALU.getInst();
            listRS1ALU.removeIf(removePredicate);

            if (hazardExists(OperationUnit1ALU.getRobIndex()))
                listROB.get(OperationUnit1ALU.getRobIndex()).setReady("N");
            else
                listROB.get(OperationUnit1ALU.getRobIndex()).setReady("Y");

            valorALU1.setValue("");
            OperationUnit1ALU = new EntryOU(0, "", "", "", 0);

        }
    
        //Executa ALU2 e Escrever o Resultado
        
        if (OperationUnit2ALU.getInst()!=0){
            
            listROB.get(OperationUnit2ALU.getRobIndex()).setV("Result");  

            Predicate<EntryRS> removePredicate = p-> p.getInst() == OperationUnit2ALU.getInst();
            listRS2ALU.removeIf(removePredicate);

            if (hazardExists(OperationUnit2ALU.getRobIndex()))
                listROB.get(OperationUnit2ALU.getRobIndex()).setReady("N");
            else
                listROB.get(OperationUnit2ALU.getRobIndex()).setReady("Y");

            valorALU2.setValue("");
            OperationUnit2ALU = new EntryOU(0, "", "", "", 0);

        }
    
        //Avança Pipeline FP1 e Escrever o Resultado do Último Estágio
        
        if (OperationUnit1FPstage3.getInst()!=0){
            
            listROB.get(OperationUnit1FPstage3.getRobIndex()).setV("Result");
            
            Predicate<EntryRS> removePredicate = p-> p.getInst() == OperationUnit1FPstage3.getInst();
            listRS1FP.removeIf(removePredicate);

            if (hazardExists(OperationUnit1FPstage3.getRobIndex()))
                listROB.get(OperationUnit1FPstage3.getRobIndex()).setReady("N");
            else
                listROB.get(OperationUnit1FPstage3.getRobIndex()).setReady("Y");

        }

        OperationUnit1FPstage3 = new EntryOU(OperationUnit1FPstage2.getInst(), OperationUnit1FPstage2.getOp(), 
                OperationUnit1FPstage2.getOperand1(), OperationUnit1FPstage2.getOperand2(), OperationUnit1FPstage2.getRobIndex());
        OperationUnit1FPstage2 = new EntryOU(OperationUnit1FPstage1.getInst(), OperationUnit1FPstage1.getOp(), 
                OperationUnit1FPstage1.getOperand1(), OperationUnit1FPstage1.getOperand2(), OperationUnit1FPstage1.getRobIndex());
        OperationUnit1FPstage1 = new EntryOU(0, "", "", "", 0);
        
        if (OperationUnit1FPstage1.getInst()==0) // Se Inst igual a zero, não há instrução na etapa
            valorFP11.setValue("");
    
        if (OperationUnit1FPstage2.getInst()!=0) // Senão, há instrução na etapa
            valorFP12.setValue("I-"+OperationUnit1FPstage2.getInst());
        else
            valorFP12.setValue("");
        
        if (OperationUnit1FPstage3.getInst()!=0)
            valorFP13.setValue("I-"+OperationUnit1FPstage3.getInst());
        else
            valorFP13.setValue("");
        
        //Avança Pipeline FP2 e Escrever o Resultado do Último Estágio
        
        if (OperationUnit2FPstage3.getInst()!=0){
            
            listROB.get(OperationUnit2FPstage3.getRobIndex()).setV("Result"); 
            
            Predicate<EntryRS> removePredicate = p-> p.getInst() == OperationUnit2FPstage3.getInst();
            listRS2FP.removeIf(removePredicate);

            if (hazardExists(OperationUnit2FPstage3.getRobIndex()))
                listROB.get(OperationUnit2FPstage3.getRobIndex()).setReady("N");
            else
                listROB.get(OperationUnit2FPstage3.getRobIndex()).setReady("Y");

        }

        OperationUnit2FPstage3 = new EntryOU(OperationUnit2FPstage2.getInst(), OperationUnit2FPstage2.getOp(), 
                OperationUnit2FPstage2.getOperand1(), OperationUnit2FPstage2.getOperand2(), OperationUnit2FPstage2.getRobIndex());
        OperationUnit2FPstage2 = new EntryOU(OperationUnit2FPstage1.getInst(), OperationUnit2FPstage1.getOp(), 
                OperationUnit2FPstage1.getOperand1(), OperationUnit2FPstage1.getOperand2(), OperationUnit2FPstage1.getRobIndex());
        OperationUnit2FPstage1 = new EntryOU(0, "", "", "", 0);
        
        if (OperationUnit2FPstage1.getInst()==0)
            valorFP21.setValue("");

        if (OperationUnit2FPstage2.getInst()!=0)
            valorFP22.setValue("I-"+OperationUnit2FPstage2.getInst());
        else
            valorFP22.setValue("");
        
        if (OperationUnit2FPstage3.getInst()!=0)
            valorFP23.setValue("I-"+OperationUnit2FPstage3.getInst());
        else
            valorFP23.setValue("");
        
        //Executa MEM1 e Escrever o Resultado
        
        if (OperationUnit1MEM.getInst()!=0){
            if ((OperationUnit1MEM.getOp().equals("S.D") || OperationUnit1MEM.getOp().equals("SW")) && OperationUnit1MEM.getInst()!=0){
                listROB.get(OperationUnit1MEM.getRobIndex()).setD(OperationUnit1MEM.getOperand1()+" + "+OperationUnit1MEM.getOperand2());
            }
            else{
                listROB.get(OperationUnit1MEM.getRobIndex()).setV(OperationUnit1MEM.getOperand1()+" + "+OperationUnit1MEM.getOperand2());
            }
            
            if ((OperationUnit1MEM.getOp().equals("SW") || OperationUnit1MEM.getOp().equals("S.D")) 
                    && !hazardExists(OperationUnit1MEM.getRobIndex()))
                listROB.get(OperationUnit1MEM.getRobIndex()).setReady("Y");

            Predicate<EntryRS> removePredicate = p-> p.getInst() == OperationUnit1MEM.getInst();
            listRS1MEM.removeIf(removePredicate);

            valorMEM1.setValue("");
            OperationUnit1MEM = new EntryOU(0, "", "", "", 0);
        }
    
        //Executa MEM2 e Escrever o Resultado
        
        if (OperationUnit2MEM.getInst()!=0){
            if ((OperationUnit2MEM.getOp().equals("S.D") || OperationUnit2MEM.getOp().equals("SW")) && OperationUnit2MEM.getInst()!=0){
                listROB.get(OperationUnit2MEM.getRobIndex()).setD(OperationUnit2MEM.getOperand1()+" + "+OperationUnit2MEM.getOperand2());
            }
            else{
                listROB.get(OperationUnit2MEM.getRobIndex()).setV(OperationUnit2MEM.getOperand1()+" + "+OperationUnit2MEM.getOperand2());
            }

            if ((OperationUnit2MEM.getOp().equals("SW") || OperationUnit2MEM.getOp().equals("S.D")) 
                    && !hazardExists(OperationUnit2MEM.getRobIndex()))
               listROB.get(OperationUnit2MEM.getRobIndex()).setReady("Y");

            Predicate<EntryRS> removePredicate = p-> p.getInst() == OperationUnit2MEM.getInst();
            listRS2MEM.removeIf(removePredicate);

            valorMEM2.setValue("");
            OperationUnit2MEM = new EntryOU(0, "", "", "", 0);
        }
        
        animationUpdade();

    }
    
    boolean hazardExists (int currentROBitem) {
        
        boolean wawHazardExists = false;
        boolean rawHazardExists = false;
        boolean warHazardExists = false;

        for (int previousROBitem=0; previousROBitem < currentROBitem; previousROBitem++) {

            // Verifica Hazard do tipo WAW
            if (!listROB.get(currentROBitem).getType().equals("BRA") 
                    && listROB.get(currentROBitem).getD().equals(listROB.get(previousROBitem).getD())){
                wawHazardExists = true;
                break;
            }

            // Verifica Hazerd RAW (Caso do LOAD depois de STORE)
            if (listROB.get(previousROBitem).getType().equals("STORE") && listROB.get(currentROBitem).getType().equals("LOAD")){
                if (listROB.get(currentROBitem).getV().equals(listROB.get(previousROBitem).getD())){
                    rawHazardExists = true;
                    break;
                }

            }

            // Verifica Hazerd WAR (Caso do STORE depois de LOAD)
            if (listROB.get(previousROBitem).getType().equals("LOAD") && listROB.get(currentROBitem).getType().equals("STORE")){
                if (listROB.get(currentROBitem).getD().equals(listROB.get(previousROBitem).getV())){
                    warHazardExists = true;
                    break;
                }

            }

        } 
        
        return wawHazardExists || warHazardExists  || rawHazardExists;
        
    }

    void commitStage(){
        
        int currentWay = 1;
        int currentROBitem = 0;
        
        while (currentROBitem < listROB.size()) {
            
            if (currentWay > wayNumber)
                break;

            if (listROB.get(currentROBitem).getReady().equals("Y")){

                switch (listROB.get(currentROBitem).getType()) {
                    case "ALU":
                    case "FP":
                    case "LOAD":
                        String robDestRegType = listROB.get(currentROBitem).getD().substring(0,1);
                        int robDestIndex = Integer.parseInt(listROB.get(currentROBitem).getD().substring(1));
                        if (robDestRegType.equals("R"))
                            robDestIndex+=(listREGMaxSize/2);

                        if (currentROBitem == Integer.parseInt(listREG.get(robDestIndex).getQi().substring(4))){
                            listREG.get(robDestIndex).setQi("");
                            listREG.get(robDestIndex).setValid("Y");
                        }
                        reservStationWriteBack(currentROBitem, listROB.get(currentROBitem).getD());
                        listROB.remove(currentROBitem);
                        recalcROBrenaming(currentROBitem);
                        break;
                    case "BRA":
                    case "STORE":
                        listROB.remove(currentROBitem);
                        recalcROBrenaming(currentROBitem);
                        break;
                }

                listROBcurrentPos--;
                currentWay++;

            }
            else {
                currentROBitem++;
            }

        }

        //Ler buffer de leitura

        for (EntryROB entry: listROB) {
        
            if (entry.getType().equals("LOAD") && !entry.getV().equals("")){ 
                entry.setV("Value");
                entry.setReady("Y");
            }
            
        }
        
        // Recalcula as Dependências
        
        for (currentROBitem=0; currentROBitem < listROB.size(); currentROBitem++){
            
            switch (listROB.get(currentROBitem).getType()){
                case "STORE": 
                    if (!listROB.get(currentROBitem).getD().equals("") && !hazardExists (currentROBitem))
                        listROB.get(currentROBitem).setReady("Y");
                    else 
                        listROB.get(currentROBitem).setReady("N");
                    break;
                case "LOAD": 
                    if (listROB.get(currentROBitem).getV().equals("Value") && !hazardExists (currentROBitem))
                        listROB.get(currentROBitem).setReady("Y");
                    else 
                        listROB.get(currentROBitem).setReady("N");
                    break;
                default:
                    if (listROB.get(currentROBitem).getV().equals("Result") && !hazardExists (currentROBitem))
                        listROB.get(currentROBitem).setReady("Y");
                    else 
                        listROB.get(currentROBitem).setReady("N");
                    break;
                    
            }
        }
 
        animationUpdade();

    }
    
    void reservStationWriteBack(int currentROBitem, String dest){
        
        for (EntryRS entry: listRS1ALU) {
            if (entry.getQj().equals("ROB."+currentROBitem)){
                entry.setVj("Reg["+dest+"]");
                entry.setQj("");
            }
            if (entry.getQk().equals("ROB."+currentROBitem)){
                entry.setVk("Reg["+dest+"]");
                entry.setQk("");
            }
        }

        for (EntryRS entry: listRS2ALU) {
            if (entry.getQj().equals("ROB."+currentROBitem)){
                entry.setVj("Reg["+dest+"]");
                entry.setQj("");
            }
            if (entry.getQk().equals("ROB."+currentROBitem)){
                entry.setVk("Reg["+dest+"]");
                entry.setQk("");
            }
        }

        for (EntryRS entry: listRS1FP) {
            if (entry.getQj().equals("ROB."+currentROBitem)){
                entry.setVj("Reg["+dest+"]");
                entry.setQj("");
            }
            if (entry.getQk().equals("ROB."+currentROBitem)){
                entry.setVk("Reg["+dest+"]");
                entry.setQk("");
            }
        }

        for (EntryRS entry: listRS2FP) {
            if (entry.getQj().equals("ROB."+currentROBitem)){
                entry.setVj("Reg["+dest+"]");
                entry.setQj("");
            }
            if (entry.getQk().equals("ROB."+currentROBitem)){
                entry.setVk("Reg["+dest+"]");
                entry.setQk("");
            }
        }

        for (EntryRS entry: listRS1MEM) {
            if (entry.getQj().equals("ROB."+currentROBitem)){
                entry.setVj("Reg["+dest+"]");
                entry.setQj("");
            }
            if (entry.getQk().equals("ROB."+currentROBitem)){
                entry.setVk("Reg["+dest+"]");
                entry.setQk("");
            }
        }

        for (EntryRS entry: listRS2MEM) {
            if (entry.getQj().equals("ROB."+currentROBitem)){
                entry.setVj("Reg["+dest+"]");
                entry.setQj("");
            }
            if (entry.getQk().equals("ROB."+currentROBitem)){
                entry.setVk("Reg["+dest+"]");
                entry.setQk("");
            }
        }
    
    }
    
    void recalcROBrenaming(int robExcludedIndex){
        
        if (!listROB.isEmpty()){
        
            for (EntryRS entry: listRS1ALU) {
                if (!entry.getQj().equals("") && Integer.parseInt(entry.getQj().substring(4))>robExcludedIndex)
                    entry.setQj("ROB."+Integer.toString(Integer.parseInt(entry.getQj().substring(4))-1));

                if (!entry.getQk().equals("") && Integer.parseInt(entry.getQk().substring(4))>robExcludedIndex)
                    entry.setQk("ROB."+Integer.toString(Integer.parseInt(entry.getQk().substring(4))-1));

                if (entry.getRob()>robExcludedIndex)
                    entry.setRob(entry.getRob()-1);
            }

            for (EntryRS entry: listRS2ALU) {
                if (!entry.getQj().equals("") && Integer.parseInt(entry.getQj().substring(4))>robExcludedIndex)
                    entry.setQj("ROB."+Integer.toString(Integer.parseInt(entry.getQj().substring(4))-1));

                if (!entry.getQk().equals("") && Integer.parseInt(entry.getQk().substring(4))>robExcludedIndex)
                    entry.setQk("ROB."+Integer.toString(Integer.parseInt(entry.getQk().substring(4))-1));

                if (entry.getRob()>robExcludedIndex)
                    entry.setRob(entry.getRob()-1);
            }

            for (EntryRS entry: listRS1FP) {
                if (!entry.getQj().equals("") && Integer.parseInt(entry.getQj().substring(4))>robExcludedIndex)
                    entry.setQj("ROB."+Integer.toString(Integer.parseInt(entry.getQj().substring(4))-1));

                if (!entry.getQk().equals("") && Integer.parseInt(entry.getQk().substring(4))>robExcludedIndex)
                    entry.setQk("ROB."+Integer.toString(Integer.parseInt(entry.getQk().substring(4))-1));

                if (entry.getRob()>robExcludedIndex)
                    entry.setRob(entry.getRob()-1);
            }

            for (EntryRS entry: listRS2FP) {
                if (!entry.getQj().equals("") && Integer.parseInt(entry.getQj().substring(4))>robExcludedIndex)
                    entry.setQj("ROB."+Integer.toString(Integer.parseInt(entry.getQj().substring(4))-1));

                if (!entry.getQk().equals("") && Integer.parseInt(entry.getQk().substring(4))>robExcludedIndex)
                    entry.setQk("ROB."+Integer.toString(Integer.parseInt(entry.getQk().substring(4))-1));

                if (entry.getRob()>robExcludedIndex)
                    entry.setRob(entry.getRob()-1);
            }

            for (EntryRS entry: listRS1MEM) {
                if (!entry.getQj().equals("") && Integer.parseInt(entry.getQj().substring(4))>robExcludedIndex){
                    entry.setQj("ROB."+Integer.toString(Integer.parseInt(entry.getQj().substring(4))-1));
                }
                if (!entry.getQk().equals("") && Integer.parseInt(entry.getQk().substring(4))>robExcludedIndex){
                    entry.setQk("ROB."+Integer.toString(Integer.parseInt(entry.getQk().substring(4))-1));
                }            
                if (entry.getRob()>robExcludedIndex){
                    entry.setRob(entry.getRob()-1);
                }
            }

            for (EntryRS entry: listRS2MEM) {
                if (!entry.getQj().equals("") && Integer.parseInt(entry.getQj().substring(4))>robExcludedIndex)
                    entry.setQj("ROB."+Integer.toString(Integer.parseInt(entry.getQj().substring(4))-1));

                if (!entry.getQk().equals("") && Integer.parseInt(entry.getQk().substring(4))>robExcludedIndex)
                    entry.setQk("ROB."+Integer.toString(Integer.parseInt(entry.getQk().substring(4))-1));

                if (entry.getRob()>robExcludedIndex)
                    entry.setRob(entry.getRob()-1);
            }

            if (OperationUnit1ALU.getRobIndex()>robExcludedIndex && OperationUnit1ALU.getInst()!=0)
                    OperationUnit1ALU.setRobIndex(OperationUnit1ALU.getRobIndex()-1);

            if (OperationUnit2ALU.getRobIndex()>robExcludedIndex && OperationUnit2ALU.getInst()!=0)
                    OperationUnit2ALU.setRobIndex(OperationUnit2ALU.getRobIndex()-1);

            if (OperationUnit1FPstage1.getRobIndex()>robExcludedIndex && OperationUnit1FPstage1.getInst()!=0)
                    OperationUnit1FPstage1.setRobIndex(OperationUnit1FPstage1.getRobIndex()-1);

            if (OperationUnit1FPstage2.getRobIndex()>robExcludedIndex && OperationUnit1FPstage2.getInst()!=0)
                    OperationUnit1FPstage2.setRobIndex(OperationUnit1FPstage2.getRobIndex()-1);

            if (OperationUnit1FPstage3.getRobIndex()>robExcludedIndex && OperationUnit1FPstage3.getInst()!=0)
                    OperationUnit1FPstage3.setRobIndex(OperationUnit1FPstage3.getRobIndex()-1);

            if (OperationUnit2FPstage1.getRobIndex()>robExcludedIndex && OperationUnit2FPstage1.getInst()!=0)
                    OperationUnit2FPstage1.setRobIndex(OperationUnit2FPstage1.getRobIndex()-1);

            if (OperationUnit2FPstage2.getRobIndex()>robExcludedIndex && OperationUnit2FPstage2.getInst()!=0)
                    OperationUnit2FPstage2.setRobIndex(OperationUnit2FPstage2.getRobIndex()-1);

            if (OperationUnit2FPstage3.getRobIndex()>robExcludedIndex && OperationUnit2FPstage3.getInst()!=0)
                    OperationUnit2FPstage3.setRobIndex(OperationUnit2FPstage3.getRobIndex()-1);

            if (OperationUnit1MEM.getRobIndex()>robExcludedIndex && OperationUnit1MEM.getInst()!=0)
                    OperationUnit1MEM.setRobIndex(OperationUnit1MEM.getRobIndex()-1);

            if (OperationUnit2MEM.getRobIndex()>robExcludedIndex && OperationUnit2MEM.getInst()!=0)
                    OperationUnit2MEM.setRobIndex(OperationUnit2MEM.getRobIndex()-1);

            for (EntryREG entry: listREG) {
                if (entry.getValid().equals("N") && Integer.parseInt(entry.getQi().substring(4))>robExcludedIndex)
                    entry.setQi("ROB."+Integer.toString(Integer.parseInt(entry.getQi().substring(4))-1));
            }

            // Refaz a indicação de índices
            for (int i=0; i<listROB.size(); i++)
                listROB.get(i).setId(i);

            animationUpdade();
        }

        
    }

    
}
