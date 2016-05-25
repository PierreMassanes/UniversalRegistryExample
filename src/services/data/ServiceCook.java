package services.data;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import protocol.ReponseService;
import protocol.Service;

import javax.jms.*;
import java.io.Serializable;
import java.net.URI;

/**
 * Created by user on 25/05/16.
 */
public class ServiceCook implements Service, Serializable {
    private ReponseService reponseService;
    private Topic topic ;
    ConnectionFactory connectionFactory;
    //private Session session;

    public ServiceCook(){
        reponseService= new ReponseServiceCook();
    }

        @Override
        public String getInfo() {
        return reponseService.getInfo();
    }

        @Override
        public ReponseService accesService() {
        return reponseService;
    }

        @Override
        public void iniConnection() {
        BrokerService broker = null;
        try {
            broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
            broker.start();
            Connection connection = null;
            connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("customerTopic");
            connection.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
        public void suscribe(MessageListener listener) {
        MessageConsumer consumer = null;
        try {
            Connection connection= connectionFactory.createConnection();
            Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            consumer = session.createConsumer(topic);
            consumer.setMessageListener(listener);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void publish(String nom, String content){
        Message msg = null;
        try {
            System.out.println("test");
            Connection connection= connectionFactory.createConnection();
            Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            msg = session.createTextMessage("--"+ nom + "--: "+content);
            MessageProducer producer = session.createProducer(topic);
            System.out.println("Sending text '" + content + "'");
            producer.send(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void closeConnection(){
        //TODO
        }
}


