package controller;

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
import view.MainScreen;
import view.QuestionDialog;

public class MainController {
    
    private static final String SQS_URL_INVITES = "https://sqs.us-east-2.amazonaws.com/606600291685/tictactoeinvites";
    private static final String SQS_URL_ACCEPT_INVITATIONS = "https://sqs.us-east-2.amazonaws.com/606600291685/tictactoeacceptinvitations";
    private final ExecutorService executor1 = Executors.newSingleThreadExecutor();
    private final ExecutorService executor2 = Executors.newSingleThreadExecutor();
    private final ExecutorService executor3 = Executors.newSingleThreadExecutor();
    private final MainScreen mainContext;
    
    public MainController(MainScreen mainContext) {
        this.mainContext = mainContext;
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
        executor1.submit(() -> {
            while (true) {
                try {
                    mainContext.fillTablePlayers();
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println("Erro 1 MainController.java " + e);
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
        
        executor2.submit(() -> {
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
                    } catch (Exception e) {
                        System.out.println("Erro 2 MainController.java " + e);
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e) {
                        System.out.println("Erro 3 MainController.java " + e);
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
        
        executor3.submit(() -> {
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
                    } catch (Exception e) {
                        System.out.println("Erro 4 MainController.java " + e);
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e) {
                        System.out.println("Erro 5 MainController.java " + e);
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
    
    public void startGame(){
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
}
