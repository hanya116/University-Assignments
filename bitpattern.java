class bitpattern {
    public static void main(String[] args) {
       int aap = 13;
       int m = 1;
       m = m << 31;
       for(int i =0; i<32; i++){
       int y = aap & m;
       if (y==0)
      System.out.print("0");
       else 
      System.out.print("1");
        m = m>>>1;
       }
    }
}
