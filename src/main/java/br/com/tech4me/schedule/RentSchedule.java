package br.com.tech4me.schedule;

import br.com.tech4me.service.RentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

@Component
public class RentSchedule {

    private static final Logger log = LoggerFactory.getLogger(RentSchedule.class);

    @Autowired
    private RentService rentService;

    /* checar a cada 4 horas -> @Scheduled(fixedRate = 4, timeUnit = TimeUnit.HOUR) */
    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void checkDates() {
        rentService.validateRents();
    }

}
