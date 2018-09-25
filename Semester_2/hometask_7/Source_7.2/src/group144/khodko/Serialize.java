package group144.khodko;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serialize {
    /**
     * Serializes object to OutputStream
     * @param out output stream
     * @throws IOException if OutputStream unavailable
     */
    void serialize(OutputStream out) throws IOException;

    /**
     * Deserializes object from InputStream
     * @param in input stream
     * @throws IOException if InputStream unavailable
     */
    void deserialize(InputStream in) throws IOException;
}
