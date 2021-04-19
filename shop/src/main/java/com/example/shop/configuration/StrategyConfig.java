package com.example.shop.configuration;


import com.example.shop.Repository.InLocationRepo;
import com.example.shop.Repository.InProductRepo;
import com.example.shop.Repository.InStockRepo;
import com.example.shop.strategy.AbundantLocationStrategy;
import com.example.shop.strategy.InStrategy;
import com.example.shop.strategy.SingleLocationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
@Configuration

public class StrategyConfig {
    private final InStockRepo stockRepo;
    private final InLocationRepo locationRepo;
    private final InProductRepo productRepo;


    public StrategyConfig(InStockRepo stockRepo, InLocationRepo locationRepo, InProductRepo productRepo) {
        this.stockRepo = stockRepo;
        this.locationRepo = locationRepo;
        this.productRepo = productRepo;
    }


    @Bean
    public InStrategy strategy(@Value("${strategy}") String strategy)
    {
        if(strategy.equals(Strategy.SINGLE_STRATEGY.toString()))
            return new SingleLocationStrategy(stockRepo,locationRepo,productRepo);
        else if(strategy.equals(Strategy.ABUNDENT_STRATEGY.toString()))
            return new AbundantLocationStrategy(stockRepo,productRepo);

        throw new RuntimeException("wrong strategy");
    }


}
