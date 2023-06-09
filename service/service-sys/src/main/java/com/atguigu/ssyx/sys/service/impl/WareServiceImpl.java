package com.atguigu.ssyx.sys.service.impl;

import com.atguigu.ssyx.model.sys.Ware;
import com.atguigu.ssyx.sys.mapper.WareMapper;
import com.atguigu.ssyx.sys.service.WareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WareServiceImpl implements WareService {

    @Resource
    private WareMapper wareMapper;

    @Override
    public List<Ware> list() {
        return wareMapper.selectList(null);
    }
}
