package com.ule.cerservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ule.cerservice.config.Config;
import com.ule.cerservice.mapper.CerManagerMapper;
import com.ule.cerservice.model.CertificateInfo;
import com.ule.cerservice.model.PageResponse;
import com.ule.cerservice.service.CerManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service("cerManagerService")
public class CerManagerServiceImpl implements CerManagerService {
    private final static Logger logger = LoggerFactory.getLogger(CerManagerServiceImpl.class);
    @Autowired
    private Config config;
    @Autowired
    private CerManagerMapper cerManagerMapper;


    @Override
    public CertificateInfo selectByPrimaryKey(int id) {
        return cerManagerMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResponse findAllCerInfo(CertificateInfo certificateInfo,int pagenum) {
        PageHelper.startPage(pagenum,10);
        Page<CertificateInfo> page=(Page)cerManagerMapper.select(certificateInfo);
        PageResponse rep=new PageResponse();
        rep.setPageNum(page.getPageNum());
        rep.setPages(page.getPages());
        rep.setPageSize(10);
        rep.setPageNum(pagenum);
        rep.setResultData(page.getResult());
        return rep;
    }

    @Override
    public void del(int id) {
        cerManagerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveCzbankPay(List<CertificateInfo> list) {

        cerManagerMapper.insertList(list);
    }

    @Override
    public CertificateInfo selectByParams(Map params) {
        Example example = new Example(CertificateInfo.class);//实例化
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("busiName", params.get("busiName").toString());
        criteria.orEqualTo("sysName", params.get("sysName").toString());
        criteria.orEqualTo("cerEnv", params.get("cerEnv").toString());
        if (params.get("channelCode").toString()!=null && !"".equals(params.get("channelCode").toString())){
            criteria.orEqualTo("channelCode", params.get("channelCode").toString());
        }

        return cerManagerMapper.selectOneByExample(example);
    }
}
