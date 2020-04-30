package com.paipaiwang.admin.vo;

/**
 * 更改密码请求封装类
 */
public class ChangePWDVO {

	private String oldPWD;
	private String newPWD;
	private String repeatPWD;
	public final String getOldPWD() {
		return oldPWD;
	}
	public final void setOldPWD(String oldPWD) {
		this.oldPWD = oldPWD;
	}
	public final String getNewPWD() {
		return newPWD;
	}
	public final void setNewPWD(String newPWD) {
		this.newPWD = newPWD;
	}
	public final String getRepeatPWD() {
		return repeatPWD;
	}
	public final void setRepeatPWD(String repeatPWD) {
		this.repeatPWD = repeatPWD;
	}
	@Override
	public String toString() {
		return "ChangePWDVO [oldPWD=" + oldPWD + ", newPWD=" + newPWD
				+ ", repeatPWD=" + repeatPWD + "]";
	}
	
}
