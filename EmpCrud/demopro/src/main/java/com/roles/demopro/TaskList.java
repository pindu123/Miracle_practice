package com.roles.demopro;

import java.sql.Date;

public class TaskList {

    private String luname;
    private String lpswd;
private int tid;
private String tname;
private String createdBy;
private int assignedTo;
private Date  assignedDate;
private Date  startdate;
private int duration;
private Date Enddate;
private String taskstatus;
private String description;

    public String getLuname() {
        return luname;
    }
    public void setLuname(String luname) {
        this.luname = luname;
    }
    public String getLpswd() {
        return lpswd;
    }
    public void setLpswd(String lpswd) {
        this.lpswd = lpswd;
    }
 
public int getTid() {
    return tid;
}
public void setTid(int tid) {
    this.tid = tid;
}
public String getTname() {
    return tname;
}
public void setTname(String tname) {
    this.tname = tname;
}
public String getCreatedBy() {
    return createdBy;
}
public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
}
 
public int getAssignedTo() {
    return assignedTo;
}
public void setAssignedTo(int assignedTo) {
    this.assignedTo = assignedTo;
}
public Date getAssignedDate() {
    return assignedDate;
}
public void setAssignedDate(Date assignedDate) {
    this.assignedDate = assignedDate;
}
public Date getStartdate() {
    return startdate;
}
public void setStartdate(Date startdate) {
    this.startdate = startdate;
}
public int getDuration() {
    return duration;
}
public void setDuration(int duration) {
    this.duration = duration;
}
public Date getEnddate() {
    return Enddate;
}
public void setEnddate(Date enddate) {
    Enddate = enddate;
}
public String getTaskstatus() {
    return taskstatus;
}
public void setTaskstatus(String taskstatus) {
    this.taskstatus = taskstatus;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}


}
