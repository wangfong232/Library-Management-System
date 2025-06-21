package model;

public class Lending {

    private String bcode;
    private String rcode;
    private int state;      //0: book not given to the reader
                            //1:    still at the reader, not given back
                            //2:    is given back to the library

    public Lending() {
    }

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-5s | %2d", bcode, rcode, state);
    }
}
