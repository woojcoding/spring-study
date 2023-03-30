package woojcoding.springcore.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import woojcoding.springcore.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    public void logic(String testId) {
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("sevice id = " + testId);
    }
}
