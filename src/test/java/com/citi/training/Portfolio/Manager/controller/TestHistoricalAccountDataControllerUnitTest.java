package com.citi.training.Portfolio.Manager.controller;

import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.citi.training.Portfolio.Manager.repo.HistoricalAccountDataRepository;
import com.citi.training.Portfolio.Manager.rest.HistoricalAccountDataController;
import com.citi.training.Portfolio.Manager.service.HistoricalAccountDataService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=TestHistoricalAccountDataControllerUnitTest.Config.class)
public class TestHistoricalAccountDataControllerUnitTest {


/* The beans need to be commented out otherwise other tests will fail as they pick up the
configured beans in this test!
 */

    // Define a configuration class used for our test
    // it is static so there is only one instance of it
    // NOTE breaks other tests as the scope of this configuration goes to all test classes
    //@TestConfiguration
    protected static class Config {

        // needed for the Spring repo dependency in the service layer
        @Bean
        @Primary
        public HistoricalAccountDataRepository repo() {
            return mock(HistoricalAccountDataRepository.class);
        }

        // create a mock service layer than when asked for all the CDs returns a single CD in a list
        @Bean
        @Primary
        public HistoricalAccountDataService service() {
            List<HistoricalAccountData> hData = new ArrayList<>();
            List<HistoricalAccountData> historicalData = new ArrayList<>();
            historicalData.addAll(hData);

            HistoricalAccountDataService service = mock(HistoricalAccountDataService.class);
            when(service.getAllData()).thenReturn(historicalData);
            when(service.getDataById(1)).thenReturn(hData);
            return service;
        }

        @Bean
        @Primary
        public HistoricalAccountDataController controller() {
            return new HistoricalAccountDataController();
        }
    }

    @Autowired
    private HistoricalAccountDataController controller;


    @Test
    public void testFindAll() {
        Iterable<HistoricalAccountData> historicalData = controller.getAllHistoricalData();
        assertNotNull(historicalData);
    }


    @Test
    public void testHistoricalDataById() {
        List<HistoricalAccountData> data = controller.getHistoricalAccountDataById(1);
        assertNotNull(data);
    }

    @Test
    public void testGetLastWeekData(){
        List<HistoricalAccountData> data = controller.getLastWeekHistoricalAccountDataById(1,new Date(2020, Calendar.AUGUST,15));
        assertNotNull(data);
    }


}

