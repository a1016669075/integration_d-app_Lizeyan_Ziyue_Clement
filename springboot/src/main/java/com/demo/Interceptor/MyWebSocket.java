package com.demo.Interceptor;

        
import org.springframework.stereotype.Component;
  
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
  
/**
 * @Component  Injecter la classe dans le conteneur
 * @ServerEndpoint  Le frontal accède à la communication via cette URL et établit une connexion
 */
@ServerEndpoint("/websocket")
@Component
public class MyWebSocket {
  
    //Une collection non ordonnée thread-safe pour stocker les websockets
    private  static  CopyOnWriteArraySet<MyWebSocket> websocket = new CopyOnWriteArraySet<MyWebSocket>();
  
    private Session session;
  
    public static CopyOnWriteArraySet<MyWebSocket> getWebsocket() {
        return websocket;
    }
  
    public static void setWebsocket(CopyOnWriteArraySet<MyWebSocket> websocket) {
        MyWebSocket.websocket = websocket;
    }
  
    public Session getSession() {
        return session;
    }
  
    public void setSession(Session session) {
        this.session = session;
    }
  
    /**
     * La méthode appelée lorsque la connexion est établie avec succès
     * */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websocket.add(this);     //ajouter à l'ensemble
        // addOnlineCount();           //Ajouter 1 au décompte en ligne
        System.out.println("Entrez la méthode onOpen");
        try {
            sendMessage("Connexion établie avec succès.");
        } catch (Exception e) {
            System.out.println("Exception d'E/S");
        }
    }
  
          
    /**
     * Fermer la connexion de communication
     * @param session
     */
    @OnClose
    public void onClose(Session session){
        //supprimer ce socket après avoir fermé la connexion
        websocket.remove(this);
        System.out.println("Entrez la méthode onClose");
    }
  
    /**
     * Obtenir des informations du client
     */
    @OnMessage
    public void onMessage(String message){
        System.out.println("Entrez la méthode onMessage; message = " + message);
    }
  
    /**
     * Pousser les informations au client
     */
    public void sendMessage(String message) throws IOException {
        System.out.println("Entrez la méthode sendMessage");
        this.session.getBasicRemote().sendText(message);
    }
  
    /**
     * méthode d'exception
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("Entrez la méthode d'erreur");
        error.printStackTrace();
    }
  
}
  