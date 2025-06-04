package com.app.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IssueBook {

    private long issueId;
    private long bookId;
    private long userId;
    private LocalDate issuedDate;
    private LocalDate expectedSubmitDate;
    private LocalDate actualSubmitDate;
    private int issueDays;
    private double totalFee;
    private double totalPenalty=0;
    private boolean returned =false;


    public IssueBook(long bookId, long userId, LocalDate issuedDate,
                     LocalDate expectedSubmitDate, LocalDate actualSubmitDate,
                     int issueDays, double totalFee, double totalPenalty, boolean returned) {
        this.bookId = bookId;
        this.userId = userId;
        this.issuedDate = issuedDate;
        this.expectedSubmitDate = expectedSubmitDate;
        this.actualSubmitDate = actualSubmitDate;
        this.issueDays = issueDays;
        this.totalFee = totalFee;
        this.totalPenalty = totalPenalty;
        this.returned = returned;
    }

    

    @Override
    public String toString() {
        return "IssueBook{" +
                "issueId=" + issueId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", issuedDate=" + issuedDate +
                ", expectedSubmitDate=" + expectedSubmitDate +
                ", actualSubmitDate=" + actualSubmitDate +
                ", issueDays=" + issueDays +
                ", totalFee=" + totalFee +
                ", totalPenalty=" + totalPenalty +
                ", returned=" + returned +
                '}';
    }
}