package entity;

import javax.persistence.*;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private int insurance_id;

    @Column(name = "insurance_company")
    private String insuranceCompany;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "insurance_type")
    private String insuranceType;

    @Column(name = "insurance_cost")
    private String insuranceCost;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car cars;

    public Insurance() {
    }

    public Insurance(String insuranceCompany, String startDate, String endDate, String insuranceType, String insuranceCost) {
        this.insuranceCompany = insuranceCompany;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuranceType = insuranceType;
        this.insuranceCost = insuranceCost;

    }

    public int getInsuranceId() {
        return insurance_id;
    }

    public void setInsuranceId(int insurance_id) {
        this.insurance_id = insurance_id;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getStartDate(){return startDate;}

    public void setStartDate(String startDate){this.startDate=startDate;}

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInsuranceType(){return insuranceType;}

    public void setInsuranceType(String insuranceType){this.insuranceType=insuranceType;}

    public String getInsuranceCost(){return insuranceCost;}

    public void setInsuranceCost(String insuranceCost){this.insuranceCost=insuranceCost;}

    public Car getCar() {
        return cars;
    }

    public void setCar(Car car) {
        this.cars = car;
    }

}
