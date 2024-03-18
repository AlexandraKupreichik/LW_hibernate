package service.serviceImpl;


import dao.InsuranceDao;
import dao.daoImpl.InsuranceDaoImpl;
import entity.Insurance;
import exception.ShowException;
import org.hibernate.HibernateError;
import service.InsuranceService;

import java.util.List;

public class InsuranceServiceImpl implements InsuranceService {

    InsuranceDao insuranceDao = new InsuranceDaoImpl();

    public InsuranceServiceImpl() {}


    @Override
    public boolean addInsurance(Insurance insurance) {
        boolean isAdded = false;
        try {
            if (insuranceDao.addInsurance(insurance))
                isAdded = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateInsurance(Insurance insurance) {
        boolean isUpdated = false;
        try {
            if (insuranceDao.updateInsurance(insurance))
                isUpdated = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteInsurance(int id) {
        boolean isDeleted = false;
        try {
            if (insuranceDao.deleteInsurance(id))
                isDeleted = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isDeleted;
    }

    @Override
    public List<Insurance> showInsurance() {
        List<Insurance> insurances = null;
        try {
            insurances = insuranceDao.showInsurance();
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return insurances;
    }

    @Override
    public Insurance findInsuranceById(int id) {
        Insurance insurance = null;
        try {
            insurance = insuranceDao.findInsuranceById(id);
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return insurance;
    }
}
