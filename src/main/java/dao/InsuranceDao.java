package dao;

import entity.Insurance;

import java.util.List;

public interface InsuranceDao {
    boolean addInsurance(Insurance insurance);
    boolean updateInsurance(Insurance insurance);
    boolean deleteInsurance(int id);
    List<Insurance> showInsurance();
    Insurance findInsuranceById(int id);
}
