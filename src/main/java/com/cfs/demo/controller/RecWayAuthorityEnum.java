package com.cfs.demo.controller;


import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: RecWayAuthorityEnum <br/>
 * Description: <br/>
 * date: 2021/12/2 19:30<br/>
 *
 * @author ShowFaker<br />
 * @since JDK 8
 */
public enum RecWayAuthorityEnum {


	OnlinePay("WECHATPAY,ALIPAY,POS,SPAY", "A11,A12,A13,A14,A15,A16", true, true, 1),
	OfflinePay("DOUYIN", "A1,A5", true, false, 2);

	String bankCode;
	String recWayCode;
	Boolean transactionAudit;
	Boolean accountAudit;
	Integer jumpCode;

	RecWayAuthorityEnum(String bankCode, String recWayCode, Boolean transactionAudit, Boolean accountAudit, Integer jumpCode) {
		this.bankCode = bankCode;
		this.recWayCode = recWayCode;
		this.transactionAudit = transactionAudit;
		this.accountAudit = accountAudit;
		this.jumpCode = jumpCode;
	}

	public static Integer getJump(String code, String recWay) {
		for (RecWayAuthorityEnum value : RecWayAuthorityEnum.values()) {
			List<String> recList = Arrays.asList(value.bankCode.split(","));
			if (recList.contains(code)) {
				return value.jumpCode;
			}
		}
		for (RecWayAuthorityEnum value : RecWayAuthorityEnum.values()) {
			List<String> recList = Arrays.asList(value.recWayCode.split(","));
			if (recList.contains(recWay)) {
				return value.jumpCode;
			}
		}
		return null;
	}

	public static Boolean getAccountAuditCheck(String code, String recWay) {
		for (RecWayAuthorityEnum value : RecWayAuthorityEnum.values()) {
			if (value.bankCode.contains(code)) {
				return value.accountAudit;
			} else {
				if (value.recWayCode.contains(recWay)) {
					return value.accountAudit;
				}
			}
		}
		return null;
	}
	// true为应收单和false为三方交易单
	public static Boolean judgeCashAndTransfer(String bankCode, String recWayCode) {
		List<String> recWayList = Arrays.asList(RecWayAuthorityEnum.OnlinePay.recWayCode.split(","));
		if (recWayList.contains(recWayCode) || ((!StringUtils.isEmpty(bankCode)) && RecWayAuthorityEnum.OnlinePay.bankCode.contains(bankCode))) {
			return false;
		}
		return true;
	}

	// 返回三方交易单的code值
	public static List<String> getThirdRecWayCode() {
		List<String> codeList = Arrays.asList(RecWayAuthorityEnum.OnlinePay.recWayCode.split(","));
		return codeList;
	}
}
