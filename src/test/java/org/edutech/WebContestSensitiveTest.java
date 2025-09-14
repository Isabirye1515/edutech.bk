package org.edutech;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppTestConfig.class })
@ActiveProfiles("test")  
@Transactional  
public abstract class WebContestSensitiveTest extends AppTestConfig {

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    private IDatabaseTester databaseTester;

    @Before 
    protected void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.databaseTester = new JdbcDatabaseTester(
            "org.h2.Driver",
            "jdbc:h2:mem:testdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",  
            "sa",
            ""
        );
    }

    protected void executeDataset(String datasetPath) {
        try {
            IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(getClass().getResourceAsStream(datasetPath));
            databaseTester.setDataSet(dataSet);
            databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
            databaseTester.onSetup();
        } catch ( Exception e) {
            throw new RuntimeException("Failed to execute dataset: " + datasetPath, e);
        }
    }

    @After  
    public void tearDown() {
        try {
            databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
            databaseTester.onTearDown();
        } catch (Exception e) {
            // Soft fail to avoid halting tests
            System.err.println("Tear down failed: " + e.getMessage());
        }
    }
}