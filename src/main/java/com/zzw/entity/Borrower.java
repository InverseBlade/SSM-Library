package com.zzw.entity;

public class Borrower {

    private Integer id;

    private String cardno;

    private String department;

    private String name;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", cardno='" + cardno + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}' +
                '\n';
    }
}
