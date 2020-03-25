/**
 * Copyright 2019 bejson.com
 */
package com.ule.cermanager.model.systemside;
import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2019-02-22 9:37:46
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Profile {

    private List<Logs> logs;
    private Env env;
    private Cvs cvs;
    private String jvmVersion;
    public void setLogs(List<Logs> logs) {
        this.logs = logs;
    }
    public List<Logs> getLogs() {
        return logs;
    }

    public void setEnv(Env env) {
        this.env = env;
    }
    public Env getEnv() {
        return env;
    }

    public void setCvs(Cvs cvs) {
        this.cvs = cvs;
    }
    public Cvs getCvs() {
        return cvs;
    }

    public void setJvmVersion(String jvmVersion) {
        this.jvmVersion = jvmVersion;
    }
    public String getJvmVersion() {
        return jvmVersion;
    }

}