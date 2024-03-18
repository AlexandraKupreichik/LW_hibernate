package service;


import entity.Insurance;

import java.util.List;

public interface InsuranceService {
    boolean addInsurance(Insurance insurance);
    boolean updateInsurance(Insurance insurance);
    boolean deleteInsurance(int id);
    List<Insurance> showInsurance();
    Insurance findInsuranceById(int id);
}
