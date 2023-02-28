package com.inditex.pot.slc.infraestructure.config.spring;

import com.inditex.pot.slc.application.repository.IPriceRepository;
import com.inditex.pot.slc.application.service.IPriceService;
import com.inditex.pot.slc.application.service.impl.PriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class SlcApplicationConfig {

    @Bean
    public IPriceService priceService(IPriceRepository priceRepository) {
        return
            new PriceService(priceRepository);
    }

}
