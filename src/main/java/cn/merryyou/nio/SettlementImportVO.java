package cn.merryyou.nio;


import java.math.BigDecimal;

/**
 * 结清结果信息文件
 */
public class SettlementImportVO {
    /**当前日期**/
    private String currentDate;
    /**记录类型**/
    private String recordType;
    /**产品号**/
    private String productNo;
    /**订单号**/
    private String orderNo;
    /**客户姓名**/
    private String customerName;
    /**证件类型**/
    private String cardType;
    /**证件号码**/
    private String cardNo;
    /**贷款卡号**/
    private String  loanNo;
    /**总期数**/
    private Integer periods;
    /**当前期数**/
    private Integer currentPeriod;
    /**逾期天数**/
    private Integer overdueDay;
    /**借据号**/
    private String louNo;
    /**发起方式**/
    private String launchWay;
    /**结清原因编码**/
    private String settleReason;
    /**结清原因描述**/
    private String settleDesc;
    /**结清日期**/
    private String settleDate;
    /**结清本金**/
    private BigDecimal settlePrincipal;
    /**结清利息**/
    private BigDecimal settleInterest;
    /**结清罚息**/
    private BigDecimal settleOverdue;
    /**扣款结果**/
    private String deducResult;
    /**备注字段1**/
    private String remark1;
    /**备注字段2**/
    private String remark2;
    /**备注字段3**/
    private String remark3;

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public String getLouNo() {
        return louNo;
    }

    public void setLouNo(String louNo) {
        this.louNo = louNo;
    }

    public String getLaunchWay() {
        return launchWay;
    }

    public void setLaunchWay(String launchWay) {
        this.launchWay = launchWay;
    }

    public String getSettleReason() {
        return settleReason;
    }

    public void setSettleReason(String settleReason) {
        this.settleReason = settleReason;
    }

    public String getSettleDesc() {
        return settleDesc;
    }

    public void setSettleDesc(String settleDesc) {
        this.settleDesc = settleDesc;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public BigDecimal getSettlePrincipal() {
        return settlePrincipal;
    }

    public void setSettlePrincipal(BigDecimal settlePrincipal) {
        this.settlePrincipal = settlePrincipal;
    }

    public BigDecimal getSettleInterest() {
        return settleInterest;
    }

    public void setSettleInterest(BigDecimal settleInterest) {
        this.settleInterest = settleInterest;
    }

    public BigDecimal getSettleOverdue() {
        return settleOverdue;
    }

    public void setSettleOverdue(BigDecimal settleOverdue) {
        this.settleOverdue = settleOverdue;
    }

    public String getDeducResult() {
        return deducResult;
    }

    public void setDeducResult(String deducResult) {
        this.deducResult = deducResult;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
}
