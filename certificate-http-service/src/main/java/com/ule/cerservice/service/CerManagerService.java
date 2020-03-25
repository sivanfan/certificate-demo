package com.ule.cerservice.service;


import com.ule.cerservice.model.CertificateInfo;
import com.ule.cerservice.model.PageResponse;

import java.util.List;
import java.util.Map;

public interface CerManagerService {
    CertificateInfo selectByPrimaryKey(int id);

    PageResponse findAllCerInfo(CertificateInfo certificateInfo,int pagenum);

    void del(int id);

    void saveCzbankPay(List<CertificateInfo> list);

    CertificateInfo selectByParams(Map params);
}
