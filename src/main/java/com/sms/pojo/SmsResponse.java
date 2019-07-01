package com.sms.pojo;

import java.util.List;

public class SmsResponse {

	private int balance;
	private long batch_id;
	private int cost;
	private int num_messages;
	private Message message;
	private String receipt_url;
	private String custom;
	private List<Receipient> messages;
	private String status;
	private List<SmsWarnings> warnings;
	private List<SmsErrors> errors;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public long getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(long batch_id) {
		this.batch_id = batch_id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNum_messages() {
		return num_messages;
	}

	public void setNum_messages(int num_messages) {
		this.num_messages = num_messages;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getReceipt_url() {
		return receipt_url;
	}

	public void setReceipt_url(String receipt_url) {
		this.receipt_url = receipt_url;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public List<Receipient> getMessages() {
		return messages;
	}

	public void setMessages(List<Receipient> messages) {
		this.messages = messages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SmsWarnings> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<SmsWarnings> warnings) {
		this.warnings = warnings;
	}

	public List<SmsErrors> getErrors() {
		return errors;
	}

	public void setErrors(List<SmsErrors> errors) {
		this.errors = errors;
	}

}
