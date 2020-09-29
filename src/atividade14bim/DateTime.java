package atividade14bim;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    private Date datahora;
    private String formato;
    private SimpleDateFormat sf;
    private long timestamp;
    private String currentTime;

    public DateTime() {
        this.datahora = new Date();
        this.formato = "YYYY-MM-dd HH:mm:ss";
        this.sf = new SimpleDateFormat(this.formato);
        this.timestamp = this.datahora.getTime();
        this.currentTime = sf.format(this.datahora);
    }
    
    public DateTime(long timestamp) {
        this.datahora = new Date(timestamp);
        this.formato = "YYYY-MM-dd HH:mm:ss";
        this.sf = new SimpleDateFormat(this.formato);
        this.timestamp = timestamp;
        this.currentTime = sf.format(this.datahora);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public SimpleDateFormat getSf() {
        return sf;
    }

    public void setSf(SimpleDateFormat sf) {
        this.sf = sf;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
    
    
    
}
