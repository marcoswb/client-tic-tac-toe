package controller;

import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.MainScreen;
import view.QuestionDialog;

public class MainController {
    
    private static final String SQS_URL_INVITES = "https://sqs.us-east-2.amazonaws.com/606600291685/tictactoeinvites";
    private static final String SQS_URL_ACCEPT_INVITATIONS = "https://sqs.us-east-2.amazonaws.com/606600291685/tictactoeacceptinvitations";
    private final ExecutorService executorActivePlayers = Executors.newSingleThreadExecutor();
    private final ExecutorService executorCheckInvitation = Executors.newSingleThreadExecutor();
    private final ExecutorService executorAcceptedInvites = Executors.newSingleThreadExecutor();
    private final MainScreen mainContext;
    private static final Logger LOGGER = LogManager.getLogger();
    
    public MainController(MainScreen mainContext) {
        this.mainContext = mainContext;
        System.setProperty(SDKGlobalConfiguration.DISABLE_CERT_CHECKING_SYSTEM_PROPERTY, "true");
    }
    
    public void invitePlayer(String challenger, String challenged){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.defaultClient();
        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        messageAttributes.put("challenger", new MessageAttributeValue().withStringValue(challenger).withDataType("String"));
        messageAttributes.put("challenged", new MessageAttributeValue().withStringValue(challenged).withDataType("String"));

        SendMessageRequest sendRequest = new SendMessageRequest()
                .withQueueUrl(SQS_URL_INVITES)
                .withMessageBody(challenger)
                .withMessageAttributes(messageAttributes);
        sqsClient.sendMessage(sendRequest);
    }
    
    public void checking() {
        checkingActivePlayers();
        checkingInvitation();
        checkingAcceptedInvites();
    }
    
    private void checkingActivePlayers(){
        executorActivePlayers.submit(() -> {
            while (true) {
                try {
                    mainContext.fillTablePlayers();
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    LOGGER.error("Erro na função checkingActivePlayers `{}`", ex.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }
    
    private void checkingInvitation(){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.defaultClient();

        ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest()
                .withQueueUrl(SQS_URL_INVITES)
                .withMessageAttributeNames("All")
                .withMaxNumberOfMessages(10);
        
        executorCheckInvitation.submit(() -> {
            while (true) {
                if (mainContext.isStartCheck()) {
                    try {
                        for (Message message : sqsClient.receiveMessage(receiveRequest).getMessages()) {

                            Map<String, MessageAttributeValue> messageAttributes = message.getMessageAttributes();
                            String challenger = messageAttributes.get("challenger").getStringValue();
                            String challenged = messageAttributes.get("challenged").getStringValue();

                            if(mainContext.getNickname().equals(challenged)){
                                QuestionDialog question = new QuestionDialog();
                                int response = question.SetMessage("O usuário " + challenger + " enviou um convite para uma partida!");
                                
                                if(response == JOptionPane.YES_OPTION){
                                    acceptInvite(challenger, challenged);
                                }
                                
                                sqsClient.deleteMessage(SQS_URL_INVITES, message.getReceiptHandle());
                            }
                        }
                        
                        Thread.sleep(2000);
                    } catch (Exception ex) {
                        LOGGER.error("Erro na função checkingInvitation 1 `{}`", ex.getMessage());
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    try {
                        Thread.sleep(5000);
                    }catch (Exception ex) {
                        LOGGER.error("Erro na função checkingInvitation 2 `{}`", ex.getMessage());
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });
    }
    
    private void checkingAcceptedInvites(){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.defaultClient();

        ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest()
                .withQueueUrl(SQS_URL_ACCEPT_INVITATIONS)
                .withMessageAttributeNames("All")
                .withMaxNumberOfMessages(10);
        
        executorAcceptedInvites.submit(() -> {
            while (true) {
                if (mainContext.isStartCheck()) {
                    try {
                        for (Message message : sqsClient.receiveMessage(receiveRequest).getMessages()) {

                            Map<String, MessageAttributeValue> messageAttributes = message.getMessageAttributes();
                            String challenger = messageAttributes.get("challenger").getStringValue();
                            String challenged = messageAttributes.get("challenged").getStringValue();
                            
                            if(mainContext.getNickname().equals(challenger)){
                                sqsClient.deleteMessage(SQS_URL_ACCEPT_INVITATIONS, message.getReceiptHandle());
                                startGame(challenged);
                            }
                        }
                        
                        Thread.sleep(2000);
                    } catch (Exception ex) {
                        LOGGER.error("Erro na função checkingAcceptedInvites 1 `{}`", ex.getMessage());
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    try {
                        Thread.sleep(5000);
                    }catch (Exception ex) {
                        LOGGER.error("Erro na função checkingAcceptedInvites 2 `{}`", ex.getMessage());
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });
    }
    
    private void acceptInvite(String challenger, String challenged){
        sendAcceptInvitation(challenger, challenged);
        startGame(challenger);
    }
    
    private void sendAcceptInvitation(String challenger, String challenged){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.defaultClient();
        
        Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
        messageAttributes.put("challenger", new MessageAttributeValue().withStringValue(challenger).withDataType("String"));
        messageAttributes.put("challenged", new MessageAttributeValue().withStringValue(challenged).withDataType("String"));

        SendMessageRequest sendRequest = new SendMessageRequest()
                .withQueueUrl(SQS_URL_ACCEPT_INVITATIONS)
                .withMessageBody(challenger)
                .withMessageAttributes(messageAttributes);
        sqsClient.sendMessage(sendRequest);
    }
    
    public void startRandomGame(){
        PrepareGame board = new PrepareGame(mainContext);
        board.setNickname(mainContext.getNickname());
        board.startGame();
        mainContext.setStartCheck(false);
    }
    
    public void startGame(String opponent){
        PrepareGame board = new PrepareGame(mainContext);
        board.setNickname(mainContext.getNickname());
        board.startGame(opponent);
        mainContext.setStartCheck(false);
    }
    
    public void startGameComputer(String level){
        PrepareGame board = new PrepareGame(mainContext);
        board.setNickname(mainContext.getNickname());
        board.startGameComputer(level);
        mainContext.setStartCheck(false);
    }
}
