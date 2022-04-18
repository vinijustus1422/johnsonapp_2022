package com.triton.johnsonapp.requestpojo;

import java.util.List;

public class SubordActivityFormReqest {
    /*  "EMPNO": "E16622",
        "ENAME": "SHEIK MOHAMMED SHAHINSHA B",
         "DATE": "12-10-1995",
          "FN": "LL",
         "AN": "",
         "PER_IN_HR": "1",
         "PER_OFF": "Office",
          "REASON": "for Testing Process"*/
    private List<DataBean> Data;
    private String EMPNO;
    private String ENAME;
    private String DATE;
    private String FN;
    private String AN;
    private String PER_IN_HR;
    private String PER_OFF;
    private String REASON;

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> data) {
        Data = data;
    }

    public String getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(String EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getFN() {
        return FN;
    }

    public void setFN(String FN) {
        this.FN = FN;
    }

    public String getAN() {
        return AN;
    }

    public void setAN(String AN) {
        this.AN = AN;
    }

    public String getPER_IN_HR() {
        return PER_IN_HR;
    }

    public void setPER_IN_HR(String PER_IN_HR) {
        this.PER_IN_HR = PER_IN_HR;
    }

    public String getPER_OFF() {
        return PER_OFF;
    }

    public void setPER_OFF(String PER_OFF) {
        this.PER_OFF = PER_OFF;
    }

    public String getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON = REASON;
    }

    public static class DataBean{
        private String EMPNO;
        private String ENAME;
        private String DATE;
        private String FN;
        private String AN;
        private String PER_IN_HR;
        private String PER_OFF;
        private String REASON;

        public String getEMPNO() {
            return EMPNO;
        }

        public void setEMPNO(String EMPNO) {
            this.EMPNO = EMPNO;
        }

        public String getENAME() {
            return ENAME;
        }

        public void setENAME(String ENAME) {
            this.ENAME = ENAME;
        }

        public String getDATE() {
            return DATE;
        }

        public void setDATE(String DATE) {
            this.DATE = DATE;
        }

        public String getFN() {
            return FN;
        }

        public void setFN(String FN) {
            this.FN = FN;
        }

        public String getAN() {
            return AN;
        }

        public void setAN(String AN) {
            this.AN = AN;
        }

        public String getPER_IN_HR() {
            return PER_IN_HR;
        }

        public void setPER_IN_HR(String PER_IN_HR) {
            this.PER_IN_HR = PER_IN_HR;
        }

        public String getPER_OFF() {
            return PER_OFF;
        }

        public void setPER_OFF(String PER_OFF) {
            this.PER_OFF = PER_OFF;
        }

        public String getREASON() {
            return REASON;
        }

        public void setREASON(String REASON) {
            this.REASON = REASON;
        }
    }
}
