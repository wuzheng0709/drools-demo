package com.billing.drools.demo.entity;

public class BillingChargeParam {
	public static final int PRIMARY = 1;
	public static final int INTERMEDIATE = 2;
	public static final int SENIOR = 3;

	private int userStatus;
	private int gameId;
	private int billingType;
	private int monthCount;
	private int activityCode;
	private int accumulatePoints;
	private double money;

	public int getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getBillingType() {
		return billingType;
	}

	public void setBillingType(int billingType) {
		this.billingType = billingType;
	}

	public int getMonthCount() {
		return monthCount;
	}

	public void setMonthCount(int monthCount) {
		this.monthCount = monthCount;
	}

	public int getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(int activityCode) {
		this.activityCode = activityCode;
	}

	public int getAccumulatePoints() {
		return accumulatePoints;
	}

	public void setAccumulatePoints(int accumulatePoints) {
		this.accumulatePoints = accumulatePoints;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String toString() {
		return "{" + userStatus + "" + gameId + "" + billingType + ""
				+ monthCount + "" + activityCode + "" + accumulatePoints + ""
				+ money + "}";
	}

}
