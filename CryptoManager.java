public class CryptoManager {

    private static final char LOWER_BOUND = ' ';
    private static final char UPPER_BOUND = '_';
    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

    /**
     * This method determines if a string is within the allowable bounds of ASCII codes
     * according to the LOWER_BOUND and UPPER_BOUND characters
     * @param plainText a string to be encrypted, if it is within the allowable bounds
     * @return true if all characters are within the allowable bounds, false if any character is outside
     */
    public static boolean stringInBounds (String plainText)
    {
        for (int i = 0; i<plainText.length(); i++)
        {
            if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
                return false;
        }
        return true;
    }

    /**
     * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in plainText is replaced by the character \"offset\" away from it
     * @param plainText an uppercase string to be encrypted.
     * @param key an integer that specifies the offset of each character
     * @return the encrypted string
     */
    public static String encryptCaesar(String plainText, int key) {
        String value ="";

        //for loop to encrypt each letter
        for (int n=0; n<plainText.length(); n++)

        {
            int ch=plainText.charAt(n);



            //for loop to encrypt the letter by shifting and wrap up if necessary
            for (int pos=key; pos>0;pos--)
            {
                if (ch>=UPPER_BOUND)
                    ch=LOWER_BOUND;
                else
                    ++ch;

            }
            char valueLetter=(char) ch;

            value+=valueLetter;
        }
        return value;
    }

    /**
     * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
     * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
     * to correspond to the length of plainText
     * @param plainText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the encrypted string
     */
    public static String encryptBellaso(String plainText, String bellasoStr) {
        //equaling the lengths of both the bellaso string and the plain text text

        String newBellasoStr="";
        int l=0;
        for (int x=0; x<plainText.length(); x++)
        {

            newBellasoStr+=bellasoStr.charAt(l);

            l++;

            if (l>bellasoStr.length()-1)
            {
                l=0;
            }
        }

// encrypt the text of the plaintext
        String value="";
        for (int i=0; i<plainText.length(); i++)
        {
            int sum=(int) (plainText.charAt(i)+newBellasoStr.charAt(i));


          while (sum>UPPER_BOUND)
          {
              sum-=UPPER_BOUND;
              sum+=LOWER_BOUND;
              sum--;
          }

            value+=(char)sum;
        }


        return value;
    }

    /**
     * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in encryptedText is replaced by the character \"offset\" characters before it.
     * This is the inverse of the encryptCaesar method.
     * @param encryptedText an encrypted string to be decrypted.
     * @param key an integer that specifies the offset of each character
     * @return the plain text string
     */
    public static String decryptCaesar(String encryptedText, int key) {
        String value ="";

        //for loop to decrypt each letter
        for (int n=0; n<encryptedText.length(); n++)

        {
            int ch=encryptedText.charAt(n);



            //for loop to decrypt the letter by shifting and wrap up if necessary
            for (int pos=key; pos>0;pos--)
            {
                if (ch<=LOWER_BOUND)
                    ch=UPPER_BOUND;
                else
                    --ch;

            }
            char valueLetter=(char) ch;

            value+=valueLetter;
        }
        return value;
    }

    /**
     * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
     * the character corresponding to the character in bellasoStr, which is repeated
     * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
     * @param encryptedText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the decrypted string
     */
    public static String decryptBellaso(String encryptedText, String bellasoStr) {
        //equaling the lengths of both the bellaso string and the encrypted text
        String newBellasoStr="";
        int l=0;
        for (int x=0; x<encryptedText.length(); x++)
        {

            newBellasoStr+=bellasoStr.charAt(l);

            l++;

            if (l>bellasoStr.length()-1)
            {
                l=0;
            }
        }

// decrypting the text of the plain text
        String value="";
        for (int i=0; i<encryptedText.length(); i++)
        {
            int enc= encryptedText.charAt(i);
            int bStr= newBellasoStr.charAt(i);
            int temp=enc-bStr;
            int ch=temp;

                while (ch<LOWER_BOUND)

                {
                    ch+=(int)(RANGE);
                }

                value+=(char)ch;
        }


        return value;
    }
    }
