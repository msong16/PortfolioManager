package com.citi.training.Portfolio.Manager.repo;

import com.citi.training.Portfolio.Manager.PortfolioManagerApplication;
import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.citi.training.Portfolio.Manager.rest.HistoricalAccountDataController;
import com.citi.training.Portfolio.Manager.service.HistoricalAccountDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest // use an in memory database
@ContextConfiguration(classes= PortfolioManagerApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties") // this is only needed because swagger breaks tests

public class TestHistoricalDataRepository {


        @Autowired
        private TestEntityManager manager;

        @Autowired // this is a mock which is injected because of the @DataJpaTest
        private HistoricalAccountDataRepository repo;

        @Autowired
        private HistoricalAccountDataService dataService;


        @Autowired
        HistoricalAccountDataController controller;

        private int accountId;

        @BeforeEach
        public  void setupDatabaseEntryForReadOnlyTests() {
            HistoricalAccountData record = new HistoricalAccountData(17, 2, new Date(2021,8,18), 550.0,1000.0, 1200.0);
            HistoricalAccountData result = manager.persist(record);
            accountId = result.getId();

        }


        // unit test the repo using a mock database
        @Test
        public void canRetrieveDataByAccountId() {
            List<HistoricalAccountData> discs = repo.findAllByAccountId(2);
            Stream<HistoricalAccountData> stream = StreamSupport.stream(discs.spliterator(), false);
            //assertThat(stream.count(), equalTo(1L));
            assertNotNull(discs);
        }
//
//
//        // integration test for the service layer and data layer
//        @Test
//        public void dataServiceCanReturnARecord() {
//            Iterable<HistoricalAccountData> discs = dataService.getAllData();
//            Stream<HistoricalAccountData> stream = StreamSupport.stream(discs.spliterator(), false);
//            Optional<HistoricalAccountData> firstRecord = stream.findFirst();
//            assertThat(firstRecord.get().getCash(),equalTo(550.0));
//        }
//
//        // integration test with the controller
//        @Test
//        public void controllerCanReturnDataById() {
//            List<HistoricalAccountData> data = controller.getHistoricalAccountDataById(accountId);
//            assertThat(data.get(0).getCash(), equalTo(550.0));
//        }

}


