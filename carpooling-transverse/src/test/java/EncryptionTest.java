import edu.fst.m2.ipii.carpooling.transverse.utils.security.EncryptionUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dimitri on 14/04/2015.
 */
public class EncryptionTest {

    @Test
    public void testEncryptionDecryption() throws Exception{
        String password = "admin";

        String passwordCrypte = EncryptionUtils.encrypt(password);

        String passwordDecrypte = EncryptionUtils.decrypt(passwordCrypte);

        assertEquals(password, passwordDecrypte);
    }
}
