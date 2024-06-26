package com.roles.demopro;

import java.sql.Date;

public class Project {

    private String admail="";
    private String adpass="";
private int pid;
private String pname;
private String clientInfo;
private String AssignedBy;
private Date startdate;
private Date endDate;
private int duration;
private String hr;
private String pm;
private int noOfemp;

public String getAdmail() {
    return admail;
}
public void setAdmail(String admail) {
    this.admail = admail;
}
public String getAdpass() {
    return adpass;
}
public void setAdpass(String adpass) {
    this.adpass = adpass;
}

public int getPid() {
    return pid;
}
public void setPid(int pid) {
    this.pid = pid;
}
public String getPname() {
    return pname;
}
public void setPname(String pname) {
    this.pname = pname;
}
public String getClientInfo() {
    return clientInfo;
}
public void setClientInfo(String clientInfo) {
    this.clientInfo = clientInfo;
}
public String getAssignedBy() {
    return AssignedBy;
}
public void setAssignedBy(String assignedBy) {
    AssignedBy = assignedBy;
}
public Date getStartdate() {
    return startdate;
}
public void setStartdate(Date startdate) {
    this.startdate = startdate;
}
public Date getEndDate() {
    return endDate;
}
public void setEndDate(Date endDate) {
    this.endDate = endDate;
}
public int getDuration() {
    return duration;
}
public void setDuration(int duration) {
    this.duration = duration;
}
public String getHr() {
    return hr;
}
public void setHr(String hr) {
    this.hr = hr;
}
public String getPm() {
    return pm;
}
public void setPm(String pm) {
    this.pm = pm;
}
public int getNoOfemp() {
    return noOfemp;
}
public void setNoOfemp(int noOfemp) {
    this.noOfemp = noOfemp;
}

}
