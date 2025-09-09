package models;

import base.BaseEntity;

public class Gate extends BaseEntity {

    private Operator operator;

    private GateType gateType;

    private int gateNumber;

    private BaseStatus gameStatus;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public BaseStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(BaseStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
