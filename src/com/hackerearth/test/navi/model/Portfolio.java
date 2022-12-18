package com.hackerearth.test.navi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {
    private final Map<AssetClass,Float> assetAllocationMap;
    private long totalValue;

    public Portfolio(List<AssetClass> assetClasses){
        if(assetClasses == null || assetClasses.isEmpty()){
            throw new IllegalArgumentException();
        }
        assetAllocationMap = new HashMap<>();
        totalValue = assetClasses.stream().map(AssetClass::getBalance).reduce(0L,Long::sum);
        for(AssetClass assetClass: assetClasses){
            assetAllocationMap.put(assetClass, (float)assetClass.getBalance()/totalValue);
        }
    }
}
