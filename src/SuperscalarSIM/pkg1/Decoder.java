/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

package SuperscalarSIM.pkg1;

/**
 *
 * @author roberto
 */
public class Decoder {

    private int Inst;
    private String Op;
    private String Rd;
    private String Rs;
    private String Rt;
    private int Im;
    private String type;

    public Decoder() {
    }

    public Decoder(int Instr, String Op, String Rd, String Rs, String Rt, int imediato, String type) {
        this.Inst = Instr;
        this.Op = Op;
        this.Rd = Rd;
        this.Rs = Rs;
        this.Rt = Rt;
        this.Im = imediato;
        this.type = type;
    }

    public int getInst() {
        return Inst;
    }

    public String getOp() {
        return Op;
    }

    public String getRd() {
        return Rd;
    }

    public String getRs() {
        return Rs;
    }

    public String getRt() {
        return Rt;
    }

    public int getIm() {
        return Im;
    }

    public String getType() {
        return type;
    }

    public void setInst(int Instr) {
        this.Inst = Instr;
    }

    public void setOp(String Op) {
        this.Op = Op;
    }

    public void setRd(String Rd) {
        this.Rd = Rd;
    }

    public void setRs(String Rs) {
        this.Rs = Rs;
    }

    public void setRt(String Rt) {
        this.Rt = Rt;
    }

    public void setIm(int imediato) {
        this.Im = imediato;
    }

    public void setType(String type) {
        this.type = type;
    }

}
