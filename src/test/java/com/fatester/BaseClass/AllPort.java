package com.fatester.BaseClass;

public class AllPort {
    private OpConfig op;
    private OdlabConfig odlab;
    public OpConfig getOp() {
        return op;
    }

    public void setOp(OpConfig op) {
        this.op = op;
    }

    public OdlabConfig getOdlab() {
        return odlab;
    }

    public void setOdlab(OdlabConfig odlab) {
        this.odlab = odlab;
    }

    @Override
    public String toString() {
        return  "\nop:" + op +
                "\nodlab=" + odlab +"\n";
    }



}
