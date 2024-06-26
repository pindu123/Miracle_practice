package com.roles.demopro;

import java.sql.Date;

public class ProjectEmpDetails {
private int pid;
private int eid;
private Date assignedDate;
private String lead;
private String assignedBy;

private String username;
private String password;
public int getPid() {
    return pid;
}
public void setPid(int pid) {
    this.pid = pid;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public int getEid() {
    return eid;
}
public void setEid(int eid) {
    this.eid = eid;
}
public Date getAssignedDate() {
    return assignedDate;
}
public void setAssignedDate(Date assignedDate) {
    this.assignedDate = assignedDate;
}
public String getLead() {
    return lead;
}
public void setLead(String lead) {
    this.lead = lead;
}
public String getAssignedBy() {
    return assignedBy;
}
public void setAssignedBy(String assignedBy) {
    this.assignedBy = assignedBy;
}



}
