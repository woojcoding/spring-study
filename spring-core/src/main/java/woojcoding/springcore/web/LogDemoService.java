package woojcoding.springcore.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woojcoding.springcore.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;

    public void logic(String testId) {
        myLogger.log("sevice id = " + testId);
    }
}
