package io.github.suelytonthiago.Issuecv.domain.enums;

import io.github.suelytonthiago.Issuecv.rest.services.exceptions.CustomException;

public enum IssueStatus {

    PENDING("PENDING"),
    WAITING_CONFIRMATION("WAITING_CONFIRMATION"),
    ISSUED("ISSUED");

    private String codeName;

    private IssueStatus(String codeName){
        this.codeName = codeName;
    }

    public String getCodeName(){
        return codeName;
    }

    public static IssueStatus nameOf(String codeName){
        for(IssueStatus x  : IssueStatus.values()){
            if(x.getCodeName().equals(codeName)){
                return x;
            }
        }
        throw new CustomException("Invalid Roles name");
    }
}
