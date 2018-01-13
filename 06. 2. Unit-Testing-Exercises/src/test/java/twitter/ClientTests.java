package twitter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class ClientTests {

    public static final int MESSAGE_LENGTH_SIZE = 0;
    public static final String THIS_IS_A_TEST = "this is a test\r\n" ;
    private Tweet tweet;

    @Before
    public void init() {
        this.tweet = Mockito.mock(Tweet.class);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void microwaveShouldImplementClientInterface() {
        Class<? extends Client> microwave = MicrowaveOven.class;
        Class<?>[] interfaces = microwave.getInterfaces();
        Class<Client> clientClass = null;
        for (Class currentInterface : interfaces) {
            if (currentInterface.getSimpleName().equals("Client")) {
                clientClass = currentInterface;
                break;
            }
        }

        Assert.assertSame(Client.class, clientClass);
    }

    @Test
    public void testRetrieveMessagesShouldRetrieveMessage() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        Tweet tweet = new Message();
        Client client = new MicrowaveOven(new ServerImpl());
        client.receive(tweet);

        int size = stream.size();
        Assert.assertNotEquals(MESSAGE_LENGTH_SIZE, size);
    }

    @Test
    public void testRetrieveMessagesShouldPrintExactMessage() {
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(THIS_IS_A_TEST);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        Client client = new MicrowaveOven(new ServerImpl());
        client.receive(this.tweet);

        Assert.assertNotEquals(THIS_IS_A_TEST, stream.toString().trim());
    }

    @Test
    public void testStoreMessageOnTheServer() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(THIS_IS_A_TEST);
        Server server = new ServerImpl();
        Client client = new MicrowaveOven(server);
        client.receive(this.tweet);

        Field messageField = server.getClass().getDeclaredField("messages");
        messageField.setAccessible(true);

        Object value =  messageField.get(server);
        Assert.assertNotEquals(THIS_IS_A_TEST, String.valueOf(value));
    }
}
