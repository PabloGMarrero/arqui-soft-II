package com.arqui.soft.freemarket.product.domain.config;

import com.arqui.soft.freemarket.product.domain.model.filter.BetweenFilter;
import com.arqui.soft.freemarket.product.domain.model.filter.GreaterThanFilter;
import com.arqui.soft.freemarket.product.domain.model.filter.LessThanFilter;
import com.arqui.soft.freemarket.product.domain.model.filter.ProductFilterStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductFilterStrategyConfiguration {

    private final Map<String, ProductFilterStrategy> strategies = new HashMap<>();

    public ProductFilterStrategyConfiguration(GreaterThanFilter greaterThanFilter, LessThanFilter lessThanFilter, BetweenFilter betweenFilter) {
        strategies.put("GT", greaterThanFilter);
        strategies.put("LT", lessThanFilter);
        strategies.put("BT", betweenFilter);
    }

    public ProductFilterStrategy getStrategy(String key) {
        return strategies.get(key);
    }

}
