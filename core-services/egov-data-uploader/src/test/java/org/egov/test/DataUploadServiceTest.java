package org.egov.test;

import org.junit.jupiter.api.Test;
import org.egov.DataUploadApplication;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.User;
import org.egov.dataupload.model.UploadJob;
import org.egov.dataupload.model.UploaderRequest;
import org.egov.dataupload.service.DataUploadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;

@SpringBootTest
@ContextConfiguration(classes = {DataUploadApplication.class})
@Import(TestConfiguration.class)
@Disabled
public class DataUploadServiceTest {

    private UploadJob uploadJob;
    private RequestInfo requestInfo;

    @BeforeEach
    public void setup(){
        uploadJob = new UploadJob();
        uploadJob.setRequesterName("xyz");
        uploadJob.setLocalFilePath("C:\\Users\\Nithin\\Documents\\eGov\\data-upload\\egov-data-uploader\\src\\main\\resources" +
                "\\Emp_Create_Final.xlsx");
        uploadJob.setModuleName("HR-Employee");
        uploadJob.setRequestFileName("Emp_Create_Final.xlsx");
        uploadJob.setDefName("hr-employee-create");
        uploadJob.setTenantId("pb.amritsar");

        User user = new User();
        user.setId(110L);
        user.setUserName("manu");

        requestInfo = new RequestInfo();
        requestInfo.setApiId("org.egov.pgr");
        requestInfo.setUserInfo(user);
        requestInfo.setAuthToken("b81beb01-8c01-4886-ba02-259f1e6c9ee6");
    }

    @Autowired
    private DataUploadService dataUploadService;

    @Test
    public void test() throws Exception{
        dataUploadService.excelDataUpload(UploaderRequest.builder().uploadJobs(Collections.singletonList(uploadJob))
                .requestInfo(requestInfo).build());
    }

}
