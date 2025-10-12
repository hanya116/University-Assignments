public class hammingalgo1 {
    public static void main(String[] args) {
        // Input: 110000111001
        int[] inp = {1,1,0,0,0,0,1,1,1,0,0,1};

        // Use 9 instead of hamming bits and random number at index 0
        int[] msg = {2,9,9,1,9,1,0,0,9,0,0,1,1,1,0,0,9,1};

        String parityScheme = "ODD";
        int msgLength = msg.length;
        int s1 = 0;
        int h1 = 0;

        // calculate h1 (generating sum)
        System.out.println("Indexes = " + msgLength);

        for (int i = 3; i < msgLength; i += 2) {
            s1 += msg[i];
        }

        if (parityScheme.equalsIgnoreCase("ODD")) {
            int r = s1 % 2;
            if (r != 0)
                h1 = 0;
            else
                h1 = 1;
        } else { // EVEN parity
            int r = s1 % 2;
            if (r != 0)
                h1 = 1;
            else
                h1 = 0;
        }

        System.out.println("s1 = " + s1);
        System.out.println("h1 = " + h1);
    }
}