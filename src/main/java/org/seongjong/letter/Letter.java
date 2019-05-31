package org.seongjong.letter;

public class Letter {
	String senderId;
	String senderName;
	String receiverId;
	String receiverName;
	String title;
	String content;
	String cdate;
	
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	
	@Override
	public String toString() {
		return "Letter [senderId=" + senderId + ", senderName=" + senderName + ", receiverId=" + receiverId
				+ ", receiverName=" + receiverName + ", title=" + title + ", content=" + content + ", cdate=" + cdate
				+ "]";
	}
	
	
}
