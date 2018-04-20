/**
 * 
 */
package org.examples.hadoop.hadoop;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author nirmoho-Mac
 *
 */
public class Decode {
    
    private static final char HEX_0 = 0x30;
    private static final char HEX_UPPER_A = 0x37;
    private static final char HEX_LOWER_A = 0x57;
    private static final int UTF_8_OFFSET = 4;
   
    private static int getHexValue(final byte b) {
        if ('0' <= b && b <= '9') {
            return b - HEX_0;
        } else if ('A' <= b && b <= 'F') {
            return b - HEX_UPPER_A;
        } else if ('a' <= b && b <= 'f') {
            return b - HEX_LOWER_A;
        }
        return -1;
    }
    
    public static String decode(final String encoded) {
        if (encoded == null) {
            return null;
        }

        byte[] encodedChars = encoded.getBytes(StandardCharsets.UTF_8);
        int encodedLength = encodedChars.length;
        byte[] decodedChars = new byte[encodedLength];

        int decodedIdx = 0;
        for (int encodedIdx = 0;
             encodedIdx < encodedLength;
             encodedIdx++, decodedIdx++) {
            decodedChars[decodedIdx] = encodedChars[encodedIdx];
            if (decodedChars[decodedIdx] == '%') {
                if (encodedIdx + 2 < encodedLength) {
                    int value1 = getHexValue(
                            encodedChars[encodedIdx + 1]);
                    int value2 = getHexValue(
                            encodedChars[encodedIdx + 2]);
                    if (value1 >= 0 && value2 >= 0) {
                        decodedChars[decodedIdx] =
                                (byte) ((value1 << UTF_8_OFFSET) + value2);
                        encodedIdx += 2;
                    }
                }
            }
        }
        return new String(Arrays.copyOf(decodedChars, decodedIdx),
                StandardCharsets.UTF_8);
    }

}
