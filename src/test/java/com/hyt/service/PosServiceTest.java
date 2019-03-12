package com.hyt.service;

import com.hyt.BaseTest;
import com.hyt.entity.Pos;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class PosServiceTest extends BaseTest {
    @Autowired
    private PosService posService;

    @Test
    public void testQueryPos(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("posId", 1);
        List<Pos> posList = posService.findPoss(map);
        for(Pos pos:posList){
            System.out.println(pos);
        }
    }
}
