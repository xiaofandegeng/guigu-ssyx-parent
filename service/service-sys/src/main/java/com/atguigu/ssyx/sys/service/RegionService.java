package com.atguigu.ssyx.sys.service;

import com.atguigu.ssyx.model.sys.Region;

import java.util.List;

public interface RegionService {
    List<Region> findRegionByKeyword(String keyword);
}
