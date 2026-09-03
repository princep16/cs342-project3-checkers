import static org.junit.jupiter.api.Assertions.*;

import java.io.ObjectStreamClass;

import org.junit.jupiter.api.Test;

class ServerMessageTest {

    @Test
    void initializesServerMessageCollections() {
        Message message = new Message();

        assertNotNull(message.activeUsers);
        assertNotNull(message.validMoves);
        assertNotNull(message.onlineFriends);
    }

    @Test
    void supportsCoreServerMessageTypes() {
        Message message = new Message();

        message.type = Message.MessageType.GAME_START;
        message.sender = "PlayerOne";
        message.recipient = "PlayerTwo";
        message.playerColor = 1;

        assertEquals(Message.MessageType.GAME_START, message.type);
        assertEquals("PlayerOne", message.sender);
        assertEquals("PlayerTwo", message.recipient);
        assertEquals(1, message.playerColor);
    }

    @Test
    void usesExpectedSerializationVersion() {
        long serialVersion = ObjectStreamClass
                .lookup(Message.class)
                .getSerialVersionUID();

        assertEquals(42L, serialVersion);
    }
}
