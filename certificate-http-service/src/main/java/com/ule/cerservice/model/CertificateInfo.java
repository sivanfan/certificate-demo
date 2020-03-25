package com.ule.cerservice.model;
import javax.persistence.*;

@Table(name = "certificate_info")
public class CertificateInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;

	public String busiName;
	public String sysName;
	public Integer cerSendType;
	public Integer cerType;
	public String channelCode;
	public String downPassword;
	@Transient
	public String cerPassword;
	public String expirationDate;
	public String email;
	public String cerContent;
	public Integer cerOutType;
	public String cerOutFilename;
	public Integer cerEnv;
	public String cerName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusiName() {
		return busiName;
	}

	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public Integer getCerSendType() {
		return cerSendType;
	}

	public void setCerSendType(Integer cerSendType) {
		this.cerSendType = cerSendType;
	}

	public Integer getCerType() {
		return cerType;
	}

	public void setCerType(Integer cerType) {
		this.cerType = cerType;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getDownPassword() {
		return downPassword;
	}

	public void setDownPassword(String downPassword) {
		this.downPassword = downPassword;
	}

	public String getCerPassword() {
		return cerPassword;
	}

	public void setCerPassword(String cerPassword) {
		this.cerPassword = cerPassword;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCerContent() {
		return cerContent;
	}

	public void setCerContent(String cerContent) {
		this.cerContent = cerContent;
	}

	public Integer getCerOutType() {
		return cerOutType;
	}

	public void setCerOutType(Integer cerOutType) {
		this.cerOutType = cerOutType;
	}

	public String getCerOutFilename() {
		return cerOutFilename;
	}

	public void setCerOutFilename(String cerOutFilename) {
		this.cerOutFilename = cerOutFilename;
	}

	public Integer getCerEnv() {
		return cerEnv;
	}

	public void setCerEnv(Integer cerEnv) {
		this.cerEnv = cerEnv;
	}

	public String getCerName() {
		return cerName;
	}

	public void setCerName(String cerName) {
		this.cerName = cerName;
	}
}
