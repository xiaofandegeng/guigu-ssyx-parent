package com.atguigu.ssyx.product.mapper;

import com.atguigu.ssyx.model.product.SkuImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuImageMapper extends BaseMapper<SkuImage> {

    @Select("<script>"
            + "SELECT id AS id, sku_id AS skuId, img_name AS imgName, img_url AS imgUrl, sort, create_time as createTime, update_time as updateTime "
            + "FROM sku_image "
            + "<where>"
            + "sku_id = #{skuId}"
            + "</where>"
            + "order by updateTime DESC"
            + "</script>")
    List<SkuImage> findBySkuId(@Param("skuId") Long skuId);
}
