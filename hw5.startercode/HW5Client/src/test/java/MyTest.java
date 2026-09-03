import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

class MessageTest {

    @Test
    void initializesMessageCollections() {
        Message message = new Message();

        assertNotNull(message.activeUsers);
        assertNotNull(message.validMoves);
        assertNotNull(message.onlineFriends);
        assertTrue(message.activeUsers.isEmpty());
        assertTrue(message.validMoves.isEmpty());
        assertTrue(message.onlineFriends.isEmpty());
    }

    @Test
    void preservesDataDuringSerialization() throws Exception {
        Message original = new Message();
        original.type = Message.MessageType.MOVE;
        original.sender = "Prince";
        original.startRow = 5;
        original.startCol = 0;
        original.endRow = 4;
        original.endCol = 1;

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(original);
        }

        Message restored;

        try (ObjectInputStream input = new ObjectInputStream(
                new ByteArrayInputStream(bytes.toByteArray()))) {
            restored = (Message) input.readObject();
        }

        assertEquals(Message.MessageType.MOVE, restored.type);
        assertEquals("Prince", restored.sender);
        assertEquals(5, restored.startRow);
        assertEquals(0, restored.startCol);
        assertEquals(4, restored.endRow);
        assertEquals(1, restored.endCol);
    }
}
